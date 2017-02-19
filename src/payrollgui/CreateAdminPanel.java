/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

import java.awt.BorderLayout;
import java.awt.FlowLayout; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import models.HourlyEmployee;
import models.BaseCommissionEmployee;
import models.CommissionEmployee;
import models.SalaryEmployee;

/**
 *
 * @author chrisbyrne
 */
public class CreateAdminPanel extends JPanel {
    
     JTabbedPane tabbedPane;
     JComponent addSalaryUser;
     JComponent addCommissionUser;
     JComponent addHourlyUser;
     JComponent addBaseCommissionUser;
     JPanel panel;
     
     JTextField firstNameSalary;
     JTextField lastNameSalary;
     JTextField niNumberSalary;
     JTextField addressSalary;
     JTextField jobTitleSalary;
     JTextField firstNameCommission;
     JTextField lastNameCommission;
     JTextField niNumberCommission;
     JTextField addressCommission;
     JTextField jobTitleCommission;
     JTextField firstNameBaseCommission;
     JTextField lastNameBaseCommission;
     JTextField niNumberBaseCommission;
     JTextField addressBaseCommission;
     JTextField jobTitleBaseCommission;
     JTextField firstNameHourly;
     JTextField lastNameHourly;
     JTextField niNumberHourly;
     JTextField addressHourly;
     JTextField jobTitleHourly;
     JTextField salary;
     JTextField commissionC;
     JTextField commissionB;
     JTextField hours;
     JTextField wage;
     JTextField totalSales;
     JTextField totalEarned;
     JTextField salaryCommission;
     JTextField salaryBC;
    private JTextField overTime;
    private JTextField totalHourly;

    /**
     *
     */
    public CreateAdminPanel() {
        setLayout(new BorderLayout());
        
        tabbedPane = new JTabbedPane();
        addSalaryUser = addSalaryUser();
        addCommissionUser = addCommissionUser();
        addHourlyUser = addHourlyUser();
        addBaseCommissionUser = addBaseCommissionUser();
        tabbedPane.addTab("Add Salary User", addSalaryUser);
        tabbedPane.addTab("Add Commission User", addCommissionUser);
        tabbedPane.addTab("Add Hourly User", addHourlyUser);
        tabbedPane.addTab("Add Base Commission User", addBaseCommissionUser);
        add(tabbedPane, BorderLayout.CENTER);

    }
    
