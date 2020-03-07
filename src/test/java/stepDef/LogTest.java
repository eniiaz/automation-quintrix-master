package stepDef;

import utilities.Log;

public class LogTest {

    public static void main(String[] args) {
        System.out.println("start here");
        Log.warn("warn here pls");
        Log.info("some info logger");
        Log.error("annother error");
        System.out.println("done");
    }
}
