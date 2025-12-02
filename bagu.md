# Maven & Git


### What is Maven?

Maven is a build automation and project management tool used primarily
for Java projects.

### What is a POM file in Maven?

Core config file for dependencies, plugins, build settings, etc.

### What is the difference between dependencies and dependencyManagement?

`<dependencies>` is where you declare the actual libraries your project
needs, and those JARs are added directly to the classpath.

`<dependencyManagement>` doesn't bring in any dependency by itself，it's
mainly used to define versions and scopes in a central place, usually in
a parent POM, so child modules or dependencies can inherit those
settings without repeating version numbers. 

In short, `<dependencies>` adds the library, while `<dependencyManagement>` just manages consistent
versions across the project.

### What is a transitive dependency in Maven?

A transitive dependency in Maven is an indirect dependency that your
project gets because one of your direct dependencies depends on it. For
example, if your project depends on library **A**, and **A** internally
depends on library **B**, then **B** is pulled into your project
automatically as a transitive dependency. This makes dependency
management easier since you don't have to explicitly declare everything,
but it can also lead to conflicts if different libraries bring in
different versions of the same dependency.

### What is the difference between a snapshot and a release in Maven?

In Maven, a **release** version is a fixed, immutable build meant for
production. Once deployed, it should never change, and it is considered
stable. A **snapshot** version is a development version that can change
over time. Maven will check remote repositories for newer timestamped
builds of a snapshot and update them automatically.

### What are some commonly used Maven plugins?

-   **maven-compiler-plugin** -- compiles Java source code.
-   **maven-surefire-plugin** -- runs unit tests.
-   **maven-failsafe-plugin** -- runs integration tests.
-   **maven-jar-plugin** -- builds JAR files.
-   **maven-war-plugin** -- builds WAR files for web applications.
-   **maven-clean-plugin** -- cleans the target directory.
-   **maven-install-plugin** -- installs the artifact into the local
    repository.
-   **maven-deploy-plugin** -- deploys artifacts to a remote repository.
-   **maven-site-plugin** -- generates project documentation.

**In short:** compiler for building, surefire/failsafe for testing,
jar/war for packaging, and clean/install/deploy for lifecycle
management.

### What is Maven lifecycle?

The **Maven life cycle** is a **set of well-defined phases** that manage
the **build process** of a project.

There are three built-in build lifecycles: **default**, **clean** and
**site**. The `default` lifecycle handles your project deployment, the
`clean` lifecycle handles project cleaning, while the `site` lifecycle
handles the creation of your project's web site.

### What are some common lifecycle phases?

-   `validate` - validate the project is correct and all necessary
    information is available
-   `compile` - compile the source code of the project
-   `test` - test the compiled source code using a suitable unit testing
    framework. These tests should not require the code be packaged or
    deployed
-   `package` - take the compiled code and package it in its
    distributable format, such as a **JAR**.
-   `verify` - run any checks on results of integration tests to ensure
    quality criteria are met
-   `install` - install the package into the **local repository**, for
    use as a dependency in other projects locally
-   `deploy` - done in the build environment, copies the final package
    to the remote repository for sharing with other developers and
    projects.

### What is the difference between mvn package and mvn install?

-   **`mvn package`** -- compiles the code, runs tests, and packages the
    application inside the project's target directory.
-   **`mvn install`** -- does everything `package` does, and in
    addition, it installs the built artifact into the **local Maven
    repository** (`~/.m2/repository`) so it can be used as a dependency
    in other local projects.
-   **Use mvn package** when you're just building and testing your
    project.
-   **Use mvn install** when you want to **use this project as a
    dependency** in another local project.

### What is the difference between git fetch and git pull?

-   **`git fetch`** downloads new commits, branches, and tags from the
    remote repository, but it does **not** change your working directory
    or current branch. It only updates your local tracking references.
-   **`git pull`** is essentially `git fetch` **followed by**
    `git merge` (or `git rebase` if configured). It not only downloads
    the new commits but also updates your current branch with them.

**In short:**

-   `fetch` = just downloads updates.
-   `pull` = downloads + integrates updates into your current branch.
-   `git fetch` is safer because it lets you review incoming changes
    before merging, while `git pull` merges immediately.

### What is the difference between git merge and git rebase? Pro and Cons?

-   **`git merge`**: Combines changes from one branch into another by
    creating a new **merge commit**. The branch history remains
    unchanged and non-linear.
    -   **Pros:** Preserves complete history, simple and safe, avoids
        rewriting commits.
    -   **Cons:** History can become cluttered with many merge commits,
        harder to read.
-   **`git rebase`**: Moves or "replays" your branch's commits on top of
    another branch, rewriting history to look linear.
    -   **Pros:** Cleaner, linear history, easier to follow with
        `git log`.
    -   **Cons:** Rewrites commit history, which can be dangerous if
        already pushed/shared (may cause conflicts for collaborators).

### How do you resolve merge conflicts in Git?

A merge conflict happens when Git can't automatically combine changes.
When that happens, I check with `git status` to see which files are in
conflict. Then I open those files, look at the conflict markers, and
decide whether to keep my changes, the incoming changes, or a mix of
both. After I clean up the file and remove the markers, I stage it with
`git add`, and then finish with `git commit` or `git rebase --continue`.
If I mess up, I can always use `git merge --abort` or
`git rebase --abort` to start over.

### What is the purpose of .gitignore?

The `.gitignore` file tells Git which files or directories should be
ignored and not tracked in version control. This is useful for excluding
things like build artifacts, temporary files, logs, IDE settings, or
sensitive configuration files that should not be committed.

### How do you undo a commit that has already been pushed?

-   **`git revert`** (Safe way, preferred for shared branches)
    -   Creates a new commit that reverses the changes of a previous
        commit.
    -   Keeps history intact, avoids rewriting commits.
    -   Recommended for undoing changes on a public branch.

### Can you give me some common git commands?

-   git clone
-   git status
-   git add
-   git commit
-   git push
-   git pull
-   git branch
-   git merge
-   git fetch

# 2. Java Core


### 1. What are Primitive data types in Java?

Primitive data types are the most basic data types that store simple values directly in memory.

- byte, short, int, long, float, double, char, boolean

### 2. What is the difference between == and equals()?

- `==` compares **object references** (or primitive values).
- **`equals()`** is a method (from `Object` class) that compares **object values/content** (if overridden).
- If `equals()` not been overridden, it inherits `Object`’s default implementation, which works like `==`.

### 3. What is String Pool?

A special area in the Heap stores all String literals; it helps save memory.

### 4. What is Final, Finally, and Finalize?

- **`Final`** is a keyword; **`final`** variable, **`final`** method, **`final`** class.
- **`Finally`** is a block used in exception handling.
- **`finalize()`** is a method called by the Garbage Collector (to perform cleanup before an object is garbage collected).

### 5. What is Static?

A keyword in Java meaning that the member (variable, method, block, or nested class) belongs to the **class itself** rather than to any specific object. This means it can be accessed without creating an instance of the class.

### 6. What is OOP (4 principles)?

Programming paradigm centered around objects and classes. It promotes four principles: **encapsulation, inheritance, polymorphism, and abstraction.**

### 7. What is Polymorphism?

In programming, *polymorphism* refers to the same object exhibiting different forms and behaviors.

Polymorphism allows one interface or method name to represent multiple implementations — **overloading** at compile time, and **overriding** at runtime.

### 8. What is method overriding and overloading?

- **Overriding (Runtime Polymorphism)**: A subclass provides a different implementation of a method of its superclass.
- **Overloading (Compile-time Polymorphism)**: Two or more methods in the same class with the same name but different parameter lists.

### 9. What is abstract class and interface? Difference?

- Common: Interface and Abstract class are used to achieve abstraction.
- Abstract class can have constructors, but interface cannot (Why?)
  - Interfaces cannot be instantiated.
  - The constructor of the class implementing the interface is responsible for initialization.
- A class can only extend one abstract class, but can implement multiple interfaces.
- All methods in an interface are `public abstract`, but abstract classes can have others.
- All fields in an interface are `static final`, but abstract classes can have others.

### 10. What is exception and error?

- **`Error`** and **`Exception`** both are subclasses of **`Throwable`**.
- **`Error`** is unrecoverable, severe failure in JVM, like `OutOfMemoryError`, `StackOverflowError`.
- **`Exception`** is caused by the application itself, and an application can catch them.
  - **`Checked Exception`**: Checked at compile-time, forces the programmer to handle them (e.g., `IOException`, `SQLException`).
  - **`Unchecked Exception`**: Not checked at compile-time, do not need to be handled (e.g., `NullPointerException`, `ArrayIndexOutOfBoundsException`).

### 11. What is the difference between throw and throws?

- **`throw`**: Explicitly throw an exception from a method.
- **`throws`**: Used in the method signature to indicate that this method might throw listed exceptions.
- The caller to these methods has to handle the exception using a `try-catch` block or throw it further.

### 12. What is StringBuilder and StringBuffer?

`StringBuilder` and `StringBuffer` are **mutable classes** in Java used to create and manipulate strings.

- `StringBuffer`: synchronized, thread-safe, slower.
- `StringBuilder`: non-synchronized, faster, single-threaded.

### 13. What are different access modifiers?

- **public** – Accessible from anywhere.  
- **protected** – Accessible in the same package and by subclasses.  
- **default** – Accessible in the same package only.  
- **private** – Accessible in the same class only.


# 3. Java Collections & Concurrency


### Difference between ArrayList and LinkedList

- `ArrayList` is implemented by an `array`, while `LinkedList` is implemented by a `doubly-linked list`.
- Accessing elements in `ArrayList` is `O(1)`, while adding/removing elements in `LinkedList` is `O(1)`.
- `ArrayList` is preferred when there are more `get` operations, while `LinkedList` is preferred when there are more `insert/delete` operations.

### Difference between Vector and ArrayList

- `ArrayList` is faster, not synchronized, and is the modern choice.
- `Vector` is synchronized, thread-safe, and considered a legacy class (used before Java 2).

### Time Complexity of HashMap

| **Operation**    | **Average Case** | **Worst Case (Pre-Java 8)** | **Worst Case (Java 8+)** |
| ---------------- | ---------------- | --------------------------- | ------------------------ |
| put(key, value)  | O(1)             | O(n)                        | O(log n)                 |
| get(key)         | O(1)             | O(n)                        | O(log n)                 |
| remove(key)      | O(1)             | O(n)                        | O(log n)                 |
| containsKey(key) | O(1)             | O(n)                        | O(log n)                 |
| iteration        | O(n)             | O(n)                        | O(n)                     |

### Java HashMap Implementation

HashMap implementation is a resizable hash table backed by an array of buckets, where each bucket can hold a linked list or a balanced tree of entries.

### What happens if hash collision occurs?

If two keys map to the same index (collision), entries are stored:

- As a **linked list** initially.
- If the list exceeds a threshold, it converts to a **Red-Black Tree** for faster lookup. This improves worst-case lookup from **O(n)** (list traversal) to **O(log n)** (tree search).

### What are hashCode() and equals()

- **`equals()`**: Determines the equality of two objects.
- **`hashCode()`**: Returns an integer hash code used to calculate the bucket index.

### Why need to implement hashCode() when implementing equals()?

Hashing retrieval is a **two-step process**:

1. Find the right bucket (using `hashCode()`).
2. Search the bucket for the right element (using `equals()`).
   - If `hashCode()` is not overridden, objects with the same content (`equals() == true`) may not hash to the same bucket.
   - If `equals()` is not overridden, we cannot find the same object (key) in the bucket.

### HashMap vs TreeMap vs HashTable

| **Feature / Class**             | `HashMap`                           | `Hashtable`                     | `TreeMap`                             |
| ------------------------------- | ----------------------------------- | ------------------------------- | ------------------------------------- |
| **Ordering**                    | Unordered                           | Unordered                       | Sorted by natural order or comparator |
| **Thread-Safe**                 | ❌ No                                | ✅ Yes (synchronized)            | ❌ No                                  |
| **Underlying Structure**        | Array + LinkedList / Tree (Java 8+) | Array + LinkedList              | Red-Black Tree                        |
| **Sorted?**                     | ❌ No                                | ❌ No                            | ✅ Yes                                 |
| **Iteration Order**             | Unpredictable                       | Unpredictable                   | Key-sorted order                      |
| **Performance (Single Thread)** | ✅ Fast (O(1))                       | ❌ Slower due to synchronization | ❌ Slower (O(log n))                   |

### How does ConcurrentHashMap work?

`ConcurrentHashMap` is a thread-safe alternative to `HashMap` that allows concurrent read and write operations without locking the entire map.

It achieves **high concurrency and good performance** by using finer-grained locking — locking only portions of the map (buckets/bins) and using **CAS (Compare-And-Swap)** operations, allowing multiple threads to read and write simultaneously without blocking the entire map.

# 4

### How to create a new thread? 

- Extends Thread Class override run()
- Implements Runnable
- Implements Callable
- Use ExecutorService



### Difference between Runnable and Callable? 

| **Feature**                  | `Runnable`                    | `Callable<V>`           |
| ---------------------------- | :---------------------------- | ----------------------- |
| Return value                 | Cannot return a result (void) | Can return a result (V) |
| Can throw checked exceptions | No                            | Yes                     |
| Method to implement          | `run()`                       | `call()`                |
| Used with                    | Thread, Executor              | ExecutorService, Future |



### How does thread communicate with each other? 

- **`wait()`** makes the current thread release the lock and go into waiting state until another thread notifies it.
- **`notify()`** wakes up one thread that is waiting on the same object’s monitor.
- **`notifyAll()`** wakes up **all** threads waiting on that object.



### What is synchronized? 

synchronized is a keyword used to ensure that only one thread at a time can access a block or method of code



### What is volatile? 

Indicate that a variable’s value may be modified by multiple threads, and therefore should not be cached.



### sleep() vs. wait()? 

- sleep() method is used to pause the execution of the current thread for a specified amount of time.
- wait() is a method used for inter-thread communication, allowing one thread to pause execution and release the monitor (lock) it holds, until another thread notifies it using notify() or notifyAll().



### What is the difference between t.start() and t.run()? 

**`t.run()`**

Does not start a new thread

