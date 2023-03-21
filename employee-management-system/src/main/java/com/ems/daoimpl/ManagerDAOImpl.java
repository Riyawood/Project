package com.ems.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ems.config.HibernateUtil;
import com.ems.dao.ManagerDAO;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

public class ManagerDAOImpl implements ManagerDAO
{
	//Method for saving manager details
	@Override
	public void saveManager(Manager manager) 
	{
		try(Session session = HibernateUtil.getSession())
		{
			session.beginTransaction();
			//add all the new employee details
			session.save(manager);
			
			//java object saved to the database
			session.getTransaction().commit();
			
			//clear the session
			session.clear();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//Method for updating manager details
	@Override
	public Manager updateManager(int id, Manager manager)
	{
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			Manager mgr=session.get(Manager.class, id);
			
			//updating existing details with the new one
			mgr.setMgrName(manager.getMgrName());
			mgr.setMgrAddress(manager.getMgrAddress());
			mgr.setSalary(manager.getSalary());
			mgr.setContact(manager.getContact());
			mgr.setEmail(manager.getEmail());
			mgr.setUserName(manager.getUserName());
			mgr.setPassword(manager.getPassword());
			
			session.saveOrUpdate(mgr);
			session.getTransaction().commit();
			
			return mgr; 
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	// Assign employee to manager details using id
	@Override
	public void assignEmployeeToManager(int employeeId, int id) 
	{
		try(Session session=HibernateUtil.getSession())
		{
			Employee emp = session.get(Employee.class, employeeId);
			Manager mgr= session.get(Manager.class, id);
			
			List<Employee> employees = new ArrayList<>();
			employees.add(emp);
			
			mgr.setEmployees(employees);
			emp.setManager(mgr);
			
			session.beginTransaction();
			session.saveOrUpdate(mgr);
			
			session.getTransaction().commit();
		}
		catch (HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	//Method to get manager details using id
	@Override
	public Manager getManagerUsingId(int id) 
	{
		try(Session session = HibernateUtil.getSession())
		{
			Manager manager = session.get(Manager.class, id);
			return manager;
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

	//Method for deleting manager details
	@Override
	public void deleteManagerById(int id) 
	{
		try(Session session=HibernateUtil.getSession())
		{
			
			Manager manager=session.load(Manager.class, id);
			
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?",
					"Are you sure?",JOptionPane.YES_NO_OPTION);
			if(input==0)
			{
				session.delete(manager);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "User wants to retain it!");
			}
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		}
	}

	//Method for login manager details
	@Override
	public boolean login(String userName, String password)
	{
		try(Session session=HibernateUtil.getSession())
		{
			int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Id: ","Type here.."));
			Manager manager=session.get(Manager.class, id);
			if(manager.getUserName().equals(userName) && manager.getPassword().equals(password) 
					&& manager.getRole().equals("manager"))
			{
				JOptionPane.showMessageDialog(null, "Log In successfull!!");
				return true;
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Wrong Credentials!!");
				return false;
			}
		}
	}
}