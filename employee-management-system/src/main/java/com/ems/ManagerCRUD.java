package com.ems;

import java.util.Scanner;
import javax.swing.JOptionPane;

import com.ems.entity.Manager;
import com.ems.exception.GlobalException;
import com.ems.model.ManagerDTO;
import com.ems.service.ManagerService;
import com.ems.serviceimpl.ManagerServiceImpl;

public class ManagerCRUD 
{
	static Scanner sc = new Scanner(System.in);
	static ManagerService mgrService = new ManagerServiceImpl();
	// Saving manager details
	public static void saveManager()
	{
		Manager mgr = new Manager();
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		String add = JOptionPane.showInputDialog("Enter address:","Type here..");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter salary:","Type here.."));
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String cont = JOptionPane.showInputDialog("Enter phone no.:","Type here..");
		String user = JOptionPane.showInputDialog("Enter username:","Type here..");
		String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
		
		mgr.setMgrName(name);
		mgr.setMgrAddress(add);
		mgr.setSalary(sal);
		mgr.setEmail(email);
		mgr.setContact(cont);
		mgr.setUserName(user);
		mgr.setPassword(pass);
		mgr.setRole("manager");

		mgrService.saveManager(mgr);
		System.out.println("Manager details saved!!");
	}	
	
	// Updating manager details
	public static void updateManager()
	{
		Manager mgr1 = new Manager();
		String name = JOptionPane.showInputDialog("Enter name:","Type here..");
		String add = JOptionPane.showInputDialog("Enter address:","Type here..");
		Double sal = Double.parseDouble(JOptionPane.showInputDialog("Enter salary:","Type here.."));
		String email = JOptionPane.showInputDialog("Enter email:","Type here..");
		String cont = JOptionPane.showInputDialog("Enter phone no.:","Type here..");
		
		mgr1.setMgrName(name);
		mgr1.setMgrAddress(add);
		mgr1.setSalary(sal);
		mgr1.setEmail(email);
		mgr1.setContact(cont);

		mgrService.updateManager(Integer.parseInt(
				JOptionPane.showInputDialog("Enter id to update:","Type here..")), mgr1);

		System.out.println("Manager details saved!!");
	}
	
	//Method to Assign employee to manager 
	public static void assign()
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter manager id:","Type here.."));
		int empId = Integer.parseInt(JOptionPane.showInputDialog("Enter employee id:","Type here.."));
		mgrService.assignEmployeeToManager(empId, id);
		JOptionPane.showMessageDialog(null, "Employee has been assigned successfully!!");
	}
	
	//Method to get manager details using id
	public static void getManager() throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to search:","Type here.."));
		ManagerDTO mgr1= mgrService.getManagerUsingId(id);
	    
	    System.out.println("Manager Name:"+mgr1.getMgrName());
	    System.out.println("Manager Address:"+mgr1.getMgrAddress());
	    System.out.println("Manager Salary:"+mgr1.getSalary());
	    System.out.println("Manager Contact:"+mgr1.getContact());
	    System.out.println("Manager Email:"+mgr1.getEmail());
	    System.out.println("Manager Username:"+mgr1.getUserName());
	    System.out.println("Manager Password:"+mgr1.getPassword());
	}
	
	//Deleting manager details
	public static void deleteManager()
	{
		int id= Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:","Type here.."));
		
		mgrService.deleteManagerById(id);
		JOptionPane.showMessageDialog(null, "Object is deleted!!");
	}
	
	//method for login
	public static void login()
	{
		mgrService.login(JOptionPane.showInputDialog("Enter user_name:","Type here.."), 
				JOptionPane.showInputDialog("Enter password:","Type here.."));
	}
	
	//method after login
	public static void afterLoginManager()
    {
		do {
    	System.out.println();
      	System.out.println("A) Save new Manager\nB) Assign employee to manager ID\n"
      			+ "C) To check Manager details using\nD) To update Manager details\n"
      			+ "E) To delete an Manager\nF) Exit");
      	String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    	switch(choice)
    	{
    	case "A":
    		ManagerCRUD.saveManager();
    		break;
    		
    	case "B":
    		ManagerCRUD.assign();
    		break;
    		
    	case "C":
    		ManagerCRUD.getManager();
    		break;
    		
    	case "D":
    		ManagerCRUD.updateManager();
    		break;
    		
    	case "E":
    		ManagerCRUD.deleteManager();
    		break;

    	case "F":
    		App.mainManager();
    		break;
    	}
		}while(true);
    }
}