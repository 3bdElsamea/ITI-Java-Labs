
package datasourcedb;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;

public class DataSourceFactory {
    public static DataSource getMySQLDataSource() {
        Properties prop = new Properties();
        FileInputStream input = null;
        MysqlDataSource ds = null;
        try {
            input = new FileInputStream("ITI.properties");
            prop.load(input);
            ds = new MysqlDataSource();
            ds.setURL(prop.getProperty("BD_URL"));
            ds.setUser(prop.getProperty("BD_USERNAME"));
            ds.setPassword(prop.getProperty("BD_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ds;
    }
}
