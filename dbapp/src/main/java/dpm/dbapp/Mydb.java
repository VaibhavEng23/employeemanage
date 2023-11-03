/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpm.dbapp;
import java.sql.*;

/**
 *
 * @author sspmcoe
 */
public class Mydb {
    Connection connection;
    PreparedStatement st;
    ResultSet rs1,rs2;
    
    Mydb()
    {
        try {       
             Class.forName("com.mysql.jdbc.Driver");
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employee",
                        "root", "");
               System.out.println("Connect");
            } catch (Exception e) {
                    System.out.println(e);
                }
            
    }
    public void insert(int eId,String eName,String eDepartment,String eResignation,int eSalary)
    {
        try {
            st = (PreparedStatement) connection
                           .prepareStatement("INSERT INTO `team` VALUES ('"+eId + "', '" + eName +"', '"  + eDepartment + "', '"+eResignation +"', '"+ eSalary +"')");
            System.out.println(st.execute());
            /*if(st.execute())
            {
                System.out.print("Insert");
                //JOptionPane.showMessageDialog(Mydb, "You have successfully inserted");
            } else {
                        //JOptionPane.showMessageDialog(Mydb, "Wrong input");
                        System.out.print("Insert failed");
                    }*/
        }
        catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
    public static void main(String args[])
    {
        Mydb d =new Mydb();
        d.insert(1," vaibhav","computer","xyz", 100);
                
    }
    
}
