
package utils.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.enums.OSType;

import java.util.Locale;

import static org.aspectj.bridge.MessageUtil.fail;
import static utils.constants.Constants.*;


public class OSHandler {

    private static final Logger LOG = LoggerFactory.getLogger( OSHandler.class.getName() );

    /**
     * Detect OS
     *
     * @return the detected OS OSType
     */
    public static OSType getOs(){
        OSType detectedOS;
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);

        if ((OS.contains("mac")) || (OS.contains("darwin"))) {
            detectedOS = OSType.MAC_OS;
        } else if (OS.contains("win")) {
            detectedOS = OSType.WINDOWS;
        } else {
            detectedOS = OSType.OTHER;
        }

        LOG.info("Detected OS is {}.", detectedOS);
        return detectedOS;
    }

    /**
     * Based on the stored OS will be applied the proper ChromeDriver
     */
    public static void setChromeDriverPropertyByOs(){
        switch (SharedStates.getDetectedOs()){
            case "WINDOWS":{
                System.setProperty(SYSTEM_CHROMEDRIVER_PROPERTY_KEY, WIN_CHROME_DRIVER_RELATIVE_PATH);
                LOG.info("Setting up ChromeDriver for {}.", SharedStates.getDetectedOs());
                break;
            }
            case "MAC_OS":{
                System.setProperty(SYSTEM_CHROMEDRIVER_PROPERTY_KEY, MAC_CHROME_DRIVER_RELATIVE_PATH);
                LOG.info("Setting up ChromeDriver for {}.", SharedStates.getDetectedOs());
                break;
            }
            case "OTHER":{
                fail("Unsupported Operating System.");
                break;
            }
        }
    }
}
