package com.sefryek.broker.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.sefryek.broker.model.MessageDetails;

import static com.sefryek.broker.dao.HibernateUtil.*;

/**
 * Created by IntelliJ IDEA.
 * User: Sarvenaz
 * Date: Jul 26, 2011
 * Time: 1:47:52 PM
 */
public class MessageDetailsDAO extends BaseDAO{

    public static final String ID="messageDetailsId";
    public static final String MESSAGE_CONTENT_LENGHT ="messageContentLength";
    public static final String MESSAGE_CONTENT ="messageContent";

    public MessageDetails findById(int messageDetailsId) {
        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        MessageDetails messageDetails = (MessageDetails)super.findById(MessageDetails.class, messageDetailsId);
        transaction.commit();
        closeSession();
        return messageDetails;
    }

    public void update(MessageDetails messageDetails){
        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        super.update(messageDetails);
        transaction.commit();
        closeSession();
    }

    public void saveOrUpdateAll(List MessageDetailss){
        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        super.saveOrUpdateAll(MessageDetailss);
        transaction.commit();
        closeSession();
    }

    public void saveOrUpdate(MessageDetails MessageDetails){
        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        super.saveOrUpdate(MessageDetails);
        closeSession();
        transaction.commit();
    }

    public MessageDetails findByMessageDetailsContent(String content) {
        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        MessageDetails messageDetails = (MessageDetails) super.findObjectByPropertyEqualTo(MessageDetails.class, MESSAGE_CONTENT, content);
        transaction.commit();
        closeSession();
        return messageDetails;
    }

    public List<MessageDetails> findAll() {

        Session session = getHibernateSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        List<MessageDetails> MessageDetailss = session.createCriteria(MessageDetails.class).list();
        transaction.commit();
        closeSession();
        return MessageDetailss;
    }
}