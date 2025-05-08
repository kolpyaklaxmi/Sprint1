package VARGSC.com.agreementgeneratorsystem.dao.impl;

import VARGSC.com.agreementgeneratorsystem.dao.LandlordDAO;
import VARGSC.com.agreementgeneratorsystem.entity.Landlord;
import VARGSC.com.agreementgeneratorsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class LandlordDAOImpl implements LandlordDAO {
    private Session session;

    @Override
    public void save(Landlord landlord) {
        session = HibernateUtil.getSessionFactory().openSession(); // Open a session using Hibernate
        Transaction transaction = session.beginTransaction();
        session.save(landlord); // Save the Landlord object
        transaction.commit();
        session.close(); // Close the session
    }
    

    // Get landlord by ID
    @Override
    public Landlord getLandlordById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Landlord.class, id);
        }
    }

    // Get all landlords from the database
    @Override
    public List<Landlord> getAllLandlords() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Landlord", Landlord.class).list();
        }
    }

    // Update an existing landlord's details
    @Override
    public void updateLandlord(Landlord landlord) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(landlord);
            transaction.commit();
        }
    }

    // Delete landlord by ID
    @Override
    public void deleteLandlord(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Landlord landlord = session.get(Landlord.class, id);
            if (landlord != null) {
                session.delete(landlord);
            }
            transaction.commit();
        }
    }
}
