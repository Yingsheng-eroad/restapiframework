package baseTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.FileAndEnv;

public class DeviceConfigBaseTest {

    public static RequestSpecification spec = null;

    static {
        spec = new RequestSpecBuilder().setBaseUri(FileAndEnv.getInstance().getDeviceConfigUrl()).build();
    }
}
