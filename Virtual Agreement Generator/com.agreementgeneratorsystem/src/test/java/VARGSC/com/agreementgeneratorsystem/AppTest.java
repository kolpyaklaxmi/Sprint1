package VARGSC.com.agreementgeneratorsystem;

import VARGSC.com.agreementgeneratorsystem.entity.*;
import VARGSC.com.agreementgeneratorsystem.service.*;
import VARGSC.com.agreementgeneratorsystem.service.impl.*;

import java.util.*;

public class AppTest {
    public static void main(String[] args) {
        LandlordService landlordService = new LandlordServiceImpl();
        TenantService tenantService = new TenantServiceImpl();
        PropertyService propertyService = new PropertyServiceImpl();
        AgreementService agreementService = new AgreementServiceImpl();

        // Simulate Landlord Registration
        Landlord landlord = new Landlord();
        landlord.setName("TestLandlord");
        landlord.setEmail("landlord@test.com");
        landlord.setPhoneNumber("1234567890");
        landlord.setPassword("test123");
        landlordService.addLandlord(landlord);

        // Simulate Property Addition
        Property property = new Property();
        property.setLandlord(landlord);
        property.setType("2BHK");
        property.setRentPrice(15000.0);
        property.setDescription("Nice flat in center");
        property.setAddress("Mumbai");
        propertyService.addProperty(property);

        // View All Properties by Landlord
        List<Property> properties = propertyService.getPropertiesByLandlord(landlord.getId());
        for (Property p : properties) {
            System.out.println(p);
        }

        // Simulate Tenant Registration
        Tenant tenant = new Tenant();
        tenant.setName("TestTenant");
        tenant.setEmail("tenant@test.com");
        tenant.setPhoneNumber("9876543210");
        tenant.setPassword("tenant123");
        tenantService.addTenant(tenant);

        // Simulate Agreement
        Agreement agreement = new Agreement();
        agreement.setLandlord(landlord);
        agreement.setTenant(tenant);
        agreement.setProperty(property);
        agreement.setStartDate("2025-05-01");
        agreement.setEndDate("2026-04-30");
        agreement.setTerms("Standard 11-month rental terms.");
        agreement.setStatus("Active");
        agreementService.createAgreement(agreement);

        System.out.println("Agreement Created with ID: " + agreement.getId());
    }
}
