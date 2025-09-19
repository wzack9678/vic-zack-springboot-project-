How to setup and run the application
如何设置和运行应用程序

Especially for those optional functions. It is ok to include some external links. But make sure you give a clear instruction on which part the user needs to read. It is painful to get lost in many documents.
特别是那些可选功能，可以包含一些外部链接。但一定要明确指出用户需要阅读的部分，避免在大量文档中迷失。

This might be the most important part. It is important to let others start your application locally and play with it.
这可能是最重要的部分，必须确保别人能在本地启动你的应用并进行尝试。

Some instructions on API
一些关于 API 的使用说明

Again, do not waste too much time on this. If your API parameters can be easily figured out, you can even skip it.
同样，不要在这上面花费太多时间。如果 API 参数很容易理解，你甚至可以跳过。

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
spring.datasource.password=demo_pass

list all tables
\d

退出 psql：
```sql
\q
```

---

✅ 至此，你已经完成了从 **Docker 启动 PostgreSQL**，到 **运行 Spring Boot 应用**，再到 **使用 API 并在数据库中验证结果** 的完整流程。






The design you made
你所做的设计

Only include the situation you made a choice. What’s the tradeoff? Why did you make this decision?
只写你需要做出选择的地方。有哪些取舍？为什么要做出这个决定？

👌 我来帮你梳理三种方式的 **trade-off**，再解释为什么最后你选择了 **方式一**（单个商品的订单）。

---

# 🛒 三种订单–商品关系的实现方式对比

## 方式一：订单里只有一个商品

**Order → Product (Many-to-One)**

```java
@ManyToOne
@JoinColumn(name = "product_id")
private Product product;
```

* ✅ **优点**

    * 实现简单：一张 `orders` 表就能搞定。
    * 查询方便：`JOIN` 一次就能拿到订单和商品。
    * 适合 demo、小项目、作业场景（学习重点在于 Spring Data JPA / API 测试）。

* ❌ **缺点**

    * 限制性强：一个订单只能买一个商品。
    * 不符合真实电商购物车逻辑（一般一个订单会有多个商品）。

👉 **适合场景**：作业、演示、小实验。

---

## 方式二：订单里有多个商品 （和 hw5 相同）

**Order ↔ Product (Many-to-Many with join table)**

```java
@ManyToMany
@JoinTable(
    name = "order_products",
    joinColumns = @JoinColumn(name = "order_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id")
)
private Set<Product> products;
```

* ✅ **优点**

    * 一个订单可以包含多个商品。
    * 查询时可以直接通过 `order_products` 关系表拿到所有商品。

* ❌ **缺点**

    * 无法单独保存每个商品的数量、价格快照。

        * 比如订单里买了 2 个 iPhone 和 3 个 iPad，数量信息没法存在关系表里。
    * 在电商真实场景下不够灵活。

👉 **适合场景**：快速实现「订单包含多个商品」的需求，但业务简单。

---

## 方式三：引入 OrderItem 中间表

**Order → OrderItem → Product**

```java
@Entity
class OrderItem {
    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private int quantity;
    private double priceAtOrder;
}
```

* ✅ **优点**

    * 最符合真实电商业务：

        * 一个订单可以有多个商品。
        * 每个商品可以有不同数量、价格（还能保留下单时的历史价格）。
    * 数据库设计更加 **规范化 (3NF)**。
    * 方便后续扩展（优惠、折扣、退货等）。

* ❌ **缺点**

    * 实现复杂度更高：

        * 要多一个 `order_items` 表。
        * Repository、Service、DTO、API 都要改。
    * 对课程作业可能显得「超规格」。

👉 **适合场景**：真正要做一个电商系统或生产级项目。

---

# 🎯 为什么你最后选择了方式一

1. **老师的项目要求** 是「Spring Boot + JPA + PostgreSQL（或其他数据库）」，重点在于 CRUD、API 测试，而不是设计一个完整电商系统。
2. **方式一实现最简单**：不需要额外的中间表，不会引入太多复杂性，代码量和调试成本更低。
3. **作业时间有限**：方式二、三更贴近真实，但会让你花很多时间在数据库建模和业务逻辑上，而不是 Spring Boot / API 本身。
4. **方式一已经能覆盖要求的 CRUD 功能**，并且能展示出 `@ManyToOne` 的用法，足够体现对 JPA 的掌握。

---

⚖️ **一句话总结：**

* 方式一：适合教学/作业，简单直接 ✅
* 方式二：能支持多个商品，但业务不够灵活 ❌
* 方式三：最真实，最复杂，适合生产级项目 🔥

---



Any blockers you encountered when doing this project?
在做这个项目时你遇到过哪些阻碍？

It is ok not to have a solution. Just leave it open.
没有解决方案也没关系，可以直接写出来。

Do not spend too much time on format. Focus on content.
不要花太多时间在格式上，专注内容即可。