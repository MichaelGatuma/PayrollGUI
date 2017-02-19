/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author christopherbyrne
 */
public class LoginFrame extends JFrame {
    
    /**
     *
     */
    public LoginFrame()
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        LogoPanel logo = new LogoPanel();
        LoginPanel panel = new LoginPanel();
        setTitle("Green Solar LTD Login Panel");
        
        add(logo);
        add(panel);
    }

    
}
