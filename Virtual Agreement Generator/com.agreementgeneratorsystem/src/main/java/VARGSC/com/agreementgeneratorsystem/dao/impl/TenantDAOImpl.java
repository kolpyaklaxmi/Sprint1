package VARGSC.com.agreementgeneratorsystem.dao.impl;

import VARGSC.com.agreementgeneratorsystem.dao.TenantDAO;
import VARGSC.com.agreementgeneratorsystem.entity.Tenant;
import VARGSC.com.agreementgeneratorsystem.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TenantDAOImpl implements TenantDAO {

    // Add new tenant to the database
    @Override
    public void addTenant(Tenant tenant) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(tenant);
            transaction.commit();
        }
    }

    // Get tenant by ID
    @Override
    public Tenant getTenantById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Tenant.class, id);
        }
    }

    // Get all tenants from the database
    @Override
    public List<Tenant> getAllTenants() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Tenant", Tenant.class).list();
        }
    }

    // Update an existing tenant's details
    @Override
    public void updateTenant(Tenant tenant) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(tenant);
            transaction.commit();
        }
    }

    // Delete tenant by ID
    @Override
    public void deleteTenant(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Tenant tenant = session.get(Tenant.class, id);
            if (tenant != null) {
                session.delete(tenant);
            }
            transaction.commit();
        }
    }
}
