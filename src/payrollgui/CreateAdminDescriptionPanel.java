/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author christopherbyrne
 */
public class CreateAdminDescriptionPanel extends JPanel {
       
    /**
     *
     */
    public CreateAdminDescriptionPanel()
        {
            setLayout(new BorderLayout());
            ImageIcon image;
            image = new ImageIcon(getClass().getResource("photo.jpg"));
 
            JLabel imageLabel = new JLabel("", image, SwingConstants.CENTER);
            JLabel errorLabel = new JLabel("There was no database present. One was created for you. Please enter your Admin Employee Crenditals.");
            add(imageLabel, BorderLayout.NORTH);
            add(errorLabel,BorderLayout.SOUTH);
           
        }
}
