package com.Zomato.ServiceImpl;

import com.Zomato.Entity.Employee;
import com.Zomato.Repository.EmployeeRepository;
import com.Zomato.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee id not found "+id));
    }

    @Override
    public Employee updateEmployee(int id, Employee employeeDetails) {
Employee employee=getEmployeeById(id);

employee.setName(employeeDetails.getName());
employee.setAdress(employeeDetails.getAdress());
        return employeeRepository.save(employee);
    }
    @Override
    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);

    }
}
