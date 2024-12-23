package com.praveen.controller;

import com.praveen.model.Passenger;
import com.praveen.model.Ticket;
import com.praveen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingRestController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/ticket",consumes = "application/json",produces = "application/json")
    public ResponseEntity<Ticket> ticketBooking(@RequestBody Passenger passenger){
        Ticket ticket = bookService.bookTicket(passenger);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @GetMapping(value = "/ticket/{ticketNumber}",produces = "application/json")
    public Ticket getTicketByNum(@PathVariable("ticketNumber") Integer ticketNumber){
        return bookService.getTicket(ticketNumber);
    }

}

