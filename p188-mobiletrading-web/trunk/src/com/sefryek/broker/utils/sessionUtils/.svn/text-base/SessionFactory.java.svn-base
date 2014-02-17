package com.sefryek.broker.utils.sessionUtils;

import org.apache.log4j.Logger;
import com.sefryek.broker.webservice.RequestManager;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: Jun 20, 2011
 * Time: 10:07:29 AM
 */
public class SessionFactory {
    private static final Logger logger = Logger.getLogger(SessionFactory.class);
    
    private static final SessionFactory INSTANCE = new SessionFactory();

    // Private constructor prevents instantiation from other classes
    private SessionFactory() {}


    //Static class instantiation
    static {
        try {
            logger.debug("Calles static section which is contains of SessionPool intialization.");
            new SessionPool();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * ConnectionFactoryHolder is loaded on the first execution of ConnectionFactory.getInstance()
     * or the first access to ConnectionFactoryHolder.INSTANCE, not before.
     * @return return single session factory
     */
    public static SessionFactory getInstance() {
        return INSTANCE;
    }

    public Session initializeSession(String brokerId, String customerId, String sessionId, RequestManager manager, String encryptionKey) {
        Session session = SessionPool.getSessionAndUpdateLasUsageTime(brokerId, customerId, sessionId);
        if(session != null) {
            session.setManager(manager);
            session.setEncryptionKey(encryptionKey);
            return session;
        }

        return SessionPool.createNewSession(brokerId, customerId, sessionId, manager, encryptionKey);
    }

    public Session getSessionAndUpdateLasSessionUsageTime(String brokerId, String customerId, String sessionId) {
        return SessionPool.getSessionAndUpdateLasUsageTime(brokerId, customerId, sessionId);
    }

    public void destroySessionBySessionId(String brokerId, String customerId, String sessionId) {
        SessionPool.destroySession(brokerId, customerId, sessionId);
    }

}
