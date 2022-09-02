package com.baz.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class EmployeeDTOCustom {

	private String fullName;
    private String taxIdNumber;
    private String email;
    private String contractName;
    private Timestamp dateFrom;
    private Timestamp dateTo;
    private BigDecimal salaryPerDay;
 
	public EmployeeDTOCustom(String fullName, String taxIdNumber, String email, String contractName, Timestamp dateFrom,
			Timestamp dateTo, BigDecimal salaryPerDay) {
		this.fullName = fullName;
		this.taxIdNumber = taxIdNumber;
		this.email = email;
		this.contractName = contractName;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.salaryPerDay = salaryPerDay;
	}
	


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTaxIdNumber() {
		return taxIdNumber;
	}

	public void setTaxIdNumber(String taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public Timestamp getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Timestamp dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Timestamp getDateTo() {
		return dateTo;
	}

	public void setDateTo(Timestamp dateTo) {
		this.dateTo = dateTo;
	}

	public BigDecimal getSalaryPerDay() {
		return salaryPerDay;
	}

	public void setSalaryPerDay(BigDecimal salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
	}
}
