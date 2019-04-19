package EmployeeApp.EmployeeAppInfo.EmployeeRespository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import EmployeeApp.EmployeeAppInfo.EmployeeEntity.employeeEntityClass;
@Repository
public interface EmployeeInterface extends CrudRepository<employeeEntityClass,Long> {
	List<employeeEntityClass> findAll();
	
	@SuppressWarnings("unchecked")
	employeeEntityClass save(employeeEntityClass e);
	
	employeeEntityClass findByemployeeId(int e);
	
	@Query("Select p from employeeEntityClass p where p.employeeName like %:query%")
	employeeEntityClass findByemployeeName(@Param("query") String query);
	
	@Transactional
	long deleteByemployeeId(int employeeId);
}
