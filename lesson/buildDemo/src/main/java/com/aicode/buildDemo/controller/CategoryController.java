package com.aicode.buildDemo.controller;

import com.aicode.buildDemo.entity.Category;
import com.aicode.buildDemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.list();
    }

    @PostMapping
    public boolean addCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping
    public boolean updateCategory(@RequestBody Category category) {
        return categoryService.updateById(category);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable Integer id) {
        return categoryService.removeById(id);
    }
}