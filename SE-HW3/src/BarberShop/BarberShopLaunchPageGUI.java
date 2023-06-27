package BarberShop;
import javax.swing.*;
import java.awt.*;

public class BarberShopLaunchPageGUI {
    //members:
    private BarberShop _barberShop;
    private JFrame _frame;
    private JPanel _panel;
    private JButton _cashRegisterButton;
    private JButton _CustomersMenuButton;
    private JButton _ServicesMenuButton;
    private JButton _CalendarMenuButton;


    //constructor:
    public BarberShopLaunchPageGUI(BarberShop barberShop) {

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

        //this._panel.setLayout(new FlowLayout());
        this._panel.setLayout(null);

        // Create the buttons
        this.setCashRegisterButton();
        this.setCustomersMenuButton();
        this.setServicesMenuButton();
        this.setCalendarMenuButton();

        // Set the title of the panel
        JLabel titleLabel = new JLabel("Barber's Shop");
        // Set small title
        JLabel smallTitleLabel = new JLabel("By: Chen, Avidan, Shoam & Hadas");

        // Set the title's font
        titleLabel.setFont(new Font("Brush Script", Font.BOLD, 70));
        smallTitleLabel.setFont(new Font("Brush Script", Font.BOLD, 30));

        // Set the title's color
        titleLabel.setForeground(new Color(255, 255, 255));
        smallTitleLabel.setForeground(new Color(255, 255, 255));

        // Set the title's position
        titleLabel.setBounds(295, 0, 500, 100);
        smallTitleLabel.setBounds(280, 55, 600, 100);

        // Set the title's background
        titleLabel.setOpaque(false);
        smallTitleLabel.setOpaque(false);

        // Add the title to the panel
        this._panel.add(titleLabel);
        this._panel.add(smallTitleLabel);
        // add buttons to the panel
        this._panel.add(this._cashRegisterButton);
        this._panel.add(this._CustomersMenuButton);

        this._frame.getContentPane().add(this._panel);

        // Make the frame visible
        this._frame.setVisible(true);
    }


    // Button functions
    private void setCustomersMenuButton() {
        // create the button
        this._CustomersMenuButton = new JButton("Customers Menu");
        // set button font
        this._CustomersMenuButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        this._CustomersMenuButton.setForeground(Color.white);
        this._CustomersMenuButton.setBackground(Color.white);
        this._CustomersMenuButton.setOpaque(false);
        this._CustomersMenuButton.setBorderPainted(false);
        // set button position
        this._CustomersMenuButton.setBounds(400, 360, 350, 50);
        // set the button's listener
        this._CustomersMenuButton.addActionListener(e -> {
            this._frame.getContentPane().removeAll();
            this._frame.getContentPane().repaint();
            this._frame.getContentPane().revalidate();
            this._frame.getContentPane().add(this._panel);
            this._frame.getContentPane().repaint();
            this._frame.getContentPane().revalidate();

            //add functionallity
            System.out.println(this._barberShop.getCustomersList());
        });
        this._panel.add(this._CustomersMenuButton);
    }

    private void setCashRegisterButton() {
        this._cashRegisterButton = new JButton("Cash Register");
        this._cashRegisterButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        this._cashRegisterButton.setForeground(Color.white);
        this._cashRegisterButton.setBackground(Color.white);
        this._cashRegisterButton.setOpaque(false);
        this._cashRegisterButton.setBorderPainted(false);
        // set button position
        this._cashRegisterButton.setBounds(400, 430, 350, 50);
        // set the button's listener
        this._cashRegisterButton.addActionListener(e -> {
            this._frame.getContentPane().removeAll();
            this._frame.getContentPane().repaint();
            this._frame.getContentPane().revalidate();
            this._frame.getContentPane().add(this._panel);
            this._frame.getContentPane().repaint();
            this._frame.getContentPane().revalidate();

            //add functionallity
            System.out.println(this._barberShop.getCashRegister());
        });
        this._panel.add(this._cashRegisterButton);
    }

    private void setServicesMenuButton() {
        this._ServicesMenuButton = new JButton("Services Menu");
        this._ServicesMenuButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        this._ServicesMenuButton.setForeground(Color.white);
        this._ServicesMenuButton.setBackground(Color.white);
        this._ServicesMenuButton.setOpaque(false);
        this._ServicesMenuButton.setBorderPainted(false);
        // set button position
        this._ServicesMenuButton.setBounds(400, 500, 350, 50);
        // set the button's listener
        this._ServicesMenuButton.addActionListener(e -> {
            this._frame.getContentPane().removeAll();
            this._frame.getContentPane().repaint();
            this._frame.getContentPane().revalidate();
            this._frame.getContentPane().add(this._panel);
            this._frame.getContentPane().repaint();
            this._frame.getContentPane().revalidate();

            //add functionallity
            System.out.println(this._barberShop.getServiceList());
        });
        this._panel.add(this._ServicesMenuButton);
    }


    private void setCalendarMenuButton() {
        this._CalendarMenuButton = new JButton("Calendar Menu");
        this._CalendarMenuButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        this._CalendarMenuButton.setForeground(Color.white);
        this._CalendarMenuButton.setBackground(Color.white);
        this._CalendarMenuButton.setOpaque(false);
        this._CalendarMenuButton.setBorderPainted(false);
        // set button position
        this._CalendarMenuButton.setBounds(400, 570, 350, 50);
        // set the button's listener
        this._CalendarMenuButton.addActionListener(e -> {
            this._frame.getContentPane().removeAll();
            this._frame.getContentPane().repaint();
            this._frame.getContentPane().revalidate();
            this._frame.getContentPane().add(this._panel);
            this._frame.getContentPane().repaint();
            this._frame.getContentPane().revalidate();

            //add functionallity
            System.out.println(this._barberShop.getCalendar());
        });
        this._panel.add(this._CalendarMenuButton);
    }


    private void setFrame()
    {
        this._frame = new JFrame("Barber Shop");
        // Set the frame's default close operation to exit on close
        this._frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the frame's size to 1000x667
        this._frame.setSize(1000, 667);
        // Set the frame's layout to border layout
        this._frame.setLayout(new BorderLayout());

        // Set the frame to be not resizable
        this._frame.setResizable(false);
    }

    //main function:
    public static void main(String[] args) {
        BarberShop barberShop = new BarberShop();

        BarberShopLaunchPageGUI gui = new BarberShopLaunchPageGUI(barberShop);
    }

}
