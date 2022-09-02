package com.baz.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "ContractType")
public class ContractTypeEntity {
	
	@Id
	@Column(name ="contractTypeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short contractTypeId;
	
	@Column(nullable = false, length = 80)
	private String name;
	
	@Column(length = 255)
	private String description;
	
	@Column(nullable = false)
	private boolean isActive;
	
	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp dateCreated;
	
	@OneToMany(targetEntity = ContractEntity.class ,mappedBy = "contractTypeId", cascade = CascadeType.ALL)
	private Set<ContractEntity> contracts = new HashSet<>();

	public ContractTypeEntity() {
	}

	public ContractTypeEntity(short contractTypeId, String name, String description, boolean isActive,
			Timestamp dateCreated, Set<ContractEntity> contractTypes) {
		this.contractTypeId = contractTypeId;
		this.name = name;
		this.description = description;
		this.isActive = isActive;
		this.dateCreated = dateCreated;
		this.contracts = contractTypes;
	}

	public short getContractTypeId() {
		return contractTypeId;
	}

	public void setContractTypeId(short contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<ContractEntity> getContractTypes() {
		return contracts;
	}

	public void setContractTypes(Set<ContractEntity> contractTypes) {
		this.contracts = contractTypes;
	/*	for(ContractEntity contractType: contractTypes) {
			contractType.setContractType(this);
		}*/
	}

}
