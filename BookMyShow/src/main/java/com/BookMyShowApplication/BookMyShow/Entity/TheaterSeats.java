package com.BookMyShowApplication.BookMyShow.Entity;

import com.BookMyShowApplication.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TheaterSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String seatNo;

    @Enumerated(value = EnumType.STRING)
    SeatType seatType;

    @ManyToOne
    @JoinColumn
    Theater theater;
}
