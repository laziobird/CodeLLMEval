/*
package com.next.ai;

import com.next.ai.dao.LsCategoryDao;
import com.next.ai.entity.LsCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LsCategoryDaoCometV2Test {

    @Autowired
    private LsCategoryDao lsCategoryDao;

    @Test
    @Transactional
    public void testInsertBatchWithValidData() {
        // Prepare test data
        LsCategory category1 = new LsCategory();
        category1.setName("Category1");
        category1.setCode("1001"); // Assuming code is generated based on some logic, but setting it here for testing
        category1.setSort(1);
        category1.setStatus(0);
        category1.setLevel(1);
        category1.setParentId(0);
        category1.setCreatedUserId(1);
        category1.setCreatedUserName("admin");
        category1.setUpdatedUserId(1);
        category1.setUpdatedUserName("admin");
        category1.setVersion(0);

        LsCategory category2 = new LsCategory();
        category2.setName("Category2");
        category2.setCode("1002");
        category2.setSort(2);
        category2.setStatus(0);
        category2.setLevel(1);
        category2.setParentId(0);
        category2.setCreatedUserId(1);
        category2.setCreatedUserName("admin");
        category2.setUpdatedUserId(1);
        category2.setUpdatedUserName("admin");
        category2.setVersion(0);

        List<LsCategory> categories = Arrays.asList(category1, category2);

        // Execute the method to be tested
        int rowsInserted = lsCategoryDao.insertBatch(categories);

        // Verify the result
        assertEquals(2, rowsInserted);
    }

    @Test
    @Transactional
    public void testInsertBatchWithEmptyList() {
        // Prepare test data
        List<LsCategory> emptyList = Collections.emptyList();

        // Execute the method to be tested and assert the behavior
        Exception exception = assertThrows(RuntimeException.class, () -> {
            lsCategoryDao.insertBatch(emptyList);
        });

        // Verify the exception message or type if necessary
        // Note: The actual exception type may vary depending on your MyBatis configuration or database behavior
        // Here we assume it's a RuntimeException, but in reality it might be a more specific exception
        assertTrue(exception.getMessage().contains("入参是空List的时候会抛SQL语句错误的异常"));
    }
}*/
