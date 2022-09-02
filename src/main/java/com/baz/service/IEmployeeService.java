package com.baz.service;

import java.util.List;

import com.baz.dto.EmployeeDTOCustom;
import com.baz.model.EmployeeEntity;

import lombok.NonNull;

public interface IEmployeeService {

	List<EmployeeDTOCustom> getAllEmployees();

	EmployeeResult add(EmployeeEntity employeeEntity);
	
	EmployeeResult updateEmployee(Integer employeeId, EmployeeEntity dto);

	@NonNull
	default EmployeeResult addEmployeeSuccessful(final @NonNull EmployeeEntity saved) {
		return EmployeeResult.builder()
				.success(true)
				.employee(saved)
				.build();
	}

	@NonNull
	default EmployeeResult duplicateEmployee(final @NonNull EmployeeEntity duplicate) {
		return EmployeeResult.builder()
				.success(false)
				.employee(duplicate)
				.errorMessage("The taxIdNumber: " + duplicate.getTaxIdNumber()+ " already exist.")
				.build();
	}
	
	@NonNull
    default EmployeeResult invalidTaxIdNumber(final @NonNull EmployeeEntity invalidate) {
        return EmployeeResult.builder()
                .success(false)
                .employee(invalidate)
                .errorMessage("The taxIdNumber: " + invalidate.getTaxIdNumber() +" is invalidate format.")
                .build();
    }
	
	@NonNull
    default EmployeeResult updatedEmployeeSuccessful(final EmployeeEntity updated) {
        return EmployeeResult.builder()
                .success(true)
                .employee(updated)
                .build();
    }
	
	@NonNull
    default EmployeeResult notFoundEmployee(final Integer notFound) {
        return EmployeeResult.builder()
                .success(false)
                .employee(null)
                .errorMessage("The id dont exist.")
                .build();
    }

}
