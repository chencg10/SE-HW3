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
        this._frame.setLayout(null);

        // Create a JPanel as the content pane with a layered layout
        //JPanel contentPane = new JPanel(new BorderLayout());

        // Create a background image label
        ImageIcon background = new ImageIcon("src/BarberShop/BarberBackround.jpeg");
        JLabel backgroundLabel = new JLabel(background);

        // Create a title label
        JLabel titleLabel = new JLabel("Barber Shop");
        titleLabel.setFont(new Font("MV Boli", Font.PLAIN, 30));
        // Set the foreground color to white
        titleLabel.setForeground(Color.WHITE);
        //move the title to the center-top of the screen:
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setBounds(0, 0, 1000, 100);


        // Set the layout manager for the content pane
        //contentPane.setLayout(new OverlayLayout(contentPane));

        // Add the background and title labels to the content pane
        //contentPane.add(backgroundLabel);
        //contentPane.add(titleLabel);


        // Set the content pane on the frame
        //this._frame.setContentPane(contentPane);
        this._frame.add(backgroundLabel);
        this._frame.add(titleLabel);

        // Create an icon for the frame
        ImageIcon icon = new ImageIcon("src/BarberShop/BarberIcon.jpeg");
        this._frame.setIconImage(icon.getImage());

        // Make the frame visible
        this._frame.setVisible(true);
    }

    //main function:
    public static void main(String[] args) {
        BarberShop barberShop = new BarberShop();
        BarberShopGUI gui = new BarberShopGUI(barberShop);
    }

}
