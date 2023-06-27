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
        this._frame = new JFrame("Barber Shop");
        this._frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this._frame.setSize(1000, 667);
        this._frame.setLayout(new BorderLayout());
        this._frame.setResizable(false);

        // Create a background image
        ImageIcon background = new ImageIcon("src/BarberShop/BarberBackround.jpeg");
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        this._frame.add(backgroundLabel, BorderLayout.CENTER);

        // Create an icon for the frame
        ImageIcon icon = new ImageIcon("src/BarberShop/BarberIcon.jpeg");
        this._frame.setIconImage(icon.getImage());

        // Set the title
        JLabel titleLabel = new JLabel("Barber Shop");
        titleLabel.setFont(new Font("MV Boli", Font.PLAIN, 30));
        titleLabel.setForeground(new Color(150,75,0));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(false);
        this._frame.add(titleLabel, BorderLayout.NORTH);

        // Make the frame visible
        this._frame.setVisible(true);
    }

    //main function:
    public static void main(String[] args) {
        BarberShop barberShop = new BarberShop();
        BarberShopGUI gui = new BarberShopGUI(barberShop);
    }

}
