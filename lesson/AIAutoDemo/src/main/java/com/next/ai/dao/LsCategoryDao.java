package com.next.ai.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.next.ai.entity.LsCategory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 商品类目(LsCategory)表数据库访问层
 *
 * @author jiangzhiwei
 * @since 2024-07-23 14:06:08
 */
@Mapper
public interface LsCategoryDao extends BaseMapper<LsCategory> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<LsCategory> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<LsCategory> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<LsCategory> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<LsCategory> entities);

}

