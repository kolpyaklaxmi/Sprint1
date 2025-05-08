package VARGSC.com.agreementgeneratorsystem.dao;

import VARGSC.com.agreementgeneratorsystem.entity.Payment;

import java.util.List;

public interface PaymentDAO {
    // Method to add a payment detail
    void addPaymentDetails(Payment payment);

    // Method to get payment by its ID
    Payment getPaymentById(int id);

    // Method to get all payments
    List<Payment> getAllPayments();

    // Method to update payment details
    void updatePaymentDetails(Payment payment);

    // Method to delete a payment by its ID
    void deletePayment(int id);

    // Method to get payments by status (e.g., "Paid", "Pending")
    List<Payment> getPaymentsByStatus(String status);

    // Method to get payments by landlord's ID
    List<Payment> getPaymentsByLandlord(int landlordId);
}
