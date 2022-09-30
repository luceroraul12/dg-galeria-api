package dggaleriaapi.services.Imp;


import antlr.StringUtils;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.alignment.HorizontalAlignment;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import dggaleriaapi.dto.CustomerDTO;
import dggaleriaapi.dto.TasteResumenDTO;
import dggaleriaapi.models.Brand;
import dggaleriaapi.models.BrandedTaste;
import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.DrinkContaineredTaste;
import dggaleriaapi.services.BrandService;
import dggaleriaapi.services.BrandedTasteService;
import dggaleriaapi.services.CustomerService;
import dggaleriaapi.services.DrinkContaineredTasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class CustomerPDFServiceImp {


    @Autowired
    DrinkContaineredTasteService drinkContaineredTasteService;

    @Autowired
    CustomerService customerService;

    @Autowired
    BrandService brandService;


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


        drinkContaineredTasteList.sort((d1, d2) -> {
            return 0;
        });

        drinkContaineredTasteList.sort((d1, d2) -> {
            return d1.getBrandedTaste().getTaste().getTasteName().compareTo(
                    d2.getBrandedTaste().getTaste().getTasteName()
            );
        });

        drinkContaineredTasteList.sort((d1, d2) -> {
            return d1.getBrandedTaste().getBrand().getBrandName().compareTo(
                    d2.getBrandedTaste().getBrand().getBrandName()
            );
        });

    }

    private static String adaptContainerName(Integer ammo){
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
        result = ammoFix + ammoPreFix + " ";
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


        generateTables(document, getAllCustomerDTO());


        document.close();

    }

    private List<CustomerDTO> getAllCustomerDTO() {
        List<CustomerDTO> result = new ArrayList<>();
        List<Brand> brands = brandService.getAll().getStockDataResult();
        brands.forEach(b -> {
            result.add(
                    customerService.obtenerResumenPorBrand(b).getCustomerResult()
            );
        });
        return result;
    }

    private static void generateTables(Document document, List<CustomerDTO> customerList) throws IOException {

        Table imageTable;
        Table tastesTable;
        Cell brandCell;
        Cell iconicBrandCell;
        Cell contenedorSaboresCell;
        Cell tamanioCell;


        for (CustomerDTO customer : customerList){

            Brand brand = customer.getBrandSelected();
            List<TasteResumenDTO> tasteResumenDTOList = customer.getTasteResults();

            Image brandImage = Image.getInstance(new URL(brand.getUrl()));
            brandImage.scaleAbsolute(150,150);

            imageTable = new Table(2);
            imageTable.setBorderWidth(1);
            imageTable.setPadding(5);
            imageTable.setSpacing(5);
            imageTable.setWidth(100);

            tastesTable = new Table(2);
            tastesTable.setBorderWidth(1);
            tastesTable.setPadding(5);
            tastesTable.setSpacing(5);
            tastesTable.setWidth(100);

            brandCell = new Cell();
            brandCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
            brandCell.add(brandImage);
            brandCell.add(new Paragraph("MARCA "));
            imageTable.addCell(brandCell,0,0);

            iconicBrandCell = new Cell();
            iconicBrandCell.setHorizontalAlignment(HorizontalAlignment.CENTER);
            iconicBrandCell.add(brandImage);
            iconicBrandCell.add(new Chunk("PRODUCTO ICONICO "));
            imageTable.addCell(iconicBrandCell,0,1);

            contenedorSaboresCell = new Cell();
            contenedorSaboresCell.setColspan(2);
            contenedorSaboresCell.setRowspan(2);

            Font font = new Font();
            font.setColor(Color.BLUE);
            font.setSize(15);
            Paragraph p = new Paragraph(brand.getBrandName().toUpperCase(),font);
            p.setAlignment(Element.ALIGN_CENTER);
            p.setSpacingBefore(10);

            tastesTable.addCell("Sabores");
            tastesTable.addCell("Tamaños");

            for (TasteResumenDTO taste : tasteResumenDTOList){

                List<DrinkContainer> containers = taste.getDrinkContainersAvailable();

                tastesTable.addCell(taste.getTasteName().toUpperCase());
                tamanioCell =  new Cell();

                for (DrinkContainer dc : containers){
                    tamanioCell.add(new Chunk(
                            adaptContainerName(dc.getContainerName())
                    ));
                }
                tastesTable.addCell(tamanioCell);

                contenedorSaboresCell.add(tastesTable);

            }

            document.add(p);
            document.add(imageTable);
            document.add(tastesTable);

        }



    }


}
