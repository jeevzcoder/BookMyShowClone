package com.projects.bms.Repository;

import com.projects.bms.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Integer> {
    @Override
    Optional<Show> findById(Integer integer);
}
