package VARGSC.com.agreementgeneratorsystem.service;

import VARGSC.com.agreementgeneratorsystem.entity.Agreement;

import java.util.List;

public interface AgreementService {
    void createAgreement(Agreement agreement);
    Agreement getAgreementById(int id);
    List<Agreement> getAllAgreements();
    void updateAgreement(Agreement agreement);
    void deleteAgreement(int id);
}
