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
### 用户通用权限系统表设计
```
系统后台的用户权限系统，设计表，产品需求如下：
角色管理：添加角色、编辑角色、删除角色
权限管理：添加权限、编辑权限、删除权限
用户管理：添加用户、编辑用户、删除用户
角色权限管理：分配角色权限、修改角色权限、查看角色权限
每个表都有如下的几个字段:   `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_id` bigint NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
返回结果:  所有表所有字段和字段说明的SQL语句
```
 * 高级版本：支持组织、职称
```
系统后台的用户权限系统，设计表，产品需求如下：
角色管理：添加角色、编辑角色、删除角色
权限管理：添加权限、编辑权限、删除权限
用户管理：添加用户、编辑用户、删除用户
角色权限管理：分配角色权限、修改角色权限、查看角色权限
组织管理：用户加入组织
每个组织下都会有多个职位,一个人只能一个职位
每个职位对应多个角色
每个表都有如下的几个字段:   `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_id` bigint NOT NULL DEFAULT '0' COMMENT '创建人id',
  `update_id` bigint NOT NULL DEFAULT '0' COMMENT '更新人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
返回结果:  所有表所有字段和字段说明的SQL语句
```
最好的效果：通义灵码或者Github Copliot
```
-- Table for roles
CREATE TABLE roles (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL COMMENT '角色名称',
  remarks VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  create_id BIGINT NOT NULL DEFAULT '0' COMMENT '创建人id',
  update_id BIGINT NOT NULL DEFAULT '0' COMMENT '更新人id',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- Table for permissions
CREATE TABLE permissions (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL COMMENT '权限名称',
  remarks VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  create_id BIGINT NOT NULL DEFAULT '0' COMMENT '创建人id',
  update_id BIGINT NOT NULL DEFAULT '0' COMMENT '更新人id',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- Table for users
CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL COMMENT '用户名',
  password VARCHAR(255) NOT NULL COMMENT '密码',
  remarks VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  create_id BIGINT NOT NULL DEFAULT '0' COMMENT '创建人id',
  update_id BIGINT NOT NULL DEFAULT '0' COMMENT '更新人id',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- Table for role-permission assignments
CREATE TABLE role_permissions (
  role_id BIGINT NOT NULL COMMENT '角色ID',
  permission_id BIGINT NOT NULL COMMENT '权限ID',
  remarks VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  create_id BIGINT NOT NULL DEFAULT '0' COMMENT '创建人id',
  update_id BIGINT NOT NULL DEFAULT '0' COMMENT '更新人id',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (role_id, permission_id),
  FOREIGN KEY (role_id) REFERENCES roles(id),
  FOREIGN KEY (permission_id) REFERENCES permissions(id)
);

-- Table for organizations
CREATE TABLE organizations (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL COMMENT '组织名称',
  remarks VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  create_id BIGINT NOT NULL DEFAULT '0' COMMENT '创建人id',
  update_id BIGINT NOT NULL DEFAULT '0' COMMENT '更新人id',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

-- Table for departments
CREATE TABLE departments (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  organization_id BIGINT NOT NULL COMMENT '组织ID',
  name VARCHAR(255) NOT NULL COMMENT '部门名称',
  remarks VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  create_id BIGINT NOT NULL DEFAULT '0' COMMENT '创建人id',
  update_id BIGINT NOT NULL DEFAULT '0' COMMENT '更新人id',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  FOREIGN KEY (organization_id) REFERENCES organizations(id)
);

-- Table for positions
CREATE TABLE positions (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  department_id BIGINT NOT NULL COMMENT '部门ID',
  name VARCHAR(255) NOT NULL COMMENT '职位名称',
  remarks VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  create_id BIGINT NOT NULL DEFAULT '0' COMMENT '创建人id',
  update_id BIGINT NOT NULL DEFAULT '0' COMMENT '更新人id',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  FOREIGN KEY (department_id) REFERENCES departments(id)
);

-- Table for user positions
CREATE TABLE user_positions (
  user_id BIGINT NOT NULL COMMENT '用户ID',
  position_id BIGINT NOT NULL COMMENT '职位ID',
  remarks VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  create_id BIGINT NOT NULL DEFAULT '0' COMMENT '创建人id',
  update_id BIGINT NOT NULL DEFAULT '0' COMMENT '更新人id',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (user_id, position_id),
  FOREIGN KEY (user_id) REFERENCES users(id),
  FOREIGN KEY (position_id) REFERENCES positions(id)
);

-- Table for position-role assignments
CREATE TABLE position_roles (
  position_id BIGINT NOT NULL COMMENT '职位ID',
  role_id BIGINT NOT NULL COMMENT '角色ID',
  remarks VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  create_id BIGINT NOT NULL DEFAULT '0' COMMENT '创建人id',
  update_id BIGINT NOT NULL DEFAULT '0' COMMENT '更新人id',
  create_time DATETIME NOT NULL COMMENT '创建时间',
  update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (position_id, role_id),
  FOREIGN KEY (position_id) REFERENCES positions(id),
  FOREIGN KEY (role_id) REFERENCES roles(id)
);
```
 * 参考的E-R图
![image](https://github.com/user-attachments/assets/c30b66fd-34b2-4ef8-88a1-5a1135aa5f36)


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
 * 参考的E-R图
<img width="511" alt="image" src="https://github.com/user-attachments/assets/fbad470c-5c60-4846-94b1-af7bf636fa85">

