package com.nontius.proje.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nontius.proje.entityDTO.EmployeeDTO;
import com.nontius.proje.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
@CrossOrigin("*")
public class EmployeeController {

	private EmployeeService employeeService;

	// Create Employee@PostMapping
	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO dto) {

		EmployeeDTO savedEmployee = employeeService.createEmployee(dto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") Long employeeID) {

		EmployeeDTO employeeDTO = employeeService.getEmployeeFindId(employeeID);

		return ResponseEntity.ok(employeeDTO);

	}

	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
		
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	// Update
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long id,
			@RequestBody EmployeeDTO employeeDTO){
		
		EmployeeDTO employee = employeeService.updateEmployee(id, employeeDTO);
		
		return ResponseEntity.ok(employee);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmploye(@PathVariable("id") Long id){
		
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Employe deleted succefuly!");
	}
	
	
	

	
	

}
