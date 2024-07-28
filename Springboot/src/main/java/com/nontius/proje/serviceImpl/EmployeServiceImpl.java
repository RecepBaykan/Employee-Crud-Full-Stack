package com.nontius.proje.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nontius.proje.entity.Employee;
import com.nontius.proje.entityDTO.EmployeeDTO;
import com.nontius.proje.exception.ResourcesNotFound;
import com.nontius.proje.mapper.EmployeeMapper;
import com.nontius.proje.repository.EmployeeRepository;
import com.nontius.proje.service.EmployeeService;

@Service
public class EmployeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		
		Employee employee = EmployeeMapper.getToEmployee(dto);
		
		// Kodun okunurluğu açısında ve veritabanına kaydedilmiş bir veriyi de tutmak için
		// savedEmploye oluşturulmuştur
		Employee savedEmploye = employeeRepository.save(employee);
		
		return EmployeeMapper.getToEmployeeDTO(savedEmploye);
	}
	
	
	//ID'ye göre Employe bulma
	@Override
	public EmployeeDTO getEmployeeFindId(Long employeeID) {
		
		Employee employee = employeeRepository.findById(employeeID).orElseThrow(
				() -> new ResourcesNotFound("Employee is not exit with given id: " + employeeID)
				);
		
		return EmployeeMapper.getToEmployeeDTO(employee);
	}
	
	// Tüm employeleri bulma
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		return employees.stream().map(
				(employee) -> EmployeeMapper.getToEmployeeDTO(employee)
				).collect(Collectors.toList());
	}
	
	// Employe güncelleme
	@Override
	public EmployeeDTO updateEmployee(Long employeeID, EmployeeDTO updatedEmployee) {
		

		Employee employee = employeeRepository.findById(employeeID).orElseThrow(
				() -> new ResourcesNotFound("Employee is not exit with given id: " + employeeID)
				);
		
		employee.setEmail(updatedEmployee.getEmail());
		employee.setFirstname(updatedEmployee.getFirstname());
		employee.setLastname(updatedEmployee.getLastname());
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		return EmployeeMapper.getToEmployeeDTO(savedEmployee);
	}
	
	
	//Employee silme
	
	@Override
	public void deleteEmployee(Long employeeID) {
		
		Employee employee = employeeRepository.findById(employeeID)
		        .orElseThrow(() -> new ResourcesNotFound("Employee does not exist with the given ID: " + employeeID));

	
		employeeRepository.delete(employee);
	}
	

}
