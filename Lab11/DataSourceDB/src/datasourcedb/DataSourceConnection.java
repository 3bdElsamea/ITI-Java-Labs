
package datasourcedb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class DataSourceConnection {
    public static void main(String[] args) {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("ITI.properties");
            prop.setProperty("BD_URL", "jdbc:mysql://localhost:3306/ITI");
            prop.setProperty("BD_USERNAME", "root");
            prop.setProperty("BD_PASSWORD", "");
            prop.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
