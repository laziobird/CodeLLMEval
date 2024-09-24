create table ls_sku
(
    id                int(20) auto_increment comment 'sku ID'
        primary key,
    name              varchar(50)                                                       not null comment '名称',
    spu_id            int(20)                                                           not null comment 'spu ID',
    code              varchar(50)                             default '0'               null comment '编码,规则：类目编码XXXX + spu_idXXX + idXXXX,一共12位',
    status            tinyint(2)                              default 0                 not null comment '-1 下架 0 上架',
    type              tinyint(2)                              default 1                 not null comment '1 单品 2 套组',
    category_id       int(20)                                 default 0                 not null comment '三级类目id',
    supply_own        mediumtext                                                        null comment '供货方式自产，JSON格式',
    supply_out        mediumtext                                                        null comment '供货方式外购，JSON格式',
    spec              varchar(50)                                                       null comment '规格',
    barcode           varchar(50)                                                       not null comment '条形码',
    unit              varchar(10)                                                       not null comment '单位',
    remark            varchar(50)                                                       null comment '备注',
    created_at        datetime                                default CURRENT_TIMESTAMP null comment '创建时间',
    updated_at        datetime                                                          null on update CURRENT_TIMESTAMP comment '更新时间',
    created_user_id   int                                     default 0                 not null comment '创建用户ID',
    created_user_name varchar(100) collate utf8mb4_unicode_ci default ''                not null comment '创建用户名',
    updated_user_id   int                                     default 0                 not null comment '更新用户ID',
    updated_user_name varchar(100) collate utf8mb4_unicode_ci default ''                not null comment '更新用户名',
    version           int                                     default 0                 not null comment '版本号',
    deleted           tinyint                                 default 0                 not null comment '删除状态 0:未删除；1：已删除'
)
    comment 'sku 表' ;

create table ls_spu
(
    id                int(20) auto_increment comment 'sku ID'
        primary key,
    name              varchar(50)                                                       not null comment '名称，spu_name + 规格唯一确认',
    code              varchar(50)                                                       null comment '编码,规则：类目编码XXXX +idXXXX ,一共8位',
    status            tinyint(2)                              default 0                 not null comment '-1 下架 0 上架',
    type              tinyint(2)                              default 1                 not null comment '1 单品 2 套组',
    remark            varchar(255)                                                      null comment '商品描述',
    category_one_id   int(20)                                 default 0                 not null comment '一级类目id',
    category_two_id   int(20)                                 default 0                 not null comment '二级类目id',
    category_three_id int(20)                                 default 0                 not null comment '三级类目id',
    created_at        datetime                                default CURRENT_TIMESTAMP null comment '创建时间',
    updated_at        datetime                                                          null on update CURRENT_TIMESTAMP comment '更新时间',
    created_user_id   int                                     default 0                 not null comment '创建用户ID',
    created_user_name varchar(100) collate utf8mb4_unicode_ci default ''                not null comment '创建用户名',
    updated_user_id   int                                     default 0                 not null comment '更新用户ID',
    updated_user_name varchar(100) collate utf8mb4_unicode_ci default ''                not null comment '更新用户名',
    version           int                                     default 0                 not null comment '版本号',
    deleted           tinyint                                 default 0                 not null comment '删除状态 0:未删除；1：已删除'
)
    comment 'spu 表' ;

create table ls_category
(
    id                int(20) auto_increment comment '分类ID'
        primary key,
    name              varchar(50)                                                       not null comment '分类名称',
    code              varchar(50)                                                       not null comment '分类编码，规则：1000+id，一共4位',
    sort              int                                     default 0                 not null comment '排序，值越低，排靠前',
    status            tinyint(2)                              default 0                 not null comment '-1 下架 0 上架',
    level             tinyint(2)                              default 3                 not null comment '类目 1,2,3,一共三级',
    parent_id         int(20)                                 default 0                 not null comment '上级ID，根类目就是 0',
    created_at        datetime                                default CURRENT_TIMESTAMP null comment '创建时间',
    updated_at        datetime                                                          null on update CURRENT_TIMESTAMP comment '更新时间',
    created_user_id   int                                     default 0                 not null comment '创建用户ID',
    created_user_name varchar(100) collate utf8mb4_unicode_ci default ''                not null comment '创建用户名',
    updated_user_id   int                                     default 0                 not null comment '更新用户ID',
    updated_user_name varchar(100) collate utf8mb4_unicode_ci default ''                not null comment '更新用户名',
    version           int                                     default 0                 not null comment '版本号',
    deleted           tinyint                                 default 0                 not null comment '删除状态 0:未删除；1：已删除'
)
    comment '商品类目' ;
