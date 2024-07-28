package com.nontius.proje.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nontius.proje.entityDTO.EmployeeDTO;

@Service
public interface EmployeeService {
	
	//Create Employee
	EmployeeDTO createEmployee(EmployeeDTO dto);
	
	//Get Employee
	EmployeeDTO getEmployeeFindId(Long employeeID);
	
	// All Employee
	List<EmployeeDTO> getAllEmployees();
	
	// Update Employee
	EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO updatedEmployee);
	
	
	void deleteEmployee(Long employeeID);
	
	
	

}
