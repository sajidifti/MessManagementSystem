import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.table.DefaultTableModel;

public class TableReader {

    DefaultTableModel createModel(String filePath) {
        DefaultTableModel model = null;

        try {
            BufferedReader txtReader = new BufferedReader(
                    new InputStreamReader(getClass().getResourceAsStream(filePath)));
            String header = txtReader.readLine();
            model = new DefaultTableModel(header.split("\\s+"), 0);
            String line;
            while ((line = txtReader.readLine()) != null) {
                model.addRow(line.split("\\s+"));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return model;
    }
}