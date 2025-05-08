package VARGSC.com.agreementgeneratorsystem.dao;

import VARGSC.com.agreementgeneratorsystem.entity.Landlord;
import java.util.List;

public interface LandlordDAO {
    
    // Add new landlord
 	    void save(Landlord landlord);
    
    // Get landlord by ID
    Landlord getLandlordById(int id);
    
    // Get all landlords
    List<Landlord> getAllLandlords();
    
    // Update landlord
    void updateLandlord(Landlord landlord);
    
    // Delete landlord
    void deleteLandlord(int id);
}

