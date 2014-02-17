package com.sefryek.broker.utils.sessionUtils;

import com.sefryek.broker.webservice.RequestManager;

import java.util.Vector;
import java.util.Enumeration;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jun 19, 2011
 * Time: 3:28:16 PM
 */
class SessionPool {
    final static private long timeout = 10 * 60 * 1000;
    private static Vector<Session> sessions = new Vector<Session>();

    public SessionPool() {
        SessionReaper reaper = new SessionReaper(this);
        reaper.start();
    }

    protected static Session getSessionAndUpdateLasUsageTime(String brokerId, String customerId, String sessionId) {
        for(Session aSession: sessions) {
            if(brokerId.equals(aSession.getBrokerId()) && customerId.equals(aSession.getCustomerId()) && sessionId.equals(aSession.getSessionId())) {
                aSession.setUsageTime(System.currentTimeMillis());
                return aSession;
            }
        }
        return null;
    }

    protected static Session createNewSession(String brokerId, String customerId, String sessionId, RequestManager manager, String encryptionKey) {
        Session newSession = new Session(brokerId, customerId, sessionId, manager, encryptionKey, System.currentTimeMillis());
        sessions.addElement(newSession);
        return newSession;
    }

    public synchronized void reapSessions() {
        long stale = System.currentTimeMillis() - timeout;
        Enumeration sessionList = sessions.elements();

        if(sessionList != null) {
            while(sessionList.hasMoreElements()) {
                Session session = (Session)sessionList.nextElement();

                if(stale > session.getUsageTime()) {
                    removeSession(session);
                }
            }
        }
    }

    public static void destroySession(String brokerId, String customerId, String sessionId) {
        Enumeration sessionList = sessions.elements();

        if(sessionList != null) {
            while((sessionList.hasMoreElements())) {
                Session session = (Session)sessionList.nextElement();

                if(brokerId.equals(session.getBrokerId()) && customerId.equals(session.getCustomerId()) && sessionId.equals(session.getSessionId())) {
                    if(sessionId.equals(session.getSessionId())) {
                        removeSession(session);
                        break;
                    }
                }
            }
        }
    }

    private static synchronized void removeSession(Session session) {
        sessions.removeElement(session);
    }

}
