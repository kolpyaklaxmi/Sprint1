package VARGSC.com.agreementgeneratorsystem.dao.impl;

import VARGSC.com.agreementgeneratorsystem.dao.PaymentDAO;
import VARGSC.com.agreementgeneratorsystem.entity.Payment;
import VARGSC.com.agreementgeneratorsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public void addPaymentDetails(Payment payment) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
        }
    }

    @Override
    public Payment getPaymentById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Payment.class, id);
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Payment", Payment.class).list();
        }
    }

    @Override
    public void updatePaymentDetails(Payment payment) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(payment);
            transaction.commit();
        }
    }

    @Override
    public void deletePayment(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Payment payment = session.get(Payment.class, id);
            if (payment != null) {
                session.delete(payment);
            }
            transaction.commit();
        }
    }

    @Override
    public List<Payment> getPaymentsByStatus(String status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Payment WHERE status = :status", Payment.class)
                          .setParameter("status", status)
                          .getResultList();
        }
    }

    @Override
    public List<Payment> getPaymentsByLandlord(int landlordId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Payment p WHERE p.agreement.landlord.id = :landlordId", Payment.class)
                          .setParameter("landlordId", landlordId)
                          .getResultList();
        }
    }
}
