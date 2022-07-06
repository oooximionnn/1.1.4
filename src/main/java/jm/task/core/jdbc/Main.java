package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();

        User user1 = new User("Viktor", "Petrov", (byte) 23);
        User user2 = new User("Maria", "Sidorova", (byte) 55);
        User user3 = new User("Elena", "Nikolaevna", (byte) 31);
        User user4 = new User("Nikita", "Andreev", (byte) 19);
        userDaoHibernate.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userDaoHibernate.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userDaoHibernate.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userDaoHibernate.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        System.out.println(userDaoHibernate.getAllUsers());
        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.dropUsersTable();




    }
}
