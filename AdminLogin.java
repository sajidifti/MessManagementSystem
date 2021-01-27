import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminLogin extends JFrame implements ActionListener {

    private ImageIcon icon;
    private Container c;// container to change background color
    private JLabel userLabel, passLabel;
    private JTextField tf1;
    private JButton bt1, bt2;
    private JPasswordField pf;
    private Font f;

    AdminLogin() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setTitle("Admin Login");
        initComponents();
    }

    private void initComponents() {
        // this part changes the bg color
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);

        // font
        f = new Font("Arial", Font.BOLD, 16);

        // this part changes the icon
        icon = new ImageIcon(getClass().getResource("icon2.png"));
        this.setIconImage(icon.getImage());

        // this part creates JLabel
        userLabel = new JLabel();
        userLabel.setText("Enter Username");
        userLabel.setBounds(50, 20, 200, 50);
        userLabel.setFont(f);
        c.add(userLabel);

        // text field
        tf1 = new JTextField();
        tf1.setBounds(240, 20, 200, 50);
        tf1.setFont(f);
        c.add(tf1);

        // password
        passLabel = new JLabel("Enter Your Password");
        passLabel.setBounds(50, 80, 2000, 50);
        passLabel.setFont(f);
        c.add(passLabel);

        // password field
        pf = new JPasswordField();
        pf.setBounds(240, 80, 200, 50);
        pf.setFont(f);
        c.add(pf);

        // Login button
        bt1 = new JButton("Login");
        bt1.setBounds(100, 150, 100, 50);
        bt1.setFont(f);
        c.add(bt1);
        bt1.addActionListener(this);

        // clear button
        bt2 = new JButton("Clear");
        bt2.setBounds(300, 150, 100, 50);
        bt2.setFont(f);
        c.add(bt2);
        bt2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource().equals(bt1)) {
            String userName = tf1.getText();
            String password = pf.getText();

            Scanner scan = null;
            try {
                scan = new Scanner(new File("admininfo.txt"));
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            String user = scan.nextLine();
            String pass = scan.nextLine();

            if (userName.equals(user) && password.equals(pass)) {
                dispose();
                String Data2 = "Data2.txt";
                String absbill = "absbill.txt";
                String dmc = "dmc.txt";
                String immc = "immc.txt";
                String indiuti = "indiuti.txt";
                String mmc = "mmc.txt";
                String utility = "utility.txt";
                AdminPanel frame = new AdminPanel(Data2, absbill, dmc, immc, indiuti, mmc, utility);
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        } else if (e.getSource().equals(bt2)) {
            tf1.setText("");
            pf.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error Warning", JOptionPane.ERROR_MESSAGE);
        }

    }

}
