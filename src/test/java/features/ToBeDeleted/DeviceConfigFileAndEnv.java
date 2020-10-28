package features.ToBeDeleted;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class DeviceConfigFileAndEnv {
    public static Properties propMain = new Properties();
    private static final DeviceConfigFileAndEnv INSTANCE = new DeviceConfigFileAndEnv();

    private DeviceConfigFileAndEnv() {

    }

    {
        String environment = System.getProperty("env");

        try {
            Properties prop = new Properties();
            String propFileName = environment + ".config.properties";
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value
            propMain = prop;

        } catch (Exception e) {
            System.out.println("FileNotFoundException");
        }


    }
}