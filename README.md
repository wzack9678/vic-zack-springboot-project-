# Spring Boot + PostgreSQL + Docker 项目操作指南

本文档总结了从 **Docker 启动 PostgreSQL** 到 **运行 Spring Boot 应用**，并通过 **Users / Products / Orders API** 进行完整 CRUD 操作的流程。

---

## 1. 启动 PostgreSQL 容器

```bash
docker run --name demo-postgres   -e POSTGRES_USER=demo_user   -e POSTGRES_PASSWORD=demo_pass   -e POSTGRES_DB=demo   -p 5432:5432   -d postgres:16
```

---

## 2. 启动 Spring Boot 应用

直接在 IntelliJ IDEA 中点击 `DemoServicesApplication.java` 的绿色 ▶️ Run 按钮即可。  
应用启动后默认运行在：

👉 http://localhost:8081

---

## 3. Users API (http://localhost:8081/api/v1/users)

### 3.1 创建用户 (POST)
```bash
curl -X POST http://localhost:8081/api/v1/users   -H "Content-Type: application/json"   -d '{"name":"Alice","email":"alice@test.com","phone":"123456","status":"ACTIVE"}'
```
**SQL 验证**
```sql
SELECT * FROM users;
```

### 3.2 获取所有用户 (GET)
```bash
curl -X GET http://localhost:8081/api/v1/users
```
**SQL 验证**
```sql
SELECT * FROM users;
```

### 3.3 根据 ID 获取用户 (GET)
```bash
curl -X GET http://localhost:8081/api/v1/users/1
```
**SQL 验证**
```sql
SELECT * FROM users WHERE id = 1;
```

### 3.4 更新用户 (PUT)
```bash
curl -X PUT http://localhost:8081/api/v1/users/1   -H "Content-Type: application/json"   -d '{"name":"Alice Updated","email":"alice.new@test.com","phone":"999999","status":"ACTIVE"}'
```
**SQL 验证**
```sql
SELECT * FROM users WHERE id = 1;
```

### 3.5 删除用户 (DELETE)
```bash
curl -X DELETE http://localhost:8081/api/v1/users/1
```
**SQL 验证**
```sql
SELECT * FROM users WHERE id = 1;
```

---

## 4. Products API (http://localhost:8081/api/v1/products)

### 4.1 创建产品 (POST)
```bash
curl -X POST http://localhost:8081/api/v1/products   -H "Content-Type: application/json"   -d '{"name":"iPhone 16","description":"New Apple Phone","price":999.99,"status":"ACTIVE"}'
```
**SQL 验证**
```sql
SELECT * FROM products;
```

### 4.2 获取所有产品 (GET)
```bash
curl -X GET http://localhost:8081/api/v1/products
```
**SQL 验证**
```sql
SELECT * FROM products;
```

### 4.3 根据 ID 获取产品 (GET)
```bash
curl -X GET http://localhost:8081/api/v1/products/1
```
**SQL 验证**
```sql
SELECT * FROM products WHERE id = 1;
```

### 4.4 更新产品 (PUT)
```bash
curl -X PUT http://localhost:8081/api/v1/products/1   -H "Content-Type: application/json"   -d '{"name":"iPhone 16 Pro","description":"Updated Apple Phone","price":1099.99,"status":"ACTIVE"}'
```
**SQL 验证**
```sql
SELECT * FROM products WHERE id = 1;
```

### 4.5 删除产品 (DELETE)
```bash
curl -X DELETE http://localhost:8081/api/v1/products/1
```
**SQL 验证**
```sql
SELECT * FROM products WHERE id = 1;
```

---

## 5. Orders API (http://localhost:8081/api/v1/orders)

### 5.1 创建订单 (POST)
```bash
curl -X POST http://localhost:8081/api/v1/orders   -H "Content-Type: application/json"   -d '{"userId":2,"productId":1,"quantity":2}'
```
**SQL 验证**
```sql
SELECT * FROM orders;
```

### 5.2 获取所有订单 (GET)
```bash
curl -X GET http://localhost:8081/api/v1/orders
```
**SQL 验证**
```sql
SELECT * FROM orders;
```

### 5.3 根据 ID 获取订单 (GET)
```bash
curl -X GET http://localhost:8081/api/v1/orders/1
```
**SQL 验证**
```sql
SELECT * FROM orders WHERE id = 1;
```

### 5.4 更新订单 (PUT)
```bash
curl -X PUT http://localhost:8081/api/v1/orders/1   -H "Content-Type: application/json"   -d '{"userId":2,"productId":1,"quantity":5}'
```
**SQL 验证**
```sql
SELECT * FROM orders WHERE id = 1;
```

### 5.5 删除订单 (DELETE)
```bash
curl -X DELETE http://localhost:8081/api/v1/orders/1
```
**SQL 验证**
```sql
SELECT * FROM orders WHERE id = 1;
```

---

## 6. PostgreSQL 常用命令

进入容器：
```bash
docker exec -it demo-postgres bash
```

进入数据库：
```bash
psql -U demo_user -W -d demo
```

退出 psql：
```sql
\q
```

---

✅ 至此，你已经完成了从 **Docker 启动 PostgreSQL**，到 **运行 Spring Boot 应用**，再到 **使用 API 并在数据库中验证结果** 的完整流程。
