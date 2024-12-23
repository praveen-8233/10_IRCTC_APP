package com.praveen.service;

import com.praveen.model.Passenger;
import com.praveen.model.Ticket;

public interface BookService {

    public Ticket bookTicket(Passenger passenger);
    public Ticket getTicket(Integer ticketNumber);
}
