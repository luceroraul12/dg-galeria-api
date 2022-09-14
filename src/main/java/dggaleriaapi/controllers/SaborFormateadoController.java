package dggaleriaapi.controllers;

import dggaleriaapi.models.SaborFormateado;
import dggaleriaapi.responses.SaborFormateadoResponse;
import dggaleriaapi.services.SaborFormateadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/sabores-formateados")
public class SaborFormateadoController {

    @Autowired
    SaborFormateadoService saborFormateadoService;

    @GetMapping
    public ResponseEntity<SaborFormateadoResponse> getAll() {
        String successMessage = "sabores formateados encontrados";
        String badMessage = "error al buscar sabores formateados";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.getAll();
            saborFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping("/sabor-asociado")
    public ResponseEntity<SaborFormateadoResponse> getBySaborAsociadoId(@RequestBody SaborFormateado saborFormateado) {
        String successMessage = "sabores encontrados";
        String badMessage = "error al buscar sabores";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.getBySaborAsociadoId(saborFormateado);
            saborFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping("/por-brand")
    public ResponseEntity<SaborFormateadoResponse> getAllByIdBrand(@RequestParam(name = "id") Long idBrand) {
        String successMessage = "sabores encontrados";
        String badMessage = "error al buscar sabores";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.getAllByIdBrand(idBrand);
            saborFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping
    public ResponseEntity<SaborFormateadoResponse> save(@RequestBody SaborFormateado saborFormateado) {
        String successMessage = "sabor creado";
        String badMessage = "error al crear sabor";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.save(saborFormateado);
            saborFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping("/save-inicial")
    public ResponseEntity<SaborFormateadoResponse> saveInicial(@RequestBody SaborFormateado saborFormateado) {
        String successMessage = "sabores formateados creados inicialmente";
        String badMessage = "error al crear sabores formateados inicialmente";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.saveInicial(saborFormateado);
            saborFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping("/save-monton")
    public ResponseEntity<SaborFormateadoResponse> savePorMonton(@RequestBody List<SaborFormateado> saboresFormateados) {
        String successMessage = "sabores formateados por monton creados";
        String badMessage = "error al crear sabores formateados por monton";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.savePorMonton(saboresFormateados);
            saborFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping("/save-monton-inicial")
    public ResponseEntity<SaborFormateadoResponse> savePorMontonInicial(@RequestBody List<SaborFormateado> saboresFormateados) {
        String successMessage = "sabores formateados por monton inicial creados";
        String badMessage = "error al crear sabores formateados inicial por monton";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.savePorMontonInicial(saboresFormateados);
            saborFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<SaborFormateadoResponse> update(@RequestBody SaborFormateado saborFormateado) {
        String successMessage = "sabore formateado actualizado";
        String badMessage = "error al actualizar sabor formateado";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.update(saborFormateado);
            saborFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<SaborFormateadoResponse> delete(@RequestBody SaborFormateado saborFormateado) {
        String successMessage = "sabor formateado eliminado";
        String badMessage = "error al borrar sabor formateado";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.delete(saborFormateado);
            saborFormateadoResponse.setMensaje(successMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(badMessage);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
