package EmployeeApp.EmployeeAppInfo.EmployeeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="employeetable")
public class employeeEntityClass {
	
	@Column(name="employeename")
	private String employeeName;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employeeid")
	private int employeeId;
	
	@Column(name="employeecity")
	private String employeeCity;

	public employeeEntityClass (String employeeName,int employeeId,String employeeCity) {
		this.employeeName=employeeName;
		this.employeeId=employeeId;
		this.employeeCity=employeeCity;
	
	}
	public employeeEntityClass() {
		
	}
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeCity() {
		return employeeCity;
	}
	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}
	public String toString() {
		return "{ employeeName:"+ this.employeeName+",employeeId:"+this.employeeId+",employeeCity: "+this.employeeCity+"}";
	}
	

}

