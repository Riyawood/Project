

package com.ems;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ems.service.AdminService;
import com.ems.service.EmployeeService;
import com.ems.service.ManagerService;
import com.ems.serviceimpl.AdminServiceImpl;
import com.ems.serviceimpl.EmployeeServiceImpl;
import com.ems.serviceimpl.ManagerServiceImpl;

public class App 
{
	static AdminService adminService = new AdminServiceImpl();
	static EmployeeService employeeService = new EmployeeServiceImpl();
	static ManagerService managerService = new ManagerServiceImpl();
	static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
    	mainMenu();
    }
    
    public static void mainMenu()
    {
    	System.out.println();
    	int ch;
    	do {
        System.out.println("---Welcome to Employee Management System---");
        System.out.println("1) Admin\n2) Employee\n3) Manager\n4) Exit");
//      ch = sc.nextInt();
        ch = Integer.parseInt(JOptionPane.showInputDialog("Enter choice: ","Type here"));
        switch(ch)
        {
        case 1:
        	mainAdmin();
        	break;
        case 2:
        	mainUser();
        	break;
        case 3:
        	mainManager();
        	break;
        case 4:
        	System.exit(0);
        	break;
        default:
        	System.out.println("Wrong Input!!");	
        }
    	}while(ch!=4);
    }
    
    //main menu for user/employee
    public static void mainUser()
    {
    	do {
    	System.out.println("---------Employee Menu---------");
      	System.out.println("A) LOGIN");
      	System.out.println("B) Exit");
      	
      	String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    	switch(choice)
    	{
    	case "A":
    		boolean status=employeeService.login(JOptionPane.showInputDialog
    				("Enter user_name:","Type here.."), 
    				JOptionPane.showInputDialog("Enter password:","Type here.."));
    		if(status==true)
    		{
    			EmployeeCRUD.afterLoginEmployee();
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "Wrong Credentials");
    		}
    		break;
    		
    	case "B":
    		App.mainUser();
    		break;
       	}
    	}while(true);
    }
    
    //main menu for admin
    public static void mainAdmin()
    {
    	do {
    	System.out.println("---------Admin Menu---------");
      	System.out.println("A) Save new admin\nB) LogIn\nC) Exit");
      	String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    	switch(choice)
    	{
    	case "A":
    		AdminCRUD.saveAdmin();
    		break;
    		
    	case "B":
    		boolean status=adminService.login(JOptionPane.showInputDialog
    				("Enter user_name:","Type here.."), 
    				JOptionPane.showInputDialog("Enter password:","Type here.."));
    		if(status==true)
    		{
    			AdminCRUD.afterLoginAdmin();
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "Wrong Credentials");
    		}
    		break;
    	
    	case "C":
    		mainMenu();
    		break;
    		
    	}
    	}while(true);
    }   
    
   //main menu for manager
    public static void mainManager()
    {
    	do {
    	System.out.println("---------Manager Menu---------");
      	System.out.println("A) Login");
      	System.out.println("B) Exit");
      	
      	String choice = JOptionPane.showInputDialog("Enter choice: ","Type here...");
    	switch(choice)
    	{
    	case "A":
    		boolean status=managerService.login(JOptionPane.showInputDialog
    				("Enter user_name:","Type here.."), 
    				JOptionPane.showInputDialog("Enter password:","Type here.."));
    		if(status==true)
    		{
    			ManagerCRUD.afterLoginManager();
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(null, "Wrong Credentials");
    		}
    		break;
    	
    	case "B":
    		mainManager();
    		break;
    	}
    	}while(true);
    }
}