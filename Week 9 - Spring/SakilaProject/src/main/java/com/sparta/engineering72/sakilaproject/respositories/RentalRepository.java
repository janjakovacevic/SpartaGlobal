package com.sparta.engineering72.sakilaproject.respositories;

import com.sparta.engineering72.sakilaproject.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    Rental getRentalByRentalId(Integer id);
    
    @Query(value = "SELECT * FROM rental r INNER JOIN customer c ON r.customer_id = c.customer_id WHERE c.customer_id = :customerId",
            nativeQuery = true)
    List<Rental> getRentalByCustomerId(Integer customerId);

}
