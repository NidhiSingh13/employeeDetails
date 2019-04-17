package EmployeeApp.EmployeeAppInfo.EmployeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import EmployeeApp.EmployeeAppInfo.EmployeeEntity.employeeEntityClass;
import EmployeeApp.EmployeeAppInfo.EmployeeRespository.EmployeeInterface;
import io.swagger.annotations.Api;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/employeeApi")
@Api(description="set to perform crud operation")
public class EmployeeController {

	@Autowired
	EmployeeInterface EmployeeInterface;
	
	@RequestMapping(value = "/allEmployeeDetails",method =RequestMethod.GET)
	public List<employeeEntityClass> getAll() {
		
		List<employeeEntityClass> eobj  = EmployeeInterface.findAll();
		return eobj;
		
	}
	@RequestMapping(value="/getEmployeeById/{query}", method=RequestMethod.GET)
	public employeeEntityClass getEmployeeByID(@PathVariable String query) {
		System.out.println(query);
		int id = Integer.parseInt(query);
		employeeEntityClass e =EmployeeInterface.findByemployeeId(id);
		System.out.println(e.toString());
		
		return e;
	}
	
	@PostMapping(path="/postEmployeeByName", produces="application/json",consumes = "application/json")
	public ResponseEntity<employeeEntityClass> postEmployeeDetails(@RequestBody employeeEntityClass e) throws Exception {
		
		System.out.println(e+ "this is a posted data");
		employeeEntityClass eobj= EmployeeInterface.save(e);
		System.out.println(eobj);
		if(eobj==null) {
			return null;
		}
		return new ResponseEntity<employeeEntityClass>(eobj,HttpStatus.OK);
	}
	
	@RequestMapping(value="/findbyName/{query}", method =RequestMethod.GET)
	public List<employeeEntityClass> findByemployeeName(@PathVariable String query ) {
		System.out.println(query);
		List<employeeEntityClass> eobj = EmployeeInterface.findByemployeeName(query);
		System.out.println(eobj);
		
		
		return eobj;
	}
	
	@RequestMapping(value="/updateEmployee/{query}",method =RequestMethod.PATCH)
	public employeeEntityClass  UpdateEmployeeDetails(@PathVariable String query,@RequestBody JSONObject e) throws Exception {
	
		int id = Integer.parseInt(query);
		System.out.println(e);
		employeeEntityClass eobj = EmployeeInterface.findByemployeeId(id);
		
		System.out.println(e.getInt("employeeId"));
		if(id == e.getInt("employeeId")) {
		eobj.setEmployeeCity(e.getString("employeeCity"));
		eobj.setEmployeeName(e.getString("employeeName"));
		eobj =EmployeeInterface.save(eobj);
		}
		else {
			throw new Exception("Url Id and Id in body of json doesnot match");
		}
		return eobj;
	}
	
	@RequestMapping(value="/deleteEmployee/{query}",method=RequestMethod.DELETE)
	public ResponseEntity<Boolean>  deleteByemployeeId(@PathVariable  String query) {
		int employeeId = Integer.parseInt(query);
		System.out.println(employeeId);
		long rowsEffected = EmployeeInterface.deleteByemployeeId(employeeId);
		System.out.println(rowsEffected);
		return null;
		
	
		
	}

	
}
