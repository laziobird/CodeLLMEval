//package com.next.ai.dao;
//
//import java.util.*;
//import java.math.*;
//
//import com.next.ai.entity.LsCategory;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.Mockito;
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class LsCategoryDaoTest {
//
//    @Mock
//    private LsCategoryDao lsCategoryDao;
//
//    @InjectMocks
//    private LsCategoryDaoImpl lsCategoryDaoImpl;
//
//    @BeforeEach
//    public void setUp() {
//        // Any setup can be placed here
//    }
//
//    @Test
//    public void insertBatch_ShouldReturnExpectedRows_WhenEntitiesProvided() {
//        // Arrange
//        List<LsCategory> entities = new ArrayList<>();
//        LsCategory category1 = new LsCategory();
//        category1.setCategoryId(1L);
//        category1.setCategoryName("Category1");
//        entities.add(category1);
//
//        LsCategory category2 = new LsCategory();
//        category2.setCategoryId(2L);
//        category2.setCategoryName("Category2");
//        entities.add(category2);
//
//        when(lsCategoryDao.insertBatch(anyList())).thenReturn(2);
//
//        // Act
//        int result = lsCategoryDao.insertBatch(entities);
//
//        // Assert
//        assertEquals(2, result);
//        verify(lsCategoryDao, times(1)).insertBatch(anyList());
//    }
//
//    @Test
//    public void insertOrUpdateBatch_ShouldThrowException_WhenEntitiesListIsEmpty() {
//        // Arrange
//        List<LsCategory> entities = new ArrayList<>();
//
//        // Act & Assert
//        assertThrows(org.springframework.jdbc.BadSqlGrammarException.class, () -> {
//            lsCategoryDao.insertOrUpdateBatch(entities);
//        });
//        verify(lsCategoryDao, never()).insertOrUpdateBatch(anyList());
//    }
//
//    @Test
//    public void insertOrUpdateBatch_ShouldReturnExpectedRows_WhenEntitiesProvided() {
//        // Arrange
//        List<LsCategory> entities = new ArrayList<>();
//        LsCategory category1 = new LsCategory();
//        category1.setCategoryId(1L);
//        category1.setCategoryName("Category1");
//        entities.add(category1);
//
//        LsCategory category2 = new LsCategory();
//        category2.setCategoryId(2L);
//        category2.setCategoryName("Category2");
//        entities.add(category2);
//
//        when(lsCategoryDao.insertOrUpdateBatch(anyList())).thenReturn(2);
//
//        // Act
//        int result = lsCategoryDao.insertOrUpdateBatch(entities);
//
//        // Assert
//        assertEquals(2, result);
//        verify(lsCategoryDao, times(1)).insertOrUpdateBatch(anyList());
//    }
//}
