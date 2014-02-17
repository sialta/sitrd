package com.sefryek.broker;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import com.sefryek.broker.pool.ThreadManagement.SocketServer;

import java.net.URL;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    static{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        System.setProperty("current.date", dateFormat.format(new Date()));
        System.setProperty("axis.ClientConfigFile", "client-config.wsdd") ;
    }


    public static void main(String[] args) throws Exception {

        // logger.info("Main is started and socket server is listening the sockets at: " + System.currentTimeMillis());
        configureLog4j();

        try {
            SocketServer socketServer = new SocketServer();
            socketServer.serve();

        } catch (IOException e) {
            logger.info(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void configureLog4j() {
        ClassLoader classLoader = Main.class.getClassLoader();
        URL log4Jresource = classLoader.getResource("log4j-config.xml");

        DOMConfigurator.configure(log4Jresource);
    }

}