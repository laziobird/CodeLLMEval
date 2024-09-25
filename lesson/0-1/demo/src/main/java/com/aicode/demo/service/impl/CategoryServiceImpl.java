package com.aicode.demo.service.impl;

import com.aicode.demo.entity.Category;
import com.aicode.demo.mapper.CategoryDao;
import com.aicode.demo.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {
}