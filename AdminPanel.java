import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminPanel extends JFrame implements ActionListener, MouseListener {

    private Container c;
    private JLabel titleLabel, firstNameLabel, lastNameLabel, occupationLabel, phonelabel, userNameLabel, passwordLabel,
            profileLabel, bilLabel, dueLabel, creditLabel, utilityLabel, monthlyMealLabel, dailyMealLabel,
            absoluteBilLabel, absentDaysLabel, totalMembersLabel, profilePhoto, individualUtility, indiMonthlyMLabel;
    private JTextField firstNameameTextField, lastNameTextField, occupationTextField, phoneTextField, userNameTextField,
            passwordTextField, profileTextField, billTextField, dueTextField, creditTextField, utilyTextField,
            monthlyMealTextField, dailyMealTextField, absoluteBillTextField, absentDaysTextField, totalMembersTextField,
            individualUtilityTextField, indiMonthlyMTextField;
    private JButton addButton, updateButton, deleteButton, clearButton, saveButton, calculateButton;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private ImageIcon icon, image;

    private String[] columns = { "First Name", "Last Name", "Occupation", "PhoneNumber", "Username", "Password",
            "ProfilePicturePath", "AbsentDays", "Bill", "DueAmount", "CreditAmount" };
    private String[] rows = new String[11];
    private String Data2, absbill, dmc, immc, indiuti, mmc, utility;

    AdminPanel(String Data2, String absbill, String dmc, String immc, String indiuti, String mmc, String utility) {
        this.Data2 = Data2;
        this.absbill = absbill;
        this.dmc = dmc;
        this.immc = immc;
        this.indiuti = indiuti;
        this.mmc = mmc;
        this.utility = utility;

        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1530, 800);
        this.setLocationRelativeTo(null);
        this.setTitle("Admin Panel");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        // this part changes the icon
        icon = new ImageIcon(getClass().getResource("icon2.png"));
        this.setIconImage(icon.getImage());

        Font font = new Font("Arial", Font.BOLD, 16);

        titleLabel = new JLabel("Member Management Panel");
        titleLabel.setFont(font);
        titleLabel.setBounds(640, 10, 250, 50);
        c.add(titleLabel);

        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(10, 80, 140, 30);
        firstNameLabel.setFont(font);
        c.add(firstNameLabel);

        firstNameameTextField = new JTextField();
        firstNameameTextField.setBounds(180, 80, 200, 30);
        firstNameameTextField.setFont(font);
        c.add(firstNameameTextField);

        addButton = new JButton("Add");
        addButton.setBounds(1300, 80, 100, 30);
        addButton.setFont(font);
        c.add(addButton);

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(10, 130, 150, 30);
        lastNameLabel.setFont(font);
        c.add(lastNameLabel);

        lastNameTextField = new JTextField();
        lastNameTextField.setBounds(180, 130, 200, 30);
        lastNameTextField.setFont(font);
        c.add(lastNameTextField);

        updateButton = new JButton("Update");
        updateButton.setBounds(1300, 130, 100, 30);
        updateButton.setFont(font);
        c.add(updateButton);

        occupationLabel = new JLabel("Occupation");
        occupationLabel.setBounds(10, 180, 150, 30);
        occupationLabel.setFont(font);
        c.add(occupationLabel);

        occupationTextField = new JTextField();
        occupationTextField.setBounds(180, 180, 200, 30);
        occupationTextField.setFont(font);
        c.add(occupationTextField);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(1300, 180, 100, 30);
        deleteButton.setFont(font);
        c.add(deleteButton);

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

        clearButton = new JButton("Clear");
        clearButton.setBounds(1300, 230, 100, 30);
        clearButton.setFont(font);
        c.add(clearButton);

        saveButton = new JButton("Save");
        saveButton.setBounds(1300, 400, 100, 30);
        saveButton.setFont(font);
        c.add(saveButton);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(1273, 330, 150, 30);
        calculateButton.setFont(font);
        c.add(calculateButton);

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        saveButton.addActionListener(this);
        calculateButton.addActionListener(this);

        // table
        table = new JTable();

        TableReader tt5 = new TableReader();
        model = new DefaultTableModel();
        File f = new File(Data2);
        if (f.length() != 0) {
            model = tt5.createModel(Data2);
        }
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setSelectionBackground(Color.green);
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(10, 530, 1500, 200);
        c.add(scroll);

        table.addMouseListener(this);

        int num = table.getRowCount();
        String tnum = String.valueOf(num);
        totalMembersTextField.setText(tnum);
        totalMembersTextField.setEditable(false);

        String aString = reader(absbill);
        absoluteBillTextField.setText(aString);
        absoluteBillTextField.setEditable(false);

        String bString = reader(dmc);
        dailyMealTextField.setText(bString);
        dailyMealTextField.setEditable(false);

        String cString = reader(immc);
        indiMonthlyMTextField.setText(cString);
        indiMonthlyMTextField.setEditable(false);

        String dString = reader(indiuti);
        individualUtilityTextField.setText(dString);
        individualUtilityTextField.setEditable(false);

        String eString = reader(mmc);
        monthlyMealTextField.setText(eString);

        String fString = reader(utility);
        utilyTextField.setText(fString);

        billTextField.setEditable(false);
        dueTextField.setEditable(false);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

        int numberOfRow = table.getSelectedRow();

        String fname = model.getValueAt(numberOfRow, 0).toString();
        String lname = model.getValueAt(numberOfRow, 1).toString();
        String occu = model.getValueAt(numberOfRow, 2).toString();
        String phone = model.getValueAt(numberOfRow, 3).toString();
        String user = model.getValueAt(numberOfRow, 4).toString();
        String pass = model.getValueAt(numberOfRow, 5).toString();
        String profile = model.getValueAt(numberOfRow, 6).toString();
        String absent = model.getValueAt(numberOfRow, 7).toString();
        String bill = model.getValueAt(numberOfRow, 8).toString();
        String due = model.getValueAt(numberOfRow, 9).toString();
        String credit = model.getValueAt(numberOfRow, 10).toString();

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

        //try {
            //File imgFile = new File(profile);
            //image = new ImageIcon(getClass().getResource(profile));

            //if (imgFile.exists()) {
                //profilePhoto = new JLabel(image);
                //profilePhoto.setBounds(950, 100, 300, 300);
                //profilePhoto.setVisible(true);
                //c.add(profilePhoto);
            //} else {
                //profilePhoto = new JLabel("Photo Not Found");
                //profilePhoto.setBounds(950, 100, 300, 300);
                //profilePhoto.setVisible(true);
                //c.add(profilePhoto);
            //}
        //} catch (Exception e5Exception) {
            // TODO: handle exception
            //JOptionPane.showMessageDialog(null, "Error");
        //}
        
        try {
            File imgFile = new File(profile);
           
            if(profilePhoto!=null){

                c.remove(profilePhoto);
            }

            if (imgFile.exists()) {
                image = new ImageIcon(getClass().getResource(profile));
                profilePhoto = new JLabel(image);
                profilePhoto.setBounds(950, 100, 300, 300);
                profilePhoto.setVisible(true);
                c.add(profilePhoto);
                revalidate();
                repaint();
            } else {
                profilePhoto = new JLabel("Photo Not Found");
                profilePhoto.setBounds(950, 100, 300, 300);
                profilePhoto.setVisible(true);
                c.add(profilePhoto);
                revalidate();
                repaint();
            }
        } catch (Exception e5Exception) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Error Error");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    // Action Listener
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == addButton) {
            rows[0] = firstNameameTextField.getText();
            rows[1] = lastNameTextField.getText();
            rows[2] = occupationTextField.getText();
            rows[3] = phoneTextField.getText();
            rows[4] = userNameTextField.getText();
            rows[5] = passwordTextField.getText();
            rows[6] = profileTextField.getText();
            rows[7] = absentDaysTextField.getText();
            if (billTextField.getText() == null || dueTextField.getText() == null || creditTextField == null) {
                int z = 0;
                rows[8] = String.valueOf(z);
                rows[9] = String.valueOf(z);
                rows[10] = String.valueOf(z);
            } else {
                rows[8] = billTextField.getText();
                rows[9] = dueTextField.getText();
                rows[10] = creditTextField.getText();
            }

            model.addRow(rows);

            int n = table.getRowCount();
            String tn = String.valueOf(n);
            totalMembersTextField.setText(tn);

        } else if (e.getSource() == updateButton) {
            update();
        } else if (e.getSource() == deleteButton) {
            int numberOfRow = table.getSelectedRow();
            if (numberOfRow >= 0) {
                model.removeRow(numberOfRow);
            } else {
                JOptionPane.showMessageDialog(null, "No row exists or has been selected");
            }

            int n = table.getRowCount();
            String tn = String.valueOf(n);
            totalMembersTextField.setText(tn);

        } else if (e.getSource() == clearButton) {
            firstNameameTextField.setText("");
            lastNameTextField.setText("");
            occupationTextField.setText("");
            phoneTextField.setText("");
            userNameTextField.setText("");
            passwordTextField.setText("");
            profileTextField.setText("");
            absentDaysTextField.setText("");
            billTextField.setText("");
            dueTextField.setText("");
            creditTextField.setText("");
        } else if (e.getSource() == saveButton) {
            TableSaver save = new TableSaver(table);
            try {
                savetxt(mmc, monthlyMealTextField.getText());
                savetxt(absbill, absoluteBillTextField.getText());
                savetxt(indiuti, individualUtilityTextField.getText());
                savetxt(immc, indiMonthlyMTextField.getText());
                savetxt(dmc, dailyMealTextField.getText());
                savetxt(utility, utilyTextField.getText());
            } catch (IOException e2) {
                // TODO Auto-generated catch block
                e2.printStackTrace();
            }
            try {
                save.saveTable(Data2);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // userpass
            rowSeparator userPass = new rowSeparator(table);
            try {
                userPass.separate("userPass.txt", 4, 5);
            } catch (Exception ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, "Saving Successful");
        } else if (e.getSource() == calculateButton) {
            try {
                int ad = Integer.parseInt(absentDaysTextField.getText());
                int mmc2 = Integer.parseInt(monthlyMealTextField.getText());
                int ca = Integer.parseInt(creditTextField.getText());
                int ub = Integer.parseInt(utilyTextField.getText());
                int tm = Integer.parseInt(totalMembersTextField.getText());

                int immc2 = mmc2 / tm;
                int dmc2 = immc2 / 30;
                int iub = ub / tm;
                int ab = 3250 + immc2 + iub;
                int b = ab - dmc2 * ad;
                int d = b - ca;

                dueTextField.setText(String.valueOf(d));
                absoluteBillTextField.setText(String.valueOf(ab));
                indiMonthlyMTextField.setText(String.valueOf(immc2));
                individualUtilityTextField.setText(String.valueOf(iub));
                billTextField.setText(String.valueOf(b));
                dailyMealTextField.setText(String.valueOf(dmc2));

                update();
            } catch (Exception ec) {
                // TODO: handle exception
                JOptionPane.showMessageDialog(null, "Could not calculate");
                ec.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Something Went Wrong", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update() {
        int numberOfRow = table.getSelectedRow();

        String fname = firstNameameTextField.getText();
        String lname = lastNameTextField.getText();
        String occu = occupationTextField.getText();
        String phone = phoneTextField.getText();
        String user = userNameTextField.getText();
        String pass = passwordTextField.getText();
        String profile = profileTextField.getText();
        String absent = absentDaysTextField.getText();
        String bill = billTextField.getText();
        String due = dueTextField.getText();
        String credit = creditTextField.getText();

        model.setValueAt(fname, numberOfRow, 0);
        model.setValueAt(lname, numberOfRow, 1);
        model.setValueAt(occu, numberOfRow, 2);
        model.setValueAt(phone, numberOfRow, 3);
        model.setValueAt(user, numberOfRow, 4);
        model.setValueAt(pass, numberOfRow, 5);
        model.setValueAt(profile, numberOfRow, 6);
        model.setValueAt(absent, numberOfRow, 7);
        model.setValueAt(bill, numberOfRow, 8);
        model.setValueAt(due, numberOfRow, 9);
        model.setValueAt(credit, numberOfRow, 10);
    }

    public void savetxt(String s, String s2) throws IOException {
        File txtFile = new File(s);
        FileWriter fWriter = new FileWriter(txtFile);
        BufferedWriter bWriter = new BufferedWriter(fWriter);
        bWriter.write(s2);
        bWriter.close();
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
