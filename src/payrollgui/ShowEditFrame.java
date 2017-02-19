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
public class ShowEditFrame extends JFrame {
    
    /**
     *
     */
    public ShowEditFrame()
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0 , 0));
        ShowEditPanel ep = new ShowEditPanel();
        setTitle("Green Solar LTD Edit Panel");
        add(ep);
    }
    
}
