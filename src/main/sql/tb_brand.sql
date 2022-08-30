CREATE DATABASE IF NOT EXISTS test_db;
USE test_db;

DROP TABLE IF EXISTS tb_brand;
CREATE TABLE tb_brand
(
    id           int primary key auto_increment, -- 主键
    brand_name   varchar(20) not null,
    company_name varchar(20) not null,
    ordered      int         not null default 0, -- 排序字段
    description  varchar(255),
    status       int                             -- 1启用 0禁用
);

INSERT INTO tb_brand(brand_name, company_name, ordered, description, status)
values ('三只松鼠', '三只松鼠有限公司', 5, '三只松鼠', 0),
       ('华为', '华为技术有限公司', 100, 'Huawei', 1),
       ('小米', '小米科技有限公司', 50, 'Are you ok?', 1);

SELECT *
FROM tb_brand;