package VARGSC.com.agreementgeneratorsystem.service.impl;

import VARGSC.com.agreementgeneratorsystem.dao.AgreementDAO;
import VARGSC.com.agreementgeneratorsystem.dao.impl.AgreementDAOImpl;
import VARGSC.com.agreementgeneratorsystem.entity.Agreement;
import VARGSC.com.agreementgeneratorsystem.service.AgreementService;

import java.util.List;

public class AgreementServiceImpl implements AgreementService {

    private AgreementDAO agreementDAO;

    // Constructor to initialize the DAO
    public AgreementServiceImpl() {
        this.agreementDAO = new AgreementDAOImpl();
    }

    // Create new agreement using the DAO
    @Override
    public void createAgreement(Agreement agreement) {
        agreementDAO.createAgreement(agreement);
    }

    // Get agreement by ID using the DAO
    @Override
    public Agreement getAgreementById(int id) {
        return agreementDAO.getAgreementById(id);
    }

    // Get all agreements using the DAO
    @Override
    public List<Agreement> getAllAgreements() {
        return agreementDAO.getAllAgreements();
    }

    // Update agreement using the DAO
    @Override
    public void updateAgreement(Agreement agreement) {
        agreementDAO.updateAgreement(agreement);
    }

    // Delete agreement using the DAO
    @Override
    public void deleteAgreement(int id) {
        agreementDAO.deleteAgreement(id);
    }
}
