package com.clinicaOdontologica.main.dto;

import com.clinicaOdontologica.main.entity.Domicilio;
import com.clinicaOdontologica.main.entity.Odontologo;

import java.util.List;

public record PacienteDto(
        Long id,
        String name,
        String lastName
) {

}
