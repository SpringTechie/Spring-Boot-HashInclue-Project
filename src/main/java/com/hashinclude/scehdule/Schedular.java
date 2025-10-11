package com.hashinclude.scehdule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedular {

    // we have to run this method for every 5 seconds.
    // fixedRate : run every 5 seconds irrespective of job completed or not.
    // fixedDelay : waits for 5 seconds, when job is completed.
    // initialDelay = 3000

    //@Scheduled(fixedRate = 5000)
    public void run() {
        try {
            System.out.println("method started");
            Thread.sleep(10000);
            System.out.println("it posts data from main table to backup table at nyt 12am");
            System.out.println("Hello Spring Techie");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
