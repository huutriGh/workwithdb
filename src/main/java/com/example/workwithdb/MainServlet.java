package com.example.workwithdb;

import com.example.workwithdb.Service.EmployeeService;
import com.example.workwithdb.models.Employee;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.persistence.EntityManager;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/create")
public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String empName = req.getParameter("empName");
            String empAddress = req.getParameter("address");
            Integer empAge = Integer.parseInt(req.getParameter("age"));
            Employee employee = new Employee();
            employee.setName(empName).setAddress(empAddress).setAge(empAge);
            /*
            employee.setAge(empAge);
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            List<Employee> employees = entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();
            entityManager.close();
            entityManagerFactory.close();
            resp.getWriter().write("Create employee success with infor: " + employee.toString());*/

            EmployeeService employeeService = new EmployeeService();
            employeeService.create(employee);
            req.setAttribute("empList", employeeService.getAll());


            req.getServletContext().getRequestDispatcher("/WEB-INF/EmployeeList.jsp").forward(req, resp);

        } catch (Exception ex) {
            resp.getWriter().write(ex.getMessage());
        }


    }
}
