/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static payrollgui.PayrollGUI.loginFrame;

/**
 *
 * @author chrisbyrne
 */
public class ButtonPanel extends JPanel {
    
    JButton showPayslip;
    static JButton editButton;
    static JButton newButton;
    JButton exitButton;
    
    /**
     *
     */
    public ButtonPanel()
    {
        Box horizontalBox = Box.createHorizontalBox();
        
        ImageIcon loginImage = new ImageIcon(getClass().getResource("lock.png"));
        showPayslip = new JButton("Show Payslip");
        showPayslip.setIcon(loginImage);
        showPayslip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowPayslipFrame pf = new ShowPayslipFrame();
                pf.setSize(300,200);
                pf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                pf.setLocationRelativeTo(null);
                pf.setVisible(true);
            }
        });
        
        newButton = new JButton("New");
        newButton.setIcon(loginImage);
        newButton.setEnabled(false);
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TabbedEditPanel panel = new TabbedEditPanel();
                panel.setSize(700,300);
                panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                panel.setLocationRelativeTo(null);
                panel.setVisible(true);
            }
        });
        
        editButton = new JButton("Edit");
        editButton.setIcon(loginImage);
        editButton.setEnabled(true);
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowEditFrame ef = new ShowEditFrame();
                ef.setSize(300,400);
                ef.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ef.setLocationRelativeTo(null);
                ef.setVisible(true);
            }
        });
        
        exitButton = new JButton("Exit");
        exitButton.setIcon(loginImage);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        horizontalBox.add(showPayslip);
        horizontalBox.add(editButton);
        horizontalBox.add(newButton);
        horizontalBox.add(exitButton);
        add(horizontalBox);
    }
    
}
