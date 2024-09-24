/*
package com.next.ai;

import com.next.ai.dao.LsCategoryDao;
import com.next.ai.entity.LsCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LsCategoryDaoCometTest {

    @Autowired
    private LsCategoryDao lsCategoryDao;

    @Test
    @Transactional
    public void testInsertBatch() {
        // Prepare test data
        LsCategory category1 = new LsCategory();
        category1.setName("Category1");
        LsCategory category2 = new LsCategory();
        category2.setName("Category2");
        List<LsCategory> categories = Arrays.asList(category1, category2);

        // Execute the method to be tested
        int rowsInserted = lsCategoryDao.insertBatch(categories);

        // Verify the result
        assertEquals(2, rowsInserted);
    }
}*/
