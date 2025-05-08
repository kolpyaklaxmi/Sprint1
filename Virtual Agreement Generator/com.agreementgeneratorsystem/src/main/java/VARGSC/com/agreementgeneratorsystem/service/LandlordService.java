package VARGSC.com.agreementgeneratorsystem.service;

import VARGSC.com.agreementgeneratorsystem.entity.Landlord;

import java.util.List;

public interface LandlordService {
    void addLandlord(Landlord landlord);
    Landlord getLandlordById(int id);
    List<Landlord> getAllLandlords();
    void updateLandlord(Landlord landlord);
    void deleteLandlord(int id);
}
