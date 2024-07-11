package com.huanjial.springboot.study.myapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {


    @Id // @Id marks this field as the primary key of the entity. In JPA, every entity must have a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue annotation is to specify how the primary key should be generated
    // strategy = GenerationType.IDENTITY means the database will automatically generate a unique value
    // for the primary key when a new record is inserted into the table. This is commonly used for auto-increment
    // columns in relational databases.
    // For the GenerationType, we can also create our custom one by override its method.
    @Column(name="id")
    // Column is optional when our field, i.e. member variable, has the same name as the column's name we are targeting
    // E.g.: we have a column named id in database, and JPA will automatically match the private int id to the column
    // named id.
    // However, this is a bad practice. In the future, if we want to refactor the code, such as changing the private int
    // id to private int studentId, the JPA won't find the column. We might need to change the column's name in database
    // into studentId. This is very challenging because altering database can cause problems to other developers that
    // use this database as well.
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    public Student() {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Note: For those getters, setters, toString, are called boilerplate code.
    // We can use lombok dependency to generate them, and this can greatly reduce the code

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
