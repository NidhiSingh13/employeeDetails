package EmployeeApp.EmployeeAppInfo.EmployeeController;

import java.util.List;

import org.springframework.http.ResponseEntity;

import EmployeeApp.EmployeeAppInfo.EmployeeEntity.employeeEntityClass;
import EmployeeApp.EmployeeAppInfo.EmployeeRespository.EmployeeInterface;

public class ClassForCheck implements EmployeeInterface{

	@Override
	public <S extends employeeEntityClass> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public employeeEntityClass findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<employeeEntityClass> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(employeeEntityClass entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends employeeEntityClass> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<employeeEntityClass> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public employeeEntityClass save(employeeEntityClass e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public employeeEntityClass findByemployeeId(int e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public employeeEntityClass findByemployeeName(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long deleteByemployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResponseEntity<employeeEntityClass> updateemployeeId(String query, employeeEntityClass e) {
		// TODO Auto-generated method stub
		return null;
	}

}
