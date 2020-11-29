package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.entities.Inventory;
import com.sparta.engineering72.sakilaproject.entities.Rental;
import com.sparta.engineering72.sakilaproject.services.CustomerService;
import com.sparta.engineering72.sakilaproject.services.FilmService;
import com.sparta.engineering72.sakilaproject.services.InventoryService;
import com.sparta.engineering72.sakilaproject.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Controller
public class FilmController {

    private FilmService filmService;
    private InventoryService inventoryService;
    private RentalService rentalService;
    private CustomerService customerService;

    @Autowired
    public FilmController(FilmService filmService, InventoryService inventoryService, RentalService rentalService, CustomerService customerService) {
        this.filmService = filmService;
        this.inventoryService = inventoryService;
        this.rentalService = rentalService;
        this.customerService = customerService;
    }

    @GetMapping("/films")
    public String getFilms(ModelMap modelMap, @RequestParam(value = "title", defaultValue = "ALL FILMS") String filter) {
        List<Film> films;
        if (filter.equals("ALL FILMS")){
            films = filmService.getAllFilms();
        }
        else {
            films = filmService.getFilmsByTitle(filter);
        }
//        modelMap.addAttribute("title", filmService.getFilmsByTitle(title));
        modelMap.addAttribute("films", films);
        modelMap.addAttribute("availableFilms", filmService.getAvailableFilms());
        modelMap.addAttribute("allFilms", filmService.getAllFilms());
        return "/films/films";
    }

    @GetMapping("/films/details")
    public String getFilmDetails(ModelMap modelMap, @RequestParam(value = "id") Integer id) {
        Film film = filmService.getFilmByID(id);
        boolean available = filmService.getAvailableFilms().contains(film);
        modelMap.addAttribute("available", available);
        modelMap.addAttribute("details", film);
        return "films/filmDetails";
    }

    @GetMapping("/rent/{filmid}")
    public String rentFilm(ModelMap modelMap, Principal principal,
                           @PathVariable("filmid") int filmid){
        String name = principal.getName();
        Customer customer = customerService.getCustomerByEmail(name);
        List<Inventory> inventoryList = inventoryService.getAllInventory();
        for (Inventory inventory : inventoryList){
            if (inventory.getFilmId() == filmid){
                LocalDateTime returnDate = LocalDateTime.now().plusDays(filmService.getFilmByID(inventory.getFilmId()).getRentalDuration());
//                inventoryService.deleteInventoryItemById(inventory.getFilmId());
                rentalService.addRental(inventory.getInventoryId(), customer.getCustomerId(), Timestamp.valueOf(returnDate));
                break;
            }
        }
        modelMap.addAttribute("rent","Rented");
        return "redirect:/films";
    }

    @GetMapping("/owner/manage-films")
    public String getFilmDetails(ModelMap modelMap,
                                 @RequestParam(value = "title", defaultValue = "ALL FILMS") String filter) {


        List<Film> films;
        if (filter.equals("ALL FILMS")){
            films = filmService.getAllFilms();
        }
        else {
            films = filmService.getFilmsByTitle(filter);
        }

        List<Film> allFilms = filmService.getAllFilms();
        HashMap<Integer, Integer> filmCount = new HashMap<>();
        for(Film film : allFilms){
            filmCount.put(film.getFilmId(), filmService.getAvailableFilmCount(film.getFilmId()));
        }

        modelMap.addAttribute("films", films);
        modelMap.addAttribute("filmCount", filmCount);
        modelMap.addAttribute("allFilms", films);
        return "/owner/manage-films";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("/owner/edit-film");
        Film film = filmService.getFilmByID(id);
        mav.addObject("film", film);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        filmService.deleteFilmById(id);
        return "redirect:/owner/manage-films";
    }


    public Film findFilmByID(Integer id) {
        return filmService.getFilmByID(id);
    }

}
