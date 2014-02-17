package com.sefryek.broker.mobileHandler;

import com.sefryek.broker.state.TradingMessage;

import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: mahta
 * Date: May 25, 2011
 * Time: 10:22:07 AM
 */
public class MIDletHandlerConstructor extends MIDletHandler {

    public MIDletHandlerConstructor(Socket requestSocket) {
        super(requestSocket);
    }

    public TradingMessage handleRequest() {
        return null;
    }
}
