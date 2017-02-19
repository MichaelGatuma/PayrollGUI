/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

import controllers.DatabaseDriver;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author christopherbyrne
 */
public class LoginPanel extends JPanel {
    
    JButton button;
    JTextField niNumber;
    JTextField firstName;
    JLabel niNumberLabel;
    JLabel firstNameLabel;

    /**
     *
     */
    public LoginPanel()
    {
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setBorder(BorderFactory.createLineBorder(Color.black));
        niNumber = new JTextField(8);
        firstName = new JTextField(8);
        ImageIcon loginImage = new ImageIcon(getClass().getResource("lock.png"));
        button = new JButton("Login");
        button.setIcon(loginImage);
        niNumberLabel = new JLabel("Ni Number: ");
        firstNameLabel = new JLabel("Firstname: ");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                DatabaseDriver dd = new DatabaseDriver();
                
                String firstNameField = firstName.getText();
                String niNumberField = niNumber.getText();
                
                if( dd.checkUser(niNumberField, firstNameField))
                {
                    PayrollGUI.niNumber = niNumberField;
                    PayrollGUI.firstName = firstNameField;
                    PayrollGUI.setAuthorized(true);
                    StatusPanel.setStatus("User Authorized. Hello " + firstName.getText() + ".\nSee Below for operations");
                    PayrollGUI.setCurrentUser(firstNameField, niNumberField);
                    if (dd.isUserAdmin(niNumberField))
                    {
                        PayrollGUI.setAdmin(true);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "NiNumber and First Name Incorrect. Please enter a valid one.", "Error", 1);
                    StatusPanel.setStatus("User Denied. Hello " + firstName.getText() + ".");   
                }
                

            }
        });
      
        horizontalBox.add(niNumberLabel);
        horizontalBox.add(niNumber);
        horizontalBox.add(firstNameLabel);
        horizontalBox.add(firstName);
        horizontalBox.add(button);
        add(horizontalBox);
          
    }
    
}
