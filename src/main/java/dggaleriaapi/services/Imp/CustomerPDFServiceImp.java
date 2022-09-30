package dggaleriaapi.services.Imp;


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
import dggaleriaapi.models.DrinkContainer;
import dggaleriaapi.models.DrinkContaineredTaste;
import dggaleriaapi.services.BrandService;
import dggaleriaapi.services.CustomerService;
import dggaleriaapi.services.DrinkContaineredTasteService;
import dggaleriaapi.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerPDFServiceImp {


    @Autowired
    DrinkContaineredTasteService drinkContaineredTasteService;

    @Autowired
    ImageService imageService;

    @Autowired
    CustomerService customerService;

    @Autowired
    BrandService brandService;

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


        generateTables(document, getAllCustomerDTOOrdered());


        document.close();

    }

    private List<CustomerDTO> getAllCustomerDTOOrdered() {
        List<CustomerDTO> result = new ArrayList<>();
        List<Brand> brands = brandService.getAll().getStockDataResult();
        brands.forEach(b -> {
            result.add(
                    customerService.obtenerResumenPorBrand(b).getCustomerResult()
            );
        });
        orderCustomerDTO(result);
        return result;
    }

    private void orderCustomerDTO(List<CustomerDTO> result) {

        orderByBrandName(result);
        orderByTasteName(result);
        orderByDrinkContainerAsc(result);

    }

    private void orderByDrinkContainerAsc(List<CustomerDTO> data) {

        data.forEach(d -> {
            d.getTasteResults().forEach( t -> {
                t.getDrinkContainersAvailable().sort( (dc1, dc2) -> {
                    return dc1.getContainerName() - dc2.getContainerName();
                });
            });
        });
    }

    private void orderByTasteName(List<CustomerDTO> data) {
        data.forEach(d -> {
            d.getTasteResults().sort((a, b) ->{
                return a.getTasteName().compareTo(b.getTasteName());
            });
        });
    }

    private void orderByBrandName(List<CustomerDTO> data) {
        data.sort((a,b) -> a.getBrandSelected().getBrandName().compareTo(b.getBrandSelected().getBrandName()));
    }

    private void generateTables(Document document, List<CustomerDTO> customerList) throws IOException {

        Table imageTable;
        Table tastesTable;
        Cell brandCell;
        Cell iconicBrandCell;
        Cell contenedorSaboresCell;
        Cell tamanioCell;



        for (CustomerDTO customer : customerList){

            Brand brand = customer.getBrandSelected();
            List<TasteResumenDTO> tasteResumenDTOList = customer.getTasteResults();


            Image brandImage = Image.getInstance(
                    imageService.getImage(
                            brand.getId().toString(),
                            "brand"
                    )
            );
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
