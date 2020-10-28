package apiVerifications;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import pojo.AssetAndOrgIdPojo;

import static org.hamcrest.MatcherAssert.assertThat;

public class APIVerification {

    public static void responseCodeValidation(Response response, int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
        System.out.println("The Status Code is validated");
        System.out.println("The Status Code is " + statusCode);
//        try {
//
//
//        } catch (AssertionError e) {
//            System.out.println("Validation Failed");
//
//        }
    }
    public static void negativeResponseCodeValidation(Response response, int statusCode,String statusLine) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
        Assert.assertEquals(response.getStatusLine(),statusLine);
        System.out.println("The Status Code is validated");
        System.out.println("The Status Code is " + statusCode);
//        try {
//
//
//        } catch (AssertionError e) {
//            System.out.println("Validation Failed");
//
//        }
    }

    public static void responseKeyValidationFromArray(Response response, String key) {
        try {
            JSONArray array = new JSONArray(response.getBody().asString());
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                System.out.println(("Validated Values are " + obj.get(key)));
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

    public static void responseKeyValidationFromObject(Response response, String key) {
        try {
            JSONObject json = new JSONObject(response.getBody().asString());
            if (json.has(key) && json.get(key) != null) {
                System.out.println("The key from the response is : " + key );
                System.out.println("The value of " + key + " is "  + json.get(key));

            } else {
                System.out.println("Key is not present");
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }

}


