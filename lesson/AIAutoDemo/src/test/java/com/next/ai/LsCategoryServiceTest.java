/*

package com.next.ai;

import com.next.ai.entity.LsCategory;
import com.next.ai.service.LsCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LsCategoryServiceTest {

    @Autowired
    private LsCategoryService lsCategoryService;

    @Test
    void testGetAllCategories() {
        List<LsCategory> allCategories = lsCategoryService.list();
        System.out.println(allCategories!=null?allCategories.size():0);
        assertNotNull(allCategories, "Category list should not be null.");
        assertFalse(allCategories.isEmpty(), "Category list should not be empty.");
    }

    @Test
    void testGetCategoryById() {
        Long categoryId = 851472385L;
        LsCategory category = lsCategoryService.getById(categoryId);
        assertNotNull(category, "Category should not be null.");
        assertEquals(categoryId.toString(), category.getId().toString(), "Category ID should match.");
    }

    @Test
    void testAddCategory() {
        LsCategory newCategory = new LsCategory();
        newCategory.setName("New Category");
        boolean added = lsCategoryService.save(newCategory);
        assertTrue(added, "Category should be added successfully.");
    }

    @Test
    void testUpdateCategory() {
        Integer categoryId = 1;
        LsCategory updatedCategory = new LsCategory();
        updatedCategory.setId(categoryId);
        updatedCategory.setName("Updated Category Name");
        boolean updated = lsCategoryService.updateById(updatedCategory);
        assertTrue(updated, "Category should be updated successfully.");
    }

    @Test
    void testDeleteCategory() {
        Long categoryId = 2L;
        boolean deleted = lsCategoryService.removeById(categoryId);
        assertTrue(deleted, "Category should be deleted successfully.");
    }
}*/
