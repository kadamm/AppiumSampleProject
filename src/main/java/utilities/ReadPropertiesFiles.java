package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFiles {

    protected static ReadPropertiesFiles readPropertiesFiles;
        Properties properties = new Properties();

        public  ReadPropertiesFiles() {
            try (FileInputStream input = new FileInputStream("src/main/resources/general.properties")) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    public String getConfigurationProperty(String key) {
        return properties.getProperty(key);
    }

    public static ReadPropertiesFiles getPropertyFileInstance() {
            if (readPropertiesFiles == null) {
                readPropertiesFiles = new ReadPropertiesFiles();
            }
            return readPropertiesFiles;
    }


}
