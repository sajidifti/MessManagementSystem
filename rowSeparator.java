import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JTable;

public class rowSeparator {
    JTable table;

    rowSeparator(JTable table) {
        this.table = table;
    }

    public void separate(String s, int a, int b) throws Exception {
        File file = new File(s);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bfw = new BufferedWriter(fw);
        for (int i = 0; i < table.getRowCount(); i++) {
            int count = 0;
            for (int j = a; j <= b; j++) {
                bfw.write((String) (table.getValueAt(i, j)));
                count++;
                if(a<b && count==1) {
                    bfw.write(",");
                }
            }
            bfw.newLine();
        }
        bfw.close();
    }
}
