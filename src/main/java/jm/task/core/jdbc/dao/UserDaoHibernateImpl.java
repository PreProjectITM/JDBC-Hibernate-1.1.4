package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name TEXT NOT NULL, lastName TEXT NOT NULL, age INT NOT NULL);").executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropUsersTable() {
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("DROP TABLE IF EXISTS users;").executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("INSERT INTO users (name, lastName, age) VALUES (?, ?, ?);").setParameter(1, name).setParameter(2, lastName).setParameter(3, age).executeUpdate();
            transaction.commit();
            System.out.println("User с именем - " + name + " добавлен в базу данных");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("DELETE FROM users WHERE id = ?;").setParameter(1, id).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = null;
        try(Session session = Util.getSessionFactory().openSession()) {
            usersList = session.createNativeQuery("SELECT * FROM users", User.class).list();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }

    @Override
    public void cleanUsersTable() {
        try(Session session = Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createNativeQuery("TRUNCATE TABLE users;").executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
