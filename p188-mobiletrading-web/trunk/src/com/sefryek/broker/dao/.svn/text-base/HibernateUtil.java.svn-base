package com.sefryek.broker.dao;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: Sarvenaz
 * Date: Jul 26, 2011
 * Time: 4:30:05 PM
 */
public class HibernateUtil {
    public static final SessionFactory sessionFactory;


    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            // use Configuration().configure().buildSessionFactory(); for hbm files
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        } catch (Throwable e) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getHibernateSessionFactory() {
        return sessionFactory;
    }

    public static HibernateTemplate getCustomHibernateTemplate() {
        SessionFactory sessionFactory = getHibernateSessionFactory();
        return new HibernateTemplate(sessionFactory);
    }

    public static void closeSession() {
        // Close caches and connection pools
        getHibernateSessionFactory().close();
    }

}
