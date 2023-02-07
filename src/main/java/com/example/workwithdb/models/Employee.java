package com.example.workwithdb.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "EmpId")
    private  int id;

    @Column(name = "Emp_Name")
    private  String name;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Column(name = "Emp_Age")
    private  Integer age;

    @Column(name = "Emp_Address")
    private  String address;
}
