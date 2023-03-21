package com.ems.service;

import com.ems.entity.Manager;
import com.ems.model.ManagerDTO;

public interface ManagerService 
{
	void saveManager(Manager manager);
	ManagerDTO updateManager(int id, Manager manager);
	void assignEmployeeToManager(int employeeId, int id);
	ManagerDTO getManagerUsingId(int id);
	void deleteManagerById(int id);
	boolean login(String userName, String password);
}
