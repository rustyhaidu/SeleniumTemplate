
package utils.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;

public class Helper {

    /**
     * Return property value from the specified properties file
     *
     * @param propertyName Name of the property
     * @return Value of the property
     */
    public static String getPropertyValue(String propertyFileName, String propertyName) {
        ClassLoader classLoader = Helper.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("properties/" + propertyFileName + ".properties")).getFile());

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(propertyName);
    }

    public static String getRandomOfSixDigitsNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(899998) + 100000;

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }

    public static String getRandomFourDigitsNumberString() {
        // It will generate 4 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(9998) + 1000;

        // this will convert any number sequence into 4 character.
        return String.format("%04d", number);
    }
}
