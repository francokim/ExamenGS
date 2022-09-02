package com.baz.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baz.dto.EmployeeDTO;
import com.baz.dto.EmployeeDTOCustom;
import com.baz.exceptions.ModelNotFoundException;
import com.baz.model.EmployeeEntity;
import com.baz.repository.IEmployeeRepository;
import com.baz.service.EmployeeResult;
import com.baz.service.IEmployeeService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(EmployeeController.URI)
@Validated
@AllArgsConstructor
public class EmployeeController {

	protected static final String URI = "api/v1/employee";

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private IEmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("getCustom")
	public ResponseEntity<List<EmployeeDTOCustom>> getAllEmployeesCustom() throws Exception {
		final List<EmployeeDTOCustom> result = employeeService.getAllEmployees();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//HashSet
	//TryMap

	@GetMapping("getAll")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() throws Exception {
		final List<EmployeeDTO> allEmployees = employeeRepository.findAll().stream()
				.map(em -> mapper.map(em, EmployeeDTO.class)).collect(Collectors.toList());

		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}

	@PostMapping("new")
	public ResponseEntity<?> newEmployee(@Valid @RequestBody EmployeeEntity employee) throws Exception {
		log.info("Save new employee {}", employee.toString());
		final EmployeeResult result = employeeService.add(employee);
		if (result.isSuccess()) {
			EmployeeEntity saved = result.getEmployee();
			return new ResponseEntity<>(saved, HttpStatus.CREATED);
		}
		final String message = result.getErrorMessage();
		throw new ModelNotFoundException(message);
	}

	@PutMapping("update/{employeeId}")
	public ResponseEntity<?> updateEmployee(@PathVariable Integer employeeId, @RequestBody final EmployeeEntity employee)
			throws Exception {
		log.info("Try to update employee {}", employeeId);

		final EmployeeResult result = employeeService.updateEmployee(employeeId, employee);
		if (result.isSuccess()) {
			EmployeeEntity saved = result.getEmployee();
			return new ResponseEntity<>(saved, HttpStatus.OK);
		}
		final String message = result.getErrorMessage();
		throw new ModelNotFoundException(message);
	}

}
