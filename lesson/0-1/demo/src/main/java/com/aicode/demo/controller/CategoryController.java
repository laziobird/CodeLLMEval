package com.aicode.demo.controller;

import com.aicode.demo.entity.Category;
import com.aicode.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.list();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @GetMapping("/search")
    public List<Category> searchCategories(@RequestParam(required = false) Long id, @RequestParam(required = false) String name) {
        return categoryService.lambdaQuery()
                .eq(id != null, Category::getId, id)
                .like(name != null, Category::getName, name)
                .list();
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
    public boolean deleteCategory(@PathVariable Long id) {
        return categoryService.removeById(id);
    }
}