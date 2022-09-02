package com.baz.model;

import java.sql.Date;
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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "Employee",uniqueConstraints = {
        @UniqueConstraint(name = "UniqueTaxtIdNumber", columnNames = { "taxIdNumber"})
})
public class EmployeeEntity {
	
	@Id
	@Column(name ="employeeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	
	@Column(nullable = false, length = 13)  //RFC
	private String taxIdNumber;
	
	@Column(nullable = false, length = 60)
	private String name;
	
	@Column(nullable = false, length = 120)
	private String lastName;
	
	@Column(nullable = false)
	private Date birthDate;
	
	@Column(nullable = false, length = 60)
	private String email;
	
	@Column(nullable = false, length = 20)
	private String cellPhone;
	
	@Column(nullable = false)
	private boolean isActive;
	
	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp dateCreated;
	
	@OneToMany(targetEntity = ContractEntity.class ,mappedBy = "employeeId", cascade = CascadeType.ALL)
	private Set<ContractEntity> contracts = new HashSet<>();

	public EmployeeEntity() {
	}

	public EmployeeEntity(Integer employeeId, String taxIdNumber, String name, String lastName, Date birthDate,
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
	/*	for(ContractEntity contract: contracts) {
			contract.setEmployee(this);
		}*/
	}

}
