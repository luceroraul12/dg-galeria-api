package dggaleriaapi.services.Imp;


import antlr.StringUtils;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.models.DrinkContaineredTaste;
import dggaleriaapi.services.BrandedTasteService;
import dggaleriaapi.services.DrinkContaineredTasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@Service
public class CustomerPDFServiceImp {


    @Autowired
    DrinkContaineredTasteService drinkContaineredTasteService;


    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Marca", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Sabor", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Tamaño", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {

        List<DrinkContaineredTaste> drinkContaineredTasteList = drinkContaineredTasteService.getAll().getStockDataResult();

        sortDrink(drinkContaineredTasteList);

            String brandName;
            String tasteName;
            String drinkContainerName;
        for (DrinkContaineredTaste drink : drinkContaineredTasteList) {
            brandName = drink.getBrandedTaste().getBrand().getBrandName().toUpperCase();
            tasteName = drink.getBrandedTaste().getTaste().getTasteName().toUpperCase();
            drinkContainerName = adaptContainerName(
                    drink.getDrinkContainer().getContainerName());

            table.addCell(brandName);
            table.addCell(tasteName);
            table.addCell(drinkContainerName);
        }
    }

    private void sortDrink(List<DrinkContaineredTaste> drinkContaineredTasteList) {


        Collections.sort(drinkContaineredTasteList, (d1, d2) -> {
            return d1.getDrinkContainer().getContainerName() - d2.getDrinkContainer().getContainerName();
        });

        Collections.sort(drinkContaineredTasteList, (d1, d2) ->{
            return d1.getBrandedTaste().getTaste().getTasteName().compareTo(
                d2.getBrandedTaste().getTaste().getTasteName()
            );
        });

        Collections.sort(drinkContaineredTasteList, (d1, d2) -> {
            return d1.getBrandedTaste().getBrand().getBrandName().compareTo(
                    d2.getBrandedTaste().getBrand().getBrandName()
            );
        });

    }

    private String adaptContainerName(Integer ammo){
        String ammoPreFix;
        int ammoFix;
        String result;
        if (ammo >= 1000){
            ammoPreFix = "Lts";
            ammoFix = ammo / 1000;
        } else {
            ammoPreFix = "ml";
            ammoFix = ammo;
        }
        result = ammoFix + " " + ammoPreFix;
        return result;

    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Distribuidora Gustavo", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        font.setSize(10);
        p = new Paragraph("Fecha de emision: "+ LocalDate.now().toString(),font);
        p.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(p);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 1f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }













}
