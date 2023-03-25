package com.clinicaOdontologica.main.service;

import com.clinicaOdontologica.main.repository.IDao;
import com.clinicaOdontologica.main.entity.Odontologo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public OdontologoService() {
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo save(Odontologo odontologo) {
        return odontologoIDao.save(odontologo);
    }
    public void update(Odontologo odontologo, Long id) throws SQLException {
        odontologoIDao.update(odontologo, id);
    }
    public void delete(Long id) throws SQLException {
        odontologoIDao.delete(id);
    }
    public Odontologo share(Long id) throws SQLException {
        return odontologoIDao.share(id);
    }
    public List<Odontologo> shareAll() throws SQLException {
        return odontologoIDao.shareAll();
    }
}