Simply calls the `run()` method like a normal method in the current thread.

**`t.start()`**

**Starts a new thread** of execution.

The thread will execute the code inside the `run()`  method.



### What’s the difference between class lock and object lock? 

**Object Lock (Instance Lock)**

- Acquired when a thread enters a **synchronized instance method** or **synchronized block** on `this`.
- Ensures that only one thread at a time can access the synchronized code of a particular object.

**Class Lock (Static Lock)**

- Acquired when a thread enters a **static synchronized method** or **synchronized block on Class object**.
- Ensures mutual exclusion across **all instances** of that class.



**Object lock** is tied to a specific instance, controls access to **instance-level** members.

**Class lock**  is tied to the `Class` object, controls access to **class-level (static)** members.

### What is join() method? 

join() is used to pause the execution of the current thread until another thread finishes its execution



### What is yield() method 

a static method that tells the currently executing thread to pause and let other threads of the same priority run.



### What is ThreadPool? How many types of ThreadPool? What is the TaskQueue in ThreadPool? 

Thread Pool is a pool of pre-created worker threads used to execute multiple tasks concurrently without the overhead of creating and destroying threads for each task.

- **FixedThreadPool**
  - A pool with a fixed number of threads.
  - Extra tasks are queued until a thread becomes free.
- **CachedThreadPool**
  - Creates new threads as needed, reuses idle ones.
  - Good for short-lived, lightweight tasks.
- **SingleThreadExecutor**
  - A pool with only **one thread**.
  - Ensures tasks execute sequentially.
- **ScheduledThreadPool**
  - Executes tasks after a delay or periodically.

In a `ThreadPoolExecutor`, the **TaskQueue** is a **BlockingQueue** that holds tasks waiting to be executed.

### Difference between shutdown() and shutdownNow() methods of executor 

- `shutdown()` graceful shutdown: lets running tasks finish, no new tasks accepted.
- `shutdownNow()` forced shutdown: tries to cancel running tasks and discards queued ones.



### What is the concurrent collections? Can you list some concurrent data structure (Thread-safe)



| **interface** | **non-thread-safe**     | **thread-safe**                              |
| ------------- | ----------------------- | -------------------------------------------- |
| List          | ArrayList               | **CopyOnWriteArrayList**                     |
| Map           | HashMap                 | **ConcurrentHashMap**                        |
| Set           | HashSet / TreeSet       | **CopyOnWriteArraySet**                      |
| Queue         | ArrayDeque / LinkedList | **ArrayBlockingQueue / LinkedBlockingQueue** |
| Deque         | ArrayDeque / LinkedList | **LinkedBlockingDeque**                      |


# 5 Java 8

### What are Java 8 new features?

- **Default and Static Methods in Interfaces**
  - A default method provides a concrete implementation in an interface, so implementing classes don’t have to override it unless needed.
  - A static method belongs to the interface itself, not to instances or implementing classes.
- **Lambda Expressions** 
- **Method References** 
- **Functional Interfaces** 
- **Optional Class**
- **Stream API**
- **CompletableFuture**



### What is the @FunctionalInterface?

an interface that contains exactly one abstract method.



### Can a functional interface extend/inherit another interface?

**only if** the total number of abstract methods across the hierarchy is **exactly one**



### What is lamda?

anonymous function that implements a functional interface

### What is Method Reference?

a shorthand syntax for writing lambda expressions. It allows you to refer to a method by its name, rather than writing a full lambda expression.



### What is the Optional class?

a container object used to represent the presence or absence of a value. Instead of returning null, methods can return an Optional<T> to indicate a value may or may not exist.



### What are the advantages of using the Optional class?

- To avoid Null checks and run time NullPointerExceptions

- Makes code more readable and expressive

  - Indicates clearly when a method **might not return a value**.

    Example:

    ```
    Optional<User> findUser(String id);
    ```

    communicates intent better than `User findUser(String id)` returning `null`.

- **Encourages functional programming style**

  - With methods like `map()`, `filter()`, `ifPresent()`, `orElse()`, it promotes concise, chainable operations instead of nested `if-else`.

- **Reduces boilerplate null checks**

  - Replaces repetitive `if (obj != null)` checks with clear API calls.

### What is stream API?

a powerful feature for processing collections of data in a **functional and declarative style**. It allows you to perform operations like filtering, mapping, and reducing on data without writing explicit loops.

#### 	**What is a Stream?**		

- A **Stream** is a sequence of elements that can be processed **in a pipeline** of operations — such as `filtering`, `mapping`, and `reducing` — ***without modifying the original data source.***

  It is **not** a data structure and does **not store elements**; it’s a ***view of data*** from a source

#### 	**What is the benefits of using stream API?**

1. **Concise and Readable Code**

   Stream API allows you to write **clean, declarative, and expressive** code, especially when performing multiple operations on collections.

   ```java
   // Without Streams
   List<String> result = new ArrayList<>();
   for (String name : names) {
       if (name.startsWith("A")) {
           result.add(name.toUpperCase());
       }
   }
   
   // With Streams
   List<String> result = names.stream()
       .filter(name -> name.startsWith("A"))
       .map(String::toUpperCase)
       .collect(Collectors.toList());
   ```

2. **Chaining and Pipelining**

   You can **chain multiple operations** like filter(), map(), sorted(), etc., to build a **processing pipeline** in a single, fluent statement.

3. **Lazy Evaluation (better performance)** Intermediate operations (like filter() and map()) are **lazy** — they are only executed when a **terminal operation** (like `collect()` or `forEach()`) is invoked. This improves performance. (Skips unnecessary work, reduces overhead)

4. **No Side Effects**

   Stream operations are designed to be **pure** and **stateless**, encouraging **functional programming** principles and reducing bugs caused by shared mutable state.

### What are the most commonly used Intermediate operations?

- **Intermediate (return a Stream, lazy)**

  - `filter()` → select elements
  - `map()` → transform elements
  - `sorted()` → sort elements
  - limit(n) Truncates the stream to at most `n` elements.

  - **`skip(n)`**Skips the first `n` elements.
  - **`distinct()`**Removes duplicate elements (based on `equals()`).
  - **`flatMap(Function)`**Flattens nested structures into a single stream.

### How are Collections different from Stream?

Collections are **data structures that store elements**, while Streams are **pipelines for processing data** in a functional, lazy, and often parallel way.



| Aspect               | **Collections**                                              | **Streams**                                                  |
| -------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **Nature**           | Stores and manages data in memory (e.g., `List`, `Set`, `Map`). | Represents a *pipeline of operations* on a data source.      |
| **Storage**          | **Eager** — holds all elements in memory.                    | **Lazy** — does not store data, processes it on demand.      |
| **Operations**       | Focus on **CRUD** operations (add, remove, update, iterate). | Focus on **functional operations** (filter, map, reduce, collect). |
| **Reusability**      | Can be iterated over **multiple times**.                     | A stream can be consumed **only once**.                      |
| **Iteration**        | Uses **external iteration** (e.g., for-loop, iterator).      | Uses **internal iteration** handled by the Stream API.       |
| **Parallelism**      | Manual — need to use threads explicitly.                     | Built-in support via `parallelStream()`.                     |
| **API Introduction** | Java 1.2 (Collections Framework).                            | Java 8 (Streams API).                                        |



# 6 SpringBoot



### What is IoC? 

Inversion of Control is a design principle, it inverts the control of dependencies to the container. And the container is responsible for creating and managing the objects.

### What is DI? 

- **Dependency Injection** is a **design pattern** used to ***implement*** IoC. 
- It means **injecting dependent objects (dependencies) into a class**, rather than creating them inside the class.

### What are 3 types of DI? 

- **Constructor Injection  (Recommended)**
  - injected objects are **immutable**
  - easy for unit test
- **Setter Injection**
  - when the dependency is optional
- **Field Injection (Not recommend)**
  - easy to implement
  - **hard for testing**

### What is bean? 

 a Spring Bean is an object that is managed by the Spring IoC (Inversion of Control) container.

### What is bean scope? 

In Spring, **bean scope** defines **how many instances of a bean are created** and **how long they live** within the container. It controls the lifecycle and visibility of a bean.

- ### Common Bean Scopes

  1. **Singleton** *(default)*
     - Only **one instance** of the bean is created per Spring container.
     - All requests for the bean return the same object.
  2. **Prototype**
     - A **new instance** is created every time the bean is requested.
  3. **Request** *(Web-aware only)*
     - A new bean instance is created for **each HTTP request**.
  4. **Session** *(Web-aware only)*
     - A new bean instance is created for **each HTTP session**.
  5. **Application** *(Web-aware only)*
     - A single bean instance is shared across the **ServletContext**.

### What are the benefits of using Spring Boot? 

- **Auto-configuration:** Spring Boot automatically configures your application based on the dependencies you include, reducing the need for manual setup.
- **Starter Dependencies:** Bundled dependencies for specific functionalities (e.g., `spring-boot-starter-web`, `spring-boot-starter-data-jpa`) make it easy to get started quickly.
- **Embedded Servers：** No need to deploy WAR files to external servers. Spring Boot provides embedded servers like **Tomcat**, **Jetty**,
- **Integration with Spring Ecosystem：** Works seamlessly with the entire Spring ecosystem: Spring Security, Spring Data, Spring Cloud, etc.

### What is bean life cycle? 

- **Bean instantiated** by container
- **Dependencies Injected**
- **Post initialization** `@PostConstruct`
- Bean methods are used
- **Pre destroy**  `@PreDestroy`

### What is @Autowired? 

an annotation in Spring used for **dependency injection**.

Spring automatically injects a matching bean from the application context

### What are the differences between @RequestParam and @PathVariable? 

`@PathVariable`Binds a **variable part of the URL** to a method parameter.

`@RequestParam`Extracts values from the **query string** (`?key=value`).

### What is @SpringBootApplication 

`@SpringBootApplication` is a convenience annotation in Spring Boot that combines three commonly used annotations into one: `@Configuration`, `@EnableAutoConfiguration`, `@ComponentScan`

### Difference between @Controller VS @RestController? 

- **`@RestController`** is a special version of the **`@Controller`** annotation.

  It includes the **`@Controller`** and **`@ResponseBody`

  - `@Controller`returns ModelAndView 
  - **`@RestController`** returns ResponseEntity

### How to handle exceptions in Spring Boot? 

- Local exception handling: `@ExceptionHandler`
- Global exception handling: Using `@ControllerAdvice` + `@ExceptionHandler `

### How do you create a rest controller?

To create a REST controller, annotate a class with **`@RestController`**, map requests with `@RequestMapping`/`@GetMapping`/`@PostMapping`, and return objects 

### What is spring boot actuator?

- **Spring Boot Actuator** is a module in Spring Boot that helps you **monitor and manage** your application in production

  **Key Features：**

  - **/actuator/health :** Shows application health status
  - **/actuator/metrics:** Exposes metrics (e.g., JVM stats, HTTP requests, etc.)
  - **/actuator/env:** Shows environment properties (profiles, configs)
  - **/actuator/beans:** Lists all Spring-managed beans


# 7 database

## Chapter 1: Database Basics


### 1. what is database and what is database management system 

The database is where the data is stored. It contains actual data and structure of data.

A Database Management System (DBMS) is the application (software, db server, engine) that lets you interact with the database.

### 2. what is the difference between relational database and non-relational database 

RDBMS stores information in tables.

NoSQL stores data in **flexible formats**: key-value pairs, documents (JSON), wide-column, or graphs.

### 3. what is CAP (Consistency, Availability & Partition Tolerance) theory 

CAP theorem says a distributed system cannot provide **Consistency, Availability, and Partition Tolerance all at once**. In practice, since partitions are inevitable, systems must choose between **CP** (favoring consistency) or **AP** (favoring availability).

### 4. what is consistency 

Every read receives the **most recent write** (or an error).

**Consistency** means all users see the same up-to-date data at the same time.

### 5. what is availability 



**Availability** means the system always gives a response, even during failures, but that response may be outdated.

### 6. when will you choose MySQL and when will you choose PostgreSQL 

MySQL has improved performance for high-frequency read operations. 

PostgreSQL has improved performance for high-frequency write operations.

PostgreSQL is always ACID compliant. 

- choose MySQL when I need simplicity, speed, and read-heavy workloads.
- choose PostgreSQL when I need advanced SQL, complex queries, strong ACID compliance, or support for JSON/geo/analytical workloads.

### 7. can you list some MySQL and postgreSQL commands 

Both MySQL and PostgreSQL follow SQL standards, so basic commands like CREATE TABLE, INSERT, SELECT, UPDATE, and DELETE are the same.

In MySQL we often use commands like SHOW DATABASES, SHOW TABLES, and DESCRIBE to inspect schema.

In PostgreSQL, similar tasks are done with meta-commands like \l, \dt, and \d. For performance tuning, MySQL uses EXPLAIN, while PostgreSQL uses EXPLAIN ANALYZE.

### 8. what is ACID 

ACID is an acronym that stands for atomicity, consistency, isolation, and durability (ACID)

**Atomicity**: All or nothing: A transaction must either complete fully or not happen at all. If one part of the transaction fails, the entire transaction is rolled back.

**Consistency**: A transaction must take the database from one valid state to another. Any data written to the database must be valid according to all defined rule. 

**Isolation**: Transactions occur independently of each other.

**Durability**: Once a transaction is committed, it remains saved, even in the case of a system crash or power failure.

### 9. what is atomic operation 

All or nothing: A transaction must either complete fully or not happen at all. If one part of the transaction fails, the entire transaction is rolled back.

### 10. what is indexing in database 

Indexing in a database is a **data structure technique** that improves the **speed of data retrieval** operations on a table, at the cost of additional **storage space** and **slower write operations**

## Chapter 2: NoSQL Databases

### 11. how to query data from MongoDB? 

using the `find()` method or the MongoDB Query Language (MQL)

### 12. what are CRUD (CREATE, READ, UPDATE and DELETE) syntax? 

CRUD stands for **Create, Read, Update, Delete**. In SQL, they correspond to `INSERT`, `SELECT`, `UPDATE`, and `DELETE`. 

### 13. what's the difference between MongoDB and DynamoDB? 

MongoDB – Stores data in flexible, JSON-like documents. open-source

