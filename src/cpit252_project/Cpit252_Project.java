/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit252_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author AHC
 */
public class Cpit252_Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //-------------------------
        //Facade 
        //Login
        Login loin = new proxyLogin("raghad", "raghad");
        TailorSystemFacade TailorSystemFacade = loin.login();
        
        PricingAndDeliveryDateService pricingService = new PricingAndDeliveryDateService();//calculate price and deliverydate
        pricingService.calculatePricingAndDeliveryDate();

        
    //-------------------------------Strategy pattern and Decorator pattern for price and date -----------------------
   
        Scanner input = new Scanner(System.in);

        
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.addCustomer(); //let user enter customer info
          
          
        //get price info from PricingAndDeliveryDateService facade
        double finalPrice = pricingService.getFinalPrice();
        LocalDate deliveryDate = pricingService.getDeliveryDate();
        String garmentType = pricingService.getGarmentType();
        String fabricType = pricingService.getFabricType();
        
        //------------------------------------------Builder design pattern for make order------------------------------------------------------------------------------
        OrderBuilder orderBuilder = new Invoice();
        OrderDirector orderDirector = new OrderDirector(orderBuilder);
        orderDirector.makeOrder(customer, fabricType, garmentType, deliveryDate, finalPrice);
        Order order = orderDirector.getOrder();
        //System.out.println(order.GenerateInvoice());
        
       
       
        //--------------------------------------------------------------
        //database db = new database();
        //System.out.println(db.checkLogin("raghad", "raghad"));
        
        
        //------------------------------------------display output in interface-------------------------------------------------------
        
        JFrame frame = new JFrame("Touch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 480);
      
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 600, 430);
        
        
        // use your paths, note: images are in (resourse) folder
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\msbbr\\OneDrive\\Documents\\NetBeansProjects\\cpit252_project\\src\\resources\\1.png"); 
        Image image = imageIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        imageIcon.setImage(image);

        
        // display image
        JLabel imagelable = new JLabel(imageIcon);
        imagelable.setBounds(0, 0, 600, 430); 
        layeredPane.add(imagelable, Integer.valueOf(0));
       
      
        // second image
        ImageIcon imageIcon2 = new ImageIcon("C:\\Users\\msbbr\\OneDrive\\Documents\\NetBeansProjects\\cpit252_project\\src\\resources\\2.png"); 
        Image Image2 = imageIcon2.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        imageIcon2.setImage(Image2);
       
        
        //display output
        JLabel outputLabel = new JLabel(" ");
        outputLabel.setBounds(100, 110, 500, 200); // Adjust position and size for the text
        outputLabel.setForeground(Color.BLACK); // Set text color
        outputLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        layeredPane.add(outputLabel, Integer.valueOf(1));
        
        
        // create button
        JButton invisibleButton = new JButton("make order");
        invisibleButton.setOpaque(false);
        invisibleButton.setContentAreaFilled(false);
        invisibleButton.setBorderPainted(false);
        invisibleButton.setFocusPainted(false);
        invisibleButton.setForeground(Color.WHITE);
        
        //adjust button size and position
        invisibleButton.setBounds(350, 370, 120, 40);
        layeredPane.add(invisibleButton, Integer.valueOf(2));
        
        // create button for add customer
        JButton invisibleButton2 = new JButton("Add Customer");
        invisibleButton2.setOpaque(false);
        invisibleButton2.setContentAreaFilled(false);
        invisibleButton2.setBorderPainted(false);
        invisibleButton2.setFocusPainted(false);
        invisibleButton2.setForeground(Color.WHITE);
        
        //adjust button size and position
        invisibleButton2.setBounds(148, 248, 120, 40);
        layeredPane.add(invisibleButton2, Integer.valueOf(2));
        
        invisibleButton2.addActionListener(new ActionListener() { //if user click the button
          

            @Override
            public void actionPerformed(ActionEvent e) { 
              
                    TailorSystemFacade.addCustomer();
                        
                } 
        });
        
        // back button
        JButton backButton = new JButton("Back");
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(10, 25, 30, 35); // Position the "Back" button differently
        layeredPane.add(backButton, Integer.valueOf(3));
        
        
        invisibleButton.addActionListener(new ActionListener() {
          

            @Override
            public void actionPerformed(ActionEvent e) {
              
                    imagelable.setIcon(imageIcon2);
                    String orderOutput = order.GenerateInvoice();
                    outputLabel.setText("<html>" + orderOutput + "</html>");
                    invisibleButton2.setVisible(false);
                    invisibleButton.setVisible(false);
                    backButton.setVisible(true);
                        
                } 
        });
        
         backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the first image
                imagelable.setIcon(imageIcon);

                // Clear the output label text
                outputLabel.setText("");

                // Show the "Make Order" button and hide the "Back" button
                invisibleButton.setVisible(true);
                backButton.setVisible(false);
            }
            });
        frame.add(layeredPane);
        frame.setVisible(true);
    }
    
}
