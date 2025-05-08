package VARGSC.com.agreementgeneratorsystem.service.impl;

import VARGSC.com.agreementgeneratorsystem.dao.TenantDAO;
import VARGSC.com.agreementgeneratorsystem.dao.impl.TenantDAOImpl;
import VARGSC.com.agreementgeneratorsystem.entity.Tenant;
import VARGSC.com.agreementgeneratorsystem.service.TenantService;

import java.util.List;

public class TenantServiceImpl implements TenantService {

    private TenantDAO tenantDAO;

    // Constructor to initialize the DAO
    public TenantServiceImpl() {
        this.tenantDAO = new TenantDAOImpl();
    }

    // Add tenant using the DAO
    @Override
    public void addTenant(Tenant tenant) {
        tenantDAO.addTenant(tenant);
    }

    // Get tenant by ID using the DAO
    @Override
    public Tenant getTenantById(int id) {
        return tenantDAO.getTenantById(id);
    }

    // Get all tenants using the DAO
    @Override
    public List<Tenant> getAllTenants() {
        return tenantDAO.getAllTenants();
    }

    // Update tenant using the DAO
    @Override
    public void updateTenant(Tenant tenant) {
        tenantDAO.updateTenant(tenant);
    }

    // Delete tenant using the DAO
    @Override
    public void deleteTenant(int id) {
        tenantDAO.deleteTenant(id);
    }
}
