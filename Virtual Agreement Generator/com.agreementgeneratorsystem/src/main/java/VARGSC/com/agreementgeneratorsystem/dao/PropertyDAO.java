package VARGSC.com.agreementgeneratorsystem.dao;

import VARGSC.com.agreementgeneratorsystem.entity.Property;
import java.util.List;

public interface PropertyDAO {

    // Add new property
    void addProperty(Property property);

    // Get property by ID
    Property getPropertyById(int id);

    // Get all properties
    List<Property> getAllProperties();

    // Update property
    void updateProperty(Property property);

    // Delete property
    void deleteProperty(int id);

    // Get properties by landlord ID (for landlord-specific view)
    List<Property> getPropertiesByLandlord(int landlordId);

    // Search properties by type and address (used by tenants)
    List<Property> searchProperties(String type, String address);
}
