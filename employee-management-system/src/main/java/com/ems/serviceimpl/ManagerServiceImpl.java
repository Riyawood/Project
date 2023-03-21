package com.ems.serviceimpl;

import org.modelmapper.ModelMapper;

import com.ems.dao.ManagerDAO;
import com.ems.daoimpl.ManagerDAOImpl;
import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;

public class ManagerServiceImpl implements ManagerService
{
	//Accessing the Data Access Layer(DAO) to call the methods 
    ManagerDAO managerDAO = new ManagerDAOImpl();
		
    //Method for saving manager details 
	@Override
	public void saveManager(Manager manager) 
	{
		managerDAO.saveManager(manager);
	}

	//Method for updating manager details using id
	@Override
	public ManagerDTO updateManager(int id, Manager manager)
	{
		Manager mgr =managerDAO.updateManager(id, manager);
		if(mgr!=null)
		{
			return new ModelMapper().map(mgr, ManagerDTO.class);
		}
		else
			throw new GlobalException("Manager with id "+id+" not found!!");
	}

	//Assigning employee to manager details
	@Override
	public void assignEmployeeToManager(int employeeId, int id)
	{
		managerDAO.assignEmployeeToManager(employeeId, id);
	}

	//Method to get manager details using id
	@Override
	public ManagerDTO getManagerUsingId(int id) 
	{
		Manager manager = managerDAO.getManagerUsingId(id);
		if(manager!=null)
		{
			return new ModelMapper().map(manager, ManagerDTO.class);
		}
		else
			throw new GlobalException("Employee details not found!!");
	}

	//Method for deleting manager details 
	@Override
	public void deleteManagerById(int id) 
	{
		managerDAO.deleteManagerById(id);	
	}

	//Method for login
	@Override
	public boolean login(String userName, String password)
	{
		return managerDAO.login(userName, password);
	}
}