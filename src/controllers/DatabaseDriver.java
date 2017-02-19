/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author chrisbyrne
 */
public class DatabaseDriver {
    
    /**
     *
     */
    public static final String url = "jdbc:derby://localhost:1527/Employee";

    /**
     *
     */
    public static final String driver = "org.apache.derby.jdbc.ClientDriver";

    /**
     *
     */
    public static final String username = "app";

    /**
     *
     */
    public static final String password = "app";
    
    private Connection con;
    private Statement stmt;
    private ResultSet res;
    private ResultSetMetaData rsmd;
    private DatabaseMetaData dbmd;
    
    /**
     *
     */
    public DatabaseDriver()
    {
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Driver Not Found");
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        
    }
    
    /**
     *
     * @param sql
     * @return
     */
    public ResultSet query(String sql)
    {
        res = null;
        
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        
        return res;
    }
    
    /**
     *
     * @param sql
     */
    public void update(String sql)
    {
        try {
            stmt = con.createStatement();
            int num = stmt.executeUpdate(sql);
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    /**
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet check(String sql) throws SQLException
    {
        stmt = con.createStatement();
        res = stmt.executeQuery(sql);
        return res;
    }
    
    /**
     *
     * @param niNumber
     * @param firstName
     * @return
     */
    public boolean checkUser(String niNumber, String firstName)
    {
        DatabaseDriver dd = new DatabaseDriver();
        String sql = "SELECT niNumber, firstName FROM EMPLOYEE WHERE niNumber = '" + niNumber +"'";
        res = dd.query(sql);
            
        try {
            while(res.next())
            {
                String dbfn = res.getString("firstName");
                String dbnin = res.getString("niNumber");
                
                if(niNumber.equals(dbnin))
                {
                    if(firstName.equals(dbfn))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()); 
        }
        
        return false;
    }
    
    /**
     *
     * @param niNumber
     * @return
     */
    public boolean isUserAdmin(String niNumber)
    {
        DatabaseDriver dd = new DatabaseDriver();
        String sql = "SELECT admin FROM EMPLOYEE WHERE niNumber = '" + niNumber +"'";
        res = dd.query(sql);
            
        try {
            while(res.next())
            {
                Boolean admin = res.getBoolean("admin");
                
                if(admin)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()); 
        }
        
        return false;
    }
    
    /**
     *
     * @param sql
     * @return
     */
    public ResultSet get(String sql)
    {
        res = null;
        try {
            
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            
            return res;
            
        }
        catch(SQLException ex)
        {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    /**
     *
     */
    public void close()
    {
        try {
            stmt.close();
            
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        
        try {
             con.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        
    }
    
    /**
     *
     * @return
     */
    public boolean checkDB()
    {
        try {
                dbmd = con.getMetaData();
                res = dbmd.getTables(null, null, "SALARY", null);
            
                return res.next();
            
            }
            catch(SQLException ex)
            {
                 System.out.println(ex.getMessage());
                 return false;
            }
   
    }
    
    /**
     *
     * @param niNumber
     * @return
     */
    public String employeeType(String niNumber)
    {
        DatabaseDriver dd = new DatabaseDriver();
        String sql = "SELECT niNumber FROM Salary WHERE niNumber = '" + niNumber +"'";
        res = dd.query(sql);
            
        try {
            while(res.next())
            {
                String dbnin = res.getString("niNumber");
                
                if(niNumber.equals(dbnin))
                {
                    return "Salary";
                }
                else
                {
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()); 
        }
        
        sql = "SELECT niNumber FROM Hourly WHERE niNumber = '" + niNumber +"'";
        res = dd.query(sql);
            
        try {
            while(res.next())
            {
                String dbnin = res.getString("niNumber");
                
                if(niNumber.equals(dbnin))
                {
                    return "Hourly";
                }
                else
                {
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()); 
        }
        
        sql = "SELECT niNumber FROM Commission WHERE niNumber = '" + niNumber +"'";
        res = dd.query(sql);
            
        try {
            while(res.next())
            {
                String dbnin = res.getString("niNumber");
                
                if(niNumber.equals(dbnin))
                {
                    return "Commission";
                }
                else
                {
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()); 
        }
        
        sql = "SELECT niNumber FROM BaseCommission WHERE niNumber = '" + niNumber +"'";
        res = dd.query(sql);
            
        try {
            while(res.next())
            {
                String dbnin = res.getString("niNumber");
                
                if(niNumber.equals(dbnin))
                {
                    return "BaseCommission";
                }
                else
                {
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()); 
        }
        
        dd.close();
        return null;
        

    }
    
    /**
     *
     */
    public void createDB()
    {
        String employee = "CREATE TABLE Employee ("
                + "niNumber VARCHAR(256) NOT NULL,"
                + "firstName VARCHAR(256) NOT NULL,"
                + "lastName VARCHAR(256) NOT NULL,"
                + "address VARCHAR(256) NOT NULL,"
                + "jobTitle VARCHAR(256) NOT NULL,"
                + "admin BOOLEAN NOT NULL,"
                + "PRIMARY KEY (niNumber))";
        String salary = "CREATE TABLE Salary ("
                + "niNumber VARCHAR(256) NOT NULL,"
                + "salary DOUBLE NOT NULL,"
                + "FOREIGN KEY (niNumber) REFERENCES Employee(niNumber))";
        String hourly = "CREATE TABLE Hourly ("
                + "niNumber VARCHAR(256) NOT NULL,"
                + "wage DOUBLE NOT NULL,"
                + "worked DOUBLE NOT NULL,"
                + "overTime DOUBLE NOT NULL,"
                + "total DOUBLE NOT NULL,"
                + "FOREIGN KEY (niNumber) REFERENCES Employee(niNumber))";
        String commission = "CREATE TABLE Commission ("
                + "niNumber VARCHAR(256) NOT NULL,"
                + "salary DOUBLE NOT NULL,"
                + "commission DOUBLE NOT NULL,"
                + "PRIMARY KEY (niNumber),"
                + "FOREIGN KEY (niNumber) REFERENCES Employee(niNumber))";
        String baseCommission = "CREATE TABLE BaseCommission ("
                + "niNumber VARCHAR(256) NOT NULL,"
                + "totalSales INT NOT NULL ,"
                + "totalEarned DOUBLE NOT NULL,"
                + "FOREIGN KEY (niNumber) REFERENCES Commission(niNumber))";
        
        update(employee);
        update(salary);
        update(hourly);
        update(commission);
        update(baseCommission);
        
    }
    
    
}
