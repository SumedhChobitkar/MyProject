package com.Zomato.Controller;

import com.Zomato.Entity.Employee;
import com.Zomato.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){

       Employee saveEmployee=employeeService.saveEmployee(employee);

       return  ResponseEntity.status(HttpStatus.CREATED).body(saveEmployee);

    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployee(){
        return  employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee employee=new Employee();

        return employeeService.getEmployeeById(id);

    }

    @PutMapping("/{id}")
    public Employee updateEmploye(@PathVariable int id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);

    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "employee deleted successfully";

    }



}
