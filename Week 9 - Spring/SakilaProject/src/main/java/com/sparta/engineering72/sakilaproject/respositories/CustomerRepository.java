package com.sparta.engineering72.sakilaproject.respositories;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT * FROM customer c WHERE c.email = :username AND c.customer_id = :password",
            nativeQuery = true)
    Customer getCustomerByCredentials(String username, Integer password);

    @Query(value = "SELECT * FROM customer c WHERE c.email = :username",
            nativeQuery = true)
    Customer getCustomerByUsername(String username);

    @Query(value = "SELECT * FROM customer c WHERE c.first_name = :firstName",
            nativeQuery = true)
    List<Customer> getCustomersByFirstName(String firstName);

    @Query(value = "SELECT * FROM customer c WHERE c.last_name = :lastName",
            nativeQuery = true)
    List<Customer> getCustomersByLastName(String lastName);

    @Query(value = "SELECT * FROM customer c WHERE c.first_name = :firstName AND c.last_name = :lastName",
            nativeQuery = true)
    List<Customer> getCustomersByFullName(String firstName, String lastName);

    Customer getCustomerByCustomerId(Integer id);
    Customer getCustomerByEmail(String email);

    @Query(value = "SELECT COUNT(*) FROM customer c",
            nativeQuery = true)
    Integer getCustomerCount();
}
