# Spring Boot + PostgreSQL + Docker 项目操作指南

本文档总结了从 **Docker 启动 PostgreSQL** 到 **运行 Spring Boot 项目**，以及 **通过 API + SQL 验证结果** 的完整流程。

---

## 1. 启动 PostgreSQL 容器

```bash
docker run --name demo-postgres   -e POSTGRES_USER=demo_user   -e POSTGRES_PASSWORD=demo_pass   -e POSTGRES_DB=demo   -p 5432:5432   -d postgres:16
```

---

## 2. 进入容器

```bash
docker exec -it demo-postgres bash
```

---

## 3. 使用 psql 连接数据库

```bash
psql -U demo_user -W -d demo
```

密码：`demo_pass`

---

## 4. 启动 Spring Boot 应用

### 方法一（命令行启动）
```bash
mvn spring-boot:run
```

### 方法二（IntelliJ IDEA 启动）
- 直接点击右上角绿色 ▶️ Run 按钮  
- 会运行 `DemoServicesApplication.main()`，效果与命令行相同

---

## 5. API 测试与数据库验证

### 5.1 Users API

#### 创建用户
```bash
curl -X POST http://localhost:8081/api/v1/users    -H "Content-Type: application/json"    -d '{"name":"Alice","email":"alice@test.com","phone":"123456","status":"ACTIVE"}'
```

**验证 SQL**
```sql
SELECT * FROM users;
```

访问链接（查看所有用户）：  
👉 http://localhost:8081/api/v1/users

---

### 5.2 Products API

#### 创建产品
```bash
curl -X POST http://localhost:8081/api/v1/products    -H "Content-Type: application/json"    -d '{"name":"iPhone 16","description":"New Apple Phone","price":999.99,"status":"ACTIVE"}'
```

**验证 SQL**
```sql
SELECT * FROM products;
```

访问链接（查看所有产品）：  
👉 http://localhost:8081/api/v1/products

---

### 5.3 Orders API

#### 创建订单
```bash
curl -X POST http://localhost:8081/api/v1/orders    -H "Content-Type: application/json"    -d '{"userId":4,"productId":2,"quantity":2}'
```

⚠️ 注意：`userId` 和 `productId` 必须存在，否则会报错 `ResourceNotFoundException`。

**验证 SQL**
```sql
SELECT * FROM orders;
```

访问链接（查看所有订单）：  
👉 http://localhost:8081/api/v1/orders

---

## 6. 常用 SQL

- 查看所有数据库  
```sql
\l
```

- 切换数据库  
```sql
\c demo
```

- 查看所有表  
```sql
\dt
```

- 查看表结构  
```sql
\d users
\d products
\d orders
```

- 查询数据  
```sql
SELECT * FROM users;
SELECT * FROM products;
SELECT * FROM orders;
```

---

✅ 至此，你已经完成了从 **Docker 启动 PostgreSQL** 到 **Spring Boot 项目运行 + API 测试 + SQL 验证** 的完整流程。
