package com.clinicaOdontologica.main.dto;

import com.clinicaOdontologica.main.entity.Paciente;

import java.util.function.Function;
import java.util.stream.Collectors;

public class PacienteDTOMapper implements Function<Paciente, PacienteDto> {

    @Override
    public PacienteDto apply(Paciente paciente) {
        return new PacienteDto(
                        paciente.getId(),
                        paciente.getNome(),
                        paciente.getLastName()
                );
    }
}
