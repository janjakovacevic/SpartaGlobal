package com.sparta.engineering72.sakilaproject.respositories;

import com.sparta.engineering72.sakilaproject.entities.Actor;
import com.sparta.engineering72.sakilaproject.entities.Customer;
import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.entities.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {

    @Query(value = "SELECT count(*) FROM film f INNER JOIN inventory i ON f.film_id = i.film_id WHERE i.film_id = :id",
            nativeQuery = true)
    Integer getAvailableFilmCount(Integer id);

    @Query(value = "SELECT * FROM film f INNER JOIN inventory i ON f.film_id = i.film_id",
            nativeQuery = true)
    List<Film> getAvailableFilms();

    @Query(value = "SELECT * FROM film f INNER JOIN film_category fc ON f.film_id = fc.film_id INNER JOIN category c ON fc.category_id = c.category_id WHERE c.category_id = :categoryId",
            nativeQuery = true)
    List<Film> getAllFilmsByCategory(Integer categoryId);

    @Query(value = "SELECT * FROM actor a INNER JOIN film_actor fa ON a.actor_id = fa.actor_id INNER JOIN film f ON fa.film_id = f.film_id WHERE a.actor_id = :actorId",
            nativeQuery = true)
    List<Film> getAllFilmsByActor(Integer actorId);

    List<Film> findByTitle(String title);
    Film getFilmByFilmId(Integer id);

}
