package VARGSC.com.agreementgeneratorsystem.service.impl;

import VARGSC.com.agreementgeneratorsystem.dao.PaymentDAO;
import VARGSC.com.agreementgeneratorsystem.dao.impl.PaymentDAOImpl;
import VARGSC.com.agreementgeneratorsystem.entity.Payment;
import VARGSC.com.agreementgeneratorsystem.service.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private PaymentDAO paymentDAO;

    public PaymentServiceImpl() {
        paymentDAO = new PaymentDAOImpl();
    }

    @Override
    public void addPaymentDetails(Payment payment) {
        paymentDAO.addPaymentDetails(payment);
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentDAO.getPaymentById(id);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentDAO.getAllPayments();
    }

    @Override
    public void updatePaymentDetails(Payment payment) {
        paymentDAO.updatePaymentDetails(payment);
    }

    @Override
    public void deletePayment(int id) {
        paymentDAO.deletePayment(id);
    }

    @Override
    public List<Payment> getPaymentsByStatus(String status) {
        return paymentDAO.getPaymentsByStatus(status);
    }

    @Override
    public List<Payment> getPaymentsByLandlord(int landlordId) {
        return paymentDAO.getPaymentsByLandlord(landlordId); // Implement logic to get payments by landlord
    }

    @Override
    public void makePayment(Payment payment) {
        paymentDAO.addPaymentDetails(payment); // Handle adding payment details
    }
}
