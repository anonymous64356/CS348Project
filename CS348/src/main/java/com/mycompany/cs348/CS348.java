/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.cs348;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Joseph Murphy
 */
public class CS348 {

    private static Connection conn = null;
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://hospital.c3zw36cwszgr.us-east-1.rds.amazonaws.com/hospital?user=admin&password=d94cjBx3FKtuN0q7");
            ResultSet result = getResultFromQuery("SELECT * FROM medicine");
            while (result.next())
            System.out.printf("Name: %s, ID: %d\n", result.getString("name"), result.getInt("medicineID"));
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
            System.out.println(e);
        }
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PrescriptionGUI().setVisible(true);
//            }
//        });
    }
    
    public static ResultSet getResultFromQuery(String query) {
        if (conn != null) {
            try {
                return conn.createStatement().executeQuery(query);
            } catch (SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            } 
        } else
            System.out.println("Connection to SQL not initialized");
        return null;
    }
}
