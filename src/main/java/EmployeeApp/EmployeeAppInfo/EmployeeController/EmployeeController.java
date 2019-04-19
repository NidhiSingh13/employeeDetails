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

public class EmployeeController {

	@Autowired
	EmployeeInterface EmployeeInterface;
	
	@RequestMapping(value = "/allEmployeeDetails",method =RequestMethod.GET)
	public List<employeeEntityClass> getAll() {
		
		List<employeeEntityClass> eobj  = EmployeeInterface.findAll();
		return eobj;
		
	}
	@RequestMapping(value="/getEmployeeById/{query}", method=RequestMethod.GET)
	public ResponseEntity<Object> getEmployeeByID(@PathVariable String query) {
		System.out.println(query);
		int id = Integer.parseInt(query);
		employeeEntityClass e =EmployeeInterface.findByemployeeId(id);
		System.out.println(e.toString());
		if(e!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(e);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request");
		}
	
		
	}
	
	@PostMapping(path="/postEmployeeByName", produces="application/json",consumes = "application/json")
	public ResponseEntity<employeeEntityClass> postEmployeeDetails(@RequestBody employeeEntityClass e) throws Exception {
		
		System.out.println(e+ "this is a posted data");
		employeeEntityClass eobj= EmployeeInterface.save(e);
		System.out.println(eobj);
		if(eobj==null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<employeeEntityClass>(eobj,HttpStatus.OK);
	}
	
	@RequestMapping(value="/findbyName/{query}", method =RequestMethod.GET)
	public ResponseEntity<Object>findByemployeeName(@PathVariable String query ) {
		System.out.println(query);
		employeeEntityClass eobj = EmployeeInterface.findByemployeeName(query);
		System.out.println(eobj);
		if(eobj!=null) {
		return ResponseEntity.status(HttpStatus.OK).body(eobj);}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("no fullfillment_id is there");
		}
	
	}
	
	@RequestMapping(value="/updateEmployee/{query}",method =RequestMethod.PATCH)
	public ResponseEntity<Object>  UpdateEmployeeDetails(@PathVariable String query,@RequestBody employeeEntityClass e) throws Exception {
	
		int id = Integer.parseInt(query);
		System.out.println(e);
		employeeEntityClass eobj = EmployeeInterface.findByemployeeId(id);
		
		System.out.println(e.getEmployeeId());
		if(id == e.getEmployeeId()) {
			eobj.setEmployeeCity(e.getEmployeeCity());
			eobj.setEmployeeName(e.getEmployeeName());
			eobj =EmployeeInterface.save(eobj);
			return ResponseEntity.status(HttpStatus.OK).body(eobj);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
		
	}
	
	@RequestMapping(value="/deleteEmployee/{query}",method=RequestMethod.DELETE)
	public ResponseEntity<Object>  deleteByemployeeId(@PathVariable  String query) {
		int employeeId = Integer.parseInt(query);
		System.out.println(employeeId);
		long rowsEffected = EmployeeInterface.deleteByemployeeId(employeeId);
		System.out.println(rowsEffected);
		if(rowsEffected!=0) {
			return  ResponseEntity.status(HttpStatus.OK).body(rowsEffected);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Deletion Failed");
		}
		
	
		
	}

	
}
