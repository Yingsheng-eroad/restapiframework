package features.ToBeDeleted.ExcelTrial;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ExcelCallMethods {

    public static String[] httpPost(String jsonContent, String baseUri, String apiPath, int expResCode)
            throws IOException {

        String[] arr = new String[2];
        arr[1] = "Failed";

        // Set base URI for API call
        RestAssured.baseURI = baseUri;

        // Define API request
        RequestSpecification request = RestAssured.given();
        request.body(jsonContent);

        // Send the request and save the response
        Response response = request.post(apiPath);

        // Get the status code from the response and verify that it's as expected
        int statusCode = response.getStatusCode();

        arr[0] = Integer.toString(statusCode);
        if (statusCode == expResCode)
            arr[1] = "Passed";

        return arr;

    }
}
