package com.clinicaOdontologica.main.service;

import com.clinicaOdontologica.main.repository.IDao;
import com.clinicaOdontologica.main.repository.impl.OdontologoDaoH2;
import com.clinicaOdontologica.main.entity.Odontologo;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class OdontologoServiceTest {
    private static IDao<Odontologo> odontologDao = new OdontologoDaoH2();
    private static OdontologoService odontologService = new OdontologoService();
    @BeforeClass
    public static void cargarOdontologo() {
        odontologService.setOdontologoIDao(odontologDao);
        odontologService.save(new Odontologo(1L, "Marcus", "Gonzales", 1312));
        odontologService.save(new Odontologo(2L, "Juan", "Gonzales", 3233));
        odontologService.save(new Odontologo(3L, "Mariana", "pinamar", 1233));
        odontologService.save(new Odontologo(4L, "Belen", "Mahle", 1239));
    }
    @Test
    public void BuscarOdontologo() throws SQLException {
        odontologService.setOdontologoIDao(odontologDao);
        Odontologo odontologo = odontologService.share(1L);
        Assert.assertEquals("Marcus", odontologo.getName());
        Assert.assertEquals("Gonzales", odontologo.getLastName());

    }
    @Test
    public void ListarATodosLosOdontologos() throws SQLException {
        odontologService.setOdontologoIDao(odontologDao);
        Assert.assertEquals(4, odontologService.shareAll().size());
    }
}
