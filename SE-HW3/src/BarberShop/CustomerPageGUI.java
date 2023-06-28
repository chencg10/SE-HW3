package BarberShop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class CustomerPageGUI implements ActionListener {

    // members:
    private BarberShop _barberShop;
    private JFrame _frame = new JFrame("Customers Page");
    private JPanel _panel;
    private JButton _backButton = new JButton("Back");

    //Customer object buttons
    private JButton _addCustomerButton = new JButton("Add Customer to the system");
    private JButton _removeCustomerButton = new JButton("Remove Customer from the system");
    private JButton _editCustomerButton = new JButton("Edit Customer details");
    private JButton _showCustomerButton = new JButton("Show Customer details");
    private JButton _showAllCustomersButton = new JButton("Show all Customers");
    private JButton _sortCustomersButton = new JButton("Sort Customers by lexicographic order");

    public static final int FEMALE = 0;
    public static final int MALE = 1;

    // constructor:
    public CustomerPageGUI(BarberShop barberShop) {
        // Set the barber shop
        this._barberShop = barberShop;
        // Create the frame
        this.setFrame();

        // Create a JPanel with a custom background color or image
        this._panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                 ImageIcon imageIcon = new ImageIcon("src/BarberShop/BarberBackround.jpeg");
                 Image image = imageIcon.getImage();
                 g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        JLabel titleLabel = new JLabel("Customers Page");

        // Set the title's font
        titleLabel.setFont(new Font("Brush Script", Font.BOLD, 60));

        // Set the title's color
        titleLabel.setForeground(new Color(255, 255, 255));

        // Set the title's position
        titleLabel.setBounds(295, 0, 500, 100);

        // Set the title's background
        titleLabel.setOpaque(false);

        // Set the back button's position
        this.setBackButton();

        // Set functionality buttons
        this.setAddCustomerButton();
        this.setRemoveCustomerButton();
//        this.setEditCustomerButton();
//        this.setShowCustomerButton();
//        this.setShowAllCustomersButton();
//        this.setSortCustomersButton();



        // Add the title to the panel
        this._panel.add(titleLabel);
        // Add the back button to the panel
        this._panel.add(this._backButton);

        // set the panel's layout
        this._panel.setLayout(null);

        // add the panel to the frame
        this._frame.getContentPane().add(this._panel);
        // set visible
        this._frame.setVisible(true);

    }

    private void setAddCustomerButton() {
        this._addCustomerButton.setFont(new Font("MV Boli", Font.BOLD, 25));
        this._addCustomerButton.setForeground(Color.white);
        this._addCustomerButton.setBackground(Color.white);
        this._addCustomerButton.setOpaque(false);
        this._addCustomerButton.setBorderPainted(false);
        this._addCustomerButton.setFocusable(true);
        // set button position
        this._addCustomerButton.setBounds(340, 400, 450, 50);
        // set the button's listener
        this._addCustomerButton.addActionListener(this);
        // add the button to the panel
        this._panel.add(this._addCustomerButton);
    }

    private void setRemoveCustomerButton() {
        this._removeCustomerButton.setFont(new Font("MV Boli", Font.BOLD, 25));
        this._removeCustomerButton.setForeground(Color.white);
        this._removeCustomerButton.setBackground(Color.white);
        this._removeCustomerButton.setOpaque(false);
        this._removeCustomerButton.setBorderPainted(false);
        this._removeCustomerButton.setFocusable(true);
        // set button position
        this._removeCustomerButton.setBounds(340, 470, 500, 50);
        // set the button's listener
        this._removeCustomerButton.addActionListener(this);
        // add the button to the panel
        this._panel.add(this._removeCustomerButton);
    }


    private void setFrame()
    {
        // Set the frame's default close operation to exit on close
        this._frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the frame's size to 1000x667
        this._frame.setSize(1000, 667);
        // Set the frame to be not resizable
        this._frame.setResizable(false);
    }

    private void setBackButton() {
        this._backButton = new JButton("Back");
        this._backButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        this._backButton.setForeground(Color.white);
        this._backButton.setBackground(Color.white);
        this._backButton.setOpaque(false);
        this._backButton.setBorderPainted(false);
        this._backButton.setFocusable(true);
        // set button position
        this._backButton.setBounds(0, 550, 250, 50);
        // set the button's listener
        this._backButton.addActionListener(this);
    }


    private boolean isValidName(String name)
    {
        int comperName=name.compareTo(" ");
        boolean isSpace = false;
        if(comperName==0)
        {
            isSpace = true;
        }
        //return true only if the name contains only letters
        return name.matches("[a-zA-Z\\s]+") && !isSpace;
    }

    //this function is used to check if the phone number of the customer contain only letters
    private boolean isValidPhoneNumber(String phoneNumber)
    {
        return phoneNumber.matches("\\d+") && phoneNumber.length()==10;
    }

    private boolean isValidCvv(String cvv)
    {
        //return true if the length of the cvv is 3 and contains only number
        return cvv.length()==3 && cvv.matches("\\d+");
    }

    //this function is used to check if the card number is leag
    private boolean isValidCreditCard(String creditCard)
    {
        //return true if the lenght of the cvv is 16 and contains only numbers
        return creditCard.length()==16 && creditCard.matches("\\d+");
    }

    private boolean isValidGender(int gender)
    {
        //set gender - check if gender is valid:
        if(gender != MALE && gender != FEMALE)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this._backButton) {
            this._frame.dispose();
            new BarberShopHomePageGUI(this._barberShop);
        }

        else if (e.getSource() == this._addCustomerButton) {
            // each input will be checked for validity, and it will be asked again if it is invalid
            String name;
            String phoneNumber;
            String creditCardNumber;
            String creditCardCVV;
            String genderStr;
            int gender;

            while (true) {
                // create a pop-up window to ask for the customer's details
                name = JOptionPane.showInputDialog(this._frame, "Enter the customer's name:",
                        "Add Customer", JOptionPane.PLAIN_MESSAGE);
                // check if the name is valid
                if (this.isValidName(name)) {
                    // name is valid, moving to the next input
                    break;
                }
                else {
                    // create a pop-up window to notify the user that the name is invalid
                    JOptionPane.showMessageDialog(this._frame, "Invalid name, please try again: ",
                            "Add Customer", JOptionPane.ERROR_MESSAGE);
                }
            }

            while (true) {
                // update the customer's list
                phoneNumber = JOptionPane.showInputDialog(this._frame, "Enter the customer's phone number:",
                        "Add Customer", JOptionPane.PLAIN_MESSAGE);
                // check if the phone number is valid
                if (this.isValidPhoneNumber(phoneNumber)) {
                    // phone number is valid, moving to the next input
                    break;
                }
                else {
                    // create a pop-up window to notify the user that the phone number is invalid
                    JOptionPane.showMessageDialog(this._frame, "Invalid phone number, please try again: ",
                            "Add Customer", JOptionPane.ERROR_MESSAGE);
                }
            }

            while (true) {
                // add credit card details
                creditCardNumber = JOptionPane.showInputDialog(this._frame, "Enter the customer's credit card number:",
                        "Add Customer", JOptionPane.PLAIN_MESSAGE);
                // check if the credit card number is valid
                if (this.isValidCreditCard(creditCardNumber)) {
                    // credit card number is valid, moving to the next input
                    // Now, CVV
                    creditCardCVV = JOptionPane.showInputDialog(this._frame, "Enter the customer's CVV:",
                            "Add Customer", JOptionPane.PLAIN_MESSAGE);
                    // check if the CVV is valid
                    if (this.isValidCvv(creditCardCVV)) {
                        // CVV is valid, moving to the next input
                        break;
                    }
                    else {
                        // create a pop-up window to notify the user that the CVV is invalid
                        JOptionPane.showMessageDialog(this._frame, "Invalid CVV, please try again: ",
                                "Add Customer", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    // create a pop-up window to notify the user that the credit card number is invalid
                    JOptionPane.showMessageDialog(this._frame, "Invalid credit card number, please try again.",
                            "Add Customer", JOptionPane.ERROR_MESSAGE);
                }
            }

            while(true) {
                // get the customer's gender
                genderStr = JOptionPane.showInputDialog(this._frame, "Please enter your gender: " +
                        "\n(1 - for male, 0 for female)", "Add Customer", JOptionPane.PLAIN_MESSAGE);
                //convert gender to int
                gender = Integer.parseInt(genderStr);
                // validate the gender type
                if (this.isValidGender(gender)) {
                    // gender is valid
                    break;
                }
                else {
                    // create a pop-up window to notify the user that the CVV is invalid
                    JOptionPane.showMessageDialog(this._frame, "Invalid gender, please try again",
                            "Add Customer", JOptionPane.ERROR_MESSAGE);
                }
            }

            // now ask the costumer for the service he wants


            // now, add the customer to the barber shop
            // First, create credit card object
            CreditCard creditCard = new CreditCard(creditCardNumber, creditCardCVV);
            this._barberShop.addCustomer(new Customer(name, phoneNumber, creditCard, gender));
           // check
            System.out.println(this._barberShop.getCustomersList());
        }


        else if (e.getSource() == this._removeCustomerButton) {
            // create a pop-up window to ask for the customer's name
            String name = JOptionPane.showInputDialog(this._frame, "Enter the customer's name:",
                    "Remove Customer", JOptionPane.PLAIN_MESSAGE);
            // check if the name exists in the barber shop customers list
            if (!this._barberShop.isCustomerExists(name)) {
                // create a pop-up window to notify the user that the customer does not exist
                JOptionPane.showMessageDialog(this._frame, "Customer does not exist, please try again.",
                        "Remove Customer", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // get the customer object from the barber shop customers list
            Customer customerToRemove = this._barberShop.getCustomerByName(name);
            // remove the customer from the barber shop
            this._barberShop.removeCustomer(customerToRemove);

            //notify the user that the customer was removed
            JOptionPane.showMessageDialog(this._frame, "Customer was removed successfully.",
                    "Remove Customer", JOptionPane.INFORMATION_MESSAGE);

            // check
            System.out.println(this._barberShop.getCustomersList());
        }



    }
}
