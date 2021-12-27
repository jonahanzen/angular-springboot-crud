package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.entity.Employee;
import br.com.repository.EmployeeRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
    	return repository.findById(id).get();
       
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }
    
    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@PathVariable Long id,@RequestBody Employee employeeDetails) {
    	Employee employee = repository.findById(id).get();
    	employeeDetails.setId(employee.getId());
    	return repository.save(employeeDetails);
    	}
    
    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable Long id) {
    	Employee employee = repository.findById(id).get();
    	repository.delete(employee);
    }

}
