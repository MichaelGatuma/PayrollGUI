/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author christopherbyrne
 */
public class CreateAdminFrame extends JFrame {
        
    /**
     *
     */
    public CreateAdminFrame()
    {   
        
        setLayout(new GridLayout(2,1));
        CreateAdminDescriptionPanel descPanel = new CreateAdminDescriptionPanel();
        System.out.println("1");
        CreateAdminPanel adminPanel = new CreateAdminPanel();
        System.out.println("2"); 
        add(descPanel);
        add(adminPanel);


    }
    

    
    
}
