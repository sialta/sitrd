package com.sefryek.broker.pool.ThreadManagement;

import org.apache.log4j.Logger;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.RejectedExecutionException;

import com.sefryek.broker.mobileHandler.MIDletHandlerConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: mahta
 * Date: May 11, 2011
 * Time: 2:19:16 PM
 */


public class SocketServer {
    private static final Logger logger = Logger.getLogger(SocketServer.class);
    private static final short LISTEN_PORT = 9000;
    private static int index = 0;


    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private boolean shutdown = false;
    private ThreadPoolExecutor pool;

    public SocketServer() throws IOException {
        try {
            pool = ThreadPoolExecutorFactory.getInstance();
            serverSocket = new ServerSocket(LISTEN_PORT);

        } catch (IOException e) {
            pool.shutdownNow();
            throw e;
        }
    }

    public void serve() {
        try {
            while(!shutdown) {
                socket = serverSocket.accept();
                logger.debug("In the serve method, a new socket has been accepted (execute method is called) from ip: "
                        + (socket.getInetAddress() != null ? socket.getInetAddress().getHostAddress() : " Null")
                        + ", and queue size is: " + pool.getQueue().size() + ", Time is: " + System.currentTimeMillis());
                pool.execute(new MIDletHandlerConstructor(socket));

            }

        } catch (RejectedExecutionException rej) {
            try {

                socket.close();

            } catch (IOException e) {
                logger.info(e.getMessage());
            }

        } catch (Exception e) {
            logger.error("Exception while starting request: " + e.getMessage(), e);
        }
    }

}