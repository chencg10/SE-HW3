package BarberShop;
import javax.swing.*;
import java.awt.*;

public class BarberShopGUI {
    //members:
    private BarberShop _barberShop;
    private JFrame _frame;


    //constructor:
    public BarberShopGUI(BarberShop barberShop) {

        this._barberShop = barberShop;
        // Create the frame
        this._frame = new JFrame("Barber Shop");
        // Set the frame's default close operation to exit on close
        this._frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the frame's size to 1000x667
        this._frame.setSize(1000, 667);
        // Set the frame's layout to border layout
        this._frame.setLayout(new BorderLayout());

        // Set the frame to be not resizable
        this._frame.setResizable(false);

        // Create a background image
//        ImageIcon background = new ImageIcon("src/BarberShop/BarberBackround.jpeg");
//        // Create a label for the background image
//        JLabel backgroundLabel = new JLabel(background);
//        backgroundLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
//        this._frame.add(backgroundLabel, BorderLayout.CENTER);

        // Create a JPanel with a custom background color or image
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                 ImageIcon imageIcon = new ImageIcon("src/BarberShop/BarberBackround.jpeg");
                 Image image = imageIcon.getImage();
                 g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        panel.setLayout(new FlowLayout());

        // Set the title of the panel
        JLabel titleLabel = new JLabel("Barber Shop");
        titleLabel.setFont(new Font("MV Boli", Font.PLAIN, 30));
        // Set the title's color to brown
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(false);
        //this._frame.add(titleLabel, BorderLayout.NORTH);
        panel.add(titleLabel);
        this._frame.getContentPane().add(panel);

        // Make the frame visible
        this._frame.setVisible(true);
    }

    //main function:
    public static void main(String[] args) {
        BarberShop barberShop = new BarberShop();
        BarberShopGUI gui = new BarberShopGUI(barberShop);
    }

}
