package com.example.workwithdb;

import com.example.workwithdb.Service.EmployeeService;
import com.example.workwithdb.models.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("emp", employeeService.getById(Integer.valueOf(req.getParameter("id"))));
        req.getServletContext().getRequestDispatcher("/WEB-INF/Update.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Integer id = Integer.valueOf(req.getParameter("id"));
        String empName = req.getParameter("empName");
        String empAddress = req.getParameter("address");
        Integer empAge = Integer.parseInt(req.getParameter("age"));
        Employee employee = new Employee();
        employee.setId(id).setName(empName).setAddress(empAddress).setAge(empAge);
        employeeService.update(employee);
        req.setAttribute("empList",employeeService.getAll());
        req.getServletContext().getRequestDispatcher("/WEB-INF/EmployeeList.jsp").forward(req,resp);



    }
}
