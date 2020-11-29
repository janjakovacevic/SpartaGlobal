package com.sparta.engineering72.sakilaproject.services;

import com.sparta.engineering72.sakilaproject.entities.Film;
import com.sparta.engineering72.sakilaproject.respositories.FilmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
    }

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public Film getFilmByID(int id){
        return filmRepository.getFilmByFilmId(id);
    }

    public List<Film> getFilmsByTitle(String title){
        return filmRepository.findByTitle(title);
    }

    public List<Film> getAvailableFilms(){
        return filmRepository.getAvailableFilms();
    }

    public Integer getAvailableFilmCount(Integer id){
        return filmRepository.getAvailableFilmCount(id);
    }

    public List<Film> getFilmsByCategory(Integer id){
        return filmRepository.getAllFilmsByCategory(id);
    }

    public List<Film> getFilmsByActor(Integer id){
        return filmRepository.getAllFilmsByActor(id);
    }

    public void save(Film film) {
        filmRepository.save(film);
    }

    public void deleteFilmById(int id) {
        filmRepository.deleteById(id);
    }

}
