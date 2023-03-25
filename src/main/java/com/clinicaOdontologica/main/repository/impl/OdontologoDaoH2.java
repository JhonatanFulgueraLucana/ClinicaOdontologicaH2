package com.clinicaOdontologica.main.repository.impl;


import com.clinicaOdontologica.main.repository.IDao;
import com.clinicaOdontologica.main.entity.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class OdontologoDaoH2 implements IDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "12345678";

    @Override
    public Odontologo save(Odontologo o) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("insert into odontologo values(?,?,?,?)");
            preparedStatement.setLong(1, o.getId());
            preparedStatement.setString(2, o.getName());
            preparedStatement.setString(3, o.getLastName());
            preparedStatement.setInt(4, o.getEnrolment());
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            logger.error(throwables);
        }
        return o;
    }

    @Override
    public void update(Odontologo odontologo, Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //Empezar la Tx
            connection.setAutoCommit(false);
            logger.warn("Advertencia, se modifico el valor del autoComit para empezar con la transaction");

            preparedStatement = connection.prepareStatement("update odontologo set name=?, lastName=?, enrolment=? where id=?");
            preparedStatement.setString(1, odontologo.getName());
            preparedStatement.setString(2, odontologo.getLastName());
            preparedStatement.setInt(3, odontologo.getEnrolment());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.commit();
            connection.setAutoCommit(true);
            System.out.println("Odontologo actualizado");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            assert connection != null;

            connection.rollback();
        } finally {
            assert connection != null;
            connection.close();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("delete from odontologo where id=?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            assert connection!= null;
            connection.rollback();
        } finally {
            assert connection!= null;
            connection.close();
        }
    }
    @Override
    public Odontologo share(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo o = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("select * from odontologo where id=?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long idOdontologo = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int enrolment = resultSet.getInt("enrolment");
                o = new Odontologo(idOdontologo, name, lastName, enrolment);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            assert connection!= null;
            connection.rollback();
        } finally {
            assert connection!= null;
            connection.close();
        }
        return o;
    }

    @Override
    public List<Odontologo> shareAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo> o = new ArrayList<>();
        logger.info("Comenzamos a listar a todos los Odontologos: ");
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            connection.setAutoCommit(false);
            logger.warn("Advertencia, se modifico el valor del autoComit para empezar con la transaction");

            preparedStatement = connection.prepareStatement("select * from odontologo");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long idOdontologo = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                int enrolment = resultSet.getInt("enrolment");
                o.add(new Odontologo(idOdontologo, name, lastName, enrolment));
            }
            connection.commit();
            connection.setAutoCommit(true);

        }catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            assert connection!= null;
            connection.rollback();
            logger.error("Error al conectarse a la BD: ", throwables);
        } finally {
            assert connection!= null;
            connection.close();
        }
        return o;
    }
}
