package com.praveen.service;

import com.praveen.model.Passenger;
import com.praveen.model.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    private Map<Integer, Ticket> ticketMap = new HashMap<>();
    private Integer ticketNum = 1;

    @Override
    public Ticket bookTicket(Passenger passenger) {
        Ticket t = new Ticket();
        BeanUtils.copyProperties(passenger, t);
        t.setTicketNumber(ticketNum);
        t.setStatus("CONFIRMED");
        t.setTicketCost(550.00);
        ticketMap.put(ticketNum, t);
        ticketNum++;
        return t;
    }

    @Override
    public Ticket getTicket(Integer ticketNumber) {
        if (ticketMap.containsKey(ticketNumber)) {
            return ticketMap.get(ticketNumber);
        }
        return null;
    }
}
