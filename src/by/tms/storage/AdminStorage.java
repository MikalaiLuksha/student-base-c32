package by.tms.storage;

import by.tms.domain.Admin;
import by.tms.domain.Student;
import java.sql.*;

public class AdminStorage {

    Connection connection = null;

    public void updatePasswordById (long id , String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("update admins set password = ? where id = ?");
            preparedStatement.setString(1, password);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePasswordByLogin (String login , String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("update admins set password = ? where login = ?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, login);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Admin findAdminByLogin (String login) {
        long id = 0;
        String name = null;
        String password = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1987Roll");
            PreparedStatement preparedStatement = connection.prepareStatement("select *from admins where login = ?");
            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getLong(1);
                name = resultSet.getString(2);
                password = resultSet.getString(3);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeAdminByLogin (String login, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("delete * from admins a where a.login = ? and a.password = ?");
            preparedStatement.setString(1,login);
            preparedStatement.setString(2, password);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
    public void removeAdminById (long id, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("delete * from admins a where a.id = ? and a.password = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.setString(2, password);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAdminNameByLogin (String login, String password, String name) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("update admins a set a.name = ? where a.login = ? and a.password = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,login);
            preparedStatement.setString(3, password);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    public void updateAdminNameById (long id, String password, String newName) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("update admins a set a.name = ? where a.id = ? and a.password = ?");
            preparedStatement.setString(1, newName);
            preparedStatement.setLong(2, id);
            preparedStatement.setString(3, password);
            preparedStatement.executeQuery();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkAdminByLogin (String login, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from admins a where a.login = ? and a.password = ?");
            preparedStatement.setString(1,login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkAdminById (Long id, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "learn2000_");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from admins a where a.id = ? and a.password = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