Amazon DynamoDB – A fully managed key-value database on AWS. Not for free

MongoDB gives flexibility and control, DynamoDB gives scalability and simplicity in AWS.

### 14. Can you use “join” in MongoDB? 

MongoDB is a **NoSQL document database**, and unlike relational databases, it doesn’t have native **SQL JOINs** between tables.

However, MongoDB provides the **`$lookup` aggregation stage** to perform a **left outer join** between two collections.

### 15. compare with MongoDB and Cassendra 

**Cassandra** is a wide-column database optimized for massive scale and high write throughput, often used in time-series and distributed apps.



- **DynamoDB** → Best for **AWS-based apps** that need **serverless, auto-scaling, low-latency** storage (IoT, gaming, e-commerce).
- **MongoDB** → Best when you need **flexible schema**, **rich queries/aggregation**, and developer productivity (content management, analytics, hybrid workloads).
- **Cassandra** → Best for **high write throughput, global distribution, time-series data** (logs, metrics, telecom, IoT at scale).

| Aspect             | **DynamoDB**                                                 | **MongoDB**                                                  | **Cassandra**                                                |
| ------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| **Type**           | Managed **key-value & document** NoSQL DB (AWS only)         | Open-source **document-oriented** NoSQL DB                   | Open-source **wide-column store** (inspired by Google Bigtable) |
| **Hosting**        | AWS managed service only                                     | Self-hosted or managed (MongoDB Atlas, cloud/on-prem)        | Self-hosted, managed (DataStax Astra, on-prem, cloud)        |
| **Data Model**     | Tables with **Partition Key + Sort Key**; items are JSON-like | Flexible **JSON/BSON documents** with nested fields          | Tables with **rows, columns, and partitions** (good for time-series data) |
| **Schema**         | Schema-less but requires well-defined keys                   | Schema-less, very flexible                                   | Schema-light but enforces partition key/cluster key          |
| **Query Language** | AWS SDK / PartiQL (SQL-like)                                 | MongoDB Query Language (MQL), aggregation pipeline           | CQL (Cassandra Query Language, SQL-like)                     |
| **Scalability**    | **Automatic scaling** by AWS (serverless)                    | Sharding + replication (user must configure, Atlas automates) | **Linearly scalable** with peer-to-peer architecture         |
| **Consistency**    | Tunable: eventually consistent or strongly consistent reads  | Strong consistency within a replica set, eventual with sharding | Tunable consistency (per query: ONE, QUORUM, ALL)            |
| **Transactions**   | Limited, single-region ACID support                          | Multi-document ACID transactions (since v4.0)                | Lightweight transactions (Paxos-based), slower               |
| **Strengths**      | Serverless, integrates tightly with AWS ecosystem, simple to operate | Rich queries, flexible schema, strong dev community          | High write throughput, fault tolerance, perfect for large-scale time-series and distributed workloads |
| **Weaknesses**     | Locked into AWS, limited query flexibility                   | Needs sharding for huge scale, ops overhead if self-hosted   | Complex data modeling, weaker for ad-hoc queries             |

### 16. what can redis be used for? 

Redis is an in-memory key-value store mainly used for **caching**, but it’s also widely used for **session management, leaderboards, pub-sub messaging, distributed locks, and real-time analytics**. Its speed and support for rich data structures make it very versatile.

### 17. what is DynamoDB? what can it do?

DynamoDB is a fully managed, serverless NoSQL database by AWS that provides **key-value and document storage with automatic scaling, replication, and millisecond performance**. It’s widely used for **real-time, high-scale applications** like gaming, IoT, and e-commerce

### 18. what are cassandra data types? 

Cassandra supports **simple types (int, text, uuid, etc.), collections (list, set, map), and**

**User-Defined Types (UDTs)**

### 19. What is memtable and SSTable in Cassandra? 

- **Memtable**
  - In-memory data structure where writes are stored first.
  - Each `INSERT`/`UPDATE` goes to a **Commit Log (for durability)** + **Memtable** (for fast access).
  - When the Memtable is full, it’s flushed to disk as an SSTable.
- **SSTable (Sorted String Table)**
  - Immutable on-disk file created from a flushed Memtable.
  - Stores key-value pairs sorted by partition key.
  - Multiple SSTables exist; Cassandra uses **Bloom filters, indexes, and compaction** to read efficiently.

**In short:** Memtable = in-memory buffer; SSTable = on-disk sorted file.

### 20. what does wide column and column family mean? 

**Wide Column Model**

- Unlike relational tables (fixed columns), Cassandra’s rows can have **different numbers of columns**.
- Data is grouped by **partition key**, and within each partition, rows can have many dynamic columns.
- Useful for time-series data 

**Column Family**

- Similar to a “table” in RDBMS, but stores rows with **dynamic, sparse columns**.
- Each Column Family = a set of **rows**, each row = a set of **columns** identified by a row key.



*Wide Column* = flexible schema where rows can have many/different columns.

*Column Family* = Cassandra’s equivalent of a table, but designed for sparse/dynamic columns.

### 21. what is partition key 

**Definition:** The field (or set of fields) used to decide **which partition (or shard/node)** the data will be stored in.

Ensures **data distribution** and scalability in distributed databases.

All rows/documents with the same partition key are stored together.

Cassandra/DynamoDB: Partition key determines which node holds the row.

MongoDB: Shard key plays a similar role (it’s essentially a partition key).

### 22. what is clustering key 

**Definition:** Determines the **order of rows within a partition**.

Defines how data is **sorted and retrieved** inside a partition.

Helps with **range queries and sorting** efficiently.

### 23. what is graph database 

A **graph database** is a type of database that uses **graph structures** — **nodes (entities), edges (relationships), and properties (attributes)** — to store and query data.

graph databases are optimized for traversing relationships, which makes them ideal for social networks, fraud detection, and recommendation engines.

### 24. How many ways to store a graph (in leetcode)? 

1. **Adjacency List** (most common)

- **What:** For each node, store its neighbors.
- **Use when:** Sparse graphs; most DFS/BFS/Dijkstra/Topo sort.
- **Space:** `O(n + m)` (n = nodes, m = edges)

2. **Adjacency Matrix**

- **What:** `n x n` boolean/weight matrix `mat[u][v]`.
- **Use when:** Dense graphs, quick edge-existence checks `O(1)`, or small `n` (≤ 200–500).
- **Space:** `O(n^2)`; **Time to build:** `O(m)`.

3. **Edge List**

- **What:** Just store edges as pairs/triples `(u, v [, w])`.

  **Use when:** You don’t need fast neighbor iteration (e.g., Kruskal with DSU, or one-pass processing).

  **Space:** `O(m)`.

## Chapter 3: Keys, Normalization, Transactions
  

### 25. what is primary key what is foreign key 

**Primary key**

- A **unique identifier** for each record in a table.
- Ensures **uniqueness** (no two rows have the same primary key).
- Cannot be `NULL`.
- A table can have **only one primary key**, which may consist of one or multiple columns (composite key).

**Foreign key**

- A column (or set of columns) in one table that **references the primary key** in another table.
- Enforces **referential integrity** → ensures that the relationship between two tables is valid.
- A table can have **multiple foreign keys**.

### 26. what is database normalization

Database normalization is a process of structuring relational databases to **minimize redundancy and dependency** by splitting tables and using keys to maintain relationships. It prevents anomalies and ensures data integrity. Common normal forms are **1NF, 2NF, 3NF, and BCNF**.

### 27. what is transaction 

In a database, a transaction is a sequence of one or more operations (like INSERT, UPDATE, DELETE, or SELECT) that are executed as a single logical unit of work. A transaction must follow the ACID properties to ensure data integrit

## Chapter 4: ORM, JPA, Hibernate, Spring


### 28. what is ORM 

ORM (Object-Relational Mapping) is a technique that maps database tables to programming objects, so developers can work with a database using object-oriented code instead of SQL.

### 29. what is JPA 

**JPA (Java Persistence API)** is a **specification** in Java that defines how to **map Java objects to relational database tables**.

It is part of Java EE (Jakarta EE) and provides a **standard API for ORM **.

JPA itself is **just an interface/specification**, not an implementation.



***JPA** is the **Java specification** for ORM — it defines how Java objects map to database tables.*

### 30. what is Hilbernate 

**Hibernate** is the **most popular implementation** of the JPA specification.

It is an **ORM framework** that provides:

- Automatic SQL generation from Java entities
- Caching, lazy loading, dirty checking
- Advanced mappings (one-to-many, many-to-many, etc.)

You can use Hibernate directly (with its own APIs) or through the **JPA standard API**.



***Hibernate** is the **implementation** of JPA (and adds extra features), making it the most widely used ORM framework in Java.*

### 31. In hibernate, what does the generator element do? 

Defines **how primary key values are generated** for entities.

It is part of the `<id>` mapping in XML configuration.

### 32. what is derived property in hibernate 

A **calculated (read-only) property** that is not stored in the DB but computed using SQL expressions.

Defined using `@Formula` annotation.

### 33. What are the core interfaces of hibernate? 

**Session** → Represents a single unit of work (used for CRUD operations).

**SessionFactory** → A heavyweight object, thread-safe, used to create Sessions.

**Transaction** → Manages atomic units of work.

**Query** → For executing HQL/SQL queries.

**Configuration** → For bootstrapping Hibernate configuration.

### 34. How to configure sessionFactory for hibernate 

**(a) XML (hibernate.cfg.xml)**

**(b) Java Code:**

```java
SessionFactory factory = new Configuration()
    .configure("hibernate.cfg.xml")
    .buildSessionFactory();
```

### 35. What is HQL：Hibernate Query Language (HQL) 

HQL is **object-oriented query language** similar to SQL but uses **entity names & properties** instead of table/column names.

DB-agnostic (Hibernate translates HQL → SQL).

### 36. what is load/get in hibernate 

`get()` → **Eager fetch**: hits the DB immediately, returns `null` if not found.

`load()` → **Lazy fetch**: returns a proxy, hits the DB only when accessed, throws `ObjectNotFoundException` if not found.

### 37. explain how to use Hibernate @OneToMany 

Defines a **one-to-many relationship** between two entities.

For example, one Department can have many Employees. You annotate the parent with `@OneToMany(mappedBy="...")` and the child with `@ManyToOne` and a `@JoinColumn`. Cascade and fetch type control persistence and loading behavior.

### 38. lazy loading and eager loading in hibernates 

**Lazy Loading** (default):

- Data is fetched **only when accessed**.
- Efficient for large datasets.
- Example: `@OneToMany(fetch = FetchType.LAZY)`

**Eager Loading**:

- Data is fetched **immediately with the parent entity**.
- Can cause performance issues (N+1 queries).
- Example: `@OneToMany(fetch = FetchType.EAGER)`

### 39. how do you define entity? 

An entity in Hibernate/JPA is a Java class mapped to a database table using `@Entity`. Each object corresponds to a row in the table. It must define a primary key (`@Id`) and typically uses annotations like `@Table` and `@Column` for mapping.

### 40. What library do you use to connect database? 

In Java, we typically use **JDBC drivers** to connect to relational databases directly, or use higher-level frameworks like **Hibernate/JPA** or **Spring Data JPA** that sit on top of JDBC to simplify persistence.

### 41. In the future, I need to change the attribution or column, how to do that in spring? 

In Spring Boot with JPA/Hibernate, if you change an entity attribute, Hibernate can auto-update the schema using `spring.jpa.hibernate.ddl-auto=update` (useful for development). But in production, the best practice is to manage schema changes with Database Migration Tool like **Flyway or Liquibase migration scripts**, so column changes are tracked and version-controlled.

### 42. Annotations used in Spring JPA

 In Spring JPA, we use annotations like `@Entity`, `@Table`, `@Id`, and `@Column` for entity mapping, and relationship annotations like `@OneToMany`, `@ManyToOne`, and `@ManyToMany`. Spring Data JPA also provides `@Repository`, `@Query`, and `@Transactional` for repository and transaction management.

### 43. How will you introduce transactions into your Spring Boot code?

In Spring Boot I add `@Transactional` at the **service layer** to wrap a use case as one unit of work, tuning **propagation, isolation, rollback rules** as needed; Boot auto-configures the `TransactionManager`. For edge cases I use **TransactionTemplate**.


# 8 Spring additional

## AOP 

#### Spring AOP, why it is needed 

Aspect-Oriented Programming. 

It's a way to separate cross-cutting concerns (like logging, security, transactions) from your business logic. keep business logic **clean and focused**, and make applications **easier to maintain, extend, and test**.

#### What is an aspect in Spring? 

A class that contains cross-cutting code

## Batch 

#### What is Spring Batch? 

Spring Batch is a batch processing framework designed for robust and scalable execution of batch jobs.

#### What is batch processing and realtime processing? When to use which? 

- Batch processing 
  - Processing large volumes of data **in batches** at scheduled intervals without human intervention.
- Real-time Processing
  - Processing data **immediately as it arrives**

Use **Batch** when:

- You don’t need instant results.
- You want efficiency in processing very large datasets.

Use **Real-time** when:

- Time-sensitive decisions matter (fraud detection, live analytics).
- User experience depends on instant feedback.

#### How you implement steps in Spring batch 

A **Step** is an executable phase of a Job. implement it as **Chunk-oriented** (read → process → write in chunks, with a transaction per chunk)

**Components:** `ItemReader` → `ItemProcessor` → `ItemWriter`

**Why:** Reliable bulk processing with restartability, commit/rollback per chunk, and fault tolerance.

“I implement steps as chunk-oriented when I need robust, transactional bulk processing with restart and fault tolerance; I use tasklets for single, atomic tasks. I wire reader/processor/writer, set a sensible chunk size, enable skip/retry with listeners, use `@StepScope` for parameterized components, and scale via multi-threading or partitioning as needed.”

#### If there are 1 million updates, how to use Spring Batch? 

“For ~1M updates, I build a chunk-oriented Spring Batch job with batched, idempotent writes; tune chunk and batch sizes; enable skip/retry and checkpoints for safe restarts; and scale via multi-threading or partitioning. I monitor throughput and error rates, and, if needed, push to remote partitioning or a staging-table + bulk-merge pattern for peak throughput.”

