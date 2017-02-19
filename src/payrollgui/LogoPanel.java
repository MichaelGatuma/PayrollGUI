/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

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
public class LogoPanel extends JPanel {
       
    /**
     *
     */
    public LogoPanel()
        {
            ImageIcon image;
            image = new ImageIcon(getClass().getResource("photo.jpg"));
 
            JLabel imageLabel = new JLabel("", image, SwingConstants.CENTER);
            add(imageLabel);
           
        }
}
