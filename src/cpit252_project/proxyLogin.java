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
    private String Password;
    private String CorrectPassword = "1234567";

    public proxyLogin(String Password) {
        this.Password = Password;
    }

    
   

    @Override
    public void login() {        
        if (Password.equals(CorrectPassword)){
            login = new RealLogin(Password);
            login.login();
        }
        else{
            System.out.println("Incorrect password. Please try again.");
        }
     }
    }
    

