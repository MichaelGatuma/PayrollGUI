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
 * @author chrisbyrne
 */
public class ShowPayslipFrame extends JFrame {
    
    /**
     *
     */
    public ShowPayslipFrame()
    {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0 , 0));
        ShowPayslipPanel pp = new ShowPayslipPanel();
        setTitle("Green Solar LTD Payslip Panel");
        add(pp);
    }
    
}
