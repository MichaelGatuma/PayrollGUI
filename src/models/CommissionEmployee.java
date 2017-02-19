
package models;

import controllers.DatabaseDriver;

/**
 *
 * @author christopherbyrne
 */
public class CommissionEmployee extends Employee {

    
    private double totalCommission;
    private double totalSalary;
    
    /**
     *
     * @param firstName
     * @param lastName
     * @param niNumber
     * @param address
     * @param jobTitle
     * @param commission
     * @param salary
     */
    public CommissionEmployee(String niNumber, String firstName, String lastName,  String address, String jobTitle, double commission, double salary)
    {
        super( niNumber, firstName, lastName, address, jobTitle );
        setTotalSalary(salary);
        setTotalCommission(commission);        
        DatabaseDriver dd = new DatabaseDriver();
        dd.update("INSERT INTO Commission (niNumber, salary, commission ) VALUES ('"
                + niNumber +"', '" + salary + "', '" + commission+"')" );  
   
        
    }
    
    /**
     *
     * @return
     */
    public double getTotalCommission()
    {
        return this.totalCommission;
    }
    
    /**
     *
     * @param value
     */
    public void setTotalCommission(double value)
    {
        this.totalCommission = value;
    }
    
    /**
     *
     * @return
     */
    public double getTotalSalary()
    {
        return this.totalSalary;
    }
    
    /**
     *
     * @param value
     */
    public void setTotalSalary(double value)
    {
        this.totalSalary = value;
    }
    
    @Override
    public String toString() {

        return String.format("Employee:%s, %s \tNI Number: %s \nAddress: %s\nJobtitle: %s\nSalary: %f\tCommission: %f\n",
                getLastName(), getFirstName(), getNiNumber(),getAddress(),getJobTitle(), getTotalSalary(), getTotalCommission());
    }
}
