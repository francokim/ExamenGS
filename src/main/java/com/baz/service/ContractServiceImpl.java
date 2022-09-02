package com.baz.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.baz.model.ContractEntity;
import com.baz.repository.IContractRepository;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class ContractServiceImpl implements IContractService{
	
	private final IContractRepository iContractRepository;

    @Override
    public ContractResult save(ContractEntity dto) {
        return iContractRepository.findContractByEmployeeId(dto.getEmployeeId().getEmployeeId())
                .map(this::handleSecondWorkFlow)
                .orElseGet(()-> internalAddContract(dto));
    }

  
  //primero la throwle
  
  
    @Override
    @Transactional
    public ContractResult  deleteContractById(Integer contractId) {
        return iContractRepository.findContractByEmployeeIdAndActiveIsTrue(contractId)
                .map(this::handleErrorNotExist)
                .orElseGet(()-> updateDateToCurrent(contractId));
    }

    @NonNull
    private ContractResult updateDateToCurrent(Integer contractId) {
        log.warn("The contract '{}' already is inactive.", contractId);
        return notContractValid(contractId);
    }

    @NonNull
    private ContractResult handleErrorNotExist(final @NonNull ContractEntity contractId) {
        log.warn("The contract '{}' already is active.", contractId.getContractId());
        iContractRepository.updateContractToNew(contractId.getContractId());
        return deleteSucess(contractId);

    }

    @NonNull
	private ContractResult handleSecondWorkFlow(final @NonNull ContractEntity existingContrat) {
        log.warn("The contract '{}' already exists.", existingContrat.getContractId());
        iContractRepository.updateContractToNew(existingContrat.getContractId());
        return internalAddContract(existingContrat);
    }

	@NonNull
    private ContractResult internalAddContract(final @NonNull ContractEntity contract) {
        log.info("Trying to add contract {}", contract.getSalaryPerDay());
        ContractEntity saved = iContractRepository.save(contract);
        log.info("Added user with ID: {}", saved.getContractId());
        return addContractSuccessful(saved);
    }


}
