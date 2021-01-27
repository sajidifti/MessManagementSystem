import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class memberDataSeparator {

    private JTable table;
    private DefaultTableModel model;
    private String[] columns = { "First Name", "Last Name", "Occupation", "PhoneNumber", "Username", "Password",
            "ProfilePicturePath", "AbsentDays", "Bill", "DueAmount", "CreditAmount" };

    private String[] rows = new String[11];


    public void dataSeparate(int a){

        table = new JTable();

        TableReader tt5 = new TableReader();
        model = new DefaultTableModel();
        File f = new File("Data2.txt");
        if (f.length() != 0) {
            model = tt5.createModel("Data2.txt");
        }
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        memberTable mt = new memberTable(table);
        
        try {
            mt.saveTable("member.txt", a - 1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
