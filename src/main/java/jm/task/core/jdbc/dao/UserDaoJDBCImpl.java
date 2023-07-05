package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name TEXT NOT NULL, lastName TEXT NOT NULL, age INT NOT NULL);";
    private static final String DROP_TABLE_SQL = "DROP TABLE users;";
    private static final String SAVE_USER_SQL = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?);";
    private static final String REMOVE_USER_SQL = "DELETE FROM users WHERE id = ?;";
    private static final String GET_ALL_USERS_SQL = "SELECT * FROM users;";
    private static final String CLEAN_TABLE_SQL = "TRUNCATE TABLE users;";

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
//        try (Connection connection = Util.open();
//             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_SQL)) {
//
//            preparedStatement.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void dropUsersTable() {
//        try (Connection connection = Util.open();
//             PreparedStatement preparedStatement = connection.prepareStatement(DROP_TABLE_SQL)) {
//
//            preparedStatement.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void saveUser(String name, String lastName, byte age) {
//        try (Connection connection = Util.open();
//             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER_SQL)) {
//
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setLong(3, age);
//            preparedStatement.executeUpdate();
//            System.out.println("User с именем - " + name + " добавлен в базу данных");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void removeUserById(long id) {
//        try (Connection connection = Util.open();
//             PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_USER_SQL)) {
//
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    public List<User> getAllUsers() {
//        List<User> usersList = null;
//        try (Connection connection = Util.open();
//             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS_SQL)) {
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if(resultSet!=null) {usersList = new ArrayList<>();}
//            while(resultSet.next()) {
//                User user = new User(resultSet.getString("name"), resultSet.getString("lastName"), resultSet.getByte("age"));
//                user.setId(resultSet.getLong("id"));
//                usersList.add(user);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return usersList;
        return null;
    }

    public void cleanUsersTable() {
//        try (Connection connection = Util.open();
//             PreparedStatement preparedStatement = connection.prepareStatement(CLEAN_TABLE_SQL)) {
//
//            preparedStatement.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
