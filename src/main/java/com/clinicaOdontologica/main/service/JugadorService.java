package com.clinicaOdontologica.main.service;

import com.clinicaOdontologica.main.entity.Jugador;
import org.springframework.stereotype.Service;

@Service
public class JugadorService {
    public Jugador obtenerJugador(){
        Jugador jugador = new Jugador("Alejandro", "Marcus");
        return jugador;
    }
}
