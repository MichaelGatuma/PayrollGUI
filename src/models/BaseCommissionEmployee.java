/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.DatabaseDriver;

/**
 *
 * @author christopherbyrne
 */
public final class BaseCommissionEmployee extends CommissionEmployee {

    private int totalSales;
    private double totalEarned;
    
    /**
     *
     * @param firstName
     * @param lastName
     * @param niNumber
     * @param address
     * @param jobTitle
     * @param commission
     * @param salary
     * @param sales
     * @param earned
     */
    public BaseCommissionEmployee(String niNumber, String firstName, String lastName,  String address, String jobTitle, double commission, double salary, int sales, double earned)
    {
        super(niNumber, firstName, lastName, address, jobTitle, commission, salary);
        setTotalSales(sales);
        setTotalEarned(earned);
        
        DatabaseDriver dd = new DatabaseDriver();
        dd.query("INSERT INTO BaseCommission (niNumber, totalSales, totalEarned ) VALUES ('"
                + niNumber +"', '" + sales + "', '" + earned +"')" ); 
    }
       
    /**
     *
     * @return
     */
    public int getTotalSales()
    {
        return this.totalSales;
    }
    
    /**
     *
     * @param value
     */
    public void setTotalSales(int value)
    {
        this.totalSales = value;
    }

    /**
     *
     * @return
     */
    public double getTotalEarned()
    {
        return this.totalEarned;
    }
    
    /**
     *
     * @param value
     */
    public void setTotalEarned(double value)
    {
        this.totalEarned = value;
    }
    
    @Override
    public String toString() {

        return String.format("Employee:%s, %s \tNI Number: %s \nAddress: %s\nJobtitle: %s\nTotal Commission: %f\t Total Salary: %f",
                getLastName(), getFirstName(), getNiNumber(),getAddress(),getJobTitle(), getTotalCommission(), getTotalSalary());
    }
    
}
