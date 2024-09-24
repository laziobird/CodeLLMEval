package com.next.ai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.next.ai.dao.LsCategoryDao;
import com.next.ai.entity.LsCategory;
import com.next.ai.service.LsCategoryService;
import org.springframework.stereotype.Service;

/**
 * 商品类目(LsCategory)表服务实现类
 *
 * @author makejava
 * @since 2024-07-23 14:06:11
 */
@Service("lsCategoryService")
public class LsCategoryServiceImpl extends ServiceImpl<LsCategoryDao, LsCategory> implements LsCategoryService {

}

