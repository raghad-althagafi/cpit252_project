/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author msbbr
 */
public class addCustomer extends JFrame{

    public addCustomer() {
        
        //create frame
        setTitle("add Customer");
        this.setSize(820, 860);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        ImageIcon backgroundImage = new ImageIcon("addCustomer2.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        
        add(backgroundLabel);
        
        //name textField
        JTextField name = new JTextField();
        name.setBounds(255, 363, 260, 40);
        //add textField to the frame
        backgroundLabel.add(name);
        
        //phone textField
        JTextField phoneNumber = new JTextField();
        phoneNumber.setBounds(255, 497, 260, 40);
        //add textField to the panel
        backgroundLabel.add(phoneNumber);
        
        
        //add button
        JButton addButton = new JButton("ADD");
        addButton.setBounds(280, 640, 235, 60);
        addButton.setBackground(Color.WHITE); //Set background color to white
        addButton.setForeground(Color.BLACK); //set foreround color to black
        //add button to the frame
        backgroundLabel.add(addButton);
        
    }
    
}
