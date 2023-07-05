package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public final class Util {
    // реализуйте настройку соеденения с БД

    private static final String URL_KEY = "db.url";
    private static final String USERNAME_KEY = "db.username";
    private static final String PASSWORD_KEY = "db.password";
    private static SessionFactory sessionFactory;
    private Util() {
    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null) {
            Properties properties = new Properties();
            properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
            properties.put(Environment.USER, "postgres");
            properties.put(Environment.PASS, "admin");

            Configuration configuration = new Configuration().addProperties(properties).addAnnotatedClass(User.class);
            try {
                sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {
                System.out.println("Чёт пошло не так!" + e);
            }
        }
        return sessionFactory;
    }

//    JDBC
//    public static Connection open() {
//        try {
//            return DriverManager.getConnection(PropertiesUtil.get(URL_KEY), PropertiesUtil.get(USERNAME_KEY), PropertiesUtil.get(PASSWORD_KEY));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


}
