package com.baz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baz.exceptions.ModelNotFoundException;
import com.baz.model.ContractEntity;
import com.baz.service.ContractResult;
import com.baz.service.IContractService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping(ContractController.URI)
@Validated
@AllArgsConstructor
public class ContractController {

	protected static final String URI = "api/v1/contract";

	@Autowired
	private IContractService iContractService;

	@PostMapping("add")
	public ResponseEntity<?> addContract(@Valid @RequestBody ContractEntity contractEntity) throws Exception {
		//log.info("Save new contract {}", contractEntity.toString());
		System.err.println("asdasdasd");
		final ContractResult result = iContractService.save(contractEntity);

		if (result.isSuccess()) {
			ContractEntity saved = result.getContract();
			return new ResponseEntity<>(saved, HttpStatus.CREATED);
		}
		
		final String message = result.getErrorMessage();
		throw new ModelNotFoundException(message);
		//return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("unsubscribe/{contractId}")
	public ResponseEntity <Void> delContractEmployee(@PathVariable("contractId") Integer contractId) throws Exception{
		final ContractResult result = iContractService.deleteContractById(contractId);
		
		if(result.isSuccess()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		final String message = result.getErrorMessage();
		throw new ModelNotFoundException(message);
	}

}
