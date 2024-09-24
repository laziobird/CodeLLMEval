/*
package com.next.ai;

import com.next.ai.dao.LsCategoryDao;
import com.next.ai.entity.LsCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LsCategoryDaoCodeGeeXTest {

    @Autowired
    private LsCategoryDao lsCategoryDao;

    @Test
    void insertBatch() {
        List<LsCategory> lsCategoryList = new ArrayList<>();
        LsCategory lsCategory1 = new LsCategory();
        lsCategory1.setId(1);
        lsCategory1.setName("Category1");
        lsCategoryList.add(lsCategory1);

        LsCategory lsCategory2 = new LsCategory();
        lsCategory2.setId(2);
        lsCategory2.setName("Category2");
        lsCategoryList.add(lsCategory2);

        int result = lsCategoryDao.insertBatch(lsCategoryList);
        assertEquals(2, result);
    }

    @Test
    void insertOrUpdateBatch() {
        List<LsCategory> lsCategoryList = new ArrayList<>();
        LsCategory lsCategory1 = new LsCategory();
        lsCategory1.setId(1);
        lsCategory1.setName("Category1");
        lsCategoryList.add(lsCategory1);

        LsCategory lsCategory2 = new LsCategory();
        lsCategory2.setId(2);
        lsCategory2.setName("Category2");
        lsCategoryList.add(lsCategory2);

        int result = lsCategoryDao.insertOrUpdateBatch(lsCategoryList);
        assertEquals(2, result);
    }
}
*/
