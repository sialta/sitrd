package com.sefryek.broker.pool.JDBCConnectionPool;

import java.util.Vector;
import java.util.Enumeration;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

                            
public class JDCConnectionPool {

    final static private int poolsize = 20;
    private Vector<Connection> connections;
    private String url, user, password;
    final private long timeout = 60000;


    public JDCConnectionPool(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        connections = new Vector<Connection>(poolsize);
        ConnectionReaper reaper = new ConnectionReaper(this);
        reaper.start();
    }

    public synchronized void reapConnections() {

        long stale = System.currentTimeMillis() - timeout;
        Enumeration connlist = connections.elements();

        while((connlist != null) && (connlist.hasMoreElements())) {
            JDCConnection conn = (JDCConnection)connlist.nextElement();

            if((conn.inUse()) && (stale > conn.getLastUse()) && (!conn.validate())) {
                removeConnection(conn);
            }
        }
    }

    public synchronized void closeConnections() {

        Enumeration connlist = connections.elements();
        while((connlist != null) && (connlist.hasMoreElements())) {
            JDCConnection conn = (JDCConnection)connlist.nextElement();
            removeConnection(conn);
        }
    }

    private synchronized void removeConnection(JDCConnection conn) {
        connections.removeElement(conn);
        notifyAll();
    }

    public synchronized Connection getConnection() throws SQLException {
        JDCConnection c;
        for(int i = 0; i < connections.size(); i++) {
            c = (JDCConnection)connections.elementAt(i);
            if (c.lease()) {
                return c;
            }
        }

        if(connections.size() < poolsize) {
            Connection conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            c = new JDCConnection(conn, this);
            c.lease();
            connections.addElement(c);
            return c;

        } else {

            // Wait for either a new connection to be established
            try {
//                System.out.println(Thread.currentThread().getName() + " - Wait is called. ****************************" );
                wait();

            } catch(InterruptedException ie) { /* do not need to e.printStackTrace);*/
//                System.out.println(Thread.currentThread().getName() + " - Wait is Interrupted. ****************************");
            }

//            System.out.println(Thread.currentThread().getName() + " - Wait is finished. ****************************");
            // Someone freed up a connection, so try again.
            return(getConnection());

        }
    }

    public synchronized void returnConnection(JDCConnection conn) {
        conn.expireLease();
        notifyAll();
    }
}