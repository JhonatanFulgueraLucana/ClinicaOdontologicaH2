package com.clinicaOdontologica.main.service;

import com.clinicaOdontologica.main.repository.IDao;
import com.clinicaOdontologica.main.repository.impl.PacienteDaoH2;
import com.clinicaOdontologica.main.entity.Paciente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Date;

public class PacienteServiceTest {
    private IDao<Paciente> pacienteDaoH2 = new PacienteDaoH2();
    private PacienteService pacienteService = new PacienteService();

    @Before
    public void cargarPacienteCambiandoImplementacionDao() {
        pacienteService.setPascienteServiceDao(pacienteDaoH2);
        pacienteService.save(new Paciente(3L, "Cristian", "Fulguera", "Zelarrayan3212", 42421298, new Date(2023, 10, 10)));
    }

    @Test
    public void testBuscarOdontologoCambiandoImpleDao() throws SQLException {
        pacienteService.setPascienteServiceDao(pacienteDaoH2);
        Paciente paciente = pacienteService.share(3L);
        Assert.assertNotNull(paciente);
        Assert.assertEquals(paciente.getNome(), "Cristian");
        Assert.assertEquals(paciente.getLastName(), "Fulguera");
    }
}
