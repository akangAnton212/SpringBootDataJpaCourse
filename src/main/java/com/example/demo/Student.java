package com.example.demo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;


@Entity(name = "Student")
@Table(
    name = "student",
    uniqueConstraints = {
        @UniqueConstraint(name = "student_email_unique", columnNames="email")
    }
)
public class Student {

    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private Long id;

    @Column(
        name = "first_name",
        nullable = false,
        columnDefinition = "VARCHAR",
        length = 30
    )
    private String firstName;

    @Column(
        name = "last_name",
        nullable = false,
        columnDefinition = "VARCHAR",
        length = 30
    )
    private String lastName;

    @Column(
        name = "email",
        nullable = false,
        columnDefinition = "VARCHAR",
        length = 150
    )
    private String email;

    @Column(
        name = "age",
        nullable = false
    )
    private Integer age;

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(
        name = "uid",
        nullable = false,
        columnDefinition = "UUID"
    )
    private UUID uid;

    
    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Student [age=" + age + ", email=" + email + ", firstName=" + firstName + ", id=" + id + ", lastName="
                + lastName + ", uid=" + uid + "]";
    }

    @PrePersist
    protected void onCreate() {
        setUid(java.util.UUID.randomUUID());
    }
}