package com.sparta.engineering72.sakilaproject.entities;

public class Order {
    private Customer customer;
    private Film film;
    private Rental rental;

    public Order(Customer customer, Film film, Rental rental) {
        this.customer = customer;
        this.film = film;
        this.rental = rental;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
