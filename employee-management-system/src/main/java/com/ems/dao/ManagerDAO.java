package com.ems.dao;

import com.ems.entity.Manager;

public interface ManagerDAO 
{
	void saveManager(Manager manager);
	Manager updateManager(int id, Manager manager);
	void assignEmployeeToManager(int employeeId, int id);
	Manager getManagerUsingId(int id);
	void deleteManagerById(int id);
	boolean login(String userName, String password);
}
