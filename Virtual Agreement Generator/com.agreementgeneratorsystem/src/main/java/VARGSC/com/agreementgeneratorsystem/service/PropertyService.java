package VARGSC.com.agreementgeneratorsystem.service;

import VARGSC.com.agreementgeneratorsystem.entity.Property;

import java.util.List;

public interface PropertyService {
    void addProperty(Property property);
    Property getPropertyById(int id);
    List<Property> getAllProperties();
    void updateProperty(Property property);
    void deleteProperty(int id);
    List<Property> getPropertiesByLandlord(int landlordId);
    List<Property> searchProperties(String type, String address);
}
