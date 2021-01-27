import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class MainClass extends JFrame implements ActionListener {

    private ImageIcon icon;
    private Container c;// container to change background color
    private JButton bt1, bt2;
    private Font f;

    MainClass() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(520,200);
        this.setLocationRelativeTo(null);
        this.setTitle("Mess Management System || User Login");
        initComponents();//method
    }

    public void initComponents() {
        // this part changes the bg color
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);

        // font
        f = new Font("Arial", Font.BOLD, 16);

        // this part changes the icon
        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        // Login seltion buttons
        bt1 = new JButton("Admin Login");
        bt1.setBounds(50, 50, 200, 50);
        bt1.setFont(f);
        c.add(bt1);
        bt1.addActionListener(this);

        bt2 = new JButton("Member Login");
        bt2.setBounds(260, 50, 200, 50);
        bt2.setFont(f);
        c.add(bt2);
        bt2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bt1)) {
            dispose();
            AdminLogin admin = new AdminLogin();
            admin.setVisible(true);
        } else {
            dispose();
            MemberLogin2 member = new MemberLogin2();
            member.setVisible(true);
        }

    }

    public static void main(String[] args) {
        MainClass frame = new MainClass();
        frame.setVisible(true);
    }

}