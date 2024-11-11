/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

import java.util.Scanner;

/**
 *
 * @author AHC
 */
public class proxyLogin implements Login {

    private Login login;
    private String username;
    private String Password;
    //private String CorrectPassword = "1234567";
    database db;

    public proxyLogin(String Password,String username) {
        this.Password = Password;
        this.username = username;
        db = new database();
    }

    
   

    @Override
    public TailorSystemFacade login() {        
        if (db.checkLogin(username, Password)){
            login = new RealLogin();
            return login.login();
        }
        else{
            System.out.println("user not fount or Incorrect password.");
            return null;
        }
     }


    }
    

