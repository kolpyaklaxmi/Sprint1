package VARGSC.com.agreementgeneratorsystem.dao;

import VARGSC.com.agreementgeneratorsystem.entity.Agreement;
import java.util.List;

public interface AgreementDAO {

    // Create new agreement
    void createAgreement(Agreement agreement);

    // Get agreement by ID
    Agreement getAgreementById(int id);

    // Get all agreements
    List<Agreement> getAllAgreements();

    // Update agreement
    void updateAgreement(Agreement agreement);

    // Delete agreement
    void deleteAgreement(int id);
}
