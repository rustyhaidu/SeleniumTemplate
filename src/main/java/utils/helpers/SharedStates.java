
package utils.helpers;

public class SharedStates {
    //Generic States
    private static String detectedOs;


    public static String getDetectedOs() {
        return detectedOs;
    }

    public static void setDetectedOs(String detectedOs) {
        SharedStates.detectedOs = detectedOs;
    }
}
