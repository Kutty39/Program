package com.company;

import java.time.Duration;
import java.time.Instant;

public class Stopwatch {
    private static Instant stop;
    private static Instant start;

    public void StartTime(){
        start = Instant.now();
    }
    public void StopTime(){
        stop = Instant.now();
        System.out.println(Duration.between(start,stop).toMinutes());
    }
}
