package com.sparta.engineering72.sakilaproject;
import com.sparta.engineering72.sakilaproject.controller.ActorController;
import com.sparta.engineering72.sakilaproject.controller.CategoryController;
import com.sparta.engineering72.sakilaproject.controller.CustomerController;
import com.sparta.engineering72.sakilaproject.controller.FilmController;
import com.sparta.engineering72.sakilaproject.entities.*;
import com.sparta.engineering72.sakilaproject.respositories.*;
import com.sparta.engineering72.sakilaproject.services.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.ui.ModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.Silent.class)
public class MockTests {


    @Spy
    ActorRepository actorRepository;
    @Spy
    FilmRepository filmRepository;
    @Spy
    CustomerRepository customerRepository;

    @Spy
    CategoryRepository categoryRepository;

    @Spy
    StaffRepository staffRepository;

    @Spy
    RentalRepository rentalRepository;

    @Spy
    InventoryRepository inventoryRepository;

    @Spy @InjectMocks
    ActorService actorService;

    @Spy @InjectMocks
    CategoryService categoryService;

    @Spy @InjectMocks
    FilmService filmService;

    @Spy @InjectMocks
    CustomerService customerService;

    @Spy @InjectMocks
    InventoryService inventoryService;

    @Spy @InjectMocks
    RentalService rentalService;

    @InjectMocks
    ActorController actorController;

    @InjectMocks
    FilmController filmController;

    @InjectMocks
    CategoryController categoryController;

    @Before()
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testActorById() {
        Actor actor = new Actor();
        actor.setActorId(10);
        when(actorRepository.getActorByActorId(10)).thenReturn(actor);
        Actor a = actorController.findActorById(10);
        System.out.println(actor.getFirstName());
        assertEquals(10, a.getActorId());
    }

    @Test
    public void testActorByFirstName() {
        Actor actor1 = new Actor();
        actor1.setFirstName("Frank");
        actor1.setActorId(1);
        when(actorRepository.getActorByActorId(1)).thenReturn((actor1));
        Actor aa = actorController.findActorById(1);
        assertEquals("Frank", aa.getFirstName());
    }

    @Test
    public void testActorByLastName() {
        Actor actor2 = new Actor();
        actor2.setLastName("Gomez");
        actor2.setActorId(2);
        when(actorRepository.getActorByActorId(2)).thenReturn((actor2));
        Actor aaa = actorController.findActorById(2);
        assertEquals("Gomez", aaa.getLastName());
    }

    @Test
    public void testActorByMore() {
        Actor actor3 = new Actor();
        actor3.setFirstName("Justin");
        actor3.setActorId(3);
        actor3.setLastName("Timberlake");
        when(actorRepository.getActorByActorId(3)).thenReturn((actor3));
        Actor aaaa = actorController.findActorById(3);
        assertEquals("Justin", aaaa.getFirstName());
        assertEquals("Timberlake", aaaa.getLastName());
    }

