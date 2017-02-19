/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author christopherbyrne
 */
public class StatusPanel extends JPanel {
    
    /**
     *
     */
    public static JTextArea statusWindow;
        JScrollPane scrollPane;
        JTabbedPane tabbedPane;
        JComponent panel2;
        JLabel name;
        JLabel ni;
        JButton button;
        JPanel panel;
    
    /**
     *
     */
    public StatusPanel()
        {

            tabbedPane = new JTabbedPane();
            JComponent panel1 = displayStatus();
             panel2 = displayUser();
            tabbedPane.addTab("Status", panel1);
            tabbedPane.addTab("Current User", panel2);
            
            setStatus("Payroll system started.");
            
            add(tabbedPane);
        }
        
    /**
     *
     * @param content
     */
    public static void setStatus(String content)
        {
            String currentContent = statusWindow.getText();
            statusWindow.setText(currentContent + content + '\n');
        }
        
    /**
     *
     * @return
     */
    protected final JComponent displayStatus() {

            JPanel panel1 = new JPanel(false);
            statusWindow = new JTextArea(10, 30);
            scrollPane = new JScrollPane(statusWindow, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                              JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            statusWindow.setVisible(true);
            statusWindow.disable();
            panel1.add(scrollPane);
            panel1.add(scrollPane);
            return panel1;
        }
        
    /**
     *
     * @return
     */
    protected final JComponent displayUser() {
            
            panel = new JPanel(false);    
            button = new JButton("Show");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    name = new JLabel("User's First name is: " + PayrollGUI.firstName);
                    ni = new JLabel("User's NiNumber is: " + PayrollGUI.niNumber);
                    name.setVisible(true);
                    ni.setVisible(true);
                    button.setVisible(false);
                    panel.remove(button);
                    panel.add(name);
                    panel.add(ni);
                }
            }
            );
            button.setHorizontalAlignment(JLabel.CENTER);

            panel.setLayout(new GridLayout(2, 1));
            panel.add(button);
            //panel.add(name);
            //panel.add(ni);
            return panel;
            
        }
    }

