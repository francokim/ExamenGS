package com.baz.service;

import com.baz.model.ContractEntity;

import lombok.NonNull;

public interface IContractService {

    ContractResult save(ContractEntity contractEntity);
    ContractResult deleteContractById(Integer contractId);

    @NonNull
    default ContractResult addContractSuccessful(final @NonNull ContractEntity saved) {
        return ContractResult.builder()
                .success(true)
                .contract(saved)
                .build();
    }

    @NonNull
    default ContractResult notContractValid(final Integer contract) {
        return ContractResult.builder()
                .success(false)
                .contract(null)
                .errorMessage("The current contract with id "+ contract +" already is invalid because is inactive.")
                .build();
    }

    @NonNull
    default ContractResult deleteSucess(final @NonNull ContractEntity contract) {
        return ContractResult.builder()
                .success(true)
                .contract(null)
                .errorMessage("The current contract dont exist was deleted.")
                .build();
    }
}
