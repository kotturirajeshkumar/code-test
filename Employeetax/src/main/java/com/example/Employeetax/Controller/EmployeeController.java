package com.example.Employeetax.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employeetax.Entity.Employee;
import com.example.Employeetax.Repository.EmployeeRepository;
import com.example.Employeetax.Service.TaxCalculatorService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	
	

	    @Autowired
	    private TaxCalculatorService taxCalculatorService;
	    
	    @Autowired
	    private EmployeeRepository employeeRepository;
	    
	    // API endpoint to store employee details
	    @PostMapping("/saveEmployee")
		public Employee saveemployee(@RequestBody Employee employee) {
			return taxCalculatorService.save(employee);
			
		}
	    
	  
	    
	       //API endpoint to get all employee details
	        @GetMapping(path = "/Employees")
	    public ResponseEntity<List<Employee>> getAllEmployeesData() {
	    	return new ResponseEntity<List<Employee>>(taxCalculatorService.getAllEmoployees(), HttpStatus.OK);
	    	}  
	        
	        
	        //API endpoint to return employees tax deduction
		    @GetMapping("/employeestaxdetails")
	        public ResponseEntity<List<Employee>> getTaxDeductions() {
		    List<Employee> employees = new ArrayList<>();
	        
		    // Creating sample employees
	        Employee employee1 = new Employee();
	        employee1.setId(1);
	        employee1.setFirstName("Rajesh");
	        employee1.setLastName("Kumar");
	        employee1.setEmail("rajeshkumarkotturi94@gmail.com");
	        employee1.setDoj(LocalDate.of(2020, 05, 25));
	        employee1.setSalary(28000); // Sample yearly salary
	        taxCalculatorService.calculateTax(employee1);
	        employees.add(employee1);

	        Employee employee2 = new Employee();
	        employee2.setId(2);
	        employee2.setFirstName("Shyam");
	        employee2.setLastName("Sunder");
	        employee2.setEmail("shyamsunder94@gmail.com");
	        employee2.setDoj(LocalDate.of(2018, 02, 20));
	        employee2.setSalary(30000); // Sample yearly salary
	        taxCalculatorService.calculateTax(employee2);
	        employees.add(employee2);
	        
	       

	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }
	}



