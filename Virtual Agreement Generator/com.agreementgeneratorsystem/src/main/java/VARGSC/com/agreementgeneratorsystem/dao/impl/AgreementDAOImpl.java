package VARGSC.com.agreementgeneratorsystem.dao.impl;

import VARGSC.com.agreementgeneratorsystem.dao.AgreementDAO;
import VARGSC.com.agreementgeneratorsystem.entity.Agreement;
import VARGSC.com.agreementgeneratorsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AgreementDAOImpl implements AgreementDAO {

    // Create new agreement in the database
    @Override
    public void createAgreement(Agreement agreement) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(agreement);
            transaction.commit();
        }
    }

    // Get agreement by ID
    @Override
    public Agreement getAgreementById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Agreement.class, id);
        }
    }

    // Get all agreements from the database
    @Override
    public List<Agreement> getAllAgreements() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Agreement", Agreement.class).list();
        }
    }

    // Update an existing agreement's details
    @Override
    public void updateAgreement(Agreement agreement) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(agreement);
            transaction.commit();
        }
    }

    // Delete agreement by ID
    @Override
    public void deleteAgreement(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Agreement agreement = session.get(Agreement.class, id);
            if (agreement != null) {
                session.delete(agreement);
            }
            transaction.commit();
        }
    }
}
