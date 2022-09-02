package com.baz.service;

import java.util.Optional;

import com.baz.model.EmployeeEntity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmployeeResult {
	
		@Builder.Default
		private final boolean success = false;
		private final EmployeeEntity employee;
		private final String errorMessage;
		private final Optional<Throwable> errorCause;

}