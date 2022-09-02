package com.baz.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.baz.model.EmployeeEntity;

import lombok.NonNull;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
	
	@Query(value ="SELECT * FROM vw_get_all", nativeQuery = true)
    List<Tuple> getAllEmployeeCustom();
	
	@NonNull
	Optional<EmployeeEntity> findEmployeeByTaxIdNumber(String taxIdNumber);
	
	@NonNull
    @Query(value = "SELECT * FROM employee WHERE employeeId=?", nativeQuery = true)
    Optional<EmployeeEntity> findEmployeeByEmployeeId(Integer id);

	@NonNull
    @Modifying
    @Query(value="UPDATE employee SET  taxIdNumber=?, name=?, lastName=? , birthDate=?, email=?, cellPhone=?, dateCreated=?, isActive=? WHERE employeeId=? ",nativeQuery = true)
	void update(String taxIdNumber, String name, String lastName, Date birthDate, String email,
			String cellPhone, Timestamp dateCreated, boolean isActive, Integer employeeId);

}
