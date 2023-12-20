package com.projects.bms.Repository;

import com.projects.bms.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
    @Override
    Optional<ShowSeat> findById(Integer integer);

    @Override
    ShowSeat save(ShowSeat showSeat);

}
