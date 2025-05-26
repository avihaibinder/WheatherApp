package com.example.wheatherApp.ratelimiter;

import java.util.concurrent.ThreadLocalRandom;

public class RateLimiter {
    public static void randomSleep(int minMillis, int maxMillis) throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(minMillis, maxMillis + 1));
    }
}
