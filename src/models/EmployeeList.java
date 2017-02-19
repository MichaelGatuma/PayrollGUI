package models;

import java.util.ArrayList;
import java.util.Iterator;
import controllers.DatabaseDriver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christopherbyrne - 1415276
 */
public class EmployeeList {
   
    private ArrayList Employees;
    
    /**
     *
     */
    public EmployeeList() {
        
    }
    
    /**
     * @author ch
     */
    public void listEmployees()
    {
        Iterator it = Employees.iterator();
        while(it.hasNext())
        {
            Employee emp = (Employee)it.next();
            System.out.print(emp);
            System.out.print("_______________");
            
        }
    }
    
    /**
     *
     * @param employee
     */
    public void addEmployee(Employee employee)
    {
        employee.setId(Employees.size()+1);
        Employees.add(employee);
        //this.save();
    }
    
    /**
     *
     * @param employeeNumber
     * @return
     */
    public Employee findEmployee(String employeeNumber)
    {
        Employee foundEmployee = null;
        Iterator it = Employees.iterator();
        
        while(it.hasNext())
        {
            Employee nextEmployee = (Employee)it.next();
            
            if (!employeeNumber.equalsIgnoreCase(nextEmployee.getNiNumber()))
            {
                
            } else {
                foundEmployee = nextEmployee;
            }
        }
        if (foundEmployee == null)
            System.out.println("Employee "+employeeNumber+" not found." );
        
        return foundEmployee;
        
            
    }
    
    /**
     *
     */
    
    /**
     *
     */
    public void loadSalaryEmployees()
    {
        
        try {
            DatabaseDriver dd = new DatabaseDriver();
            String sql = "SELECT EMPLOYEE.*, SALARY.* FROM EMPLOYEE, SALARY WHERE EMPLOYEE.niNumber = SALARY.niNumber";
            ResultSet res = dd.query(sql);
            
            while(res.next())
            {
                SalaryEmployee emp = new SalaryEmployee(res.getString("lastName"), res.getString("firstName"),
                                                        res.getString("niNumber"), res.getString("address"),
                                                        res.getString("jobTitle"), res.getDouble("salary"));
                this.addEmployee(emp);
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(DatabaseDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    

        
    
    

            
    
}
