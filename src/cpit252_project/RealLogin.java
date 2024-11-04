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
public class RealLogin implements Login{
     private String Password;

    public RealLogin(String Password) {
        this.Password = Password;
    }

    @Override
    public void login() {
        System.out.println("Welcome back");

    }
     

    
}
