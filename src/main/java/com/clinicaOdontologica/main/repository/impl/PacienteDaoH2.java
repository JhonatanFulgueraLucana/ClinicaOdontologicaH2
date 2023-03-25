package com.clinicaOdontologica.main.repository.impl;

import com.clinicaOdontologica.main.repository.IDao;
import com.clinicaOdontologica.main.entity.Paciente;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PacienteDaoH2 implements IDao<Paciente> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "12345678";
    @Override
    public Paciente save(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            preparedStatement = connection.prepareStatement("insert into paciente (id, name, lastName, home, dni, date) values (?,?,?,?,?,?)");
            preparedStatement.setLong(1, paciente.getId());
            preparedStatement.setString(2, paciente.getNome());
            preparedStatement.setString(3, paciente.getLastName());
            preparedStatement.setString(4,paciente.getHome());
            preparedStatement.setInt(5, paciente.getDni());
            preparedStatement.setDate(6, (Date) paciente.getDate());

            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (preparedStatement!= null) {
                    preparedStatement.close();
                }
                if (connection!= null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public void update(Paciente paciente, Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //Empezar la Tx
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("update paciente set name=?, lastName=?, home=?, dni=?, date=? where id=?");
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getLastName());
            preparedStatement.setString(3,paciente.getHome());
            preparedStatement.setInt(4, paciente.getDni());
            preparedStatement.setDate(5, (Date) paciente.getDate());
            preparedStatement.setLong(6, id);

            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
        }catch (SQLException | ClassNotFoundException throwables) {
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
            //Empezar la Tx
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("delete from paciente where id=?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
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
    public Paciente share(Long id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //Empezar la Tx
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("select * from paciente where id=?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long idPaciente = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                String home = resultSet.getString("home");
                int dni = resultSet.getInt("dni");
                Date date = resultSet.getDate("date");
                paciente = new Paciente(idPaciente, name, lastName, home, dni, date);
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            assert connection != null;
            connection.rollback();
        } finally {
            assert connection != null;
            connection.close();
        }
        return paciente;
    }

    @Override
    public List<Paciente> shareAll() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Paciente> pacientes = new ArrayList<>();
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            //Empezar la Tx
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("SELECT * FROM paciente");
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Long idPaciente = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                String home = resultSet.getString("home");
                int dni = resultSet.getInt("dni");
                Date date = resultSet.getDate("date");
                pacientes.add(new Paciente(idPaciente, name, lastName, home, dni, date));
            }
            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            assert connection != null;
            connection.rollback();
        } finally {
            assert connection != null;
            connection.close();
        }
        return pacientes;
    }
}
