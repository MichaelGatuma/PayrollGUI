
package models;

import controllers.DatabaseDriver;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author christopherbyrne
 */
public abstract class Employee {
    
    /**
     *
     */
    public int id;
    private int count;
    private String lastName;
    private String firstName;

    /**
     *
     */
    public String niNumber;
    private String address;
    private String jobTitle;
    private Boolean admin;
    
    /**
     *
     * @param lastName
     * @param firstName
     * @param niNumber
     * @param address
     * @param jobTitle
     */
    public Employee(String niNumber, String lastName, String firstName, String address, String jobTitle)
    {
        /*this.setId(count++);
        this.setLastName(lastName);
        this.setFirstName(firstName);
        this.setNiNumber(niNumber);
        this.setAddress(address);
        this.setJobTitle(jobTitle);
        this.setAdmin(false);*/
        
        this.lastName = lastName;
        this.firstName = firstName;
        this.niNumber = niNumber;
        this.address = address;
        this.jobTitle = jobTitle;
        this.admin = false;
        
        DatabaseDriver dd = new DatabaseDriver();
        dd.update("INSERT INTO Employee(niNumber, firstName, lastName, address, jobTitle, admin) VALUES ('"+ niNumber +"', '" + firstName + "', '" + lastName +"', '" + address + "', '" + jobTitle + "', false)");  
    }
    
    /**
     *
     * @param num
     */
    public void setId(int num)
    {
        this.id = num;
        
    }
    
    /**
     *
     * @return
     */
    public int getId()
    {
        return this.id;
    }
    
    /**
     *
     * @return
     */
    public String getLastName() 
    {
        DatabaseDriver dd = new DatabaseDriver();
        String sql = "SELECT lastName FROM Employee WHERE niNumber = '"+this.getNiNumber()+"'";
        ResultSet res = dd.query(sql);
            
        try {
            while(res.next())
            {
                return lastName = res.getString("lastName");
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()); 
        }
        
        return null;
        
    }
    
    /**
     *
     * @param value
     */
    public void setLastName(String value)
    {
        DatabaseDriver dd = new DatabaseDriver();
        dd.update("UPDATE Employee SET lastName = '"+value+"' WHERE niNumber = '" + this.getNiNumber() + "'");
        this.lastName = value;
    }
    
    /**
     *
     * @return
     */
    public String getFirstName()
    {
        return this.firstName;
    }
    
    /**
     *
     * @param value
     */
    public void setFirstName(String value)
    {
        this.firstName = value;
    }
    
    /**
     *
     * @return
     */
    public String getNiNumber()
    {
        
        return this.niNumber;
    }
    
    /**
     *
     * @param value
     */
    public void setNiNumber(String value)
    {
        this.niNumber = value;
    }
    
    /**
     *
     * @return
     */
    public String getAddress()
    {
        return this.address;
    }
    
    /**
     *
     * @param value
     */
    public void setAddress(String value)
    {
        this.address = value;
    }
    
    /**
     *
     * @return
     */
    public String getJobTitle()
    {
        return this.jobTitle;
    }
    
    /**
     *
     * @param value
     */
    public void setJobTitle(String value)
    {
        this.jobTitle = value;
    }
    
    /**
     *
     * @return
     */
    public Boolean getAdmin()
    {
        return this.admin;
    }
    
    /**
     *
     * @param value
     */
    public void setAdmin (Boolean value)
    {
        DatabaseDriver dd = new DatabaseDriver();
        dd.update("UPDATE Employee SET admin = '"+value+"' WHERE niNumber = '" + this.getNiNumber() + "'");
        this.admin = value;
    }
    
    @Override
    public String toString() {

        return String.format("Employee:%s\t%s \nNI Number: %s \n%s: £%.2f",
                getFirstName(), getLastName(), getNiNumber(),"Job Title: ",getJobTitle());
    }
    
}
