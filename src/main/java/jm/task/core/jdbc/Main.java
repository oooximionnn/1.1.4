package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.*;


public class Main {
    public static final String URL = "jdbc:mysql://localhost:3306/demodb";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        User user1 = new User("Viktor", "Petrov", (byte) 23);
        User user2 = new User("Maria", "Sidorova", (byte) 55);
        User user3 = new User("Elena", "Nikolaevna", (byte) 31);
        User user4 = new User("Nikita", "Andreev", (byte) 19);

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();

        userDao.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userDao.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userDao.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userDao.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        System.out.println(userDao.getAllUsers());

        userDao.cleanUsersTable();

        userDao.dropUsersTable();




    }
}
