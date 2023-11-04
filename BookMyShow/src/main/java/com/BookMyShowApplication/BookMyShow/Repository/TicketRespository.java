package com.BookMyShowApplication.BookMyShow.Repository;

import com.BookMyShowApplication.BookMyShow.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRespository extends JpaRepository<Ticket,Integer> {

}
