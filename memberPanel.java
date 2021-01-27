import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class memberPanel extends JFrame {
    private ImageIcon icon, image;
    private Container c;
    private JTable table;
    private String path;

    private DefaultTableModel model;

    private JLabel titleLabel, firstNameLabel, lastNameLabel, occupationLabel, phonelabel, userNameLabel, passwordLabel,
            profileLabel, bilLabel, dueLabel, creditLabel, utilityLabel, monthlyMealLabel, dailyMealLabel,
            absoluteBilLabel, absentDaysLabel, totalMembersLabel, profilePhoto, individualUtility, indiMonthlyMLabel;

    private JTextField firstNameameTextField, lastNameTextField, occupationTextField, phoneTextField, userNameTextField,
            passwordTextField, profileTextField, billTextField, dueTextField, creditTextField, utilyTextField,
            monthlyMealTextField, dailyMealTextField, absoluteBillTextField, absentDaysTextField, totalMembersTextField,
            individualUtilityTextField, indiMonthlyMTextField;

    private String[] columns = { "First Name", "Last Name", "Occupation", "PhoneNumber", "Username", "Password",
            "ProfilePicturePath", "AbsentDays", "Bill", "DueAmount", "CreditAmount" };

    memberPanel(String path) {
        this.path = path;
        initComponents();
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1530, 800);
        this.setLocationRelativeTo(null);
        this.setTitle("Member Panel");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);

        // this part changes the icon
        icon = new ImageIcon(getClass().getResource("icon3.png"));
        this.setIconImage(icon.getImage());

        Font font = new Font("Arial", Font.BOLD, 16);

        titleLabel = new JLabel("Member Profile Panel");
        titleLabel.setFont(font);
        titleLabel.setBounds(630, 10, 250, 50);
        c.add(titleLabel);

        // table
        table = new JTable();

        TableReader tt5 = new TableReader();
        model = new DefaultTableModel();
        File f = new File(path);
        if (f.length() != 0) {
            model = tt5.createModel(path);
        }
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        // JLabels Start
        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(10, 80, 140, 30);
        firstNameLabel.setFont(font);
        c.add(firstNameLabel);

        firstNameameTextField = new JTextField();
        firstNameameTextField.setBounds(180, 80, 200, 30);
        firstNameameTextField.setFont(font);
        c.add(firstNameameTextField);

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(10, 130, 150, 30);
        lastNameLabel.setFont(font);
        c.add(lastNameLabel);

        lastNameTextField = new JTextField();
        lastNameTextField.setBounds(180, 130, 200, 30);
        lastNameTextField.setFont(font);
        c.add(lastNameTextField);

        occupationLabel = new JLabel("Occupation");
        occupationLabel.setBounds(10, 180, 150, 30);
        occupationLabel.setFont(font);
        c.add(occupationLabel);

        occupationTextField = new JTextField();
        occupationTextField.setBounds(180, 180, 200, 30);
        occupationTextField.setFont(font);
        c.add(occupationTextField);

        phonelabel = new JLabel("Phone Number");
        phonelabel.setBounds(10, 230, 150, 30);
        phonelabel.setFont(font);
        c.add(phonelabel);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(180, 230, 200, 30);
        phoneTextField.setFont(font);
        c.add(phoneTextField);

        userNameLabel = new JLabel("User Name");
        userNameLabel.setBounds(400, 80, 150, 30);
        userNameLabel.setFont(font);
        c.add(userNameLabel);

        userNameTextField = new JTextField();
        userNameTextField.setBounds(650, 80, 200, 30);
        userNameTextField.setFont(font);
        c.add(userNameTextField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(400, 130, 150, 30);
        passwordLabel.setFont(font);
        c.add(passwordLabel);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(650, 130, 200, 30);
        passwordTextField.setFont(font);
        c.add(passwordTextField);

        profileLabel = new JLabel("Profile Pic Path (300X300px)");
        profileLabel.setBounds(400, 180, 230, 30);
        profileLabel.setFont(font);
        c.add(profileLabel);

        profileTextField = new JTextField();
        profileTextField.setBounds(650, 180, 200, 30);
        profileTextField.setFont(font);
        c.add(profileTextField);

        bilLabel = new JLabel("Bill");
        bilLabel.setBounds(400, 230, 150, 30);
        bilLabel.setFont(font);
        c.add(bilLabel);

        billTextField = new JTextField();
        billTextField.setBounds(650, 230, 200, 30);
        billTextField.setFont(font);
        c.add(billTextField);

        absentDaysLabel = new JLabel("Absent Days");
        absentDaysLabel.setBounds(10, 280, 150, 30);
        absentDaysLabel.setFont(font);
        c.add(absentDaysLabel);

        absentDaysTextField = new JTextField();
        absentDaysTextField.setBounds(180, 280, 200, 30);
        absentDaysTextField.setFont(font);
        c.add(absentDaysTextField);

        dueLabel = new JLabel("Due Amount");
        dueLabel.setBounds(10, 330, 150, 30);
        dueLabel.setFont(font);
        c.add(dueLabel);

        dueTextField = new JTextField();
        dueTextField.setBounds(180, 330, 200, 30);
        dueTextField.setFont(font);
        c.add(dueTextField);

        creditLabel = new JLabel("Credit Amount");
        creditLabel.setBounds(400, 280, 150, 30);
        creditLabel.setFont(font);
        c.add(creditLabel);

        creditTextField = new JTextField();
        creditTextField.setBounds(650, 280, 200, 30);
        creditTextField.setFont(font);
        c.add(creditTextField);

        utilityLabel = new JLabel("Utility Bill");
        utilityLabel.setBounds(400, 330, 150, 30);
        utilityLabel.setFont(font);
        c.add(utilityLabel);

        utilyTextField = new JTextField();
        utilyTextField.setBounds(650, 330, 200, 30);
        utilyTextField.setFont(font);
        c.add(utilyTextField);

        monthlyMealLabel = new JLabel("Monthly Meal Charge");
        monthlyMealLabel.setBounds(10, 380, 170, 30);
        monthlyMealLabel.setFont(font);
        c.add(monthlyMealLabel);

        monthlyMealTextField = new JTextField();
        monthlyMealTextField.setBounds(180, 380, 200, 30);
        monthlyMealTextField.setFont(font);
        c.add(monthlyMealTextField);

        dailyMealLabel = new JLabel("Daily Meal Charge");
        dailyMealLabel.setBounds(400, 380, 150, 30);
        dailyMealLabel.setFont(font);
        c.add(dailyMealLabel);

        dailyMealTextField = new JTextField();
        dailyMealTextField.setBounds(650, 380, 200, 30);
        dailyMealTextField.setFont(font);
        c.add(dailyMealTextField);

        absoluteBilLabel = new JLabel("Absolute Bill");
        absoluteBilLabel.setBounds(10, 430, 150, 30);
        absoluteBilLabel.setFont(font);
        c.add(absoluteBilLabel);

        absoluteBillTextField = new JTextField();
        absoluteBillTextField.setBounds(180, 430, 200, 30);
        absoluteBillTextField.setFont(font);
        c.add(absoluteBillTextField);

        individualUtility = new JLabel("Individual Utility Bill");
        individualUtility.setBounds(10, 480, 200, 30);
        individualUtility.setFont(font);
        c.add(individualUtility);

        individualUtilityTextField = new JTextField();
        individualUtilityTextField.setBounds(180, 480, 200, 30);
        individualUtilityTextField.setFont(font);
        c.add(individualUtilityTextField);

        totalMembersLabel = new JLabel("Total Members");
        totalMembersLabel.setBounds(400, 430, 150, 30);
        totalMembersLabel.setFont(font);
        c.add(totalMembersLabel);

        totalMembersTextField = new JTextField();
        totalMembersTextField.setBounds(650, 430, 200, 30);
        totalMembersTextField.setFont(font);
        c.add(totalMembersTextField);

        indiMonthlyMLabel = new JLabel("Individual Monthly Meal Charge");
        indiMonthlyMLabel.setBounds(400, 480, 250, 30);
        indiMonthlyMLabel.setFont(font);
        c.add(indiMonthlyMLabel);

        indiMonthlyMTextField = new JTextField();
        indiMonthlyMTextField.setBounds(650, 480, 200, 30);
        indiMonthlyMTextField.setFont(font);
        c.add(indiMonthlyMTextField);
        // JLabels End

        // JTextField Start
        String fname = model.getValueAt(0, 0).toString();
        String lname = model.getValueAt(0, 1).toString();
        String occu = model.getValueAt(0, 2).toString();
        String phone = model.getValueAt(0, 3).toString();
        String user = model.getValueAt(0, 4).toString();
        String pass = model.getValueAt(0, 5).toString();
        String profile = model.getValueAt(0, 6).toString();
        String absent = model.getValueAt(0, 7).toString();
        String bill = model.getValueAt(0, 8).toString();
        String due = model.getValueAt(0, 9).toString();
        String credit = model.getValueAt(0, 10).toString();

        firstNameameTextField.setText(fname);
        lastNameTextField.setText(lname);
        occupationTextField.setText(occu);
        phoneTextField.setText(phone);
        userNameTextField.setText(user);
        passwordTextField.setText(pass);
        profileTextField.setText(profile);
        absentDaysTextField.setText(absent);
        billTextField.setText(bill);
        dueTextField.setText(due);
        creditTextField.setText(credit);

        int num = table.getRowCount();
        String tnum = String.valueOf(num);
        totalMembersTextField.setText(tnum);

        String aString = reader("absbill.txt");
        absoluteBillTextField.setText(aString);

        String bString = reader("dmc.txt");
        dailyMealTextField.setText(bString);

        String cString = reader("immc.txt");
        indiMonthlyMTextField.setText(cString);

        String dString = reader("indiuti.txt");
        individualUtilityTextField.setText(dString);

        String eString = reader("mmc.txt");
        monthlyMealTextField.setText(eString);

        String fString = reader("utility.txt");
        utilyTextField.setText(fString);

        File imgFile = new File(profile);
        if (imgFile.exists()) {
            image = new ImageIcon(getClass().getResource(profile));
            profilePhoto = new JLabel(image);
            profilePhoto.setBounds(950, 100, 300, 300);
            profilePhoto.setVisible(true);
            c.add(profilePhoto);
        } else {
            profilePhoto = new JLabel("Photo Not Found");
            profilePhoto.setBounds(950, 100, 300, 300);
            profilePhoto.setVisible(true);
            c.add(profilePhoto);
        }

        firstNameameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        occupationTextField.setEditable(false);
        phoneTextField.setEditable(false);
        userNameTextField.setEditable(false);
        passwordTextField.setEditable(false);
        profileTextField.setEditable(false);
        billTextField.setEditable(false);
        dueTextField.setEditable(false);
        creditTextField.setEditable(false);
        utilyTextField.setEditable(false);
        monthlyMealTextField.setEditable(false);
        dailyMealTextField.setEditable(false);
        absoluteBillTextField.setEditable(false);
        absentDaysTextField.setEditable(false);
        totalMembersTextField.setEditable(false);
        individualUtilityTextField.setEditable(false);
        indiMonthlyMTextField.setEditable(false);

        firstNameameTextField.setBackground(Color.GRAY);
        lastNameTextField.setBackground(Color.GRAY);
        occupationTextField.setBackground(Color.GRAY);
        phoneTextField.setBackground(Color.GRAY);
        userNameTextField.setBackground(Color.GRAY);
        passwordTextField.setBackground(Color.GRAY);
        profileTextField.setBackground(Color.GRAY);
        billTextField.setBackground(Color.GRAY);
        dueTextField.setBackground(Color.GRAY);
        creditTextField.setBackground(Color.GRAY);
        utilyTextField.setBackground(Color.GRAY);
        monthlyMealTextField.setBackground(Color.GRAY);
        dailyMealTextField.setBackground(Color.GRAY);
        absoluteBillTextField.setBackground(Color.GRAY);
        absentDaysTextField.setBackground(Color.GRAY);
        totalMembersTextField.setBackground(Color.GRAY);
        individualUtilityTextField.setBackground(Color.GRAY);
        indiMonthlyMTextField.setBackground(Color.GRAY);
        // JTextField End

    }

    public String reader(String str) {
        String text = null;
        BufferedReader txtReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(str)));
        try {
            text = txtReader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return text;
    }
}
