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
//        database db = new database();
//        db.addSampleEvents();
//
         Scanner input = new Scanner(System.in);
         System.out.println("Enter the username");
         String user = input.next();
         System.out.println("Enter the password");
         String pass = input.next();
        Login loin = new proxyLogin(user, pass);
        TailorSystemFacade TailorSystemFacade = loin.login();
        //TailorSystemFacade TailorSystemFacade = new TailorSystemFacade();
        
//        PricingSevice Pricingsevice = new PricingSevice();
//                Pricingsevice.calculatePricing();
//
//        DeliveryDateSevice deliveryDateSevice = new DeliveryDateSevice();
    //-------------------------------Strategy pattern and Decorator pattern for price and date -----------------------
   
//        Scanner input = new Scanner(System.in);

        
          
          
        //get price info from PricingAndDeliveryDateService facade
        //double finalPrice = pricingService.getFinalPrice();
        //LocalDate deliveryDate = pricingService.getDeliveryDate();
        //String garmentType = pricingService.getGarmentType();
        //String fabricType = pricingService.getFabricType();
        
        //------------------------------------------Builder design pattern for make order------------------------------------------------------------------------------
        //get invoice from OrderService facade
        
        
          //String invoice = TailorSystemFacade.makeOrder();
//        OrderBuilder orderBuilder = new Invoice();
//        OrderDirector orderDirector = new OrderDirector(orderBuilder);
//        orderDirector.makeOrder(customer, fabricType, garmentType, deliveryDate, finalPrice);
//        Order order = orderDirector.getOrder();
        //System.out.println(order.GenerateInvoice());
        
       
       
        //--------------------------------------------------------------
        
        
        
        //------------------------------------------display output in interface-------------------------------------------------------
        
        JFrame frame = new JFrame("Touch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 470);
      
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 600, 430);
        
        
        // use your paths, note: images are in (resourse) folder
        ImageIcon imageIcon = new ImageIcon("/Users/rafarezqallah/NetBeansProjects/cpit252_project/src/resources/1.png"); 
        Image image = imageIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        imageIcon.setImage(image);

        
        // display image
        JLabel imagelable = new JLabel(imageIcon);
        imagelable.setBounds(0, 0, 600, 440); 
        layeredPane.add(imagelable, Integer.valueOf(0));
       
      
        // second image
        ImageIcon imageIcon2 = new ImageIcon("/Users/rafarezqallah/NetBeansProjects/cpit252_project/src/resources/2.png"); 
        Image Image2 = imageIcon2.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        imageIcon2.setImage(Image2);
       
        
        //display output
        JLabel outputLabel = new JLabel(" ");
        outputLabel.setBounds(100, 110, 500, 200); // Adjust position and size for the text
        outputLabel.setForeground(Color.BLACK); // Set text color
        outputLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
        layeredPane.add(outputLabel, Integer.valueOf(1));
        
        
        // create button for make order
        JButton makeOrderButton = new JButton("          ");
        makeOrderButton.setOpaque(false);
        makeOrderButton.setContentAreaFilled(false);
        makeOrderButton.setBorderPainted(false);
        makeOrderButton.setFocusPainted(false);
        makeOrderButton.setForeground(Color.WHITE);
        //adjust button size and position
        makeOrderButton.setBounds(350, 375, 120, 40);
        layeredPane.add(makeOrderButton, Integer.valueOf(2));
        
        // create button for add customer
        JButton customerButton = new JButton("          ");
        customerButton.setOpaque(false);
        customerButton.setContentAreaFilled(false);
        customerButton.setBorderPainted(false);
        customerButton.setFocusPainted(false);
        customerButton.setForeground(Color.WHITE);
         //adjust button size and position
        customerButton.setBounds(135, 260, 120, 40);
        layeredPane.add(customerButton, Integer.valueOf(2));
        
        // create button for delivery date
         JButton dateButton= new JButton("          ");
        dateButton.setOpaque(false);
        dateButton.setContentAreaFilled(false);
        dateButton.setBorderPainted(false);
        dateButton.setFocusPainted(false);
        dateButton.setForeground(Color.WHITE);
        dateButton.setBounds(193, 352, 120, 40);
        layeredPane.add(dateButton, Integer.valueOf(2));
        
        // create button for Pricing
          JButton priceButton= new JButton("          ");
        priceButton.setOpaque(false);
        priceButton.setContentAreaFilled(false);
        priceButton.setBorderPainted(false);
        priceButton.setFocusPainted(false);
        priceButton.setForeground(Color.WHITE);
        priceButton.setBounds(411, 253, 120, 40);
        layeredPane.add(priceButton, Integer.valueOf(2));
        
        
      
        
        //if user click the add customer button
        customerButton.addActionListener(new ActionListener() { 
          

            @Override
            public void actionPerformed(ActionEvent e) { 
              
                    TailorSystemFacade.addCustomer();
                        
                } 
        });
        
        //if user click the delivery date button
        dateButton.addActionListener(new ActionListener() { 
          

            @Override
            public void actionPerformed(ActionEvent e) { 
              
                    TailorSystemFacade.calculateDeliveryDate();
                        
                } 
        });
        
        //if user click the pricing button
        priceButton.addActionListener(new ActionListener() { 
          

            @Override
            public void actionPerformed(ActionEvent e) { 
              
                    TailorSystemFacade.calculatePricing();
                        
                } 
        });
        
        // create button for back 
        JButton backButton = new JButton("Back");
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(10, 25, 30, 35); // Position the "Back" button differently
        layeredPane.add(backButton, Integer.valueOf(3));
        
          backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the first image
                imagelable.setIcon(imageIcon);

                // Clear the output label text
                outputLabel.setText("");

                // Show the "Make Order" button and hide the "Back" button
                makeOrderButton.setVisible(true);
                backButton.setVisible(false);
            }
            });
        
        makeOrderButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              
                    imagelable.setIcon(imageIcon2);
                    String orderOutput = TailorSystemFacade.makeOrder();
                    outputLabel.setText("<html>" + orderOutput + "</html>");
                    customerButton.setVisible(false);
                    makeOrderButton.setVisible(false);
                    backButton.setVisible(true);
                        
                } 
        });
        frame.add(layeredPane);
        frame.setVisible(true);
    }
    
}
