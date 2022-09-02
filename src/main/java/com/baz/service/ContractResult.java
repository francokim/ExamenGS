package com.baz.service;

import java.util.Optional;

import com.baz.model.ContractEntity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ContractResult {
	
	@Builder.Default
	private final boolean success = false;
	private final ContractEntity contract;
	private final String errorMessage;
	private final Optional<Throwable> errorCause; 

}
