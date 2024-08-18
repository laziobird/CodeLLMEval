# 提示词模版
后面按行业领域细分

## 技术文档的数据建模

### 电商系统通用产品库表设计
```
设计一个商品库表：里面有sku表、spu表、类目category表;
spu和category关系：spu里面有一级、二级、三级类目信息。
spu和sku关系：一个spu 对应多个sku，区别在于规格，规格多有个值，可以用JSON方式保存为一个字段。
sku包含第三级类目的信息
```

## 产品文档的数据建模

### 通用的视频学习用户系统表设计
```
视频点播教学系统，设计表，产品需求如下：
视频管理：视频列表、视频搜索、上下架视频、新增视频、上传视频
课程管理：课程列表、课程搜索、上下架课程、新增课程、课程关联视频、课程分类、一个课程会有一个或者多个视频
分类管理：新增分类、新增一级分类、一级分类下新增二级分类、分类排序、删除分类
视频数据记录表：每个用户观看视频最大时间，观看视频的完成比，记录每个用户的id、name
视频统计信息表：每个视频观看人数、观看次数、观看完成比(每个用户观看视频95%表示视频观看完成)
每个表都有如下的几个字段:   `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_id` bigint NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
返回结果:  所有表所有字段和字段说明的SQL语句
```
