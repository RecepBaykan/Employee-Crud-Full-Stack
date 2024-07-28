package com.nontius.proje.entityDTO;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

	private Long id;
	private String firstname;
	private String lastname;
	private String email;
}
