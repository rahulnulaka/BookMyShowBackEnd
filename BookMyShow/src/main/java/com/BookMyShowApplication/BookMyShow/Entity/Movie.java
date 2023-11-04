package com.BookMyShowApplication.BookMyShow.Entity;

import com.BookMyShowApplication.BookMyShow.Enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer movieId;

    @Column(unique = true)
    String movieName;

    double rating;

    @Enumerated(value=EnumType.STRING)
    Genre genre;

    LocalDate releasedDate;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    List<Show> showList=new ArrayList<>();

}
