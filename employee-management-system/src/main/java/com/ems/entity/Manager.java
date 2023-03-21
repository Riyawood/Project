package com.ems.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Manager")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manager extends User
{
	@Column(length=20, nullable = false)
	private String mgrName;
	@Column(length=20, nullable = false)
	private String mgrAddress;
	@Column(length=20, nullable = false)
    private double salary;
	@Column(length=50, nullable = false, unique = true)
    private String email;
	@Column(length=10, nullable = false)
    private String contact;
    
	@OneToMany
	private List<Employee> employees;

	public void setDept(Department dept) 
	{
		
	}
}