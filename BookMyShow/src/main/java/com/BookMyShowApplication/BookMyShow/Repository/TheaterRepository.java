package com.BookMyShowApplication.BookMyShow.Repository;

import com.BookMyShowApplication.BookMyShow.Entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {

}
