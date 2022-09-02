package com.baz.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.baz.model.ContractEntity;

public class EmployeeDTO {

	private Integer employeeId;
	private String taxIdNumber;
	private String name;
	private String lastName;
	private Date birthDate;
	private String email;
	private String cellPhone;
	private boolean isActive;
	private Timestamp dateCreated;
	private Set<ContractEntity> contracts = new HashSet<>();

	public EmployeeDTO() {
	}

	public EmployeeDTO(Integer employeeId, String taxIdNumber, String name, String lastName, Date birthDate,
			String email, String cellPhone, boolean isActive, Timestamp dateCreated, Set<ContractEntity> contracts) {
		this.employeeId = employeeId;
		this.taxIdNumber = taxIdNumber;
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.cellPhone = cellPhone;
		this.isActive = isActive;
		this.dateCreated = dateCreated;
		this.contracts = contracts;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getTaxIdNumber() {
		return taxIdNumber;
	}

	public void setTaxIdNumber(String taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<ContractEntity> getContracts() {
		return contracts;
	}

	public void setContracts(Set<ContractEntity> contracts) {
		this.contracts = contracts;
	}

}
