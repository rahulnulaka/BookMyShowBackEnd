package com.BookMyShowApplication.BookMyShow.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ticketId;

    String movieName;

    LocalDate showDate;

    LocalTime showTime;

    String seatNos;

    String theaterAddress;

    Integer totalPrice;

    @ManyToOne
    @JoinColumn
    Show show;

    @ManyToOne
    @JoinColumn
    User user;
}
