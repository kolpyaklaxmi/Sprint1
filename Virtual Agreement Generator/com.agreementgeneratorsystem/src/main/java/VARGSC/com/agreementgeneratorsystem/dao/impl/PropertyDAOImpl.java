package VARGSC.com.agreementgeneratorsystem.dao.impl;

import VARGSC.com.agreementgeneratorsystem.dao.PropertyDAO;
import VARGSC.com.agreementgeneratorsystem.entity.Property;
import VARGSC.com.agreementgeneratorsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PropertyDAOImpl implements PropertyDAO {

    // Add new property to the database
    @Override
    public void addProperty(Property property) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(property);
            transaction.commit();
        }
    }

    // Get property by ID
    @Override
    public Property getPropertyById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Property.class, id);
        }
    }

    // Get all properties from the database
    @Override
    public List<Property> getAllProperties() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Property", Property.class).list();
        }
    }

    // Update an existing property's details
    @Override
    public void updateProperty(Property property) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(property);
            transaction.commit();
        }
    }

    // Delete property by ID
    @Override
    public void deleteProperty(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Property property = session.get(Property.class, id);
            if (property != null) {
                session.delete(property);
            }
            transaction.commit();
        }
    }

    // Get properties by landlord ID
    @Override
    public List<Property> getPropertiesByLandlord(int landlordId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Property where landlord.id = :landlordId", Property.class)
                    .setParameter("landlordId", landlordId)
                    .list();
        }
    }

    // Search properties by type and address
    @Override
    public List<Property> searchProperties(String type, String address) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Property where type like :type and address like :address", Property.class)
                    .setParameter("type", "%" + type + "%")
                    .setParameter("address", "%" + address + "%")
                    .list();
        }
    }
}
