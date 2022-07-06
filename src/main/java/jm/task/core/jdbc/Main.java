package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;


public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();
        try {
            Session session = factory.getCurrentSession();
            User user1 = new User("Viktor", "Petrov", (byte) 23);
            User user2 = new User("Maria", "Sidorova", (byte) 55);
            User user3 = new User("Elena", "Nikolaevna", (byte) 31);
            User user4 = new User("Nikita", "Andreev", (byte) 19);

            session.beginTransaction();
            session.save(user1);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}
