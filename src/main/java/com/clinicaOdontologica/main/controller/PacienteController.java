package com.clinicaOdontologica.main.controller;

import com.clinicaOdontologica.main.dto.PacienteDto;
import com.clinicaOdontologica.main.repository.impl.PacienteDaoH2;
import com.clinicaOdontologica.main.entity.Paciente;
import com.clinicaOdontologica.main.service.PacienteService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarUsuario(@PathVariable Long id) throws SQLException {
        ResponseEntity response = null;
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("Content-Type", "application/json" + pacienteService.share(id));
        if (pacienteService.share(id) == null){
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            response = new ResponseEntity<>("Resultado: "+ cabecera, HttpStatus.OK);
        }
        return response;
    }
    @PutMapping("/guardar")
    public Paciente guardarPaciente(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }
    @GetMapping("/listar")
    public List<PacienteDto> obtenerLista() throws SQLException {
        return pacienteService.shreAll();
    }

}
