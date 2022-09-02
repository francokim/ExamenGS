package com.baz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.baz.model.ContractEntity;

import lombok.NonNull;

public interface IContractRepository extends JpaRepository<ContractEntity, Integer>{
	
	@NonNull
    Optional<ContractEntity> findContractByEmployeeId(Integer contractId);

	@NonNull
    @Query(value = "SELECT * FROM contract WHERE contractId = ? AND isActive=1", nativeQuery = true)
    Optional<ContractEntity> findContractByEmployeeIdAndActiveIsTrue(Integer contractId);


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE contract SET isActive = 0, dateTo = now() WHERE contractId=? ", nativeQuery = true)
    void updateContractToNew(Integer contractId);

}
