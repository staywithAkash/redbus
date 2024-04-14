package com.redbus.user.controller;

import com.redbus.operator.payload.BookingDetailsDto;
import com.redbus.operator.util.EmailService;
import com.redbus.operator.util.PdfService;
import com.redbus.user.payload.PersonalDetailDto;
import com.redbus.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    private final UserServiceImpl userService;
    private final EmailService emailService;
    private final PdfService pdfService;

    public BookingController(UserServiceImpl userService, EmailService emailService, PdfService pdfService) {
        this.userService = userService;
        this.emailService = emailService;
        this.pdfService = pdfService;
    }

    // http://localhost:8080/api/booking/bookingdetails?busId=
    @PostMapping("/bookingdetails")
    public ResponseEntity<BookingDetailsDto> booking(
            @RequestParam String busId,
            @RequestBody PersonalDetailDto bookingDetailsDto
    ) {
        BookingDetailsDto booking = userService.createBooking(busId, bookingDetailsDto);
        if (booking != null) {
            // Send confirmation email with PDF attachment
            try {
                byte[] pdfBytes = pdfService.generatePdf(booking);
                emailService.sendEmailWithAttachment(
                        bookingDetailsDto.getEmail(),
                        "Booking confirmed with booking id " + booking.getBookingId(),
                        "Hello " + bookingDetailsDto.getFirstName() + " " + bookingDetailsDto.getLastName() +
                                "\nYour booking is confirmed. Please find the attached PDF for details.",
                        "booking_details.pdf", // Attachment file name
                        pdfBytes
                );
            } catch (Exception e) {
                e.printStackTrace();
                // Handle exception, log, or inform the user about the issue with sending the PDF
            }
        }
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}
