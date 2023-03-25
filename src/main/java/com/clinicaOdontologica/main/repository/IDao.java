package com.clinicaOdontologica.main.repository;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    public T save(T t);
    public void update(T t, Long id) throws SQLException;

    public void delete(Long id) throws SQLException;

    public T share(Long id) throws SQLException;

    public List<T> shareAll() throws SQLException;
}