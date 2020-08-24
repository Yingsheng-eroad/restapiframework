package baseTest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import utils.FileAndEnv;

public class BaseTest {
    @Test
    public void baseTest(){
       // RestAssured.baseURI= "http://ams.test.erdmg.com";

        RestAssured.baseURI= FileAndEnv.getInstance().getServerUrl();
    }



}
