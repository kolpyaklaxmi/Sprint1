package VARGSC.com.agreementgeneratorsystem;

import VARGSC.com.agreementgeneratorsystem.entity.*;
import VARGSC.com.agreementgeneratorsystem.service.*;
import VARGSC.com.agreementgeneratorsystem.service.impl.*;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LandlordService landlordService = new LandlordServiceImpl();
        TenantService tenantService = new TenantServiceImpl();
        PropertyService propertyService = new PropertyServiceImpl();
        AgreementService agreementService = new AgreementServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n🔸 Welcome to Agreement Generator System 🔸");
                System.out.println("1. Landlord Register/Login");
                System.out.println("2. Tenant Register/Login");
                System.out.println("3. Exit");
                System.out.print("Choose Option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Landlord Name: ");
                        String lname = sc.nextLine();
                        System.out.print("Email: ");
                        String lemail = sc.nextLine();
                        System.out.print("Phone: ");
                        String lphone = sc.nextLine();
                        System.out.print("Create Password: ");
                        String lpass = sc.nextLine();

                        Landlord landlord = new Landlord();
                        landlord.setName(lname);
                        landlord.setEmail(lemail);
                        landlord.setPhoneNumber(lphone);
                        landlord.setPassword(lpass);

                        landlordService.addLandlord(landlord);
                        System.out.println("✅ Landlord Registered Successfully!");

                        boolean landlordLoop = true;
                        while (landlordLoop) {
                            System.out.println("\n🔹 Landlord Menu 🔹");
                            System.out.println("1. Add Property");
                            System.out.println("2. View My Properties");
                            System.out.println("3. Update Property");
                            System.out.println("4. Delete Property");
                            System.out.println("5. View Payments");
                            System.out.println("6. Back");
                            System.out.print("Choose Option: ");
                            int lopt = sc.nextInt();
                            sc.nextLine();

                            switch (lopt) {
                                case 1:
                                    Property prop = new Property();
                                    prop.setLandlord(landlord);
                                    System.out.print("Property Type: ");
                                    prop.setType(sc.nextLine());
                                    System.out.print("Rent Price: ");
                                    prop.setRentPrice(sc.nextDouble());
                                    sc.nextLine();
                                    System.out.print("Description: ");
                                    prop.setDescription(sc.nextLine());
                                    System.out.print("Address: ");
                                    prop.setAddress(sc.nextLine());

                                    propertyService.addProperty(prop);
                                    System.out.println("✅ Property Added!");
                                    break;

                                case 2:
                                    List<Property> properties = propertyService.getPropertiesByLandlord(landlord.getId());
                                    for (Property p : properties) {
                                        System.out.println(p);
                                    }
                                    break;

                                case 3:
                                    System.out.print("Enter Property ID to Update: ");
                                    int pid = sc.nextInt();
                                    sc.nextLine();
                                    Property updateProp = propertyService.getPropertyById(pid);
                                    if (updateProp != null) {
                                        System.out.print("New Rent Price: ");
                                        updateProp.setRentPrice(sc.nextDouble());
                                        sc.nextLine();
                                        System.out.print("New Description: ");
                                        updateProp.setDescription(sc.nextLine());
                                        propertyService.updateProperty(updateProp);
                                        System.out.println("✅ Property Updated.");
                                    } else {
                                        System.out.println("❌ Property Not Found.");
                                    }
                                    break;

                                case 4:
                                    System.out.print("Enter Property ID to Delete: ");
                                    int delId = sc.nextInt();
                                    propertyService.deleteProperty(delId);
                                    System.out.println("✅ Property Deleted.");
                                    break;

                                case 5:
                                    List<Payment> payments = paymentService.getPaymentsByLandlord(landlord.getId());
                                    for (Payment payment : payments) {
                                        System.out.println(payment);
                                    }
                                    break;

                                case 6:
                                    landlordLoop = false;
                                    break;
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Enter Tenant Name: ");
                        String tname = sc.nextLine();
                        System.out.print("Email: ");
                        String temail = sc.nextLine();
                        System.out.print("Phone: ");
                        String tphone = sc.nextLine();
                        System.out.print("Create Password: ");
                        String tpass = sc.nextLine();

                        Tenant tenant = new Tenant();
                        tenant.setName(tname);
                        tenant.setEmail(temail);
                        tenant.setPhoneNumber(tphone);
                        tenant.setPassword(tpass);

                        tenantService.addTenant(tenant);
                        System.out.println("✅ Tenant Registered Successfully!");

                        boolean tenantLoop = true;
                        while (tenantLoop) {
                            System.out.println("\n🔹 Tenant Menu 🔹");
                            System.out.println("1. Search Property");
                            System.out.println("2. Rent Property");
                            System.out.println("3. Make Payment");
                            System.out.println("4. Back");
                            System.out.print("Choose Option: ");
                            int topt = sc.nextInt();
                            sc.nextLine();

                            switch (topt) {
                                case 1:
                                    System.out.print("Enter Property Type: ");
                                    String type = sc.nextLine();
                                    System.out.print("Enter Address/Area: ");
                                    String address = sc.nextLine();
                                    List<Property> results = propertyService.searchProperties(type, address);
                                    for (Property prop : results) {
                                        System.out.println(prop);
                                    }
                                    break;

                                case 2:
                                    System.out.print("Enter Property ID to Rent: ");
                                    int rentPid = sc.nextInt();
                                    sc.nextLine();
                                    Property selectedProp = propertyService.getPropertyById(rentPid);

                                    if (selectedProp != null) {
                                        Agreement agreement = new Agreement();
                                        agreement.setLandlord(selectedProp.getLandlord());
                                        agreement.setTenant(tenant);
                                        agreement.setProperty(selectedProp);

                                        System.out.print("Enter Start Date (yyyy-mm-dd): ");
                                        String startDate = sc.nextLine();
                                        agreement.setStartDate(startDate);

                                        System.out.print("Enter End Date (yyyy-mm-dd): ");
                                        String endDate = sc.nextLine();
                                        agreement.setEndDate(endDate);

                                        agreement.setTerms("Standard 11-month rental terms.");
                                        agreement.setStatus("Active");

                                        agreementService.createAgreement(agreement);
                                        System.out.println("📝 Agreement Created with ID: " + agreement.getId());
                                        System.out.println("✅ Generating PDF...");
                                        System.out.println("📄 PDF Generated.");
                                    } else {
                                        System.out.println("❌ Property Not Found.");
                                    }
                                    break;

                                case 3:
                                    System.out.print("Enter Agreement ID for Payment: ");
                                    int agreementId = sc.nextInt();
                                    System.out.print("Enter Amount: ");
                                    double amount = sc.nextDouble();
                                    sc.nextLine();

                                    Agreement ag = agreementService.getAgreementById(agreementId); // You must have this method

                                    if (ag != null) {
                                        Payment payment = new Payment();
                                        payment.setAgreement(ag);
                                        payment.setAmount(amount);
                                        payment.setPaymentDate("2025-04-25");
                                        payment.setPaymentMethod("Online");
                                        payment.setStatus("Success");

                                        paymentService.makePayment(payment);
                                        System.out.println("✅ Payment Processed.");
                                    } else {
                                        System.out.println("❌ Invalid Agreement ID.");
                                    }
                                    break;

                                case 4:
                                    tenantLoop = false;
                                    break;
                            }
                        }
                        break;

                    case 3:
                        System.out.println("👋 Exiting... Thank you!");
                        System.exit(0);
                }
            }
        }
    }
}
