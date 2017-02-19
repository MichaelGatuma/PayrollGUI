/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

import controllers.DatabaseDriver;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author chrisbyrne
 */
public class ShowPayslipPanel extends JPanel {

    /**
     *
     */
    public ShowPayslipPanel()
    {
        
        
        setLayout(new GridLayout(10, 10));
        DatabaseDriver dd = new DatabaseDriver();
        String employeeType = dd.employeeType(PayrollGUI.niNumber);
        String niNumber = PayrollGUI.niNumber;
        String firstName = PayrollGUI.firstName;
        String lastName = null;
        String address = null;
        String jobTitle = null;
        SimpleDateFormat datef = new SimpleDateFormat("dd/mm/yyyy");
        String date = datef.format(new Date());
        String sql;
        ResultSet res;
        Double salary = null;
        Double wage = null;
        Double overTime = null;
        Double worked = null;
        Double total = null;
        Double salaryc = null;
        Double commission = null;
        Double totalSales = null;
        Double totalEarned = null;
        Double salaryb = null;
        Double commissionb = null;
        
        sql = "SELECT * FROM EMPLOYEE WHERE niNumber = '" + niNumber + "'";
        res = dd.query(sql);
        
        try
        {
            while(res.next())
            {
                lastName = res.getString("lastName");
                firstName = res.getString("firstName");
                address = res.getString("address");
                jobTitle = res.getString("jobTitle");
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()); 
        }
        
        
        switch(employeeType)
        {
            case "Salary":
                     sql = "SELECT *  FROM Salary WHERE niNumber = '"+niNumber+"'";
                     res = dd.query(sql);
            
                    try {
                        while(res.next())
                        {
                            salary = res.getDouble("salary");
                        }
                    }
                    catch (SQLException ex)
                    {
                        System.out.println(ex.getMessage()); 
                    }
                    JTextArea sp = new JTextArea("Payslip\n", 30 ,20);
                    sp.setEditable(false);
                    sp.append("Date: " + date  + "\n" );
                    sp.append("FirstName: " + firstName  + "\n");
                    sp.append("LastName: " + lastName  + "\n");
                    sp.append("Ni Number: " + niNumber  + "\n");
                    sp.append("Address: " + address  + "\n");
                    sp.append("Job Title: " + jobTitle  + "\n");
                    sp.append("Salary: " + salary.toString() + "\n");
                    
                    /*JLabel dateDesc = new JLabel("Date:");
                    JLabel dateLabel = new JLabel(date);
                    JLabel firstNameDesc = new JLabel("FirstName:");
                    JLabel firstNameLabel = new JLabel(firstName);
                    JLabel lastNameDesc = new JLabel("LastName:");
                    JLabel lastNameLabel = new JLabel(lastName);
                    JLabel niNumberDesc = new JLabel("Ni Number:");
                    JLabel niNumberLabel = new JLabel(niNumber);
                    JLabel addressDesc = new JLabel("Address:");
                    JLabel addressLabel = new JLabel(address);
                    JLabel jobTitleDesc = new JLabel("Job Title:");
                    JLabel jobTitleLabel = new JLabel(jobTitle);
                    JLabel salaryDesc = new JLabel("Salary:");
                    JLabel salaryLabel = new JLabel(salary.toString());
                    add(dateDesc);
                    add(dateLabel);
                    add(firstNameDesc);
                    add(firstNameLabel);
                    add(lastNameDesc);
                    add(lastNameLabel);
                    add(niNumberDesc);
                    add(niNumberLabel);
                    add(addressDesc);
                    add(addressLabel);
                    add(jobTitleDesc);
                    add(jobTitleLabel);
                    add(salaryDesc);
                    add(salaryLabel);*/
                    add(sp);
                break;
            case "Hourly":
                     sql = "SELECT  wage,worked,overTime,total FROM Hourly WHERE niNumber = '"+niNumber+"'";
                     res = dd.query(sql);
            
                    try {
                        while(res.next())
                        {
                            wage = res.getDouble("wage");
                            worked = res.getDouble("worked");
                            overTime = res.getDouble("overTime");
                            total = res.getDouble("total");
                        }
                    }
                    catch (SQLException ex)
                    {
                        System.out.println(ex.getMessage()); 
                    }
                    
                    JTextArea hp = new JTextArea("Payslip\n", 30 ,20);
                    hp.setEditable(false);;
                    hp.append("Date: " + date  + "\n" );
                    hp.append("FirstName: " + firstName  + "\n");
                    hp.append("LastName: " + lastName  + "\n");
                    hp.append("Ni Number: " + niNumber  + "\n");
                    hp.append("Address: " + address  + "\n");
                    hp.append("Job Title: " + jobTitle  + "\n");
                    hp.append("Wage: " + wage.toString() + "\n");
                    hp.append("Worked: " + worked.toString() + "\n");
                    hp.append("Overtime: " + overTime.toString() + "\n");
                    hp.append("Total: " + total.toString() + "\n");
                    
                    /*JLabel dateDesch = new JLabel("Date:");
                    JLabel dateLabelh = new JLabel(date);
                    
                    JLabel firstNameDesch = new JLabel("FirstName:");
                    JLabel firstNameLabelh = new JLabel(firstName);
                    JLabel lastNameDesch = new JLabel("LastName:");
                    JLabel lastNameLabelh = new JLabel(lastName);
                    JLabel niNumberDesch = new JLabel("Ni Number:");
                    JLabel niNumberLabelh = new JLabel(niNumber);
                    JLabel addressDesch = new JLabel("Address:");
                    JLabel addressLabelh = new JLabel(address);
                    JLabel jobTitleDesch = new JLabel("Job Title:");
                    JLabel jobTitleLabelh = new JLabel(jobTitle);
                    JLabel wageDesc = new JLabel("Wage:");
                    JLabel wageLabel = new JLabel(wage.toString());
                    JLabel workedDesc = new JLabel("Worked:");
                    JLabel workedLabel = new JLabel(worked.toString());
                    JLabel overTimeDesc = new JLabel("Over time:");
                    JLabel overTimeLabel = new JLabel(overTime.toString());
                    JLabel totalDesc = new JLabel("Total:");
                    JLabel totalLabel = new JLabel(total.toString());
                    add(dateDesch);
                    add(dateLabelh);
                    add(firstNameDesch);
                    add(firstNameLabelh);
                    add(lastNameDesch);
                    add(lastNameLabelh);
                    add(niNumberDesch);
                    add(niNumberLabelh);
                    add(addressDesch);
                    add(addressLabelh);
                    add(jobTitleDesch);
                    add(jobTitleLabelh);
                    add(wageDesc);
                    add(wageLabel);
                    add(workedDesc);
                    add(workedLabel);
                    add(overTimeDesc);
                    add(overTimeLabel);
                    add(totalDesc);
                    add(totalLabel);*/
                    add(hp);
                break;
            case "Commission":
                     sql = "SELECT salary,commission FROM Commission WHERE niNumber = '"+niNumber+"'";
                     res = dd.query(sql);
            
                    try {
                        while(res.next())
                        {
                            salaryc = res.getDouble("salary");
                            commission = res.getDouble("commission");
                        }
                    }
                    catch (SQLException ex)
                    {
                        System.out.println(ex.getMessage()); 
                    }
                    
                    
                    JTextArea cp = new JTextArea("Payslip\n", 30 ,20);
                    cp.setEditable(false);
                    cp.append("Date: " + date + "\n");
                    cp.append("FirstName: " + firstName+ "\n");
                    cp.append("LastName: " + lastName+ "\n");
                    cp.append("Ni Number: " + niNumber+ "\n");
                    cp.append("Address: " + address + "\n");
                    cp.append("Job Title: " + jobTitle + "\n");
                    cp.append("Salary: " + salaryc.toString() + "\n");
                    cp.append("Commission: " + commission.toString() + "\n");
                    
                    /*JLabel dateDescc = new JLabel("Date:");
                    JLabel dateLabelc = new JLabel(date);
                    JLabel firstNameDescc = new JLabel("FirstName:");
                    JLabel firstNameLabelc = new JLabel(firstName);
                    JLabel lastNameDescc = new JLabel("LastName:");
                    JLabel lastNameLabelc = new JLabel(lastName);
                    JLabel niNumberDescc = new JLabel("Ni Number:");
                    JLabel niNumberLabelc = new JLabel(niNumber);
                    JLabel addressDescc = new JLabel("Address:");
                    JLabel addressLabelc = new JLabel(address);
                    JLabel jobTitleDescc = new JLabel("Job Title:");
                    JLabel jobTitleLabelc = new JLabel(jobTitle);
                    JLabel wageDescc = new JLabel("Salary:");
                    JLabel wageLabelc = new JLabel(salaryc.toString());
                    JLabel commissionDesc = new JLabel("Commission:");
                    JLabel commissionLabel = new JLabel(commission.toString());
                    add(dateDescc);
                    add(dateLabelc);
                    add(firstNameDescc);
                    add(firstNameLabelc);
                    add(lastNameDescc);
                    add(lastNameLabelc);
                    add(niNumberDescc);
                    add(niNumberLabelc);
                    add(addressDescc);
                    add(addressLabelc);
                    add(jobTitleDescc);
                    add(jobTitleLabelc);
                    add(wageDescc);
                    add(wageLabelc);
                    add(commissionDesc);
                    add(commissionLabel);*/
                    add(cp);
                break;
            case "BaseCommission":
                     //sql = "SELECT totalSales,totalEarned FROM BaseCommission WHERE niNumber = '"+niNumber+"'";
                     sql = "SELECT * FROM Commission, BaseCommission WHERE Commission.niNumber = '" + niNumber +"' AND BaseCommission.niNumber = '"+ niNumber + "'";
                     res = dd.query(sql);
            
                    try {
                        while(res.next())
                        {
                            salaryb = res.getDouble("salary");
                            commissionb = res.getDouble("commission");
                            totalSales = res.getDouble("totalSales");
                            totalEarned = res.getDouble("totalEarned");
                            
                        }
                    }
                    catch (SQLException ex)
                    {
                        System.out.println(ex.getMessage()); 
                    }
                    
                    JTextArea bp = new JTextArea("Payslip \n", 30 ,20);
                    bp.setEditable(false);
                    bp.append("Date: " + date + "\n" );
                    bp.append("FirstName: " + firstName+ "\n");
                    bp.append("LastName: " + lastName+ "\n");
                    bp.append("Ni Number: " + niNumber+ "\n");
                    bp.append("Address: " + address+ "\n");
                    bp.append("Job Title: " + jobTitle+ "\n");
                    bp.append("Salary: " + salaryb.toString()+ "\n");
                    bp.append("Commission: " + commissionb.toString()+ "\n");
                    bp.append("Total Sales: " + totalSales.toString()+ "\n");
                    bp.append("Total Earned: " + totalEarned.toString()+ "\n");
                    
                    /*JLabel dateDescb = new JLabel("Date:");
                    JLabel dateLabelb = new JLabel(date);
                    JLabel firstNameDescb = new JLabel("FirstName:");
                    JLabel firstNameLabelb = new JLabel(firstName);
                    JLabel lastNameDescb = new JLabel("LastName:");
                    JLabel lastNameLabelb = new JLabel(lastName);
                    JLabel niNumberDescb = new JLabel("Ni Number:");
                    JLabel niNumberLabelb = new JLabel(niNumber);
                    JLabel addressDescb = new JLabel("Address:");
                    JLabel addressLabelb = new JLabel(address);
                    JLabel jobTitleDescb = new JLabel("Job Title:");
                    JLabel jobTitleLabelb = new JLabel(jobTitle);
                    JLabel totalSalesDesc = new JLabel("Total Sales:");
                    JLabel totalSalesLabel = new JLabel(totalSales.toString());
                    JLabel totalEarnedDesc = new JLabel("Total Earned:");
                    JLabel totalEarnedLabel = new JLabel(totalEarned.toString());
                    add(dateDescb);
                    add(dateLabelb);
                    add(firstNameDescb);
                    add(firstNameLabelb);
                    add(lastNameDescb);
                    add(lastNameLabelb);
                    add(niNumberDescb);
                    add(niNumberLabelb);
                    add(addressDescb);
                    add(addressLabelb);
                    add(jobTitleDescb);
                    add(jobTitleLabelb);
                    add(totalSalesDesc);
                    add(totalSalesLabel);
                    add(totalEarnedDesc);
                    add(totalEarnedLabel);*/
                    add(bp);
                break;
            default:
                
        }        
        

        
        
        

    }
    

    
}
