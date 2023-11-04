package com.BookMyShowApplication.BookMyShow.Entity;

import com.BookMyShowApplication.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ShowSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer showId;

    String seatNo;

    @Enumerated(value = EnumType.STRING)
    SeatType seatType;

    Integer cost;

    boolean isAvailable;

    boolean isFoodAttached;

    @ManyToOne
    @JoinColumn
    Show show;

}
