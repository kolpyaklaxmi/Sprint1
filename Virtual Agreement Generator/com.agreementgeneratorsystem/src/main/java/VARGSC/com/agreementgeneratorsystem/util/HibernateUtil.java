package VARGSC.com.agreementgeneratorsystem.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import VARGSC.com.agreementgeneratorsystem.entity.Property;
import VARGSC.com.agreementgeneratorsystem.entity.Landlord;
import VARGSC.com.agreementgeneratorsystem.entity.Tenant;
import VARGSC.com.agreementgeneratorsystem.entity.Agreement;
import VARGSC.com.agreementgeneratorsystem.entity.Payment;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Property.class)
                    .addAnnotatedClass(Landlord.class)
                    .addAnnotatedClass(Tenant.class)
                    .addAnnotatedClass(Agreement.class)
                    .addAnnotatedClass(Payment.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
