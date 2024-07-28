package com.nontius.proje.mapper;

import com.nontius.proje.entity.Employee;
import com.nontius.proje.entityDTO.EmployeeDTO;

// Static metotlar ile tanım olduğu için spring bileşini ile işaretleye gerek yoktur
//@Components
public class EmployeeMapper {

	public static EmployeeDTO getToEmployeeDTO(Employee employee) {
		
		return new EmployeeDTO(
					employee.getId(),
					employee.getFirstname(),
					employee.getLastname(),
					employee.getEmail()
					
				);
	}
	
	public static Employee getToEmployee(EmployeeDTO employeeDTO) {
		
		return new Employee(
				
				employeeDTO.getId(),
				employeeDTO.getFirstname(),
				employeeDTO.getLastname(),
				employeeDTO.getEmail()
				
				);
	}
}
