package com.aicode.demo.mapper;

import com.aicode.demo.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryDao extends BaseMapper<Category> {

    int insertBatch(@Param("list") List<Category> list);
}