/*
package com.next.ai;

import com.next.ai.dao.LsCategoryDao;
import com.next.ai.entity.LsCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LsCategoryDaoGithubCopoiltTest {

    @Autowired
    private LsCategoryDao lsCategoryDao;

    @Test
    //@Transactional
    public void testInsertBatch() {
        // Prepare test data
        List<LsCategory> categories = new ArrayList<>();
        LsCategory category1 = new LsCategory();
        category1.setName("Category923");
        category1.setCode("1001");
        category1.setSort(1);
        category1.setStatus((int) 0);
        category1.setLevel((int) 3);
        category1.setParentId(0);

        category1.setCreatedUserId(1);
        category1.setCreatedUserName("User1");
        category1.setUpdatedUserId(1);
        category1.setUpdatedUserName("User1");
        category1.setVersion(1);
        category1.setDeleted((int) 0);
        categories.add(category1);

        LsCategory category2 = new LsCategory();
        category2.setName("Category2");
        category2.setCode("1002");
        category2.setSort(2);
        category2.setStatus((int) 0);
        category2.setLevel((int) 3);
        category2.setParentId(0);

        category2.setCreatedUserId(2);
        category2.setCreatedUserName("User2");
        category2.setUpdatedUserId(2);
        category2.setUpdatedUserName("User2");
        category2.setVersion(1);
        category2.setDeleted((int) 0);
        categories.add(category2);

        // Execute the method to be tested
        int rowsInserted = lsCategoryDao.insertBatch(categories);

        // Verify the result
        assertEquals(2, rowsInserted);
    }

    @Test
    //@Transactional
    public void insertBatchWithEmptyList() {
        List<LsCategory> emptyList = Collections.emptyList();

        Exception exception = assertThrows(RuntimeException.class, () -> {
            lsCategoryDao.insertBatch(emptyList);
        });

        assertNotNull(exception);
    }
}*/
