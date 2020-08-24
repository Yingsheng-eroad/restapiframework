package apiConfig;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

    public Map<String, String> defaultHeaders(){
        Map<String,String>defaultHeaders= new HashMap<String,String>();

        defaultHeaders.put("Content-Type","application/json");
        defaultHeaders.put("Accept","application/json");

        return defaultHeaders;

    }
    public static void main(String[]args)
    {
        HeaderConfigs hed=new HeaderConfigs();
        System.out.println(hed.defaultHeaders());
    }
}
