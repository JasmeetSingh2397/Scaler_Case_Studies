package com.scaler.bookmyshow.Repositories;

import com.scaler.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface ShowRepository extends JpaRepository<Show, Long> {
    Optional<Show> findById(Long showId);


}
