
package models;

import controllers.DatabaseDriver;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author christopherbyrne
 */
public class SalaryEmployee extends Employee {
    
    /**
     *
     */
    public double weeklySalary;

    /**
     *
     */
    public double numberOfWeeksWorked;

    /**
     *
     */
    public double total;


    /**
     *
     * @param lastName
     * @param firstName
     * @param niNumber
     * @param address
     * @param jobTitle
     * @param salary
     */
    public SalaryEmployee(String niNumber ,String firstName, String lastName, String address, String jobTitle, double salary)
    {
        super( niNumber, lastName, firstName, address, jobTitle);
        DatabaseDriver dd = new DatabaseDriver();
        dd.update("INSERT INTO Salary (niNumber, salary)  VALUES ('"+ niNumber +"', " + salary + ")");  

    }
    
    /**
     *
     * @return
     */
    public double getWeeklySalary()
    {
        DatabaseDriver dd = new DatabaseDriver();
        String sql = "SELECT salary FROM Salary WHERE niNumber = '" + this.getNiNumber() +"'";
        ResultSet res = dd.query(sql);
            
        try {
            while(res.next())
            {
                Double d = res.getDouble("salary");
                return d;
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()); 
        }
        
        return this.weeklySalary;
    }
    
    /**
     *
     * @param value
     */
    public void setWeeklySalary(double value)
    {
        this.weeklySalary = value;
    }
    
    /**
     *
     * @return
     */
    public double getNumberOfWeeksWorked()
    {
        return this.numberOfWeeksWorked;
    }
    
    /**
     *
     * @param value
     */
    public void setNumberOfWeeksWorked(double value)
    {
        this.numberOfWeeksWorked = value;
    }

    /**
     *
     * @return
     */
    public double getTotal()
    {
        return this.total;
    }
    
    /**
     *
     * @param value
     */
    public void setTotal(double value)
    {
        this.total = value;
    }
    
    @Override
    public String toString() {

        return String.format("Employee:%s, %s \tNI Number: %s \nAddress: %s\nJobtitle: %s\nSalary: %f",
                getLastName(), getFirstName(), getNiNumber(),getAddress(),getJobTitle(), getWeeklySalary());
    }
}
