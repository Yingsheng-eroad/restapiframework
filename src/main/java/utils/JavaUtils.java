package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class JavaUtils {
    public static String randomNumber(){
        Random random =new Random();
        int randomNumber = random.nextInt(1000);
        String id = Integer.toString(randomNumber);
        return id;
    }

    public static String randomString(){
        String randomString = RandomStringUtils.randomAlphanumeric(15);
        return randomString;
}

}
