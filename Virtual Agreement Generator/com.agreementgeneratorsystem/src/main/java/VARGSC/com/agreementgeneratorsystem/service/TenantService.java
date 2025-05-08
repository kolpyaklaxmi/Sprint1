package VARGSC.com.agreementgeneratorsystem.service;

import VARGSC.com.agreementgeneratorsystem.entity.Tenant;

import java.util.List;

public interface TenantService {
    void addTenant(Tenant tenant);
    Tenant getTenantById(int id);
    List<Tenant> getAllTenants();
    void updateTenant(Tenant tenant);
    void deleteTenant(int id);
}
