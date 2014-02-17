package com.sefryek.broker.pool.JDBCConnectionPool;

public class ConnectionReaper extends Thread {

    private JDCConnectionPool pool;
    private final long delay = 300000;

    ConnectionReaper(JDCConnectionPool pool) {
        this.pool = pool;
    }

    public void run() {
        while(true) {
            try {
                sleep(delay);

            } catch( InterruptedException e) {
                // System.out.println();
            }

            pool.reapConnections();

        }
    }

}