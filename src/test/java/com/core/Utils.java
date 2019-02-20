package com.core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static int getARandomNumberBetween(int a, int b) {
        return ThreadLocalRandom.current().nextInt(a, b);
    }

    public static void waitForSeconds(int seconds) {
        for (int i=1; i <= seconds; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
