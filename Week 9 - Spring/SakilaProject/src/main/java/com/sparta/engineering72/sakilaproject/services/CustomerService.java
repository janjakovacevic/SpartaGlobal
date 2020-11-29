package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.respositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public List<Customer> getCustomersByFirstName(String firstName){
        return customerRepository.getCustomersByFirstName(firstName);
    }

    public List<Customer> getCustomersByLastName(String lastName){
        return customerRepository.getCustomersByLastName(lastName);
    }

    public List<Customer> getCustomersByFullName(String firstName, String lastName){
        return customerRepository.getCustomersByFullName(firstName, lastName);
    }

    public Customer getCustomerByID(int id){
        return customerRepository.getCustomerByCustomerId(id);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.getCustomerByEmail(email);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Integer getCustomerCount(){
        return customerRepository.getCustomerCount();
    }
}
