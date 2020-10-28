package apiBuilder;

import java.util.HashMap;
import java.util.Map;

public class PostAPIBuilder {

    public Map<String, String> postRequestBody(String sno,String imsi,String iccid){
        Map<String,String>postBody= new HashMap<String,String>();

        postBody.put("serialNumber",sno);
        postBody.put("imsi",imsi);
        postBody.put("iccid",iccid);

        return postBody;

    }
    public Map<String, String> postRequestBodyParameterised(String sno,String imei,String imsi,String iccid,String msisdn){
        Map<String,String>postBodyparmeterised= new HashMap<String,String>();

        postBodyparmeterised.put("serialNumber",sno);
        postBodyparmeterised.put("imei",imei);
        postBodyparmeterised.put("imsi",imsi);
        postBodyparmeterised.put("iccid",iccid);
        postBodyparmeterised.put("msisdn",msisdn);
        return postBodyparmeterised;

    }
    public Map<String, String> invalidPostRequestBody(String imsi,String iccid){
        Map<String,String>postBody= new HashMap<String,String>();

        postBody.put("imsi",imsi);
        postBody.put("iccid",iccid);

        return postBody;

    }
}
