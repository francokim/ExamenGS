1. Ejecutar los scipts de acontunuacion:


##view
CREATE VIEW vw_get_all AS

SELECT CONCAT(e.name,' ',e.lastName) fullName,e.taxIdNumber taxIdNumber, e.email ,

case when c.isActive = 1 then ct.name else null end contractName,
case when c.isActive = 1 then c.dateFrom else null end dateFrom,
case when c.isActive = 1 then c.dateTo else null end dateTo,
case when c.isActive = 1 then c.salaryPerDay else null end salaryPerDay

FROM employee e JOIN contract c
ON e.employeeId = c.employeeId
JOIN contractType ct ON ct.contractTypeId = c.contractTypeId;

****************************************************

INSERT INTO contracttype (contracttypeid,name, isactive, description, datecreated)
VALUES (1,'Permanent', 1, 'Text', now());

INSERT INTO contracttype (contracttypeid,name, isactive, description, datecreated)
VALUES (2,'Fixed-Term', 1, 'Text', now());

INSERT INTO contracttype (contracttypeid,name, isactive, description, datecreated)
VALUES (3,'External', 1, 'Text', now());

**********************************************************************************************
   
END POINTS:

METODO:            PETICION:                                           BODY
 GET.              http://localhost:8080/api/v1/employee/getCustom
  GET.              http://localhost:8080/api/v1/employee/getAll
 POST.              http://localhost:8080/api/v1/employee/new             
                                                                      {
																		    "taxIdNumber": "LOHC931217EWA",
																		    "name": "Cristhofer",
																		    "lastName": "López Hernandez",
																		    "birthDate": "1993-12-17",
																		    "email": "krispher.1993@gmail.com",
																		    "cellPhone": "9711549545",
																		    "isActive": true
																		}
    
 DELETE.      http://localhost:8080/api/v1/contract/delete/{id}
 
 PUT.         http://localhost:8080/api/v1/employees/update/{id}   
                                                                      {
																		    "taxIdNumber": "LOHC931217ABC",
																		    "name": "Juan Camaleon",
																		    "lastName": "López",
																		    "birthDate": "1993-12-28",
																		    "email": "juan_93@gmail.com",
																		    "cellPhone": "1234567890",
																		    "isActive": true,
																		    "dateCreated": "2022-07-01T19:11:28.388+00:00"
																		}
                               

                                                                
   
  
  
  
