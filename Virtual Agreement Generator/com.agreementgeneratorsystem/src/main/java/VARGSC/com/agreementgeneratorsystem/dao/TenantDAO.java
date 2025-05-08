package VARGSC.com.agreementgeneratorsystem.dao;

import VARGSC.com.agreementgeneratorsystem.entity.Tenant;
import java.util.List;

public interface TenantDAO {
    
    // Add new tenant
    void addTenant(Tenant tenant);
    
    // Get tenant by ID
    Tenant getTenantById(int id);
    
    // Get all tenants
    List<Tenant> getAllTenants();
    
    // Update tenant
    void updateTenant(Tenant tenant);
    
    // Delete tenant
    void deleteTenant(int id);
}