## Inteceptor 

#### inteceptor vs filter 

- Spring Interceptor

  - Part of Spring MVC (`HandlerInterceptor`). Runs **inside Spring** after `DispatcherServlet`, but before controller methods.
  - Only applies to requests handled by Spring MVC
  - **Use cases:**
    - Authorization based on handler method annotations (`@RolesAllowed`, custom auth)
    - Adding attributes to `ModelAndView`
    - Pre/post controller logic (e.g., logging execution time, auditing which controller was called)

- Servlet Filter

  - Part of the Servlet specification (javax.servlet). Runs at the **container level** before requests hit the `DispatcherServlet`.

  - **Scope:** Can work on *any* resource (JSP, static files, REST endpoints).

    **Use cases:**

    - Request/response logging
    - Authentication (basic checks)
    - Character encoding
    - Compression / CORS headers



“Filters are servlet-spec and sit before Spring; they work on all requests globally but only see raw `HttpServletRequest/Response`. Interceptors are Spring-specific, applied after `DispatcherServlet`, and can access handler methods and the MVC context. I use filters for cross-cutting container-level tasks like CORS/logging, and interceptors for MVC-aware logic like auth checks, auditing, or performance monitoring.”

#### authentication vs authorization 

| Aspect                    | Authentication ✅                       | Authorization ✅                            |
| ------------------------- | -------------------------------------- | ------------------------------------------ |
| **Question answered**     | *Who are you?*                         | *What are you allowed to do?*              |
| **Order**                 | Always comes first                     | Only after authentication succeeds         |
| **Spring Security layer** | Login filters, `AuthenticationManager` | AccessDecisionManager, method/URL security |
| **Failure result**        | 401 Unauthorized                       | 403 Forbidden                              |

“Authentication is the process of confirming a user’s identity, while authorization determines what actions that authenticated user is permitted to perform. In Spring Security, authentication comes first through the `AuthenticationManager`, and then authorization is enforced through access rules and role checks.”

## MVC

#### what is MVC? 

MVC is a design pattern, it emphasizes a separation between the software's business logic and display. It provides a clear separation of business logic, UI logic, and input logic.

#### what is DispatcherServlet? 

The **DispatcherServlet** is the **front controller** of Spring MVC. It’s itself a Servlet (extends `HttpServlet`) but specialized to handle all web requests in a Spring application.

**Responsibilities:**

- Receives every incoming request mapped to it.
- Delegates to **HandlerMappings** to find the right controller.
- Invokes the controller method through **HandlerAdapters**.
- Passes data to a **ViewResolver** to render the response (HTML, JSON, etc.).

#### what is Servlet? 

A Servlet is a Java class used to handle HTTP requests and responses in a web application

It runs on a Servlet container (like Apache Tomcat) and follows the Servlet API, which is part of Java EE (now Jakarta EE).

Example Flow:

- User visits http://example.com/hello 
- Tomcat receives the request and routes it to the corresponding Servlet. 
- The Servlet runs some logic (e.g., fetches data). It will call controller in Spring MVC 
- The Servlet returns a response to the browser.

#### can you describe the flow of MVC? 

- A user sends an HTTP request (e.g., via a browser). 
- The DispatcherServlet (front controller) receives the request. 
- DispatcherServlet passes it to the correct Controller based on URL mapping. 
- The controller processes the request and returns a ModelAndView (or just the data/view name). 
- The ViewResolver resolves the view and renders the output (e.g., HTML) using the data from the model. 
- The response is sent back to the user.

#### what is model? 

Represents the application's data and business logic

#### what is controller? 

Handles incoming HTTP requests, processes them (with the help of services), and returns a view.

#### what is view? 

The view is the part responsible for displaying the data returned by the controller. 

It could be: 

- An HTML page using Thymeleaf, JSP, or FreeMarker 
- A JSON response (in case of REST APIs, especially with @RestController) 
- Even a PDF or Excel file in some advanced cases

## Cron 

#### What is cron job? 

A cron job is a scheduled task that runs automatically at specified times or intervals. In Spring Boot, a cron job is implemented using the @Scheduled(cron = "...") annotation

#### how to use @scheduled 

- `@Scheduled` is a Spring annotation (from **Spring’s scheduling support**) used to run a method periodically or at a specific time.
- To enable it, you must annotate a configuration class with `@EnableScheduling`.
- The method should be `public`, return `void`, and typically have no parameters.

#### how to make a job run everyday at 1 am 

To schedule tasks in Spring, I annotate a method with `@Scheduled`. For example, to run a job daily at 1 AM, I use `@Scheduled(cron = "0 0 1 * * ?")`. I also enable scheduling with `@EnableScheduling` in the config class.

## Actuator 

#### what is the actuator in springboot?

- **Spring Boot Actuator** is a module in Spring Boot that helps you **monitor and manage** your application in production

  **Key Features：**

  - **/actuator/health :** Shows application health status
  - **/actuator/metrics:** Exposes metrics (e.g., JVM stats, HTTP requests, etc.)
  - **/actuator/env:** Shows environment properties (profiles, configs)
  - **/actuator/beans:** Lists all Spring-managed beans

## Listener 

#### What is listener? 

In Spring Boot, a listener is a component that listens for specific events and responds accordingly.

#### what events have you used with the listeners in spring? 

I’ve used Spring’s built-in events like `ContextRefreshedEvent` to preload data and `ApplicationReadyEvent` to trigger startup jobs. I’ve also created custom events like `UserRegisteredEvent` to send emails asynchronously. These listeners help decouple business logic and improve maintainability.

## Swagger 

#### what is Swagger? 

Swagger is a third party tool used to automatically generate API documentation for your RESTful web services. 

What Swagger Does in Spring Boot: 

- Documents your REST APIs by scanning annotations like @RestController, @GetMapping, etc. 
- Creates a user-friendly UI (Swagger UI) to explore, test, and debug endpoints. 
- Provides a JSON/YAML output of your API structure based on OpenAPI.

## Logging 

#### What is log level? Why to use it? 

- TRACE – Fine-grained, useful for debugging 
- DEBUG – General debugging info 
- INFO – Standard runtime info 
- WARN – Non-critical issues 
- ERROR – Serious problems
- Log level can be used to config which logs should be displayed (config in application.properties)

#### How to enter debug mode in Intelij?

In IntelliJ, you can enter debug mode by running your app with the bug icon or Shift+F9. You set breakpoints in the editor, and when execution hits them, you can inspect variables, threads, and call stack. For remote apps, you attach a remote debugger on a specific port using JVM debug options.

# 9 Test 

#### what are unit test and integration test? what tools should we use for those tests? 

- Unit test : checks the accuracy of a smaller, isolated block of application code, typically a function or method. JUnit Mockito
- Integration test: checks different parts of the software system that are designed to interact do so correctly
  - API Testing: Postman **RestAssured** 
  - E2E Testing: **Cypress** and **Playwright** 

#### what is functional test? 

Functional testing checks that the system behaves according to business requirements — essentially verifying that the features work as expected from the user’s perspective. It’s black-box testing, focused on correctness of functionality rather than performance or internal design.

#### what tools do you use to test performance? Or do you do performance testing? 

I usually use JMeter or Gatling to simulate concurrent user loads, and combine that with Spring Boot Actuator and Prometheus/Grafana to monitor throughput, latency, and resource usage. I focus on load, stress, and endurance scenarios to validate system scalability.

#### What are phases for software testing lifecycle? 

The software testing life cycle includes requirement analysis, test planning, test case development, environment setup, test execution, defect reporting & tracking, and test closure. Each phase ensures we validate requirements, catch defects early, and deliver a reliable product.

#### Verification vs Validation of software testing 

Verification is about ensuring we build the product right by checking documents, designs, and code against specifications. 

Validation is about ensuring we build the right product by actually testing the software against user needs.

#### Most effective test strategy you have applied? 

The most effective test strategy I’ve applied was a **layered testing approach**: unit tests for logic, integration tests for service/data contracts, end-to-end tests for business flows, and JMeter for performance. Combined with CI/CD integration, this reduced production defects and gave us faster, safer releases.

#### what is the difference between spy and mock in mockito 

A mock is a fake object where all methods are stubbed and return defaults unless defined. A spy wraps a real object — real methods run unless you stub them. Use mocks for full isolation, and spies when you need partial mocking.

#### What is Test-Driven Development (TDD) 

Test-Driven Development (TDD) is a Software development method in which you write Automation Tests before the actual development process (coding).

#### how to test a private static method

- test through public methods that use them
- Refactor to a Utility/Helper Class
- Using Reflection


# 10 microservice

#### what is a microservice? 

Microservice is an architecture design pattern. It splits one large application into multiple small and independent service based applications.

#### can you tell me some components in microservice? 

