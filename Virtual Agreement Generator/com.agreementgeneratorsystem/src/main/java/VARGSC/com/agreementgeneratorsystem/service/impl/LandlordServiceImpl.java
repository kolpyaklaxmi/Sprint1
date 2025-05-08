package VARGSC.com.agreementgeneratorsystem.service.impl;

import VARGSC.com.agreementgeneratorsystem.dao.LandlordDAO;
import VARGSC.com.agreementgeneratorsystem.dao.impl.LandlordDAOImpl;
import VARGSC.com.agreementgeneratorsystem.entity.Landlord;
import VARGSC.com.agreementgeneratorsystem.service.LandlordService;

import java.util.List;

public class LandlordServiceImpl implements LandlordService {
    private LandlordDAO landlordDAO = new LandlordDAOImpl();

    // Constructor to initialize the DAO
    public LandlordServiceImpl() {
        this.landlordDAO = new LandlordDAOImpl();
    }

    // Add landlord using the DAO
    @Override
    public void addLandlord(Landlord landlord) {
        landlordDAO.save(landlord);
    }

    // Get landlord by ID using the DAO
    @Override
    public Landlord getLandlordById(int id) {
        return landlordDAO.getLandlordById(id);
    }

    // Get all landlords using the DAO
    @Override
    public List<Landlord> getAllLandlords() {
        return landlordDAO.getAllLandlords();
    }

    // Update landlord using the DAO
    @Override
    public void updateLandlord(Landlord landlord) {
        landlordDAO.updateLandlord(landlord);
    }

    // Delete landlord using the DAO
    @Override
    public void deleteLandlord(int id) {
        landlordDAO.deleteLandlord(id);
    }
}
