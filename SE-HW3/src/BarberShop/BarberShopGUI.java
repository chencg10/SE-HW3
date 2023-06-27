package BarberShop;
import javax.swing.*;
import java.awt.*;

public class BarberShopGUI {
    //members:
    private BarberShop _barberShop;
    private JFrame _frame;
    private JPanel _panel;
    private JButton _cashRegisterButton;
    private JButton _CustomersMenuButton;
    private JButton _ServicesMenuButton;
    private JButton _CalendarMenuButton;


    //constructor:
    public BarberShopGUI(BarberShop barberShop) {

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

        this._panel.setLayout(new FlowLayout());

        // Create the buttons
        this.setCashRegisterButton();
        this.setCustomersMenuButton();

        // Set the title of the panel
        JLabel titleLabel = new JLabel("Barber Shop");
        titleLabel.setFont(new Font("MV Boli", Font.PLAIN, 30));
        // Set the title's color to brown
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(false);
        //this._frame.add(titleLabel, BorderLayout.NORTH);
        this._panel.add(titleLabel);
        // add buttons to the panel
        this._panel.add(this._cashRegisterButton, BorderLayout.EAST);
        this._panel.add(this._CustomersMenuButton, BorderLayout.EAST);

        this._frame.getContentPane().add(this._panel);

        // Make the frame visible
        this._frame.setVisible(true);
    }

    private void setCustomersMenuButton() {
        this._CustomersMenuButton = new JButton("Customers Menu");
        this._CustomersMenuButton.setFont(new Font("MV Boli", Font.PLAIN, 16));
        this._CustomersMenuButton.setForeground(Color.white);
        this._CustomersMenuButton.setBackground(Color.white);
        this._CustomersMenuButton.setOpaque(false);
        this._CustomersMenuButton.setBorderPainted(false);
        // set button position
        this._CustomersMenuButton.setBounds(0, 0, 50, 25);
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
        this._cashRegisterButton.setFont(new Font("MV Boli", Font.PLAIN, 16));
        this._cashRegisterButton.setForeground(Color.white);
        this._cashRegisterButton.setBackground(Color.white);
        this._cashRegisterButton.setOpaque(false);
        this._cashRegisterButton.setBorderPainted(false);
        // set button position
        this._cashRegisterButton.setBounds(0, 25, 50, 25);
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

        BarberShopGUI gui = new BarberShopGUI(barberShop);
    }

}
