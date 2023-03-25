package com.clinicaOdontologica.main.controller;

import com.clinicaOdontologica.main.entity.Jugador;
import com.clinicaOdontologica.main.service.JugadorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Jugador")
public class JugadorController {
    private JugadorService jugadorService = new JugadorService();
    @GetMapping
    public Jugador buscarJugador() {
        return jugadorService.obtenerJugador();
    }
}
