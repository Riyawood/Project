package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;

import com.ems.dao.DepartmentDAO;
import com.ems.daoimpl.DepartmentDAOImpl;
import com.ems.entity.Department;
import com.ems.exception.GlobalException;
import com.ems.model.DepartmentDTO;
import com.ems.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService
{
	//accessing the Data Access Layer(DAO) to call the methods
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		
		//method to save new department details
		@Override
		public void saveDepartment(Department dept) 
		{
			deptDAO.saveDepartment(dept);
		}

		//Method to fetch department details using id
		@Override
		public DepartmentDTO getDeptUsingId(int id) 
		{
			Department department=deptDAO.getDeptUsingId(id);
			if(department!=null)
			{
				return new ModelMapper().map(department, DepartmentDTO.class);
			}
			else
				throw new GlobalException("Department details not found!!");
		}

		//Method to assign employee to department
		@Override
		public void assignEmployeeToDept(int employeeId, int deptId)
		{
			deptDAO.assignEmployeeToDept(employeeId, deptId);	
		}

		//Method to assign manager to department
		@Override
		public void assignManagerToDept(int managerId, int deptId) 
		{
			deptDAO.assignManagerToDept(managerId, deptId);
		}
}