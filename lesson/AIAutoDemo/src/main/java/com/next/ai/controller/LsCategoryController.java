package com.next.ai.controller;

import com.next.ai.entity.LsCategory;
import com.next.ai.service.LsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lsCategory")
public class LsCategoryController {

    @Autowired
    private LsCategoryService lsCategoryService;

    // 获取所有商品类目
    @GetMapping("/")
    public ResponseEntity<List<LsCategory>> getAllLsCategories() {
        List<LsCategory> lsCategoryList = lsCategoryService.list();
        return ResponseEntity.ok(lsCategoryList);
    }

    // 根据ID获取商品类目
    @GetMapping("/{id}")
    public ResponseEntity<LsCategory> getLsCategoryById(@PathVariable Long id) {
        LsCategory lsCategory = lsCategoryService.getById(id);
        if (lsCategory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lsCategory);
    }

    // 创建新的商品类目

    @PostMapping("/")
    public ResponseEntity<LsCategory> createLsCategory(@RequestBody LsCategory lsCategory) {
        lsCategoryService.save(lsCategory);
        return ResponseEntity.ok(lsCategory); // 或者返回创建后的实体
    }

    // 更新商品类目
    @PutMapping("/{id}")
    public ResponseEntity<String> updateLsCategory(@PathVariable Integer id, @RequestBody LsCategory lsCategory) {
        if (lsCategoryService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        lsCategory.setId(id); // 确保ID匹配
        lsCategoryService.updateById(lsCategory);
        return ResponseEntity.ok("成功"); // 或者返回更新后的实体
    }

    // 删除商品类目
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLsCategory(@PathVariable Long id) {
        if (lsCategoryService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        }


        lsCategoryService.removeById(id);
        return ResponseEntity.ok().build();
    }
}