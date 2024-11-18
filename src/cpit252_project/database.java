/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

/**
 *
 * @author AHC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class database {
        
    private Connection con;

    public database() {
        //(1) create the database
        createDB();
        //(2) connect to database
       connectToDatabase();
        //(3) create DB tables 
        createTables();
      
    }
    
    //------------------------------------
    
    //method for creating DB
    public void createDB(){
    
    //statment for create DB
    String createDatabase = "CREATE DATABASE IF NOT EXISTS TailorSystem";
    
    //connect to mySql server
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Leena1234");
             Statement st = conn.createStatement()) {
            // Execute statement to create the database
            st.executeUpdate(createDatabase);
        } catch (SQLException s) {
            System.out.println("SQL statement for database creation is not executed!");
        }
        
    }
    
    //------------------------------------
    
    // Connect to the database
    private void connectToDatabase() {
        try {
            //Set the connection to KAU_EVENTS DB
            String connectionURL = "jdbc:mysql://localhost:3306/TailorSystem";
            con = DriverManager.getConnection(connectionURL, "root", "Leena1234");
        } catch (SQLException s) {
            System.out.println("SQL statement for connecting to the database is not executed!");
        }
    }
    
    //------------------------------------
    //method for creating tables of DB
    public void createTables(){
        
        //user table statment
        String usersTable = "CREATE TABLE IF NOT EXISTS users ("
                                + "username VARCHAR(13) NOT NULL PRIMARY KEY, "
                                + "password VARCHAR(50) NOT NULL"
                                +")";
        
        try(Statement st = con.createStatement()){
            //create users table
            st.executeUpdate(usersTable);
        }
        catch (SQLException s){
         System.out.println("SQL statement is not executed!");
        }
    }
    

 
     
        //method to check user Login
    public boolean checkLogin(String username,String Password){
        String query = "SELECT password FROM users WHERE username=?";
        
        try (PreparedStatement st = con.prepareStatement(query)){
            
            //set the values of username
            st.setString(1, username);
            
            //excute statment
            ResultSet rs = st.executeQuery();
            
            //if user exists
            if(rs.next()){
                //the real pass
                String RealPass = rs.getString("password");
                //check if the entered pass equla the real pass
                boolean flag = RealPass.trim().equalsIgnoreCase(Password.trim());
                //return the value
                return flag;
            }
            
            //if user not found
            else{
                return false;
            }
        }
        catch (SQLException s){
         System.out.println("SQL statement is not executed!");
        }
        
        return false;
    }

   
     
}
    

