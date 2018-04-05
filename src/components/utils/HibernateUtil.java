/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.utils;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author MitsuyoRai
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static AnnotationConfiguration _annotationCfg;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            _annotationCfg = new AnnotationConfiguration();
            sessionFactory = _annotationCfg.configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static String getUrl() {
        String url = _annotationCfg.getProperty("hibernate.connection.url");
        String usr = _annotationCfg.getProperty("hibernate.connection.username");
        String pwd = _annotationCfg.getProperty("hibernate.connection.password");
        return url + ";" + ";user=" + usr + ";password=" + pwd;
    }
}
