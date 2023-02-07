package com.example.workwithdb.Service;

import com.example.workwithdb.models.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;


public class EmployeeService {


    private EntityManager entityManager;

    public EmployeeService() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public Employee create(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        return employee;
    }

    public List<Employee> getAll() {

        return entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();

    }

    public Employee getById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    public Employee update(Employee emp) {
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, emp.getId());
        employee.setAge(emp.getAge());
        employee.setName(emp.getName());
        employee.setAddress(emp.getAddress());

        entityManager.getTransaction().commit();
        return employee;

    }
    public void delete(Integer id){
        entityManager.getTransaction().begin();
        entityManager.remove(getById(id));
        entityManager.getTransaction().commit();
    }

}
