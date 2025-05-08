package VARGSC.com.agreementgeneratorsystem.service.impl;

import VARGSC.com.agreementgeneratorsystem.dao.PropertyDAO;
import VARGSC.com.agreementgeneratorsystem.dao.impl.PropertyDAOImpl;
import VARGSC.com.agreementgeneratorsystem.entity.Property;
import VARGSC.com.agreementgeneratorsystem.service.PropertyService;

import java.util.List;

public class PropertyServiceImpl implements PropertyService {

    private PropertyDAO propertyDAO;

    // Constructor to initialize the DAO
    public PropertyServiceImpl() {
        this.propertyDAO = new PropertyDAOImpl();
    }

    // Add property using the DAO
    @Override
    public void addProperty(Property property) {
        propertyDAO.addProperty(property);
    }

    // Get property by ID using the DAO
    @Override
    public Property getPropertyById(int id) {
        return propertyDAO.getPropertyById(id);
    }

    // Get all properties using the DAO
    @Override
    public List<Property> getAllProperties() {
        return propertyDAO.getAllProperties();
    }

    // Update property using the DAO
    @Override
    public void updateProperty(Property property) {
        propertyDAO.updateProperty(property);
    }

    // Delete property using the DAO
    @Override
    public void deleteProperty(int id) {
        propertyDAO.deleteProperty(id);
    }

    // Get properties by landlord ID using the DAO
    @Override
    public List<Property> getPropertiesByLandlord(int landlordId) {
        return propertyDAO.getPropertiesByLandlord(landlordId);
    }

    // Search properties using the DAO
    @Override
    public List<Property> searchProperties(String type, String address) {
        return propertyDAO.searchProperties(type, address);
    }
}
