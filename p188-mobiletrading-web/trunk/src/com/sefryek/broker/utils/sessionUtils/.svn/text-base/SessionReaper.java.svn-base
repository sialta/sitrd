package com.sefryek.broker.utils.sessionUtils;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jun 20, 2011
 * Time: 9:50:11 AM
 */
public class SessionReaper extends Thread {
    private SessionPool instance;
    private final long delay = 1800000;

    SessionReaper(SessionPool instance) {
        this.instance = instance;
    }

    public void run() {
        while(true) {
            try {
                sleep(delay);

            } catch( InterruptedException e) {
                // System.out.println();
            }

            instance.reapSessions();
        }
    }

}