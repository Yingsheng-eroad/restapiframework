package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class FileAndEnv {

    public static Properties propMain=new Properties();
    private static final FileAndEnv INSTANCE = new FileAndEnv();

    private FileAndEnv() {

    }
    {
        String environment= System.getProperty("env");

        try{
            Properties prop = new Properties();
            String propFileName = environment+".config.properties";
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
             prop.load(inputStream);
            } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value
            propMain=prop;

        }catch(Exception e){
         System.out.println("FileNotFoundException");
        }

     }
   public String getServerUrl(){
       return propMain.getProperty("ServerUrl");
   }
    public static FileAndEnv getInstance() {
        return INSTANCE;
    }
}
