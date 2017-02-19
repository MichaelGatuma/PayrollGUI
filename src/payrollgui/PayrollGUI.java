/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package payrollgui;

import controllers.DatabaseDriver;
import javax.swing.JFrame;
import models.Employee;

/**
 *
 * @author christopherbyrne
 */
public class PayrollGUI {
    
    /**
     *
     */
    public static boolean isAdmin = false;

    /**
     *
     */
    public static String firstName;

    /**
     *
     */
    public static String niNumber;

    /**
     *
     */
    public static Employee employee;
    
    /**
     *
     */
    public static MainFrame mainFrame;

    /**
     *
     */
    public static LoginFrame loginFrame;

    /**
     *
     */
    public static CreateAdminFrame createAdminFrame;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DatabaseDriver dd = new DatabaseDriver();
        
        if(dd.checkDB())
        {
            System.out.println("Database exists. All OK.");
            conjourFrames();
        }
        else
        {
            dd.createDB();
            dd.close();
            createAdminFrame = new CreateAdminFrame();
            createAdminFrame.setSize(1000,500);
            createAdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            createAdminFrame.setLocationRelativeTo(null);
            createAdminFrame.setVisible(true);
        }
        

        
    }
    
    /**
     *
     */
    public static void conjourFrames()
    {
        loginFrame = new LoginFrame();
        loginFrame.setSize(500,300);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        
        mainFrame = new MainFrame();         
        mainFrame.setSize(450,550);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(false);
    }
    
    /**
     *
     * @param op
     */
    public static void setAuthorized(boolean op)
    {
        isAdmin = op;
        System.out.println("Accesssed.");
        mainFrame.setVisible(true);
        loginFrame.setVisible(false);
    }
    
    /**
     *
     * @param op
     */
    public static void setAdmin(boolean op)
    {
        isAdmin = op;
        ButtonPanel.editButton.setEnabled(true);
        ButtonPanel.newButton.setEnabled(true);
        
    }
    
    /**
     *
     * @param name
     * @param ni
     */
    public static void setCurrentUser(String name, String ni)
    {
        
        firstName = name;
        niNumber = ni;
        
    }
        
}
    

