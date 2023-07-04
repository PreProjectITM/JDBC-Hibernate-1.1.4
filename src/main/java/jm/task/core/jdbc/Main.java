package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Michail", "Antipov", (byte) 76);
        userService.saveUser("Antip", "Mihailov", (byte) 67);
        userService.saveUser("Petr", "Ivanov", (byte) 34);
        userService.saveUser("Ivan", "Petrov", (byte) 43);

        List<User> users = userService.getAllUsers();
        for(User user : users) {
            System.out.println(user.toString());
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}
