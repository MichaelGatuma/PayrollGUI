/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

import controllers.DatabaseDriver;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import models.*;

/**
 *
 * @author christopherbyrne
 */
public class ShowEditPanel extends JPanel {
    
        String sql;
        String firstName;
        String lastName;
        String address;
        String jobTitle;
        Boolean admin;
        Double salary;
        Double wage;
        Double worked;
        Double overTime;
        Double total;
        Double commission;
        Double totalSales;
        Double totalEarned;
        
        JTextField salaryField = null;
        JTextField commissionField = null;
         JTextField wageField = null;
         JTextField workedField = null;
         JTextField overTimeField = null;
         JTextField totalField = null;
        JTextField totalEarnedField = null;
        JTextField totalSalesField = null;
        String niNumber = PayrollGUI.niNumber;
        JTextField firstNameField;
        JTextField lastNameField;
        JTextField addressField;
        JTextField niNumberField;
        JTextField jobTitleField;
        JCheckBox adminBox;
    
    /**
     *
     */
    public ShowEditPanel() 
    {
         
        final DatabaseDriver dd = new DatabaseDriver();
        
        final String employeeType = dd.employeeType(niNumber);
            switch (employeeType) {
                case "Salary":
                    {
                        sql = "SELECT * FROM Employee, Salary WHERE Employee.niNumber = '" + niNumber +"' AND Salary.niNumber = '" + niNumber +"'";
                        ResultSet res = dd.query(sql);
                        try {
                            while(res.next())
                            {
                                firstName = res.getString("firstName");
                                lastName = res.getString("lastName");
                                address = res.getString("address");
                                jobTitle = res.getString("jobTitle");
                                salary = res.getDouble("salary");
                                admin = res.getBoolean("admin");
                            }
                        }
                        catch (SQLException ex)
                        {
                            System.out.println(ex.getMessage());
                        }           break;
                    }
                case "Hourly":
                    {
                        sql = "SELECT * FROM Employee, Hourly WHERE Employee.niNumber = '" + niNumber +"' AND Hourly.niNumber = '" + niNumber +"'";
                        ResultSet res = dd.query(sql);
                        try {
                            while(res.next())
                            {
                                firstName = res.getString("firstName");
                                lastName = res.getString("lastName");
                                address = res.getString("address");
                                jobTitle = res.getString("jobTitle");
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
                        break;
                    }
                case "Commission":
                    {
                        sql = "SELECT * FROM Employee, Commission WHERE Employee.niNumber = '" + niNumber +"' AND Commission.niNumber = '" + niNumber +"'";
                        ResultSet res = dd.query(sql);
                        try {
                            while(res.next())
                            {
                                firstName = res.getString("firstName");
                                lastName = res.getString("lastName");
                                address = res.getString("address");
                                jobTitle = res.getString("jobTitle");
                                salary = res.getDouble("salary");
                                commission = res.getDouble("commission");
                            }
                        }
                        catch (SQLException ex)
                        {
                            System.out.println(ex.getMessage());
                        }           break;
                    }
                case "BaseCommission":
                    {
                        sql = "SELECT * FROM Employee, Commission, BaseCommission WHERE Employee.niNumber = '" + niNumber +"' AND Commission.niNumber = '" + niNumber +"' AND BaseCommission.niNumber = '"+ niNumber + "'";
                        ResultSet res = dd.query(sql);
                        try {
                            while(res.next())
                            {
                                firstName = res.getString("firstName");
                                lastName = res.getString("lastName");
                                address = res.getString("address");
                                jobTitle = res.getString("jobTitle");
                                salary = res.getDouble("salary");
                                commission = res.getDouble("commission");
                                totalSales = res.getDouble("totalSales");
                                totalEarned = res.getDouble("totalEarned");
                            }
                        }
                        catch (SQLException ex)
                        {
                            System.out.println(ex.getMessage());
                        }           break;
                    }
            }
        
        setLayout(new GridLayout(10, 10));
        
        JLabel firstNameLabel = new JLabel("Firstname:");
        JLabel lastNameLabel = new JLabel("Lastname:");
        JLabel niNumberLabel = new JLabel("Ni Number:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel jobTitleLabel = new JLabel("Job Title:");
        firstNameField = new JTextField(8);
        firstNameField.setText(firstName);
        lastNameField = new JTextField(8);
        lastNameField.setText(lastName);
        niNumberField = new JTextField(8);
        niNumberField.setText(niNumber);
         addressField = new JTextField(8);
        addressField.setText(address);
        //salary = new JTextField(8);
        jobTitleField = new JTextField(8);
        jobTitleField.setText(jobTitle);

        
        
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(niNumberLabel);
        add(niNumberField);
        add(addressLabel);
        add(addressField);
        add(jobTitleLabel);
        add(jobTitleField);
        
        if(employeeType.equals("Salary"))
        {
            JLabel salaryLabel = new JLabel("Salary: ");
            salaryField = new JTextField(8);
            salaryField.setText(salary.toString());
            add(salaryLabel);
            add(salaryField);
        }
        else if(employeeType.equals("Hourly"))
        {
            JLabel wageLabel = new JLabel("Wage: ");
            wageField = new JTextField(8);
            wageField.setText(wage.toString());
            JLabel workedLabel = new JLabel("Worked: ");
            workedField = new JTextField(8);
            workedField.setText(worked.toString());
            JLabel overTimeLabel = new JLabel("Over Time: ");
            overTimeField = new JTextField(8);
            overTimeField.setText(overTime.toString());
            JLabel totalLabel = new JLabel("Total: ");
            totalField = new JTextField(8);
            totalField.setText(total.toString());
            add(wageLabel);
            add(wageField); 
            add(workedLabel);
            add(workedField);
            add(overTimeLabel);
            add(overTimeField);
            add(totalLabel);
            add(totalField);
        }
        else if(employeeType.equals("Commission"))
        {
            JLabel salaryLabel = new JLabel("Salary: ");
            salaryField = new JTextField(8);
            salaryField.setText(salary.toString());
            JLabel commissionLabel = new JLabel("Commission: ");
            commissionField = new JTextField(8);
            commissionField.setText(commission.toString());
            add(salaryLabel);
            add(salaryField);
            add(commissionLabel);
            add(commissionField);
        }
        else if(employeeType.equals("BaseCommission"))
        {
            JLabel salaryLabel = new JLabel("Salary: ");
            salaryField = new JTextField(8);
            salaryField.setText(salary.toString());
            JLabel commissionLabel = new JLabel("Commission: ");
            commissionField = new JTextField(8);
            commissionField.setText(commission.toString());
            JLabel totalSalesLabel = new JLabel("Total Sales: ");
            totalSalesField = new JTextField(8);
            totalSalesField.setText(totalSales.toString());
            JLabel totalEarnedLabel = new JLabel("Total Sales: ");
            totalEarnedField = new JTextField(8);
            totalEarnedField.setText(totalEarned.toString());
            add(salaryLabel);
            add(salaryField);
            add(commissionLabel);
            add(commissionField);
            add(totalSalesLabel);
            add(totalSalesField);
            add(totalEarnedLabel);
            add(totalEarnedField);
        }
        JLabel adminLabel = new JLabel("Admin?:");
        adminBox = new JCheckBox("Admin?");
        
        JLabel submitLabel = new JLabel("Submit: ");
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dd.update("UPDATE Employee SET niNumber = '"+ niNumberField.getText() +"', lastName = '"+lastNameField.getText()+"', firstName = '"+firstNameField.getText()+"', address = '"+ addressField.getText() +"', jobTitle = '"+ jobTitleField.getText() +"', admin = " + adminBox.isSelected() +"  WHERE niNumber = '" + niNumber + "'");
                  switch (employeeType) {
                      case "Salary":
                          dd.update("UPDATE Salary SET niNumber = '"+ niNumberField.getText() +"', salary = " + salaryField.getText() + " WHERE niNumber = '" + niNumber + "'");
                          break;
                      case "Hourly":
                          dd.update("UPDATE Hourly SET niNumber = '" + niNumberField.getText() + "', wage = " + wageField.getText() + ", worked = " + workedField.getText() + ", overTime = " +overTimeField.getText() + ", total = " + totalField.getText() + " WHERE niNumber = '" + niNumber + "'" );
                          break;
                      case "Commission":
                          dd.update("UPDATE Commission SET niNumber ='"+ niNumberField.getText() + "', salary = " + salaryField.getText() + ", commission = " + commissionField.getText() + " WHERE niNumber = '" + niNumber + "'");
                          break;
                      case "BaseCommission":
                          dd.update("UPDATE Commission SET niNumber ='"+ niNumberField.getText() + "', salary = " + salaryField.getText() + ", commission = " + commissionField.getText() + " WHERE niNumber = '" + niNumber + "'");
                          dd.update("UPDATE BaseCommission SET niNumber ='"+ niNumberField.getText() + "', totalSales = " + totalSalesField.getText() + ", totalEarned = " + totalEarnedField.getText() + " WHERE niNumber = '" + niNumber + "'");
                          break;
                  }
                    JOptionPane.showMessageDialog(null, "User updated.", "Finished", 1);
              }
            }
        );
       
        if(!dd.isUserAdmin(niNumber))
        {
            // Don't add Administrator Options
        }
        else
        {
            add(adminLabel);
            add(adminBox);
        }
        add(submitLabel); 
        add(submit);
    }
}
