package com.sefryek.broker.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import com.sefryek.broker.model.Message;

import static com.sefryek.broker.dao.HibernateUtil.*;

/**
 * Created by IntelliJ IDEA.
 * User: Sarvenaz
 * Date: Jul 26, 2011
 * Time: 1:47:52 PM
 */
public class MessageDAO extends BaseDAO {
    private static Logger logger = Logger.getLogger(MessageDAO.class);

    public static final String ID = "messageId";
    public static final String MESSAGE_SUBJECT_LENGHT = "messageSubjectLength";
    public static final String MESSAGE_SUBJECT = "messageSubject";
    public static final String MESSAGE_STATUS = "messageStatus";
    public static final String MESSAGE_DATE = "messageDate";

    public Message findById(int messageId) {
        logger.debug("finding a Message with this id: " + messageId);
        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Message message = (Message)super.findById(Message.class, messageId);
        transaction.commit();
        closeSession();
        return message;
    }

    public void update(Message message){
        logger.info("updating a Message with this id: " + message.getMessageId());
        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        super.update(message);
        transaction.commit();
        closeSession();
    }

    public void saveOrUpdateAll(List messages){
        logger.info("Messages status updating.");
        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        super.saveOrUpdateAll(messages);
        transaction.commit();
        closeSession();
    }

    public void saveOrUpdate(Message message){
        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        super.saveOrUpdate(message);
        transaction.commit();
        closeSession();
    }

    public Message findByMessageSubject(String subject) {
        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Message message = (Message) super.findObjectByPropertyEqualTo(Message.class, MESSAGE_SUBJECT, subject);
        transaction.commit();
        closeSession();
        return message;
    }

    public List<Message> findAll() {

        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<Message> Messages = session.createCriteria(Message.class).list();
        transaction.commit();
        closeSession();
        return Messages;
    }
}