    @Test
    public void testActorByFullName() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Actor actor4 = new Actor();
        actor4.setFirstName("Leo");
        actor4.setActorId(3);
        actor4.setLastName("DiCaprio");
        actor4.setLastUpdate(timestamp);
        when(actorRepository.getActorByActorId(3)).thenReturn((actor4));
        Actor aaaa = actorController.findActorById(3);
        assertEquals(timestamp.toString(),aaaa.getLastUpdate().toString());
    }

    @Test
    public void testFilmByID() {
        FilmActor theFilmActor = new FilmActor();
        Actor filmActor = new Actor();
        theFilmActor.setActorId(filmActor.getActorId());
        Film film = new Film();
        film.setFilmId(1);
        when(filmRepository.getFilmByFilmId(1)).thenReturn((film));
        Film theFilm = filmController.findFilmByID(1);
        assertEquals(1, theFilm.getFilmId());
    }

    @Test
    public void testFilmByDescritption() {
        Film film = new Film();
        film.setDescription("Horror");
        film.setFilmId(2);
        when(filmRepository.getFilmByFilmId(2)).thenReturn((film));
        Film theFilm = filmController.findFilmByID(2);
        assertEquals("Horror", theFilm.getDescription());
    }

    @Test
    public void testFilmByRating() {
        Film film = new Film();
        film.setRating("18");
        film.setFilmId(3);
        when(filmRepository.getFilmByFilmId(3)).thenReturn((film));
        Film theFilm = filmController.findFilmByID(3);
        assertEquals("18", theFilm.getRating());
    }

    @Test
    public void testFilmByLength() {
        Film film = new Film();
        film.setLength(200);
        film.setFilmId(4);
        when(filmRepository.getFilmByFilmId(4)).thenReturn((film));
        Film theFilm = filmController.findFilmByID(4);
        assertEquals(200, theFilm.getLength());
    }

    @Test
    public void testFilmByName() {
        Film film = new Film();
        film.setTitle("Goodfellas");
        film.setFilmId(5);
        when(filmRepository.getFilmByFilmId(5)).thenReturn((film));
        Film theFilm = filmController.findFilmByID(5);
        assertEquals( "Goodfellas" , theFilm.getTitle());
    }

    @Test
    public void testFilmByDescription() {
        Film film = new Film();
        film.setDescription("This is a long description");
        film.setFilmId(5);
        when(filmRepository.getFilmByFilmId(5)).thenReturn((film));
        Film theFilm = film;
        assertEquals( "This is a long description" , theFilm.getDescription());
    }


    @Test
    public void testFilms() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Film film = new Film();
        film.setLastUpdate(timestamp);
        film.setTitle("Goodfellas");
        film.setFilmId(5);
        film.setSpecialFeatures("Special");
        film.setReplacementCost(BigDecimal.valueOf(0.999));
        film.setRentalRate(BigDecimal.valueOf(0.888));
        film.setRentalDuration(10);
        film.setReleaseYear(2000);
        when(filmRepository.getFilmByFilmId(5)).thenReturn((film));
        Film theFilm = film;
        assertEquals( timestamp.toString() , theFilm.getLastUpdate().toString());
        assertEquals(  10, theFilm.getRentalDuration());
        assertEquals(  BigDecimal.valueOf(0.999), theFilm.getReplacementCost());
        assertEquals(  BigDecimal.valueOf(0.888), theFilm.getRentalRate());
        assertEquals(  2000, theFilm.getReleaseYear());
    }

    @Test
    public void testCategoryById() {
        Category category = new Category();
        category.setCategoryId(10);
        when(categoryRepository.getCategoryByCategoryId(10)).thenReturn((category));
        Category secondCategory = categoryController.getCategoryById(10);
        assertEquals( 10 , secondCategory.getCategoryId());
    }

    @Test
    public void testCategoryByName() {
        Category category = new Category();
        category.setName("Category");
        category.setCategoryId(10);
        when(categoryRepository.getCategoryByCategoryId(10)).thenReturn((category));
        Category secondCategory = category;
        assertEquals( 10 , secondCategory.getCategoryId());
    }

    @Test
    public void testCustomerById() {
        Customer customer = new Customer();
        customer.setCustomerId(10);
        when(customerRepository.getCustomerByCustomerId(10)).thenReturn((customer));
        Customer secondCustomer = customer;
        assertEquals( 10 , secondCustomer.getCustomerId());
    }

    @Test
    public void testCustomer() {
        Date date = new Date();
        Customer customer = new Customer();
        customer.setEmail("email");
        customer.setCustomerId(10);
        customer.setCreateDate(new Timestamp(date.getTime()));
        customer.setFirstName("Paul");
        customer.setLastName("Watson");
        when(customerRepository.getCustomerByCustomerId(10)).thenReturn((customer));
        Customer secondCustomer = customer;
        assertEquals( 10 , secondCustomer.getCustomerId());
        assertEquals( "email" , secondCustomer.getEmail());
        assertEquals( date , secondCustomer.getCreateDate());
        assertEquals( "Paul" , secondCustomer.getFirstName());
        assertEquals( "Watson" , secondCustomer.getLastName());

    }

    @Test
    public void testStaff() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Staff staff = new Staff();
        staff.setEmail("email");
        staff.setStaffId(10);
        staff.setFirstName("Paul");
        staff.setLastName("Watson");
        staff.setLastUpdate(timestamp);
        staff.setPassword("Password");
        staff.setUsername("Username");
        when(staffRepository.getStaffByUsername("Username")).thenReturn((staff));
        Staff secondStaff = staff;
        assertEquals( 10 , secondStaff.getStaffId());
        assertEquals( "email" , secondStaff.getEmail());
        assertEquals( "Paul" , secondStaff.getFirstName());
        assertEquals( "Watson" , secondStaff.getLastName());
        assertEquals( timestamp.toString(), secondStaff.getLastUpdate().toString());
        assertEquals( "Password" , secondStaff.getPassword());
        assertEquals( "Username" , secondStaff.getUsername());

    }

    @Test
    public void testFilmController() {
        ModelMap modelMap = new ModelMap();
        FilmController filmController = new FilmController(filmService, inventoryService, rentalService, customerService);
        String result = filmController.getFilmDetails(modelMap , 10);
        assertEquals( result , "films/filmDetails");
    }

    @Test
    public void testFilmController2() {
        ModelMap modelMap = new ModelMap();
        FilmController filmController = new FilmController(filmService, inventoryService, rentalService, customerService);
        String result = filmController.getFilms(modelMap , "Filter");
        assertEquals( result ,  "/films/films");
    }

    @Test
    public void testCategory() {
        ModelMap modelMap = new ModelMap();
        CategoryController categoryController = new CategoryController(filmService, categoryService);
        String result = categoryController.getCategoryDetails(modelMap , 10);
        assertEquals( result ,  "categories/categoryDetails");
    }

    @Test
    public void testCategory2() {
        ModelMap modelMap = new ModelMap();
        CategoryController categoryController = new CategoryController(filmService, categoryService);
        String result = categoryController.getCategories(modelMap);
        assertEquals( result,  "/categories/categories");
    }

    @Test
    public void testActorController1() {
        ModelMap modelMap = new ModelMap();
        ActorController actorController = new ActorController(filmService, actorService);
        String result = actorController.getActors(modelMap , "FirstName" , "LastName");
        assertEquals( result,   "actors/actors");
    }

    @Test
    public void testCustomerController() {
        ModelMap modelMap = new ModelMap();
        CustomerController customerController = new CustomerController(customerService, rentalService, inventoryService, filmService);
        String result = customerController.getCustomers(modelMap, "ALL CUSTOMERS", "ALL CUSTOMERS");
        assertEquals( result,   "owner/customers");

    }

    @Test
    public void testCustomerController2() {
        ModelMap modelMap = new ModelMap();
        CustomerController customerController = new CustomerController(customerService, rentalService, inventoryService, filmService);
        String result = customerController.showUsersRentalHistory(modelMap , 10);
        assertEquals( result,   "owner/customerDetails");
    }

    @Test
    public void testInventory() {
        Date date = new Date(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(date.getTime());
        Timestamp timestamp1 = new Timestamp(timestamp.getTime());
        Film film = new Film();
        film.setReleaseYear(2000);
        film.setLastUpdate(timestamp);
        Inventory inventory = new Inventory();
        inventory.setFilmId(film.getFilmId());
        inventory.setInventoryId(10);
        inventory.setLastUpdate(timestamp1);
        when(inventoryRepository.getInventoriesByInventoryId(10)).thenReturn((inventory));
        Inventory secondInventory = inventory;
        assertEquals( 10 , secondInventory.getInventoryId());
        assertEquals( timestamp.toString() , secondInventory.getLastUpdate().toString());
        assertEquals( timestamp1.toString() , secondInventory.getLastUpdate().toString());
        System.out.println(date.toString());
    }


    @Test
    public void testRental() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Inventory inventory = new Inventory();
        Customer customer = new Customer();
        customer.setFirstName("James");
        customer.setLastName("Peak");
        Staff staff = new Staff();
        staff.setFirstName("Paul");
        staff.setLastName("Watson");
        Rental rental = new Rental();
        rental.setRentalId(10);
        rental.setReturnDate(timestamp);
        rental.setRentalDate(timestamp);
        rental.setInventoryId(inventory.getInventoryId());
        rental.setCustomerId(customer.getCustomerId());
        rental.setLastUpdate(timestamp);
        rental.setStaffId(staff.getStaffId());

        when(rentalRepository.getRentalByRentalId(10)).thenReturn((rental));
        Rental secondRental = rental;
        assertEquals( 10 , secondRental.getRentalId());
        assertEquals( inventory.getInventoryId() , secondRental.getInventoryId());
        assertEquals( timestamp.toString() , secondRental.getLastUpdate().toString());
        assertEquals( customer.getCustomerId(), secondRental.getCustomerId());
        assertEquals( staff.getStaffId(), secondRental.getStaffId());
        assertEquals( timestamp.toString(), secondRental.getReturnDate().toString());
        assertEquals( timestamp.toString(), secondRental.getRentalDate().toString());

    }

    @Test
    public void testCategoryByTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Category category = new Category();
        category.setLastUpdate(timestamp);
        category.setCategoryId(10);
        when(categoryRepository.getCategoryByCategoryId(10)).thenReturn((category));
        Category secondCategory = category;
        assertEquals( timestamp.toString() , secondCategory.getLastUpdate().toString());
    }

}
