package com.example.Employeetax.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employeetax.Entity.Employee;
import com.example.Employeetax.Repository.EmployeeRepository;



@Service
public class TaxCalculatorService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	 public void calculateTax(Employee employee) {
	        double yearlySalary = employee.getSalary()*12;
	        double taxdeductsalary = yearlySalary-250000;
	       
	        double taxAmount = 0;
	        
	        
	        if(yearlySalary<=250000) {
	        	taxAmount=0*taxdeductsalary;
	        }else if (yearlySalary >250000 && yearlySalary<=500000) {
	            taxAmount = 0.05 * taxdeductsalary;
	        } else if (yearlySalary>500000 && yearlySalary<=1000000) {
	        	System.out.println(taxAmount);
	            taxAmount = 0.1 * taxdeductsalary;
	        } else if (yearlySalary >1000000) {
	        	System.out.println(taxAmount);
	            taxAmount = 0.2 * taxdeductsalary;
	        }else if(yearlySalary>2500000) {
	        	taxAmount = taxdeductsalary*0.2*0.02;//For Salary >2500000 tax amount 
	        											//which is 20% of yearlySalary and 
	        }											//2% cess Amount collected
	        

	        employee.setTaxAmount(taxAmount);
	        
	    }

	public Employee save(Employee employee) {
		
		return employeeRepository.save(employee);
		
	}

	public List<Employee> getAllEmoployees() {
	
		return employeeRepository.findAll();
	}
	}


