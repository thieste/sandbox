package de.thieste.java8.util;

/**
 * some helper methods
 * Created by thieste on 21.12.15.
 */
public final class Util {

    private Util() {
    }

    public static void delay(Long timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            //
        }
    }


    public static Integer toCentValue(Double value) {
        return Double.valueOf(value * 100).intValue();
    }
}
