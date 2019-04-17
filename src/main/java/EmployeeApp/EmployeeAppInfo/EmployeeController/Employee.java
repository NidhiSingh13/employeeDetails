package EmployeeApp.EmployeeAppInfo.EmployeeController;

public class Employee {
	private String employeeName;
	private int employeeId;
	private String employeeCity;
	private long employeeNumber;
	public Employee(String employeeName,int employeeId,String employeeCity,long employeeNumber) {
		this.employeeName=employeeName;
		this.employeeId=employeeId;
		this.employeeCity=employeeCity;
		this.employeeNumber=employeeNumber;
	}
	
	public Employee() {
		
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
	public long getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	

}
