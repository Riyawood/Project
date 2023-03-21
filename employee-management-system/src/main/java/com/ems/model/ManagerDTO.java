package com.ems.model;

import com.ems.entity.Department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDTO extends UserDTO
{
	private String mgrName;
	private String mgrAddress;
    private double salary;
    private String email;
    private String contact;
    
    private Department dept;
}
