package com.aicode.buildDemo.service.impl;

import com.aicode.buildDemo.entity.Category;
import com.aicode.buildDemo.mapper.CategoryMapper;
import com.aicode.buildDemo.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}