![diagram](https://substackcdn.com/image/fetch/$s_!iezw!,w_1456,c_limit,f_auto,q_auto:good,fl_lossy/https%3A%2F%2Fsubstack-post-media.s3.amazonaws.com%2Fpublic%2Fimages%2F18ccf7c0-51e8-4243-953d-37ccd28df10e_1329x1536.gif)

1. API Gateway
   The gateway provides a unified entry point for client applications. It handles routing, filtering, and load balancing.
2. Service Registry
   The service registry contains the details of all the services. The gateway discovers the service using the registry. For example, Consul, Eureka, Zookeeper, etc.
3. Service Layer
   Each microservices serves a specific business function and can run on multiple instances. These services can be built using frameworks like Spring Boot, NestJS, etc.
4. Authorization Server
   Used to secure the microservices and manage identity and access control. Tools like Keycloak, Azure AD, and Okta can help over here.
5. Data Storage
   Databases like PostgreSQL and MySQL can store application data generated by the services.
6. Distributed Caching
   Caching is a great approach for boosting the application performance. Options include caching solutions like Redis, Couchbase, Memcached, etc.
7. Async Microservices Communication
   Use platforms such as Kafka and RabbitMQ to support async communication between microservices.
8. Metrics Visualization
   Microservices can be configured to publish metrics to Prometheus and tools like Grafana can help visualize the metrics.
9. Log Aggregation and Visualization
   Logs generated by the services are aggregated using Logstash, stored in Elasticsearch, and visualized with Kibana.

#### How does each part of microservice communicate with each other? 

1. **Synchronous Communication**

- API
  - REST (Representational State Transfer) – Most common web API style
    - Best for simple, human-readable APIs, public APIs, and quick prototyping. Easy to use, wide support
  - gRPC – High-performance binary-based API (uses Protocol Buffers)
    - Protocol buffers, or Protobuf, is Google's serialization/deserialization protocol that enables the easy definition of services and auto-generation of client libraries.
    - It encodes/decodes data to a compact binary format for efficient storage or network transmission.
    - Best for internal services, low-latency needs, and streaming. Fast, strongly typed, good for microservices
  - GraphQL – Flexible query-based API
    - Best when clients need to control the data they fetch — great for mobile/web (UI developing). Reduces over-fetching/under-fetching

2. **Asynchronous Communication**

- Message Queue 
- RabbitMQ 
- Kafka 
- AWS SQS (Simple Queue Service) 
- Redis pub/sub (Not considered as message queue but good to know)

#### What are microservice pros and cons? 

Pros

- Agility 
- Scalability
  - Services can be scaled independently, letting you scale out subsystems that require more resources, without scaling out the entire application.
- Fault isolation and data isolation

Cons

- Complexity
- Communication latency
  - In memory data transfer compare to API call 
  - A long chain of services can cause large latency from source to destination
- Data integrity
  - Each microservice responsible for its own data persistence. As a result, data consistency across multiple services can be a challenge
- Management
  - Correlated logging across services can be challenging. Typically, logging must correlate multiple service calls for a single user operation.
- Lack of governance

#### what is Domain driven development? 

Domain-Driven Development is an approach where software design is driven by the business domain. It emphasizes ubiquitous language, bounded contexts, and modeling domain concepts as entities, value objects, aggregates, and services. The goal is to align code closely with business needs and create maintainable, domain-focused systems.

#### how to scale in microservice 

- **Horizontal scaling (scaling out): **Run **multiple instances** of the same microservice. Put them behind a **load balancer**
- **Vertical scaling (scaling up):** adding more resources (like CPU, RAM, or storage) to a single instance of a microservice. 

#### How to do service discovery in microservice? 

- **Client-Side Discovery (e.g., Netflix Eureka)**
  - The client is responsible for looking up the network locations of available service instances and load-balancing requests across them.
- **Server-Side Discovery (e.g., Kubernetes)**
  - a router or load balancer intercepts requests from the client. The router is responsible for querying the service registry, selecting a service instance, and forwarding the request.

#### Microservices vs monolithic applications 

A monolithic application is a single, tightly coupled unit, simple to start but hard to scale and evolve. A microservices application breaks functionality into independent services that can be developed, deployed, and scaled separately, offering agility and scalability at the cost of higher operational complexity.

#### steps to convert monolithic architecture to microservices architecture 

Start by defining bounded contexts and building the platform (CI/CD, gateway, discovery, observability). Migrate incrementally using the strangler pattern: extract one capability at a time with its own data, expose stable contracts, integrate via sync/async calls, test with contracts and canaries, monitor SLOs, and retire monolith pieces iteratively.

#### how does service registry know if there is a new microservice got created 

A service registry knows about new microservices either through **self-registration** (as in Eureka, where services register and send heartbeats) or through **platform-managed registration** (as in Kubernetes, where the orchestrator updates the registry automatically). Health checks and heartbeats keep the registry in sync with actual running instances.

#### what is circuit breaker 

A circuit breaker is a resilience pattern that stops sending requests to a failing service after repeated errors. It trips open, fails fast, and later tests the service again. In microservices, it prevents cascading failures and allows fallbacks, often implemented with Resilience4j or Hystrix.

#### what is the design pattern in microservice 

In microservices, we use design patterns like **API Gateway, Saga for transactions, Circuit Breaker for resilience, Database-per-service for independence, and Sidecar for cross-cutting concerns**. These patterns solve common distributed system challenges like communication, fault tolerance, and data consistency.

#### How do you implement security in your microservices? 

I secure microservices with OAuth2 at the gateway, mTLS and zero-trust between services, claim-based authorization inside each service, strong secrets/data protection, and comprehensive observability and runtime hardening—favoring short-lived identities, least privilege, and deny-by-default policies.

#### Which pattern is commonly used for implementing API gateways in microservices architecture? 

The most common pattern for implementing API gateways in microservices is the **API Gateway pattern**, often combined with Aggregator or Backend-for-Frontend variations. It provides a single entry point for clients, handles routing, aggregation, and cross-cutting concerns like auth, rate limiting, and monitoring.

#### what do you do when one microservice is down 

Detect fast, isolate with circuit breakers/timeouts, degrade gracefully with fallbacks/queues, auto-heal or roll back, then fix and learn

#### what is API gateway in microservice? 

An API gateway provides a centralized entry point for managing interactions between clients and application services. It acts as a reverse proxy and routes clients requests to the appropriate services. It can also perform various cross-cutting tasks such as authentication, SSL termination, mutual TLS, and rate limiting.

#### what is service registry? 

A Service Registry is a central directory where microservices register themselves and discover others. It keeps track of instances, health status, and allows dynamic discovery and load balancing — examples include Eureka, Consul, and Kubernetes’ built-in registry.

#### what is the difference between cookie and session?

A cookie stores small pieces of data on the client side, while a session stores user data on the server side. Cookies are lightweight but less secure, sessions are secure but require server resources. In practice, sessions are often tracked using a cookie that carries the session ID.

# Contractor八股

# Java

### OOP

- Show
    
    **Encapsulation封装**: Hiding internal data (getter/setters), makes code more maintainable
    **Inheritance继承**: subclass can extends superclass to acquire methods/fields, good for code reuse
    **Polymorphism多态**: Overloading and overriding, write loose coupling code
    **Abstraction抽象**: Interface and abstract class, hide complexity and only expose essential features.
    

### Overriding Vs Overloading

- Show
    
    **Overriding(Runtime Polymorphism运行时多态)**: a subclass provides a different implementation of a method of its superclass, they must have the **same name, return type, and parameters**
    
    **Overloading(Compile-time Polymorphism编译时多态)**: Overloading occurs when two or more methods in the same class have the **same name but different parameters**.
    

### Access Modifiers

- Show
    
    **`Private`**: variables, methods declared as private can only be accessed within the **same class**
    **`Default`**: Members can be accessed by any class within the **same package.**
    **`Protected`**: Members can be accessed within the **same package** and by **subclasses**
    **`Public`** : Members can be accessed from any class
    

### Interface VS abstract class

- Show
    
    **Interface接口** and **Abstract class抽象类** are used to achieve abstraction
    1. Abstract class can have **constructors**, but interface cannot
    2. A class can only extend one abstract class, but can implement multiple interfaces
    3. All methods in interface is `public`, but abstract class can have others
    4. All fields in interface is `static final`, but abstract class can have others
    
    **Common Interfaces**: `List`, `Set`, `Comparable`, `Runnable`
    
    **Common Abstract class**: `InputStream`, `OutputStream`
    

### Exception and Error

- Show
    
    **`Error`** and **`Exception`** both are subclasses of **`Throwable`** 
    
    **Error** is unrecoverable, severe failure in JVM, like `OutOfMemoryError` , `StackOverflowError`
    **Exception** caused by the application itself, and an application can catch them
    
    1. ***Checked Exception:*** Checked at compile-time, force the programmer to handle them, like `IOException` ,`SQLException`
    2. ***Unchecked Exception***: Not checked at compile-time, do not need programer to handle them, like `NullPointerException` ,`ArrayIndexOutOfBoundsException`
    

### Throw VS Throws

- Show
    
    **`throw`** is a keyword used to explicitly throw an exception from any method or static block.
    
    **`throws`**: The **`throws`** keyword is used in the signature of method to indicate that this method might throw one of the listed type exceptions. The caller to these methods has to handle the exception using a **`try-catch`** block or **`throws`** it further
    

### Final Keywords

- Show
    
    **Final Variables**: a **`final`** variable cannot be changed
    **Final Methods**: a **`final`** method cannot be override
    **Final Classes**: a **`final`** class cannot be extended
    

### Static Keywords

- Show
    
    **Static Variable**: A **`static`** variable is belongs to the class rather than any instance of the class. There is only one copy of a **`static`** field per class.
    
    **Static Method**: A **`static`** method is a method that belongs to the class rather than any instance of the class. You can call a **`static`** method without creating an instance of the class.
    
    **Static (Inner) Class**: A  **`static`** inner class can be accessed without having to instantiate the outer class.
    

### What is Optional Class

- Show
    
    The **`Optional`** class was introduced in Java 8 to help developers deal with **`null`** values and avoid **`NullPointerExceptions`**. **`Optional`** is a container object that may or may not contain a non-null value.
    
    **Some common methods:**
    `Optional.of()`
    `Optional.ofNullable`
    `Optional.empty()`
    `Optional.isPresent()`
    `Optional.get()`
    `Optional.orElse()`
    `Optional.orElseGet()`
    `Optional.orElseThrow()`
    

### What is Stream API

- Show
    
    It allows developers to process complex data by chaining methods
    
    **Pros**:
    
    - **Immutable and Stateless**: Stream’s element cannot be changed, each operation create a new stream.
    - **Lazy Evaluation**: Intermediate operations are not executed until terminal operation is invoked.
    
    **Some Intermediate Operations**:
    `filter()`
    `map()`
    `flatMap()`
    `sorted()`
    **Some** **Terminal Operations**:
    `collect()`
    `forEach()`
    `reduce()`
    `min()`
    `max()`
    

### JVM Memory Model

- Show
    - **Stack:** per thread; Local variables, method return address
    - **Heap**: per JVM; Objects; *Minor GC, Major GC*
    - **Method Area:** class information, static variables. *Permanent GC*
    - **Native Method Stack**
    - **Program Counter**: JVM Instruction Address
    

### Singleton单例模式

- Show
    
    **Eager懒汉**:
    
    ```java
    **//Eager**
    public class Singleton {
        **//1. Private Constructor**
        private Singleton() {}
      **//2. Private Static instance**
        private static Singleton instance = new Singleton(); 
      **//3. Public static getInstance method**
        public static getInstance() {
            return instance;
        } 
    }
    ```
    
    **Lazy饿汉(Double-Checked Locking)**
    
    ```java
    public class SingletonLazy2 {
        private SingletonLazy2() {}
    
        **//volatile防止指令重排序。**
        private **volatile** static SingletonLazy2 instance;
    
        public static SingletonLazy2 getInstance() {
            if (instance == null) { **//improve effciency, not actually get the lock**
                synchronized (SingletonLazy2.class) {
                    if (instance == null) { **//check is null again**
                        instance = new SingletonLazy2();
                    }
                }
            }
    
            return instance;
        }
    }
    
    ```
    

---

# Concurrency

### How to create a thread?

- Show
    1. Extends **`Thread`** Class and override its **`run()`** method.
    2. Implements **`Runnable`** interface and overrides its **`run`** method
    3. Implements **`Callable`** interface and overrides its **`call`** method
    4. Use ExecutorService

### Give me some common executor service

- Show
    
    ExecutorService is a thread pool api, it can be used to process asynchronous tasks.
    **`SingleThreadExecutor`**: Only uses a single worker thread
    **`FixedThreadPool`**: This ExecutorService maintains a fixed number of threads.
    **`CachedThreadPool`**: This ExecutorService creates new threads as needed for new tasks.
    

### `Synchronized` and `Volatile`

- Show
    
    **`synchronized`**: Guarantees **atomicity.** This keyword control access to a **critical section**, only one thread can access the critical section at a time, which prevents **race condition.**
    
    **`volatile`**: This keyword guarantees **visibility** of changes to variables across threads. 
    

### `t.start()` VS `t.run()`

- Show
    - **`start()`**: start the execution of a new thread. After calling **`t.start()`**, the thread goes into the runnable state, and the thread scheduler picks it up for execution based on thread priorities and other factors.
    - **`t.run()`**: The **`run()`** method contains the code that constitutes the new thread's task
    

### `t.sleep()` VS `t.wait()`

- Show
    
    `sleep()`: let the thread to sleep for a time. Lock is not released 对象是线程
    `wait()`: let the thread give up the lock and go sleep indefinitely until other thread acquired the same lock called `notify()` 对象是锁
    

### How do threads communicate with each other?

- Show
    1.  **`synchronized`** for locking(only 1 thread can enter), **`volatile`** for visibility
    2.  **`wait()`**,**`notify()`**, **`notifyAll()`** in Object class: 
        They must be used in `sychronized`
        `wait()`:suspend the current thread
        `notify`:wakeup one of waited threads
    3. **`java.util.concurrent.locks`**, such as `ReentrantLock`, `ReenrantReadWriteLock`
    4. **`CountDownLatch`**, **`CyclicBarrier` , `Semaphore`**
    5. **Blocking queue**, such as `LinkedBlockingQueue`, `ArrayBlockingQueue`, `CopyOnWriteArrayList`

### Tell me some concurrent collections

- Show
    - Map: `ConcurrentHashMap`
    - List: `CopyOnWriteArrayList`
    - Set: `CopyOnWriteArraySet`
    - Queue: `LinkedBlockingQueue`, `ArrayBlockingQueue`

### What is the CompletableFuture?

- Show
    
    **`CompletableFuture`** is an implementation and enhancement of the Future interface for **asynchronous** programming
    
    **Non-blocking**: Unlike the `Future` ’s `get()` method, you can use `thenApply()` , `thenAccept()`, `thenRun()` callbacks.
    
    **Chain Multiple Futures**: We can chain `CompletableFuture` in a pipeline use `thenApply()`,`thenCompose()`, `thenCombine()`, `allOf()`, `anyOf()`
    
    **Exception Handling**: We can use `exceptionally()` to handle exceptions
    

### HashMap implementation?

- Show
    
    Each **bucket** has a unique index and can store one or more key-value pairs (entries). The index of the bucket is calculated by calling the **`hashCode()`** method
    
    1. **LinkedList (HashCode Chain):** Before Java 8, in case of hash collision, key-value pairs with the same hashcode were stored in a linked list structure. — O(n)
    
    2. **Balanced Tree (Red-Black Tree):** From Java 8 onwards, if the number of items in a bucket exceeds a certain threshold, the linked list is transformed into a balanced tree — O(log(n))
    

---

# Spring Boot

### Maven Lifecycle?

- Show
    
    The build lifecycle is an ordered sequence of phases
    
    - **validate**: Validates that the project is correct and all necessary information is available.
    - **compile**: Compiles the source code of the project
    - **test**: Tests the compiled source code using a suitable unit testing framework.
    - **package**: Takes the compiled code and packages it in its distributable format, like a **`JAR`**.
    - **verify**: Runs any checks to verify the package is valid and meets quality criteria.
    - **install**: Installs the package into the local repository, for use as a dependency in other projects locally.
    - **deploy**:  Done in an integration or release environment, this copies the final package to the remote repository for sharing with other developers and projects.

### Maven **package VS Maven** **install**?

- Show
    
    The **`package`** phase takes the compiled code and packages it into a distributable format such as JAR, WAR, or EAR files
    
    The **`install`** phase does everything the **`package`** phase does and then it takes the packaged code and installs it into your local Maven repository.
    

### Bean Scope

- Show
    
    Scope define the lifecycle and visibility of bean
    
    - **`@Scope(”singleton”)`** : Default Scope, Only one bean instance per Spring IoC container
    - **`@Scope("prototype")`** : New instance each time a bean is requested
    - **`@RequestScope`** : New instance for each HTTP request
    - **`@SessionScope`**: New instance each HTTP session
    - **`@ApplicationScope`**: Single instance in entire ServletContext

### What is IoC and DI?

- Show
    
    **Inversion of Control 依赖反转** is a design principle, it inverts the control of dependencies to the container. And the container is responsible for creating and managing the objects.
    
    **Dependency injection 依赖注入** is an **implementation** of **Inversion of Control**, it injects the dependencies from the IoC container to the class
    

### What are 3 Types of DI?

- Show
    - **Constructor Injection**: （Dependencies are passed via constructor）[Recommended]
        - ✅ Immutable objects
        - ✅ Best for mandatory dependencies
        - ✅ Works well with final fields
        
        ```java
        @Component
        class ServiceA {
            private final ServiceB serviceB;
        
            @Autowired  // Constructor Injection
            public ServiceA(ServiceB serviceB) {
                this.serviceB = serviceB;
            }
        }
        ```
        
    - **Setter Injection**: （Dependencies are injected via setter methods）
        - ✅ Allows optional dependencies
        - ✅ Solves circular dependency issues
        
        ```java
        @Component
        class ServiceA {
            private ServiceB serviceB;
        
            @Autowired  // Setter Injection
            public void setServiceB(ServiceB serviceB) {
                this.serviceB = serviceB;
            }
        }
        ```
        
    - **Field Injection**:  (Dependencies are injected directly into fields) [Not Recommended]
        - ✅ Shorter code
        - ✅ Works well for simple cases
        - ❌ Hard to test
        
        ```java
        @Component
        class ServiceA {
            @Autowired
            private ServiceB serviceB; // Field Injection
        }
        ```
        

### What is Circular Dependency循环依赖?

- Show
    
    **Concepts**
    
    A的创建依赖B，B的创建依赖A，死循环
    
    ```java
    @Component
    class A {
        private final B b;
    
        @Autowired
        public A(B b) {
            this.b = b;
        }
    }
    
    @Component
    class B {
        private final A a;
    
        @Autowired
        public B(A a) {
            this.a = a;
        }
    }
    ```
    
    **Solution**：
    
    1. **Use @Lazy Annotation**  (delay the creation of B until it’s actually needed.)
        
        ```java
        @Component
        class A {
            private final B b;
        
            @Autowired
            public A(@Lazy B b) {
                this.b = b;
            }
        }
        ```
        
    2. **Use Setter Injection**
        
        ```java
        @Component
        class A {
            private B b;
        
            @Autowired
            public void setB(B b) {
                this.b = b;
            }
        }
        
        @Component
        class B {
            private A a;
        
            @Autowired
            public void setA(A a) {
                this.a = a;
            }
        }
        ```
        

### `@Autowired` vs `@Inject` vs `@Bean` vs `@Resource`

- Show
    
    - XML configuration
    - **`@Autowired`**: automatic dependency injection from IoC Container, *injected by type then by name*
    - **`@Bean`** and **`@Configuration`**:  method level annotation, 3rd party injection
    - **`@Inject`**: not part of spring framework, *injected by type*
    - **`@Resource`**: *injected by name*
    

### `@Configuration` and `@Bean`

- Show
    
    The **`@Configuration`** annotation in Spring is a **class-level** annotation indicating that the class can be used by the Spring IoC container as a source of bean definitions.
    
    The **`@Bean`** annotation is a **method-level** annotation that tells Spring that a method annotated with **`@Bean`** will return an object that should be registered as a bean
    

### `@Lazy`

- Show
    
    Define a bean should be lazily initialized. 
    
    Bean will not be initialized until it is first requested.
    

### **`@RequestParam`, `@PathVariable`, `@RequestBody`**

- Show
    
    - **`@RequestParam`**: used to extract query parameter from the URL after ?
    - **`@PathVariable`**: used to extract values from URL itself, it’s part of URL,  not a query parameter.
    - **`@RequestBody`**: used to extract the request body, used in POST and PUT
    

### `@Controller` VS `@RestController`

- Show
    
    **`@RestController`** is a special version of the **`@Controller`** annotation. 
    
    It includes the **`@Controller`** and **`@ResponseBody`
    
    `@Controller`** returns ModelAndView
    **`@RestController`** returns ResponseEntity
    

### **`@Compnent` vs `@Service` vs `@Controller` vs `@Repository`**

- Show
    
    They are used for auto bean detection. 
    
    `@Component` is a generic bean annotation, technically there is no difference between `@Component` and `@Service`,`@Controller`. The difference between these annotations is mostly **semantic**,
    

### `@SpringBootApplication`?

- Show
    
    **`@SpringBootApplication`** includes:
    - `@Configuration` : Indicates this class can be used as a source of bean definitions.
    - `@EnableAutoConfiguration`: Tells Spring Boot to automatically configure any beans that it thinks you might need.
    - `@ComponentScan`: Tells Spring to look for beans in the current package and sub packages
    

### How to handle exceptions?

- Show
    
    **`@ExceptionHandler` Method Level:** Handle the specific exceptions and sending the custom responses to the client
    
    **`ControllerAdvice` Class Level:** allows to handle exceptions globally across the whole application
    

### What is AOP 面向切面编程?

- Show
    
    AOP is **Aspect Oriented Programming**, AOP provides a way to separate *cross-cutting concerns* from the core business logic, resulting in cleaner and more maintainable code. Such as Logging, Transaction management, Authentication and Authorization.
    Aspect: module of code for a cross-cutting concern
        `@Aspect`
    Advice: the action taken by an aspect at a particular join point
        `@Around`
        `@Before`
        `@After`
    Join Point: the point in the execution of the application
    
    ```java
    @Aspect
    public class LoggingAspect {
        // This is a pointcut expression
        @Pointcut("execution(* com.example.service.*.*(..))")
        private void selectAllServiceMethods() {}
    
        // This is an advice that uses the above pointcut
        @Before("selectAllServiceMethods()")
        public void logBefore(JoinPoint joinPoint) {
            // ... logging logic
        }
    }
    ```
    
    In the example, the **`selectAllServiceMethods()`** method defines a pointcut that matches the execution of any method within the **`com.example.service`** package. The **`logBefore()`** method defines an advice that will be executed before any method matched by that pointcut, using the **`@Before`** annotation. The **`JoinPoint`** argument can be used to get details about the method being advised, such as its name or its arguments.
    

### What is MVC (**Model–View–Controller**)?

- Show
    
    Spring MVC is a framework follow MVC design pattern
    - **Model**: POJOs. Data and business logic of the application.
    - **View**: JSP, Thymeleaf. Responsible for rendering the user interface
    - **Controller**: **`@Controller`** . Acts as an interface between Model and View
    

### What is Dispatcher Servlet (Front Controller)?

- Show
    
    - Tomcat send the request to **`DispatcherServlet`**. The **`DispatcherServlet`** is the front controller that intercepts all requests.
    - The `DispatcherServlet` uses **`HandlerMapping`** to determine which controller should process the request, then forward request to it.
    - `Controller` process the request and return a **`ModelAndView`** object back to DispatcherServlet
    - Then the `DispatcherServlet` uses **`ViewResolver`** to determine which view to be used with the view name
    - Then the selected **`View`**(JSP, Thymeleaf) uses model data to generate the output, return to the `DispatcherServlet`.
    - Finally, `DispatcherServlet` sends back response to the client
    

### Benefits of Spring Boot?

- Show
    1. **Auto-Configuration**
    2. **Starters: Simplified Dependency Management:** Spring Boot comes with a number of pre-defined starters:
    3.  **Embedded Server**
    

### Common Starters?

- Show
    
    **`spring-boot-starter-web`:** It includes dependencies such as Tomcat and Jackson.
    
    **`spring-boot-starter-data-jpa`:** Hibernate
    
    **`spring-boot-starter-test`:** JUnit, Mockito
    
    **`spring-boot-starter-actuator`:** metrics, health checks, and environment information.
    
    **`spring-boot-starter-validation`:** used for Java Bean Validation with Hibernate Validator.
    

---

# Kafka
### what is Kafka

---

**English Answer:**
**Apache Kafka** is a **distributed event streaming platform** used to build real-time data pipelines and streaming applications. It was originally developed at **LinkedIn** and later open-sourced under the **Apache Software Foundation**.

Key features:

1. **Publish–Subscribe Model:** Producers publish messages to topics, and consumers subscribe to those topics to receive data.
2. **High Throughput and Scalability:** Kafka can handle millions of messages per second and scale horizontally by adding brokers.
3. **Fault Tolerance:** Kafka replicates data across multiple brokers to ensure data durability and high availability.
4. **Persistence:** Messages are stored on disk and can be retained for a configurable time period.
5. **Stream Processing:** Kafka integrates with tools like **Kafka Streams** or **ksqlDB** to process data in real time.

Common use cases:

* Real-time analytics (e.g., monitoring and fraud detection)
* Log aggregation
* Event-driven microservices
* Data pipeline between systems (e.g., connecting databases and analytics tools)

---

**中文翻译：**
**Apache Kafka** 是一个**分布式事件流平台（Distributed Event Streaming Platform）**，
用于构建**实时数据管道（real-time data pipelines）**和**流式应用（streaming applications）**。
它最初由 **LinkedIn** 开发，后来捐赠给 **Apache 软件基金会**。

主要特性：

1. **发布-订阅模型（Publish–Subscribe Model）：** Producer 向 topic 发布消息，Consumer 订阅并消费这些消息。
2. **高吞吐与可扩展性（High Throughput & Scalability）：** 可处理每秒上百万条消息，支持水平扩展。
3. **容错与高可用（Fault Tolerance）：** 通过多副本机制保证数据持久性与可靠性。
4. **持久化存储（Persistence）：** 消息持久化到磁盘，可根据配置保留一定时间。
5. **实时流处理（Stream Processing）：** 可与 **Kafka Streams** 或 **ksqlDB** 集成，实现实时计算。

常见应用场景：

* 实时分析（如监控、风控系统）
* 日志聚合
* 事件驱动的微服务架构
* 系统间数据管道（如数据库与数据仓库的同步）

---

是否希望我接下来帮你准备 **Kafka 面试常见问答清单**（例如：Kafka 架构、分区机制、ISR、Exactly Once 语义等）？这些在 Fullstack 面试中非常高频。


### Kafka Basic Concepts

- Show
    - **Broker**: Brokers =Server. Each broker may be allocated to zero or more partitions of a topic.
    - **Topic**: A group of messages associated with a specific category
    - **Partition:** For **fault-tolerance**, topics are divided into partitions. The messages will have an individual sequence id(*Partition offset*). Also, Multiple consumers can read from multiple partitions at the same time - **Better performance**
    - **Replication(ISR)**: Replicas are also known as “backups” of a partition. They are not at all used for reading or writing data. Preventing data loss is the job of replicas.
    - **Consumer**: Readers of the messages. consumers consume the messages by extracting the data from brokers
    - **Consumer Group**: A consumer group is a group consumers that work together to consume and process messages from one or more Kafka topics.
        - ***Scalability***: ***parallelize consumption from a topic***
        - ***Fault Tolerance:*** If a consumer fails , Kafka will redistribute that consumer's partitions to the other consumers in the group.
    - **Producer**: Producers send messages to brokers or partitions
    - **Leader**: It serves as the primary replica for the partition and maintains the in-sync replica (ISR) list
    - **Follower:** The Followers replicate the data from the Leader and stay in sync by continuously fetching data from the Leader. They act as backups for the Leader and step in if the Leader fails.

---

# Databases

### What is Hibernate and JPA?

- Show
    
    **Hibernate** is a Object-Relational-Mapping(ORM) framework. It maps data objects with the relational database.
    **Java Persistence API (JPA)** is a Java specification that provides a standardized way to manage relational data in Java applications.
    

### Hibernate cache?

- Show
    
    1st level → 2nd level → database
    - **First-level Cache (session level)** : Enable by **default**,  it associates with `Sessoin` object,  It cannot be shared between multiple sessions. If the same object is retrieved again in the same session, it's returned from the cache instead of hitting the database again
    
    - **Second-level Cache(application level)**: it associates with `SessionFactory` object. It can be shared between multiple sessions. Which means its scope is application-wide, not just tied to a single user's session.
    

### What is transactions(ACID)

- Show
    
    A **transaction** is a single unit of work that is performed against a database.
    - *Atomicity*
    - *Consistency*
    - *Isolation*
    - *Durability*
    

---

# Networks

### Common HTTP status code

- Show
    - **`200`** OK: successful request
    - **`201`** Created: new resource has been created
    - **`302`** Redirect: requested resource has been temporarily moved to a different location
    - **`400`** Bad Request: server cannot process the request due to malformed syntax or other client-side errors.
    - **`404`** Not Found:  the requested resource could not be found on the server.
    - **`500`** Internal Server Error: error occurred on the server

### HTTP Methods

- Show
    - **`GET`**: get resource
    - **`POST`**: submit data
    - **`PUT`**: update data entirely
    - **`PATCH`**: update data partially
    - **`DELETE`**: remove resource
    - **`HEAD`**: get only response header
    - **`OPTIONS`**: get communication options
    - **`TRACE`**: echoes back the received request to the client.

### SOAP vs. REST vs. GraphQL

- Show
    
    **Representation State Transfer(REST)**: is an architectural style, not a protocol. It uses HTTP methods like GET, POST for communications. It is a **lightweight stateless** architecture
    
    **Simple Object Access Protocol(SOAP)**: is a protocol that uses XML for message exchange over HTTP. SOAP is a **heavier stateful** protocol, but provide better security.
    
    **GraphQL**: Is query language for APIs. It has only one single endpoint `/graphql`, and it is **more efficient**, GraphQL you send a single query to the server that includes the specific data requirements, and get exactly what you asked for in a single response. Often used in **mobile applications**
    

### How to call api in java?

- Show
    
    The **`RestTemplate`** is a synchronous HTTP client provided by Spring
    
    ```java
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080/api/other-service/endpoint";
    MyResponse response = restTemplate.getForObject(url, MyResponse.class);
    ```
    

---

# Docker

### Docker container vs. Docker image vs. Docker file

- Show
    - **Docker file文件**: It's a text file that contains a set of instructions used to create a Docker image. It's essentially the blueprint for building an image.
    - **Docker image镜像**: It's a lightweight, standalone, executable package that includes everything needed to run a piece of software, including the code, runtime, system tools, system libraries, and settings. Docker images are composed of multiple layers. Each layer represents a specific set of changes to the underlying filesystem.
        
        create image via docker file: `docker build -t my-node-app:1.0 .`
        
    - **Docker container容器**: It's a running instance of a Docker image. You can think of a Docker container as an isolated environment in which an application runs.
        
        start container from image: `docker run -p 8080:8080 my-node-app:1.0`
        

### Common docker commands:

- Show
    1. **`docker run`**: Used to create and run a new container from a Docker image. It pulls the image from a registry if not available locally and starts the container.
    2. **`docker build`**: Builds a Docker image from a `Dockerfile`. It reads the instructions in the `Dockerfile` and executes them to create the image.
    3. **`docker start`**: Starts a stopped container. It resumes the execution of a previously stopped container.
    4. **`docker stop`**: Stops a running container. It sends a SIGTERM signal to the container, allowing it to gracefully shut down.
    5. **`docker exec -it`** : Runs a command inside a running container. It allows you to execute commands or run scripts within a container.
    6. **`docker images`**: Lists all the Docker images available on your local machine.
    7. **`docker ps`**: Shows the list of running containers.

---

# Test

### What's the test framework in your team?

- Show
    
    In our team, we primarily use JUnit and Mockito as our test frameworks.
    
    **JUnit** offers various annotations, such as **`@Test`**, **`@Before`**, and **`@After`**, which allow us to set up preconditions and clean up after each test. **Mockito**, on the other hand, is a popular mocking framework used for creating mock objects in unit tests.
    

### `@Spy`, `@Mock`, `@**InjectMocks**`

- Show
    
    **`@Mock`**: This annotation is part of the Mockito framework and is used to create a mock object of a class or interface.
    
    **`@Spy`**: This annotation is also part of the Mockito framework and is used to create a partial mock object. It is similar to **`@**Mock`, but it retains the original behavior of the object for non-mocked methods.
    
    **`@InjectMocks`**: This annotation is used in combination with **`@**Mock` or **`@**Spy` to inject the mocked or spied dependencies into the object being tested. When **`@**InjectMocks` is used, Mockito tries to automatically inject the mock objects marked with **`@**Mock` or **`@**Spy` into the target object. It simplifies the process of setting up the dependencies for the object under test.
    

### Unit test code example

- Show
    
    ```java
    @ExtendWith(MockitoExtension.class)
    public class PostServiceImplTest {
        @Mock
      private PostRepository postRepositoryMock;
    
        @Spy
      private ModelMapper modelMapper;
    
        @InjectMocks
      private PostServiceImpl postService;
    
        @BeforeEach
      void setup() {
          ModelMapper modelMapper = new ModelMapper();
          this.postDTO = modelMapper.map(this.post, PostDTO.class);
      }
    
        @Test
      public void testCreatePost() {
          Mockito.when(postRepositoryMock.save(ArgumentMatchers.any(Post.class)))
                  .thenReturn(post);
          PostDTO savedPost = postService.createPost(postDTO);
          Assertions.assertNotNull(savedPost);
          Assertions.assertEquals(postDTO.getTitle(), savedPost.getTitle());
          Assertions.assertEquals(postDTO.getDescription(), savedPost.getDescription());
          Assertions.assertEquals(postDTO.getContent(), savedPost.getContent());
      }
    ```
    

---
# Spring Boot 八股文整理

## 1. What is AOP

AOP is Aspect Oriented Programming, AOP provides a way to separate cross-cutting concerns from the core business logic, resulting in cleaner and more maintainable code. Such as Logging, Transaction management, Authentication and Authorization.

Aspect: module of code for a cross-cutting concern

    @Aspect
    
Advice: the action taken by an aspect at a particular join point

    @Around
    @Before
    @After
    
Join Point: the point in the execution of the application

## 2. What does @SpringBootApplication mean?

@SpringBootApplication includes:
- @Configuration 
- @EnableAutoConfiguration: This annotation tells Spring Boot to automatically configure any beans that it thinks you might need.
- @ComponentScan: This annotation tells Spring to look for other components, configurations, and services in the current package and sub packages

## 3. When there is circular dependency, use which type of Injection?

When dealing with circular dependencies in Spring, setter injection can be used

The reason is, during the creation of the beans, Spring first instantiates the bean and then uses setter methods to inject dependencies. This two-step process allows Spring to resolve circular dependencies.

## 4. @Controller VS @RestController?

@RestController is a specialized version of the @Controller annotation. It includes the @Controller and @ResponseBody

@Controller returns ModelAndView
@RestController returns ResponseEntity

## 5. What is the difference between @compnent, @service, @controller

They are used for auto bean detection.

@Component is a generic bean annotation, technically there is no difference between @Component and @Service,@Controller. The difference between these annotations is mostly semantic,

## 6. What is the Hibernate?

Hibernate is a Object-Relational-Mapping(ORM) framework. It maps data objects with the relational database

## 7. How do you create a rest controller?

1. @RestController
2. @RequestMapping
3. Dependency injection of service bean @Autowired
4. @GetMapping, @PostMapping...
5. @PathVariable, @RequestParam, @RequestBody

## 8. What are the differences between @RequestParam and @PathVariable?

- @RequestParam: used to extract query parameter from the URL after ?
- @PathVariable: used to extract values from URL itself, it’s part of URL,  not a query parameter.
- @RequestBody: used to extract the request body, used in POST and PUT

## 9. How do you deal with the response get from REST api? / How to convert JSON -> Java Object?

1. Use RestTemplate to call the API and get ResponseEntity
2. Use Jackson ObjectMapper to convert it to your desired object: 

## 10. What is IoC

Inversion of Control is a design principle, it inverts the control of dependencies to the container. And the container is responsible for creating and managing the objects.

## 11. What is transactions

A transaction is a single unit of work that is performed against a database.

ACID:
- Atomicity
- Consistency
- Isolation
- Durability

## 12. Could you give me the example for Singleton bean scope

Singleton bean scope is the default bean scope in Spring. For example, when you define @Component @Controller @Service @Repository

## 13. What is DI

Dependency injection is a implementation of Inversion of Control, it injects the dependencies from the IoC container

## 14. Type of dependency injection?

- Constructor Injection: injected objects are immutable; Easy to test (recommend)
- Setter Injection: when the dependency is optional
- Field Injection: hard for testing

## 15. How do you implement transaction?

1. @EnableTransactionManagement
2. @Transactional

## 16. Bean life-cycle

- Bean instantiated by container
- Dependencies Injected
- Post initialization code @PostConstruct
- Bean methods are used
- Pre destroy code @PreDestroy

## 17. Hibernate cache? First level second level?

1st level → 2nd level → database

- First-level Cache (session level) : it associates with Sessoin object, enabled by defaults. It cannot be shared between multiple sessions. If the same object is retrieved again in the same session, it's returned from the cache instead of hitting the database again

- Second-level Cache(application level): it associates with SessionFactory object. It can be shared between multiple sessions. Which means its scope is application-wide, not just tied to a single user's session.

## 18. Bean Scope

- Singleton: Only one bean instance per Spring IoC container (Default)
- Prototype: New instance each time a bean is requested
- Request: New instance each HTTP request
- Session: New instance each Http session
- Application：New instance each ServletContext
- Web socket: New instance each WebSocket

## 19. What is Spring MVC

Spring MVC is a framework follow MVC design pattern

- Model: POJOs. Data and business logic of the application.
- View: JSP, Thymeleaf. Responsible for rendering the user interface
- Controller: @Controller . Acts as an interface between Model and View

## 20. @Autowired vs @Inject vs @Bean vs @Resource

- XML configuration
- @Autowired: automatic dependency injection, injected by type
- @Bean and @Configuration:  method level annotation, 3rd party injection
- @Inject: not part of spring framework, injected by type
- @Resource: injected by name

## 21. What would you do if an API response time is 500ms

1. Caching
2. Aysnchronous Processing
3. Load Balancing

## 22. Why do you use Spring Boot? / Benefits of Spring Boot

1. Auto-Configuration
2. Simplified Dependency Management: Spring Boot comes with a number of pre-defined starter projects that simplify dependency management.
3. Embedded Server
4. Ease of Integration: Spring Boot can easily be integrated with various Spring-family frameworks like Spring JDBC, Spring ORM, Spring Data, Spring Security etc.

## 23. How to handle exceptions

@ExceptionHandler Annotation: This is used to handle the specific exceptions and sending the custom responses to the client

ControllerAdvice Annotation: @ControllerAdvice is a specialization of @Component annotation which allows to handle exceptions across the whole application

## 24. What is DispatcherServlet, answer the MVC flow

- Tomcat send the request to DispatcherServlet. The DispatcherServlet is the front controller that intercepts all requests.

- The DispatcherServlet uses HandlerMapping to determine which controller should process the request, then forward request to it.

- Controller process the request and return a ModelAndView object back to DispatcherServlet

- Then the DispatcherServlet uses ViewResolver to determine which view to be used with the view name

- Then the selected View(JSP, Thymeleaf) uses model data to generate the output, return to the DispatcherServlet.

- Finally, DispatcherServlet sends back response to the client

## 25. What is @Configuration

The @Configuration annotation in Spring is a class-level annotation indicating that the class can be used by the Spring IoC container as a source of bean definitions.

The @Bean annotation is a method-level annotation that tells Spring that a method annotated with @Bean will return an object that should be registered as a bean


# Java 八股文整理

## [OOP] What is OOP?

Encapsulation封装: Hiding internal data (getter/setters), makes code more maintainable
Inheritance继承: subclass can extends superclass to acquire methods/fields, good for code reuse
Polymorphism多态: Overloading and Overriding, write loose coupling code
Abstraction抽象: Interface and Abstract class, hide complexity and only expose essential features.

## [OOP] What is polymorphism?

Runtime Polymorphism(dynamic) - Method Overriding
Compile-time Polymorphism(static) - Method Overloading

## [OOP] Overriding Vs Overloading

Overriding(Runtime Polymorphism): a subclass provides a different implementation of a method of its superclass, they must have the same name, return type, and parameters

Overloading(Compile-time Polymorphism): Overloading occurs when two or more methods in the same class have the same name but different parameters (Return type can be different ).

## [OOP] What are different access modifiers

Private: variables, methods declared as private can only be accessed within the same class
Default: Members can be accessed by any class within the same package.
Protected: Members can be accessed within the same package and by subclasses
Public : Members can be accessed from any class

## [OOP] What is Interface and what is abstract class? What are the differences between them?

Common point: Interface and Abstract class are used to achieve abstraction

1. Abstract class can have constructors, but interface cannot
2. A class can only extend one abstract class, but can implement multiple interfaces
3. All methods in interface is public, but abstract class can have others
4. All fields in interface is static final, but abstract class can have others

## [OOP] When to use abstract class and when to use interface?

Interface: Use it when
1. You want to specify the behavior of a class
2. When we want to write loosely coupled code: since a class can only extend one abstract class, but can implement multiple interfaces

Abstract class: Use it when
1.  Liskov Substitution Principle(里氏替换原则) can be achieved (objects of a superclass should be replaceable with objects of its subclasses without breaking the application)
2. You want to have some default methods / implementation



## [Java] What is final keyword?

Final Variables: a final variable cannot be changed
Final Methods: a final method cannot be override
Final Classes: a final class cannot be extended(inherited)

## [Java] What is static field, static method, static block and static inner class?

Static Variable: A static variable is belongs to the class rather than any instance of the class. There is only one copy of a static field per class.

Static Method: A static method is a method that belongs to the class rather than any instance of the class. You can call a static method without creating an instance of the class.

Static Block: Used to initialize static fields.

Static (Inner) Class: A  static inner class can be accessed without having to instantiate the outer class.

## [Java] What are Primitive data types in Java?

byte: 8 bit, [-2^7-1, 2^7]
short: 16 bit, [-2^15-1, 2^15]
int: 32 bit, [-2^31-1, 2^31]
long: 64 bit
float: 32 bit
double: 64 bit
boolean
char: 16 bit, [0, 65535]

## [Java] What is the differences between passing by value and passing by reference?

Java only has Passing by value
Passing by value: Primitive types are passed by value, the actual value is copied into a new variable

Passing by reference: Objects are passed by reference, the reference is copied, not the instance.

## [Java] Difference between Equals and ==

== : compares the references of objects
equals: compare the content of objects

## [Java] What is String Pool

String Pool（字符串常量池） is a special area in Heap stores all String literals, it helps save memory

String Immutability: Strings are immutable, so it can be referenced by multiple variables
new(): the new keyword are not part of the String Pool by default

## [Java] List some immutable objects in Java

String Integer Boolean Double LocalDate

## [Java] Difference between Comparable vs. Comparator

相同点：
Comparable and Comparator both are interfaces and can be used to sort collection elements.

不同点：
Comparable Interface: When a object implements Comparable interface and override compareTo method, we can sort the instance based a single field

Comparator Interface: We can implement the Comparator interface and override the compare method, we can sort instances based on multiple fields

## [Java] Difference between Deep copy vs. shallow copy

Shallow Copy: Java supports shallow copying of objects with the clone() method. Primitive types and references are copied, instances are not copied.

Deep Copy: instances are copied, Java do not support deep copy directly.

## [Java] StringBuilder and StringBuffer

StringBuilder: Not Synchronized / Not Thread-safe (线程不安全)，better performance
StringBuffer: Synchronized / Thread-safe (线程安全), lower performance

## [JVM] Memory management of Java 8 feature?

Young Generation (Minor GC)
Old Generation (Major GC)
Permanent Generation (In Non-heap memory, fixed-size memory stores static contents) ⇒ replaced by MetaSpace in Java 8(Auto increase the memory size)

## [JVM] What is Java Memory Model?

JVM memory model:
1. Stack Memory: Each JVM thread has a private JVM stack, which stores frames, which contains local variables, reference to the constant pool, method return address. Each method invocation corresponds to a frame.
2. Heap Memory: All JVM thread share the same Heap, all class instances store in here. Heap is divided into Young Generation and Old Generation (The Young Generation is where new objects are created. When this area fills up, a minor garbage collection occurs. Objects that survive multiple minor garbage collections in the Young Generation are moved to the Old Generation. A major garbage collection occurs when the Old Generation fills up.)
3. Method Area(Permanent Generation): This is a shared resource across all JVM threads. The method area stores class information, static variables.
4. Native Method Stack: This contains all the native methods used in the application. Native methods are typically written in other languages like C and C++
5. PC (Program Counter) Registers: Each JVM thread also has a program counter (PC) register. The PC register contains the address of the JVM instruction currently being executed by the thread.

## [JVM]  What is garbage collection (GC)?

GC identifies and frees memory that is no longer needed, preventing memory leaks

Mark-Sweep-Compact Algorithm（标记压缩清除）:
Mark: Find all objects that has the possibility of being used in future
Sweep: Free all unused objects
Compact: The garbage collector moves referenced objects together, reduce fragmentation rate


## [JVM] Do you know memory leak?

 Memory leaks happens when an object is no longer reachable, but not collected by GC

Static fields: Unused static object will remain in the memory for the lifetime unless it is set to null.
Collections: 
Inner class which implicitly reference the outer class: GC will not occur

Use Grafana, AWS CloudWatch to define metrics:
- Check memory usage
- GC status
- OutOfMemoryError

## [Collection] Difference between Vector and ArrayList

1. Synchronization: Vector is thread-safe, while ArrayList is not thread-safe.
2. Performance: Vector’s performance is slightly slower, because it is synchronized.

## [Collection] Difference between ArrayList and LinkedList

1. ArrayList is implemented by an array, while LinkedList is implemented by a doubly-linked list
2. Accessing elements in ArrayList is O(1), while adding/removing elements in LinkedList is O(1)
3. ArrayList is preferred when there are more get/search operations, while LinkedList is preferred when there are more insert/delete operations

## [Collection] Time complexity of HashMap

O(1) for get put remove containsKey

## [Collection] Time complexity of LinkedList

add() O(1)
get(int index) remove(int index) O(n)
getFirst() getLast() addFirst() addLast() removeFist() removeLast() O(1)

## [Collection] Time complexity of ArrayList

add()  remove() O(n)
get(int index) O(1)

## [Collection] Java HashMap implementation (hashcode chain vs red black tree)

HashMap is a data structure to stores key-value pairs and allows fast retrieval, insertion, and deletion.

Each bucket has a unique index and can store one or more key-value pairs (entries). The index of the bucket is calculated by calling the hashCode() method

In case of hash collision, key-value pairs with the same hashcode were stored in a linked list structure.


## [Collection] What are hashcode() and equals() / Why need to implement the hashcode() when implementing equals()?

equals(): The equals() method is used to determine the equality of two objects.
hashCode(): The hashCode() method returns an integer hash code that is used to calculate the bucket index

Reason:
Hashing retrieval is a two-step process:
    1. Find the right bucket (using hashCode())
    2. Search the bucket for the right element (using equals() )

1. If hashCode is not override, object with same content(equals() == true) will not hash to the same bucket.
2. If equals is not override, we cannot find the same object(key) in the bucket.

## [Collection] Why HashTable cannot contain null key/value

HashTable is synchronized. You need extra null-checking code to avoid nullPointerException
1. Reduce performance
2. Ambiguity. get() method returns null if the map contains no mapping for a key. If null values were allowed, a null return could be ambiguous

## [Collection] HashMap and TreeMap and HashTable

HashMap: Not thread-safe / Allow null keys & values
TreeMap: Not thread-safe / Keys are sorted / get, put, remove is O(log(n))
HashTable: Thread-safe / Not allow null keys & values

## [Collection] Difference between HashSet and TreeSet

TreeSet guarantees that elements of the set will be sorted in ascending order according to their natural ordering, or by a comparator provided at set creation time.

## [Collection] Difference between HashMap vs. LinkedHashMap

Unlike HashMap, LinkedHashMap maintains the insertion order. It maintains a LinkedList to track the order.

## [Collection] What happens if hash collision occurs?

If the bucket is empty, the key-value pair is stored in that bucket. If the bucket is not empty (which indicates a hash collision), a new entry is added to the end of the LinkedList/TreeNode in that bucket.

## [Collection] How does ConcurrentHashMap works?

ConcurrentHashMap is thread-safe. Unlike HashTable which lock the entire map, it only locks a portion of the map. This allows multiple threads to access the map concurrently.

In ConcurrentHashMap, the data is divided into segments, and each segment has a lock of its own.

## [Collection] In ConcurrentHashMap, What is the size of the segment?

The map was divided into a number of segments specified at construction time, with the default being 16.

## [Collection] When using HashMap in multi-threading, what will happen? How to avoid it?

Infinite Loop: In specific circumstances, concurrent updates could potentially cause the data structure of the HashMap to form a loop. This could lead to a thread entering an infinite loop when trying to access certain elements.

Use ConcurrentHashMap

## [Exception] Exception

Exceptions:
1. Checked Exceptions: Checked at compile time to confirm whether the exception is handled by the programmer or not. IOExceptions, SQLException  ⇒ Throws + Try Catch
2. Unchecked Exceptions: No checked at compile time. Extends from RuntimeException.  E.g. NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException

“If a client can reasonably be expected to recover from an exception, make it a checked exception. If a client cannot do anything to recover from the exception, make it an unchecked exception.”

Errors: Recovering from Error is not possible.OutOfMemoryError, StackOverFlowError


## [Exception] Difference between Error vs. Exception?

Error and Exception both are subclasses of Throwable 

Error is unrecoverable, severe failure in JVM, like OutOfMemoryError , StackOverflowError
Exception caused by the application itself, and an application can catch them

1. Checked Exception: Checked at compile-time, force the programmer to handle them, like IOException ,SQLException
2. Unchecked Exception: Not checked at compile-time, do not need programer to handle them, like NullPointerException ,ArrayIndexOutOfBoundsException

## [Exception] How to custom an Exception?

1. Create a Exception class extends Exception(checked) or RuntimeException(unchecked)
2. Create a Exception Handler using @ControllerAdvice @ExceptionHandler

## [Exception] How do you deal with exceptions in your Spring Boot project?

1. Use @ExceptionHandler to handle specific exceptions, and log the exceptions
2. Use @ControllerAdvice @ExceptionHandler to handle exceptions globally

## [Exception] Throw vs. Throws

throw: explicitly throw an exception from a method

throws: The throws keyword is used in the signature of method to indicate that this method might throw one of the listed type exceptions. The caller to these methods has to handle the exception using a try-catch block or throws it further

## [Exception] Give me one example of NullPointerException

Accessing the ArrayList without instantiate it.

## [Exception] How to avoid NullPointerException?

Use Optional in Java 8, it can help you handle situations where you might have an object that could be null 



## [Exception] What situation will cause OutOfMemoryError? / How to avoid OutOfMemoryError?

1. Memory Leaks
2. Large objects
3. Insufficient Heap Size

How to avoid:
1. Fix memory leaks
2. Avoid large objects, like arrays, use database instead
3. Increase Heap Size

## [Exception] OutOfMemory vs. StackOverflow error

OutOfMemoryError：Heap memory is full
StackOverFlowError: Program recurses too deeply and the call stack exceeds its limit

## [Exception] How do you deal with the error?

1. Check error in logs
2. Reproduce the error, set breakpoints
3. Debug
4. Run unit tests
5. Deploy the update

## [Java 8 Features] Give me some Java 8 new features, give an example of how you use them in your project

1. Lambda Expressions / Method Reference: They're used to create anonymous methods, reducing the amount of boilerplate code required
2. Streams API: The API supports many operations like filtering, mapping, or aggregating elements
3. Optional Class: helps to prevent NullPointerException
4. Default and Static Methods in Interfaces

## [Java 8 Features] What is Optional Class

The Optional class was introduced in Java 8 to help developers deal with null values and avoid NullPointerExceptions. Optional is a container object that may or may not contain a non-null value.

Optional.of()
Optional.ofNullable
Optional.empty()
Optional.isPresent()
Optional.get()
Optional.orElse()
Optional.orElseGet()
Optional.orElseThrow()

## [Java 8 Features] What is Stream API

It allows developers to process complex data by chaining methods

Immutable and Stateless: Stream’s element cannot be changed, each operation create a new stream.
Lazy Evaluation: Intermediate operations are not executed until terminal operation is invoked. 

## [Java 8 Features] Give me some Stream API Intermediate operation and terminal operation

Intermediate Operations:
filter()
map()
flatMap()
sorted()
limit()
distinct()
peek()
Terminal Operations:
collect()
forEach()
reduce()
min()
max()
anyMatch()
allMatch()
noneMatch()

## [Java 8 Features] What is the difference between collection and stream API?

1. Collections store data, while Stream computes data
2. Element in Collection is mutable, while Stream element is immutable
3. Collection’s action executes eagerly, Stream’s action executed lazily

## [Java 8 Features] What is Functional Interface

A functional interface in Java is an interface that contains exactly one abstract method. These interfaces are used as the basis for lambda expressions and method references

E.g.
- Runnable
- Callable
- Predicate
- Consumer
- Supplier

## [Java 8 Features] Different types of method reference

Reference to a static method Integer::parseInt
Reference to an instance method s::length
Reference to an arbitrary instance method 
numbers.stream().sorted((a,b) -> a.compareTo(b)) 
numbers.stream().sorted(Integer::compareTo)
Reference to constructor
List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
bikeBrands.stream().map(Bicycle::new).toArray(Bicycle[]::new);

## [Java 8 Features] How did you use lambda expression?

A lambda expression can replace the anonymous inner class

## [Java 8 Features] Default method vs. static method

default methods provide a default implementation that can be overridden by the classes that implement the interface
static methods provide a fixed implementation that's related to the interface itself and cannot be overridden.

## [Testing] In JUnit, how to write a test

1. Use Lifecycle methods for setting up and tearing down: @BeforeEach @AfterEach @BeforeAll @AfterAll
2. Use Assertion to check the method returns expected results assertEquals assertTrue assertNotNull
3. Ensure a method throws the expected exception. assertThrows

## [Testing] TestNG vs JUnit

TestNG provides a lot more flexibility and configuration options
TestNG supports parallel test execution

## [Testing] Difference between mocking vs stubbing

Stubbing: stub you have already written with predetermined behavior..

Mocking: mock is not setup in a predetermined way so you have code that does it in your test.

## [Testing] @Spy vs @Mock

The @Mock annotation is used to create a mock object, All method calls to the mock object are intercepted, and by default, they return default values.The behavior of the mock object can be customized using Mockito's when and then methods.

The @Spy annotation is used to create a spy of a real object. A spy is a partial mock

## [Others] SOAP VS REST VS GraphQL

Representation State Transfer(REST): is an architectural style, not a protocol. It uses HTTP methods like GET, POST for communications. It is a lightweight stateless architecture

Simple Object Access Protocol(SOAP): is a protocol that uses XML for message exchange over HTTP. SOAP is a heavier stateful protocol, but provide better security.

GraphQL: Is query language for APIs. It has only one single endpoint /graphql, and it is more efficient, GraphQL you send a single query to the server that includes the specific data requirements, and get exactly what you asked for in a single response. Often used in mobile applications

## [Others] Give me some Git command you used in the project

git add
git commit
git pull
git push
git branch
git merge [branch_name] merge the specified branch into the current branch.
git rebase [branch_name] move the current branch on top of the branch_name get a much cleaner linear project history, not merge commits

## [Design Pattern] Implement a singleton

Eager:
```java

public class Singleton {
    private Singleton() {}
    private static Singleton instance = new Singleton();
    public static getInstance() {
        return instance;
    } 
}

```


Lazy (double-check locking):
```java

        public class Singleton {
            // volatile ensures that multiple threads handle the instance variable correctly
            private static volatile Singleton instance = null;

            // Private constructor prevents instantiation from other classes
            private Singleton() {
                // Optionally, you can add additional initialization code here
            }

            public static Singleton getInstance() {
                if (instance == null) {
                    synchronized (Singleton.class) {
                        if (instance == null) {
                            instance = new Singleton();
                        }
                    }
                }
                return instance;
            }
        }
```


## [Design Pattern] What design patterns did you worked on before?

Singleton, Simple Factory Pattern, Builder Pattern(Stream API filter() map())

## [Design Pattern] Talk about factory design pattern

User use the factory to create different implementations of a class, instead of calling the constructor.

Pros:
Decoupling解耦: The client does not need to know which class to instantiate, and how to instantiate
Code Reuse代码复用: No need of repeating the object creation code

## [Design Pattern] Talk about observer design pattern

It allows Subject to automatically notify the Observers. Observers can subscribe to the subject and are automatically updated whenever the subject changes. It is often used in pub-sub situation

## [Multithread] What are Thread, Runnable, Callable, Future

Thread class:
    start():create a new thread
    run(): called on newly created thread.

Runnable Interface: Overrides the run() method
Pros: Class implements runnable can also extends other classes

Callable Interface and Future:Similar to Runnable, overrides the call() method. Future represents the result of a computation. Callable can also throw an exception

## [Multithread] How does thread communicate/synchronize with each other?

1. synchronized for locking(only 1 thread can enter), volatile for visibility

2. wait(),notify(), notifyAll() in Object class: 
    They must be used in sychronized
    wait():suspend the current thread
    notify:wakeup one of waited threads

3. java.util.concurrent.locks, such as ReentrantLock, ReadWriteLock

4. Blocking queue, such as LinkedBlockingQueue, ArrayBlockingQueue, CopyOnWriteArrayList

## [Multithread] What is synchronized? What is volatile?

synchronized: This keyword control access to a critical section, only one thread can access the critical section at a time, which prevents race condition. - Atomicity

volatile: This keyword guarantees visibility of changes to variables across threads. 

## [Multithread] What is the CompletableFuture?

CompletableFuture is an extension of the Future class to handle asynchronous programming

Non-blocking: Unlike the Future ’s get() method, you can use thenApply() , thenAccept(), thenReturn callbacks.

Chain Multiple Futures: We can chain CompletableFuture in a pipeline use thenApply(),thenCompose(), thenCombine(), allOf(), anyOf()

Exception Handling: We can use exceptionally() to handle exceptions

## [Multithread] How do you create a thread

1. Extends Thread Class and override its run() method.
2. Implements Runnable interface and overrides its run method
3. Implements Callable interface and overrides its call method
4. Use ExecutorService

## [Multithread] Explain thread join()

The join() method in Java is used to pause the execution of the current thread until the thread it's called on terminates

t1.join() current thread wait t1 to join

## [Multithread] sleep() vs. wait()

sleep(): let the thread to sleep for a time. Lock is not released 对象是线程
wait(): let the thread give up the lock and go sleep indefinitely until other thread acquired the same lock called notify() 对象是锁

## [Multithread] Runnable vs Callable

• Runnable does not return a result, Callable can return a result.
• Runnable cannot throw exception, Callable can throw checked exceptions

## [Multithread] Tell me some concurrent collections

• Map: ConcurrentHashMap
• List: CopyOnWriteArrayList
• Set: CopyOnWriteArraySet
• Queue: LinkedBlockingQueue, ArrayBlockingQueue

## [Multithread] What is ExecutorService? Tell me some common ExecutorService

ExecutorService is a thread pool api, it can be used to process asynchronous tasks.

SingleThreadExecutor: Only uses a single worker thread

FixedThreadPool: This ExecutorService maintains a fixed number of threads.

CachedThreadPool: This ExecutorService creates new threads as needed for new tasks.

## [Multithread] What is the deadlock?

When two or more threads are blocked forever, each waiting for the other to release a resource.

Deadlock conditions
1. Mutual Exclusion互斥:
2. Hold and Wait or Resource Holding请求保持
3. No Preemption非抢占
4. Circular Wait循环等待

## [Multithread] How can volatile make sure the thread will get the latest result?

The volatile keyword ensures visibility

When a field is declared volatile, the Java Memory Model ensures that all reads of that field are read directly from main memory, and all writes to that field are written directly to main memory. 

This means that any updates to a volatile field by one thread will immediately be known to all other threads

## [Git] Git Merge VS Git Rebase

[main] git merge feaure-branch: Merge the 'feature-branch' into 'main’; A new merge commit is created, and the history of the feature branch is preserved.

[main] git merge --squash feature-branch  the individual commits in the feature-branch are "squashed" into one, and the specific history of that branch is lost. You must manually commit the changes
[main] git rebase feature-branch: Changes the base of the currently checked-out branch to the latest commit of feature-branch

## [Git] How to squash your commits? (combine multiple commits into a single commit)

1. Using Interactive Rebase: git rebase -i HEAD~3

2. Using merge squash: git merge squash feature-branch: instead of a merge commit being automatically created, you're left with local changes in your working copy which you can then commit yourself.

