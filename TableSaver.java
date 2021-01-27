import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JTable;

/**
 * Jtabletxt
 */
public class TableSaver {
    JTable table;

    TableSaver(JTable table) {
        this.table = table;
    }

    public void saveTable(String s) throws Exception {
        File file = new File(s);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bfw = new BufferedWriter(fw);
        for (int i = 0; i < table.getColumnCount(); i++) {
            bfw.write(table.getColumnName(i));
            bfw.write("\t");
        }

        for (int i = 0; i < table.getRowCount(); i++) {
            bfw.newLine();
            for (int j = 0; j < table.getColumnCount(); j++) {
                bfw.write((String) (table.getValueAt(i, j)));
                bfw.write("\t");
            }
        }
        bfw.close();
    }
}