    /**
     *
     * @return
     */
    protected final JComponent addSalaryUser() {
       
        panel = new JPanel(false);
        
        JLabel firstNameLabel = new JLabel("Firstname:");
        JLabel lastNameLabel = new JLabel("Lastname:");
        JLabel niNumberLabel = new JLabel("Ni Number:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel jobLabel = new JLabel("Job Title:");
        JLabel salaryLabel = new JLabel("Salary:");
        JLabel submitLabel = new JLabel("Submit:");
        firstNameSalary = new JTextField(8);
        lastNameSalary = new JTextField(8);
        niNumberSalary = new JTextField(8);
        addressSalary = new JTextField(8);
        salary = new JTextField(8);
        jobTitleSalary = new JTextField(8);
        
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  SalaryEmployee se = new SalaryEmployee(niNumberSalary.getText(), firstNameSalary.getText(), lastNameSalary.getText(), addressSalary.getText(), jobTitleSalary.getText(), Double.parseDouble(salary.getText()));
                  se.setAdmin(true);
                  PayrollGUI.conjourFrames();
                  PayrollGUI.createAdminFrame.setVisible(false);
              }
            }
        );

        panel.setLayout(new GridLayout(7,7));
        panel.add(firstNameLabel);
        panel.add(firstNameSalary);
        panel.add(lastNameLabel);
        panel.add(lastNameSalary);
        panel.add(niNumberLabel);
        panel.add(niNumberSalary);
        panel.add(addressLabel);
        panel.add(addressSalary);
        panel.add(jobLabel);
        panel.add(jobTitleSalary);
        panel.add(salaryLabel);
        panel.add(salary);
        panel.add(submitLabel);
        panel.add(button);

        return panel;
     }
        
    /**
     *
     * @return
     */
    protected final JComponent addCommissionUser() {
       
        panel = new JPanel(false);
        
        JLabel firstNameLabel = new JLabel("Firstname:");
        JLabel lastNameLabel = new JLabel("Lastname:");
        JLabel niNumberLabel = new JLabel("Ni Number:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel commissionLabel = new JLabel("Commission:");
        JLabel salaryLabel = new JLabel("Salary:");
        JLabel submitLabel = new JLabel("Submit:");
        JLabel jobTitleLabel = new JLabel("Job Title:");
        firstNameCommission = new JTextField(8);
        lastNameCommission = new JTextField(1);
        niNumberCommission = new JTextField(8);
        addressCommission = new JTextField(8);
        commissionC = new JTextField(8);
        salaryCommission = new JTextField(8);
        jobTitleCommission = new JTextField(8);
        
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  CommissionEmployee ce = new CommissionEmployee(niNumberCommission.getText(), firstNameCommission.getText(), lastNameCommission.getText(), addressCommission.getText(), jobTitleCommission.getText(), Double.parseDouble(commissionC.getText()), Double.parseDouble(salary.getText()));
                  ce.setAdmin(true);
                  PayrollGUI.conjourFrames();
                  PayrollGUI.createAdminFrame.setVisible(false);
              }
            }
        );

        panel.setLayout(new GridLayout(8,8));
        panel.add(firstNameLabel);
        panel.add(firstNameCommission);
        panel.add(lastNameLabel);
        panel.add(lastNameCommission);
        panel.add(niNumberLabel);
        panel.add(niNumberCommission);
        panel.add(addressLabel);
        panel.add(addressCommission);
        panel.add(jobTitleLabel);
        panel.add(jobTitleCommission);
        panel.add(commissionLabel);
        panel.add(commissionC);
        panel.add(salaryLabel);
        panel.add(salaryCommission);
        panel.add(submitLabel);
        panel.add(button);

        return panel;
     }
    
    /**
     *
     * @return
     */
    protected final JComponent addHourlyUser() {
       
        panel = new JPanel(false);
        
        JLabel firstNameLabel = new JLabel("Firstname:");
        JLabel lastNameLabel = new JLabel("Lastname:");
        JLabel niNumberLabel = new JLabel("Ni Number:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel jobTitleLabel = new JLabel("Job Title:");
        JLabel hoursLabel = new JLabel("Hours:");
        JLabel wageLabel = new JLabel("Wage:");
        JLabel overTimeLabel = new JLabel("Overtime:");
        JLabel totalLabel = new JLabel("Total:");
        JLabel submitLabel = new JLabel("Submit:");
        firstNameHourly = new JTextField(8);
        lastNameHourly = new JTextField(1);
        niNumberHourly = new JTextField(8);
        addressHourly = new JTextField(8);
        jobTitleHourly = new JTextField(8);
        hours = new JTextField(8);
        wage = new JTextField(8);
        overTime = new JTextField(8);
        totalHourly = new JTextField(8);
        
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  HourlyEmployee he = new HourlyEmployee(niNumberHourly.getText(), firstNameHourly.getText(), lastNameHourly.getText(), addressHourly.getText(), jobTitleHourly.getText(), Double.parseDouble(hours.getText()), Double.parseDouble(wage.getText()), Double.parseDouble(overTime.getText()), Double.parseDouble(totalHourly.getText()));
                  he.setAdmin(true);
                  PayrollGUI.conjourFrames();
                  PayrollGUI.createAdminFrame.setVisible(false);
              }
            }
        );

        panel.setLayout(new GridLayout(10,10));
        panel.add(firstNameLabel);
        panel.add(firstNameHourly);
        panel.add(lastNameLabel);
        panel.add(lastNameHourly);
        panel.add(niNumberLabel);
        panel.add(niNumberHourly);
        panel.add(addressLabel);
        panel.add(addressHourly);
        panel.add(jobTitleLabel);
        panel.add(jobTitleHourly);
        panel.add(hoursLabel);
        panel.add(hours);
        panel.add(wageLabel);
        panel.add(wage);
        panel.add(overTimeLabel);
        panel.add(overTime);
        panel.add(totalLabel);
        panel.add(totalHourly);
        panel.add(submitLabel);
        panel.add(button);

        return panel;
     }
     
    /**
     *
     * @return
     */
    protected final JComponent addBaseCommissionUser() {
       
        panel = new JPanel(false);
        
        JLabel firstNameLabel = new JLabel("Firstname:");
        JLabel lastNameLabel = new JLabel("Lastname:");
        JLabel niNumberLabel = new JLabel("Ni Number:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel commissionLabel = new JLabel("Commission:");
        JLabel totalSalesLabel = new JLabel("Total Sales:");
        JLabel totalEarnedLabel = new JLabel("Total Earned:");
        JLabel submitLabel = new JLabel("Submit:");
        JLabel jobTitleLabel = new JLabel("Job Title:");
        firstNameBaseCommission = new JTextField(8);
        lastNameBaseCommission = new JTextField(8);
        niNumberBaseCommission = new JTextField(8);
        addressBaseCommission = new JTextField(8);
        jobTitleBaseCommission = new JTextField(8);
        commissionB = new JTextField(8);
        salaryBC = new JTextField(8);
        totalSales = new JTextField(8);
        totalEarned = new JTextField(8);
        
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  BaseCommissionEmployee bce = new BaseCommissionEmployee(niNumberBaseCommission.getText(), firstNameBaseCommission.getText(), lastNameBaseCommission.getText(), addressBaseCommission.getText(), jobTitleBaseCommission.getText(), Double.parseDouble(commissionB.getText()), Double.parseDouble(salaryBC.getText()), Integer.parseInt(totalSales.getText()), Double.parseDouble(totalEarned.getText()));
                  bce.setAdmin(true);
                  PayrollGUI.conjourFrames();
                  PayrollGUI.createAdminFrame.setVisible(false);
              }
            }
        );

        panel.setLayout(new GridLayout(9,9));
        panel.add(firstNameLabel);
        panel.add(firstNameBaseCommission);
        panel.add(lastNameLabel);
        panel.add(lastNameBaseCommission);
        panel.add(niNumberLabel);
        panel.add(niNumberBaseCommission);
        panel.add(addressLabel);
        panel.add(addressBaseCommission);
        panel.add(jobTitleLabel);
        panel.add(jobTitleBaseCommission);
        panel.add(commissionLabel);
        panel.add(commissionB);
        panel.add(totalSalesLabel);
        panel.add(totalSales);
        panel.add(totalEarnedLabel);
        panel.add(totalEarned);
        panel.add(submitLabel);
        panel.add(button);

        return panel;
     }
    
}
