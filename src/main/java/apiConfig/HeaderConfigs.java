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
    public Map<String, String> invalidHeaders(){
        Map<String,String>defaultHeaders= new HashMap<String,String>();

        defaultHeaders.put("Content-Types","applications/json");
        defaultHeaders.put("Accept","application/json");

        return defaultHeaders;

    }
    public Map<String, String> nullContentTypeHeaders(){
        Map<String,String>defaultHeaders= new HashMap<String,String>();

        defaultHeaders.put("Content-Types","");
        defaultHeaders.put("Accept","application/json");

        return defaultHeaders;

    }
    public Map<String, String> nullKeyHeaders(){
        Map<String,String>defaultHeaders= new HashMap<String,String>();

        defaultHeaders.put("Content-Types","application/json");
        defaultHeaders.put("","application/json");

        return defaultHeaders;

    }
    public static void main(String[]args)
    {
        HeaderConfigs hed=new HeaderConfigs();
        System.out.println(hed.defaultHeaders());
    }
}
