package VARGSC.com.agreementgeneratorsystem.service;

import VARGSC.com.agreementgeneratorsystem.entity.Payment;
import java.util.List;

public interface PaymentService {
    void addPaymentDetails(Payment payment);
    Payment getPaymentById(int id);
    List<Payment> getAllPayments();
    void updatePaymentDetails(Payment payment);
    void deletePayment(int id);
    List<Payment> getPaymentsByStatus(String status);
    List<Payment> getPaymentsByLandlord(int landlordId);  // Method to get payments by landlord
    void makePayment(Payment payment);  // Method to process a payment
}
