package com.huanjial.springboot.study.myapp.dao;

import com.huanjial.springboot.study.myapp.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
// @Repository:
// 1. Supports component scanning
// 2. Translate JDBC exceptions to meaningful runtime exceptions
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor
    @Autowired
    // @Autowired:
    // 1. Dependency Injection: Spring automatically inject an instance of EntityManager into the StudentDAOImpl
    // class when it's created
    // 2. In this example, @Autowired is placed on the constructor of the StudentDAOImpl class. This is known as constructor injection.
    // Constructor injection ensures that the EntityManager is injected when the StudentDAOImpl instance is created,
    // and it makes the dependency explicit by requiring it in the constructor.
    // 3. With @Autowired, you don't need to manually instantiate and pass the EntityManager to the StudentDAOImpl class.
    // Spring automatically handles the wiring.
    // Why Autowire:
    // Mandatory Dependencies: Constructor injection is preferred for mandatory dependencies because it ensures that the required dependencies are not null when the class is instantiated.
    // Immutability: It allows the dependencies to be declared as final, promoting immutability.
    // Testing: Constructor injection makes it easier to write unit tests because you can easily pass mock dependencies to the constructor.
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    // @Transactional: This annotation is used to define the scope of a single database transaction.
    // When applied to a method, it ensures that the method runs within a transactional context.
    // If the method completes successfully, the transaction is committed.
    // If the method throws a runtime exception, the transaction is rolled back.
    // This is part of Spring's declarative transaction management, which simplifies handling transactions without explicitly managing them in the code.
    // @Transactional makes sure:
    // 1. Atomicity: Transactions are atomic, meaning all operations within a transaction are treated as a single unit. Either all operations succeed and the transaction is committed, or if any operation fails, the entire transaction is rolled back.
    // 2. Rollback on Failure
    // 3. Consistency: Using @Transactional helps maintain database consistency by ensuring that only fully successful transactions are committed.
    public void save(Student theStudent) {

        entityManager.persist(theStudent);
        // This method is used to insert a new entity (in this case, Student) into the persistence context and eventually into the database.
        //The persist method makes the entity managed and persistent, meaning it will be saved to the database when the transaction is committed.
    }
}
