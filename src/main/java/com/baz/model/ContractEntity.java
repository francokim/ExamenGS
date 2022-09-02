package com.baz.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Contract")
public class ContractEntity {
	
	@Id
	@Column(name ="contractId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contractId;
	
	@Column(nullable = false)
	private Date dateFrom;
	
	@Column(nullable = false)
	private Date dateTo;
	
	@Column(nullable = false)
	private BigDecimal salaryPerDay;
	
	@Column(nullable = false)
	private boolean isActive;
	
	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp dateCreated;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="employeeId")
	@JsonProperty(access = Access.WRITE_ONLY)
	private EmployeeEntity employeeId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="contractTypeId")
	@JsonProperty(access = Access.WRITE_ONLY)
	private ContractTypeEntity contractTypeId;

	public ContractEntity() {
	}

	public ContractEntity(Integer contractId, Date dateFrom, Date dateTo, BigDecimal salaryPerDay,
			boolean isActive, Timestamp dateCreated, EmployeeEntity employeeId, ContractTypeEntity contractTypeId) {
		this.contractId = contractId;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.salaryPerDay = salaryPerDay;
		this.isActive = isActive;
		this.dateCreated = dateCreated;
		this.employeeId = employeeId;
		this.contractTypeId = contractTypeId;
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public BigDecimal getSalaryPerDay() {
		return salaryPerDay;
	}

	public void setSalaryPerDay(BigDecimal salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
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

	public EmployeeEntity getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeEntity employeeId) {
		this.employeeId = employeeId;
	}

	public ContractTypeEntity getContractTypeId() {
		return contractTypeId;
	}

	public void setContractTypeId(ContractTypeEntity contractTypeId) {
		this.contractTypeId = contractTypeId;
	}
}
