package com.Zomato.Service;

import com.Zomato.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee saveEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(int id);
    public Employee updateEmployee(int id,Employee employeeDetails);

    public void deleteEmployee(int id);


}
