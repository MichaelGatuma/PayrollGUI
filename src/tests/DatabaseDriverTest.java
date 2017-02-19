/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;
import controllers.DatabaseDriver;

/**
 *
 * @author christopherbyrne
 */
public class DatabaseDriverTest {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        DatabaseDriver dd = new DatabaseDriver();
        String result = dd.employeeType("BN 11 00 11 JN");
        System.out.println(result);
        
        String error = dd.employeeType(null);
        System.out.println(error);
    }
    
}
