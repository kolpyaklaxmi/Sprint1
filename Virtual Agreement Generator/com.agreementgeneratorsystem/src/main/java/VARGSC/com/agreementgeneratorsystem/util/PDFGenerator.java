package VARGSC.com.agreementgeneratorsystem.util;

import VARGSC.com.agreementgeneratorsystem.entity.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

public class PDFGenerator {

    // Generates a rental agreement PDF
    public static void generate(Agreement agreement) {
        Document document = new Document();
        try {
            // Define PDF output path
            String fileName = "Agreement_" + agreement.getId() + ".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            document.open();

            // Title
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Rental Agreement", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" ")); // spacer

            // Agreement Info
            document.add(new Paragraph("Agreement ID: " + agreement.getId()));
            document.add(new Paragraph("Start Date: " + agreement.getStartDate()));
            document.add(new Paragraph("End Date: " + agreement.getEndDate()));
            document.add(new Paragraph("Status: " + agreement.getStatus()));
            document.add(new Paragraph(" "));

            // Landlord Info
            document.add(new Paragraph("Landlord Details:"));
            document.add(new Paragraph("Name: " + agreement.getLandlord().getName()));
            document.add(new Paragraph("Email: " + agreement.getLandlord().getEmail()));
            document.add(new Paragraph("Phone: " + agreement.getLandlord().getPhoneNumber()));
            document.add(new Paragraph(" "));

            // Tenant Info
            document.add(new Paragraph("Tenant Details:"));
            document.add(new Paragraph("Name: " + agreement.getTenant().getName()));
            document.add(new Paragraph("Email: " + agreement.getTenant().getEmail()));
            document.add(new Paragraph("Phone: " + agreement.getTenant().getPhoneNumber()));
            document.add(new Paragraph(" "));

            // Property Info
            document.add(new Paragraph("Property Details:"));
            document.add(new Paragraph("Type: " + agreement.getProperty().getType()));
            document.add(new Paragraph("Address: " + agreement.getProperty().getAddress()));
            document.add(new Paragraph("Rent Price: ₹" + agreement.getProperty().getRentPrice()));
            document.add(new Paragraph("Description: " + agreement.getProperty().getDescription()));
            document.add(new Paragraph(" "));

            // Terms
            document.add(new Paragraph("Agreement Terms:"));
            document.add(new Paragraph(agreement.getTerms()));
            document.add(new Paragraph(" "));

            // Signature placeholders
            document.add(new Paragraph("Landlord Signature: __________________"));
            document.add(new Paragraph("Tenant Signature: __________________"));

            document.close();

            System.out.println("✅ PDF saved as: " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
