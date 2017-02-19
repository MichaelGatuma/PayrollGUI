
package models;

import controllers.DatabaseDriver;

/**
 *
 * @author christopherbyrne
 */
public class HourlyEmployee extends Employee {
    
    private double hourlyWage;
    private double hoursWorked;
    private double overTime;
    private double total;
    
    /**
     *
     * @param firstName
     * @param lastName
     * @param niNumber
     * @param address
     * @param jobTitle
     * @param hours
     * @param wage
     * @param overTime
     * @param total
     */
    public HourlyEmployee( String niNumber, String firstName, String lastName, String address, String jobTitle, double hours, double wage, double overTime, double total )
    {
        super(niNumber, firstName, lastName, address, jobTitle);
        System.out.println("done");

        
        DatabaseDriver dd = new DatabaseDriver();

        dd.update("INSERT INTO Hourly (niNumber, wage, worked, overTime, total ) VALUES ('"
                + niNumber +"',"+ wage +","+ hours +", "+ overTime + ", "+total+")");
        dd.close();
    }
    
    /**
     *
     * @return
     */
    public double getHourlyWage()
    {
        return this.hourlyWage;
    }
    
    /**
     *
     * @param value
     */
    public void setHourlyWage(double value)
    {
        this.hourlyWage = value;
    }
    
    /**
     *
     * @return
     */
    public double getHoursWorked()
    {
        return this.hoursWorked;
    }
    
    /**
     *
     * @param value
     */
    public void setHoursWorked(double value)
    {
        this.hoursWorked = value;
    }
    
    /**
     *
     * @return
     */
    public double overTime()
    {
        return this.overTime;
    }
    
    /**
     *
     * @param value
     */
    public void setOverTime(double value)
    {
        this.overTime = value;
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

        return String.format("Employee:%s, %s \tNI Number: %s \nAddress: %s\nJobtitle: %s\nHourly Wage: %f\t Hours worked: %f\n",
                getLastName(), getFirstName(), getNiNumber(),getAddress(),getJobTitle(),getHourlyWage(), getHoursWorked());
    }
}
