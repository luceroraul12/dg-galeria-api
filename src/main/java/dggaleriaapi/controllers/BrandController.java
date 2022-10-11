package dggaleriaapi.controllers;

import dggaleriaapi.models.Brand;
import dggaleriaapi.models.BrandCategory;
import dggaleriaapi.repositories.BrandCategoryRepository;
import dggaleriaapi.responses.StockDataResponse;
import dggaleriaapi.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "brands")
public class BrandController {

    @Autowired
    BrandService brandService;

    @Autowired
    BrandCategoryRepository brandCategoryRepository;

    @GetMapping
    public ResponseEntity<StockDataResponse<Brand>> getAll() {
        String succesMessage = "brand obtenidos";
        String badMessage = "error al adquirir brand";
        StockDataResponse<Brand>  brandResponse = new StockDataResponse<Brand> ();
        ResponseEntity<StockDataResponse<Brand>> response;
        try {
            brandResponse = brandService.getAll();
            brandResponse.setMessage(succesMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
    @GetMapping(value = "/categories")
    public ResponseEntity<StockDataResponse<BrandCategory>> getAllCategories() {
        String succesMessage = "categorias de brands obtenidas";
        String badMessage = "error al obtener categoria de brands";
        StockDataResponse<BrandCategory>  brandResponse = new StockDataResponse<BrandCategory> ();
        ResponseEntity<StockDataResponse<BrandCategory>> response;
        try {
            brandResponse.setStockDataResult(brandCategoryRepository.findAll());
            brandResponse.setMessage(succesMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping(value = "/id")
    public ResponseEntity<StockDataResponse<Brand>> getBrandById(@RequestBody Brand brand) {
        String succesMessage = "brand obtenido por id";
        String badMessage = "error al adquirir brand";
        StockDataResponse<Brand>  brandResponse = new StockDataResponse<Brand> ();
        ResponseEntity<StockDataResponse<Brand>> response;
        try {
            brandResponse = brandService.getBrandById(brand);
            brandResponse.setMessage(succesMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<StockDataResponse<Brand>> saveBrand(@RequestBody Brand brand) {
        String successMessage = "brand creado";
        String badMessage = "error al crear brand";
        StockDataResponse<Brand>  brandResponse = new StockDataResponse<Brand> ();
        ResponseEntity<StockDataResponse<Brand>> response;
        try {
            brandResponse = brandService.saveBrand(brand);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<StockDataResponse<Brand>> updateBrand(@RequestBody Brand brand) {
        String successMessage = "brand actualizada";
        String badMessage = "error al actualizar brand";
        StockDataResponse<Brand>  brandResponse = new StockDataResponse<Brand> ();
        ResponseEntity<StockDataResponse<Brand>> response;
        try {
            brandResponse = brandService.updateBrand(brand);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PatchMapping
    public ResponseEntity<StockDataResponse<Brand>> updateStockState(@RequestBody Brand brand) {
        String successMessage = "estado de brand actualizado";
        String badMessage = "error al actualizar el estado de brand";
        StockDataResponse<Brand>  brandResponse = new StockDataResponse<Brand> ();
        ResponseEntity<StockDataResponse<Brand>> response;
        try {
            brandResponse = brandService.changeStockState(brand);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping
    public ResponseEntity<StockDataResponse<Brand>> deleteBrand(@RequestBody Brand brand) {
        String successMessage = "brand eliminada";
        String badMessage = "error al eliminar brand";
        StockDataResponse<Brand>  brandResponse = new StockDataResponse<Brand> ();
        ResponseEntity<StockDataResponse<Brand>> response;
        try {
            brandResponse = brandService.deleteBrand(brand);
            brandResponse.setMessage(successMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.OK);
        } catch (Exception e) {
            brandResponse.setMessage(badMessage);
            response = new ResponseEntity<>(brandResponse, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("download-images")
    public ResponseEntity<String> downloadImage(){
        brandService.downloadAllImages();
        return new ResponseEntity<>("imagenes descargadas", HttpStatus.OK);
    }
}
