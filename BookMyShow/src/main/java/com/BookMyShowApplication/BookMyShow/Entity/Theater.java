package com.BookMyShowApplication.BookMyShow.Entity;
import com.BookMyShowApplication.BookMyShow.Enums.City;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer theaterId;

    String name;

    String address;

    @Enumerated(value = EnumType.STRING)
    City city;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<TheaterSeats> theaterSeatsList=new ArrayList<>();

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    List<Show> showList=new ArrayList<>();
}
