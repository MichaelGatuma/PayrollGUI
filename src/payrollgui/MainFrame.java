/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author christopherbyrne
 */
public class MainFrame extends JFrame {
        
    /**
     *
     */
    public MainFrame()
    {   
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        LogoPanel logoPanel = new LogoPanel();
        StatusPanel statusPanel = new StatusPanel();
        ButtonPanel buttonPanel = new ButtonPanel();
       
        add(logoPanel);
        add(statusPanel);
        add(buttonPanel);

    }
    

    
    
}
