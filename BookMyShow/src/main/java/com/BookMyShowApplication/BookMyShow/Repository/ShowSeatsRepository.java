package com.BookMyShowApplication.BookMyShow.Repository;

import com.BookMyShowApplication.BookMyShow.Entity.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeats,Integer> {
}
