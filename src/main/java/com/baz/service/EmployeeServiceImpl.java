package com.baz.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;
import java.util.stream.Collectors;

import javax.persistence.Tuple;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baz.dto.EmployeeDTOCustom;
import com.baz.model.EmployeeEntity;
import com.baz.repository.IEmployeeRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDTOCustom> getAllEmployees() {
	       List<Tuple> tuples = employeeRepository.getAllEmployeeCustom();
	        List<EmployeeDTOCustom> respose = tuples.stream()
	                .map(t -> new EmployeeDTOCustom(
	                        t.get(0, String.class),
	                        t.get(1, String.class),
	                        t.get(2, String.class),
	                        t.get(3, String.class),
	                        t.get(4, Timestamp.class),
	                        t.get(5, Timestamp.class),
	                        t.get(6, BigDecimal.class)
	                )).collect(Collectors.toList());
	        return respose;
	}

	public EmployeeResult add(EmployeeEntity employeeEntity) {
		log.info("Try to save employee {} ", employeeEntity.getEmployeeId());
		return employeeRepository.findEmployeeByTaxIdNumber(employeeEntity.getTaxIdNumber())
				.map(this::handleDuplicateTaxId)
				.orElseGet(() -> internalAddEmployee(employeeEntity));
	}

	private EmployeeResult handleDuplicateTaxId(EmployeeEntity existingEmployee) {
		log.warn("The employee '{}' already exists.", existingEmployee.getTaxIdNumber());
		return duplicateEmployee(existingEmployee);
	}
	
    private EmployeeResult internalAddEmployee(EmployeeEntity employee) {
        log.info("Trying to add employee {}", employee.getName());
        boolean isValidTaxIdNumber = isValidTaxIdNumber(employee.getTaxIdNumber());
        log.info("The current rfc '{}' is ", isValidTaxIdNumber, employee.getTaxIdNumber());
        if (isValidTaxIdNumber){
            EmployeeEntity saved = employeeRepository.save(employee);
            return addEmployeeSuccessful(saved);
        }
        return invalidTaxIdNumber(employee);
    }

    private boolean isValidTaxIdNumber(String rfc){
        rfc.toUpperCase().trim();
        return rfc.toUpperCase().matches("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}");
    }

    private EmployeeResult internalUpdateEmployee(EmployeeEntity employee) {
        log.info("Trying employee  {}", employee.getEmployeeId());
        boolean isValidTaxIdNumber = isValidTaxIdNumber(employee.getTaxIdNumber());
        log.info("The current rfc '{}' is ", isValidTaxIdNumber, employee.getTaxIdNumber());
        if (isValidTaxIdNumber){
            employeeRepository.update(employee.getTaxIdNumber(),employee.getName(),employee.getLastName(),
                    employee.getBirthDate(),employee.getEmail(),employee.getCellPhone(),
                    employee.getDateCreated(),employee.getIsActive(), employee.getEmployeeId());
            log.info("Updated employee with ID: {}", employee.getEmployeeId());
            return updatedEmployeeSuccessful(employee);
        }
        return invalidTaxIdNumber(employee);
    }

	@Override
    @Transactional
    public EmployeeResult updateEmployee(Integer employeeId,EmployeeEntity dto) {
        dto.setEmployeeId(employeeId);
        log.info("Try to update employee with ID {} ", employeeId);
        Optional<EmployeeEntity> employee = employeeRepository.findEmployeeByEmployeeId(employeeId);
        if (employee.isPresent()){
            return internalUpdateEmployee(dto);
        }else {
           return notFoundEmployeeById(employeeId);
        }
    }

    private EmployeeResult notFoundEmployeeById(Integer notFound) {
        log.warn("The employee with id '{}' dont exists.", notFound);
        return notFoundEmployee(notFound);
    }
	


}
