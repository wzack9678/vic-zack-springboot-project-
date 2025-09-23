# Spring Boot + PostgreSQL + Docker 项目操作指南

本文档总结了从 **Docker 启动 PostgreSQL** 到 **在数据库中查看 users 表**
的完整流程。

------------------------------------------------------------------------

## 1. 启动 PostgreSQL 容器

``` bash
docker run --name demo-postgres \
  -e POSTGRES_USER=demo_user \
  -e POSTGRES_PASSWORD=demo_pass \
  -e POSTGRES_DB=demo \
  -p 5432:5432 \
  -d postgres:16
```

参数说明： - `--name demo-postgres`：容器名称。 -
`-e POSTGRES_USER=demo_user`：数据库用户名。 -
`-e POSTGRES_PASSWORD=demo_pass`：数据库密码。 -
`-e POSTGRES_DB=demo`：初始化的数据库。 -
`-p 5432:5432`：映射宿主机端口。

------------------------------------------------------------------------

## 2. 进入容器

``` bash
docker exec -it demo-postgres bash
```

------------------------------------------------------------------------

## 3. 使用 psql 连接数据库

``` bash
psql -U demo_user -W -d demo
```

输入密码：`demo_pass`。\
成功后提示符变为：

    demo=#

------------------------------------------------------------------------

## 4. 查看数据库与表

### 查看所有数据库

``` sql
\l
```

结果示例：

       Name    |   Owner   | Encoding
    -----------+-----------+----------
     demo      | demo_user | UTF8
     mydb      | demo_user | UTF8
     postgres  | demo_user | UTF8

### 切换数据库

``` sql
\c mydb
```

### 查看所有表

``` sql
\dt
```

结果示例：

     Schema | Name  | Type  |   Owner
    --------+-------+-------+-----------
     public | users | table | demo_user

### 查看表结构

``` sql
\d users
```

### 查询数据

``` sql
SELECT * FROM users;
```

结果示例：

     id |      create_date_time      |     email      | name  | phone  | status |      update_date_time
    ----+----------------------------+----------------+-------+--------+--------+----------------------------
      2 | 2025-09-16 15:29:33.526525 | alice@test.com | Alice | 123456 | ACTIVE | 2025-09-16 15:29:33.526581
      3 | 2025-09-16 15:29:46.143683 | alice@test.com | Alice | 123456 | ACTIVE | 2025-09-16 15:29:46.143786

------------------------------------------------------------------------

## 5. 其他表查询示例

### products 表

``` sql
SELECT * FROM products;
```

### orders 表

``` sql
SELECT * FROM orders;
```

------------------------------------------------------------------------

## 6. 退出 psql

``` sql
\q
```

------------------------------------------------------------------------

✅ 至此，你已经完成了从 Docker 启动 PostgreSQL，到连接数据库，并查看
`users` 表的完整流程。
