package com.example.sherh.atrbrut;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name="employee ")

public class Employee {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String ename;
    private String employeeNumber;
    private int mobile;
    private int salary;

    public Employee() {
	
	}
	public Employee(Long id, String ename, int mobile, int salary,String employeeNumber) {
	
		this.id = id;
		this.ename = ename;
		this.employeeNumber = employeeNumber;
		this.mobile = mobile;
		this.salary = salary;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", mobile=" + mobile + ", salary=" + salary + "]";
	}
}
