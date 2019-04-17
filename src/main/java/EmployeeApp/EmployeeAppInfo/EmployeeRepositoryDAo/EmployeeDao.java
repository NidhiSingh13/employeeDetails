package EmployeeApp.EmployeeAppInfo.EmployeeRepositoryDAo;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;


import EmployeeApp.EmployeeAppInfo.EmployeeRespository.EmployeeInterface;

public abstract  class EmployeeDao implements EmployeeInterface{
	@Autowired
	EntityManager entitymanager;
	
	
	public Session  getSession() {
		return  entitymanager.unwrap(Session.class);
	}


	
	
}
