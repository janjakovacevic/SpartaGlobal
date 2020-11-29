package com.sparta.engineering72.sakilaproject.respositories;

import com.sparta.engineering72.sakilaproject.entities.Inventory;
import com.sparta.engineering72.sakilaproject.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    @Query(value = "SELECT * FROM inventory i INNER JOIN rental r ON i.inventory_id = r.inventory_id WHERE i.inventory_id = :inventoryId",
            nativeQuery = true)
    Inventory getInventoriesByInventoryId(Integer inventoryId);

    @Modifying
    @Query(value = "DELETE FROM inventory i WHERE i.film_id = :id",
        nativeQuery = true)
    void deleteInventoryByInventoryId(@Param("id")Integer id);

    @Query(value = "SELECT COUNT(*) FROM inventory i",
            nativeQuery = true)
    Integer getInventoryCount();

}
