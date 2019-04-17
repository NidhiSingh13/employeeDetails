package EmployeeApp.EmployeeAppInfo.EmployeeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="  Employee Details")
@Entity
@Table(name="employeetable")
public class employeeEntityClass {
	@ApiModelProperty(notes="employee name")
	@Column(name="employeename")
	private String employeeName;
	
	@ApiModelProperty(notes="employee id")
	@Id
	@Column(name="employeeid")
	private int employeeId;
	@ApiModelProperty(notes="employee city")
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

