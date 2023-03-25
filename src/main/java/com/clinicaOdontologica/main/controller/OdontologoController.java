package com.clinicaOdontologica.main.controller;

import com.clinicaOdontologica.main.repository.impl.OdontologoDaoH2;
import com.clinicaOdontologica.main.entity.Odontologo;
import com.clinicaOdontologica.main.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/controller")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Odontologo> listarOdontologos() throws SQLException {
         return odontologoService.shareAll();
    }
    @GetMapping("/{id}")
    public Odontologo buscar(@PathVariable("id") Long id) throws SQLException {
        return odontologoService.share(id);
    }

    @PostMapping("/guardar")
    public Odontologo guardar(@RequestBody Odontologo odontologo){
        return odontologoService.save(odontologo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity borrarOdontologo(@PathVariable Long id) throws SQLException {
        ResponseEntity response = null;
        if (odontologoService.share(id) == null) {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            odontologoService.delete(id);
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return response;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody Odontologo odontologo,
                                                          @PathVariable("id") Long id) throws SQLException {
        ResponseEntity response = null;
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("Usuario actualizado","user" + odontologo + ": habilitado");
        if (odontologoService.share(id) == null){
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            odontologoService.update(odontologo, id);
            response = new ResponseEntity<>("Resultado "+ cabecera,HttpStatus.OK);}

        return response;
    }


}
