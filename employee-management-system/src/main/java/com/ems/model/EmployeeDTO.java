package com.ems.model;

import java.util.Date;

import com.ems.entity.Department;
import com.ems.entity.Manager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO extends UserDTO
{
	private String empName;
	private String empAddress;
	private double salary;
	private String contact;
	private String email;
	private String designation;
	private Date DOJ;
	
	private Department dept;
	private Manager manager;
}