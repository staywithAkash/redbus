package com.redbus.operator.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.redbus.operator.payload.BookingDetailsDto;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    public byte[] generatePdf(BookingDetailsDto bookingDetails) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, baos);

            document.open();
            addContent(document, bookingDetails);
            document.close();

            return baos.toByteArray();
        } catch (DocumentException e) {
            throw new IOException("Error generating PDF", e);
        }
    }

    private void addContent(Document document, BookingDetailsDto bookingDetails) throws DocumentException {
        document.add(new Paragraph("Booking Details:"));
        document.add(new Paragraph("Booking ID: " + bookingDetails.getBookingId()));
        document.add(new Paragraph("Bus ID: " + bookingDetails.getBusId()));
        document.add(new Paragraph("Ticket ID: " + bookingDetails.getTicketId()));
        document.add(new Paragraph("Ticket Cost: " + bookingDetails.getTicketCost()));
        document.add(new Paragraph("First Name: " + bookingDetails.getFirstName()));
        document.add(new Paragraph("Last Name: " + bookingDetails.getLastName()));
        document.add(new Paragraph("Date of Birth: " + bookingDetails.getDob()));
        document.add(new Paragraph("Email: " + bookingDetails.getEmail()));
        document.add(new Paragraph("Mobile: " + bookingDetails.getMobile()));
        document.add(new Paragraph("From City: " + bookingDetails.getFromCity()));
        document.add(new Paragraph("To City: " + bookingDetails.getToCity()));
    }
}
