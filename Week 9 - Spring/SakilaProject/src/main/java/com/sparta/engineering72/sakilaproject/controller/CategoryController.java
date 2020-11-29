package com.sparta.engineering72.sakilaproject.controller;

import com.sparta.engineering72.sakilaproject.entities.Category;
import com.sparta.engineering72.sakilaproject.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

    private FilmService filmService;
    private CategoryService categoryService;

    @Autowired
    public CategoryController(FilmService filmService, CategoryService categoryService) {
        this.filmService = filmService;
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String getCategories(ModelMap modelMap) {
        modelMap.addAttribute("allCategories", categoryService.getAllCategories());
        return "/categories/categories";
    }

    @GetMapping("/categories/details")
    public String getCategoryDetails(ModelMap modelMap,
                                 @RequestParam(value = "id") Integer id) {
        modelMap.addAttribute("category", categoryService.getByCategoryId(id));
        modelMap.addAttribute("films", filmService.getFilmsByCategory(id));
        return "categories/categoryDetails";    }

        public Category getCategoryById(Integer id) {
            return categoryService.getByCategoryId(id);
        }

}
