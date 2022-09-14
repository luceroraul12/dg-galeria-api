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
        String mensajeAfirmativo = "sabores formateados encontrados";
        String mensajeNegativo = "error al buscar sabores formateados";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.getAll();
            saborFormateadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping("/sabor-asociado")
    public ResponseEntity<SaborFormateadoResponse> getBySaborAsociadoId(@RequestBody SaborFormateado saborFormateado) {
        String mensajeAfirmativo = "sabores encontrados";
        String mensajeNegativo = "error al buscar sabores";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.getBySaborAsociadoId(saborFormateado);
            saborFormateadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @GetMapping("/por-brand")
    public ResponseEntity<SaborFormateadoResponse> getAllByIdBrand(@RequestParam(name = "id") Long idBrand) {
        String mensajeAfirmativo = "sabores encontrados";
        String mensajeNegativo = "error al buscar sabores";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.getAllByIdBrand(idBrand);
            saborFormateadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping
    public ResponseEntity<SaborFormateadoResponse> save(@RequestBody SaborFormateado saborFormateado) {
        String mensajeAfirmativo = "sabor creado";
        String mensajeNegativo = "error al crear sabor";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.save(saborFormateado);
            saborFormateadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PostMapping("/save-inicial")
    public ResponseEntity<SaborFormateadoResponse> saveInicial(@RequestBody SaborFormateado saborFormateado) {
        String mensajeAfirmativo = "sabores formateados creados inicialmente";
        String mensajeNegativo = "error al crear sabores formateados inicialmente";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.saveInicial(saborFormateado);
            saborFormateadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping("/save-monton")
    public ResponseEntity<SaborFormateadoResponse> savePorMonton(@RequestBody List<SaborFormateado> saboresFormateados) {
        String mensajeAfirmativo = "sabores formateados por monton creados";
        String mensajeNegativo = "error al crear sabores formateados por monton";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.savePorMonton(saboresFormateados);
            saborFormateadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @PostMapping("/save-monton-inicial")
    public ResponseEntity<SaborFormateadoResponse> savePorMontonInicial(@RequestBody List<SaborFormateado> saboresFormateados) {
        String mensajeAfirmativo = "sabores formateados por monton inicial creados";
        String mensajeNegativo = "error al crear sabores formateados inicial por monton";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.savePorMontonInicial(saboresFormateados);
            saborFormateadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    @PutMapping
    public ResponseEntity<SaborFormateadoResponse> update(@RequestBody SaborFormateado saborFormateado) {
        String mensajeAfirmativo = "sabore formateado actualizado";
        String mensajeNegativo = "error al actualizar sabor formateado";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.update(saborFormateado);
            saborFormateadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    @DeleteMapping
    public ResponseEntity<SaborFormateadoResponse> delete(@RequestBody SaborFormateado saborFormateado) {
        String mensajeAfirmativo = "sabor formateado eliminado";
        String mensajeNegativo = "error al borrar sabor formateado";
        SaborFormateadoResponse saborFormateadoResponse = new SaborFormateadoResponse();
        ResponseEntity<SaborFormateadoResponse> respuesta;
        try {
            saborFormateadoResponse = saborFormateadoService.delete(saborFormateado);
            saborFormateadoResponse.setMensaje(mensajeAfirmativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.OK);
        } catch (Exception e) {
            saborFormateadoResponse.setMensaje(mensajeNegativo);
            respuesta = new ResponseEntity<SaborFormateadoResponse>(saborFormateadoResponse, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
