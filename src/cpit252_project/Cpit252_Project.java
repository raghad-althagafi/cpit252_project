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
//        
//        CustomerService customerService = new CustomerService(); 
//        Login L = new proxyLogin("raghad", "raghad");
//        TailorSystemFacade TailorSystemFacade = L.login();
        
        //TailorSystemFacade.addCustomer(); //add customer service
        //TailorSystemFacade.login();
        
        
        //-------------------------
        
          
        
//        ----------------------------------Strategy pattern and Decorator pattern for price and date -----------------------
   
        Scanner input = new Scanner(System.in);

        CustomerService cus= new CustomerService();
        Customer customer = cus.addCustomer();
        //Customer newCustomer = addCustomerDisplay(input);
          // Get user input
        System.out.println("Enter garment type (e.g., 'dress', 'blouse', 'skirt'):");
        String garmentType = input.nextLine();

        System.out.println("Enter fabric type (e.g., 'cotton', 'silk', 'tulle'):");
        String fabricType = input.nextLine();

        System.out.println("Enter the number of meters required:");
        double meter = input.nextDouble();

        System.out.println("Is the order urgent? yes=1 / no=2");
        int isUrgentChoice = input.nextInt();
        boolean isUrgent = (isUrgentChoice == 1);

        // Standard Pricing Strategy
        PricingStrategy pricingStrategy = new StandardPricingStrategy();

        // Calculate delivery date
        DeliveryDate deliveryDateCalculator = new CalculateDate();
        if (isUrgent) {
            // Apply the Rush Date Decorator for urgent orders
            RushDateDecorator rushDecorator = new RushDateDecorator(deliveryDateCalculator, 2); // e.g., 2 days rush
            deliveryDateCalculator = rushDecorator;  // Use the decorated calculator
            pricingStrategy = new UrgentPricingStrategy(rushDecorator); // Apply Urgent Pricing Strategy
        }

        // Create Price Context and calculate the price
        PriceContext priceContext = new PriceContext(pricingStrategy);
        double finalPrice = priceContext.executePricingStrategy(garmentType, meter, fabricType);

        // Calculate delivery date
        System.out.println("Enter the Expected production date");
        int expectedProduction_days =input.nextInt();
        LocalDate deliveryDate = deliveryDateCalculator.calculateDeliveryDate(expectedProduction_days);
   
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
        frame.setSize(600, 430);
      
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 600, 430);
        
        
        // use your paths, note: images are in (resourse) folder
        ImageIcon imageIcon = new ImageIcon("/Users/rafarezqallah/NetBeansProjects/cpit252_project/src/resources/1.png"); 
        Image image = imageIcon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        imageIcon.setImage(image);

        
        // display image
        JLabel imagelable = new JLabel(imageIcon);
        imagelable.setBounds(0, 0, 600, 430); 
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
        
        
        // create button
        JButton invisibleButton = new JButton("make order");
        invisibleButton.setOpaque(false);
        invisibleButton.setContentAreaFilled(false);
        invisibleButton.setBorderPainted(false);
        invisibleButton.setFocusPainted(false);
        invisibleButton.setForeground(Color.WHITE);
        
        //adjust button size and position
        invisibleButton.setBounds(350, 350, 120, 40);
        layeredPane.add(invisibleButton, Integer.valueOf(2));
        
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
