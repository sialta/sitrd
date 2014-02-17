package com.sefryek.broker.dao;

import static com.sefryek.broker.dao.HibernateUtil.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;


/**
 * Created by IntelliJ IDEA.
 * User: Sarvenaz
 * Date: Jul 26, 2011
 * Time: 1:48:42 PM
 */
public class BaseDAO {

    protected void save(Object obj) {
        getHibernateSessionFactory().getCurrentSession().save(obj);
    }

    protected void update(Object obj) {
        getHibernateSessionFactory().getCurrentSession().update(obj);
    }

    protected void saveOrUpdate(Object obj) {
        getHibernateSessionFactory().getCurrentSession().saveOrUpdate(obj);
    }

    protected void saveOrUpdateAll(Collection coll) {
        getCustomHibernateTemplate().saveOrUpdateAll(coll);
    }

    protected void delete(Object obj) {
        getHibernateSessionFactory().getCurrentSession().delete(obj);
    }

    protected void deleteAll(List list) {
        getCustomHibernateTemplate().deleteAll(list);
    }

    protected Object findById(Class classObj, Integer id) {
        return getHibernateSessionFactory().getCurrentSession().get(classObj, id);
    }

    protected List findAll(Class classObj) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .list();
    }

    protected List findByIds(Class classObj, String property, String[] ids) {

        Criteria criteria = getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj);

        Criterion criterion = null;
        for(String id : ids) {
            if(criterion == null)
                criterion = Restrictions.eq(property, Integer.valueOf(id));
            else
                criterion = Restrictions.or(criterion, Restrictions.eq(property, Integer.valueOf(id)));
        }

        if(criterion != null)
            criteria.add(criterion);
        return criteria.list();
    }

    protected Object findObjectByPropertyEqualTo(Class classObj, String propertyName, Object propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add(Restrictions.eq(propertyName, propertyValue))
                .setMaxResults(1)
                .uniqueResult();
    }

    protected Object findByPropertyEqualToIgnoreCase(Class classObj, String propertyName, Object propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.eq(propertyName, propertyValue).ignoreCase() )
                .setMaxResults(1)
                .uniqueResult();
    }

    protected List findByPropertyEqualTo(Class classObj, String propertyName, Object propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.eq(propertyName, propertyValue) )
                .list();
    }

    protected List findByProperties(Class classObj, String propertyName, Object[] propertyValue) {
        Criteria criteria = getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession().createCriteria(classObj);
        Criterion criterion = null;
        for(int i = 0; i < propertyValue.length; ++i){
            if(criterion == null ) criterion = Restrictions.eq(propertyName, propertyValue[i]);
            else criterion = Restrictions.or(criterion, Restrictions.eq(propertyName, propertyValue[i]));
        }
        return criteria.add(criterion).list();
    }

    protected List findByProperties(Class classObj, String propertyName, String[] propertyValue) {
        Criteria criteria = getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession().createCriteria(classObj);
        Criterion criterion = null;
        for(int i = 0; i < propertyValue.length; ++i){
            if(criterion == null ) criterion = Restrictions.eq(propertyName, propertyValue[i]);
            else criterion = Restrictions.or(criterion, Restrictions.eq(propertyName, propertyValue[i]));
        }
        return criteria.add(criterion).list();
    }

    protected List findByProperties(Class classObj, String[] propertyName, String[] propertyValue) {
        Criteria criteria = getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession().createCriteria(classObj);
        for(int i=0; i<propertyName.length; ++i){
            criteria.add(Restrictions.eq(propertyName[i], propertyValue[i]));
        }
        return criteria.list();
    }

    protected Object findObjectByProperties(Class classObj, String[] propertyName, String[] propertyValue) {
        Criteria criteria = getHibernateSessionFactory().getCurrentSession()
                .getSessionFactory()
                .getCurrentSession()
                .createCriteria(classObj);

        Criterion firstCriterion = Restrictions.eq(propertyName[0], propertyValue[0]);
        List<Criterion> criterions = new ArrayList<Criterion>();
        for(int i = 1; i < propertyName.length; i++){
            Criterion criterion = Restrictions.eq(propertyName[i], propertyValue[i]);
            criterions.add(criterion);
        }


        for(Criterion aCriterion: criterions){
            firstCriterion= Restrictions.or(firstCriterion, aCriterion);
        }

        criteria.add(firstCriterion);
        return criteria.setMaxResults(1).uniqueResult();
    }

    protected List findByPropertyOfPropertyEqualTo(Class classObj, String property, String propertyOfProperty, Object value) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .createCriteria(property)
                .add(Restrictions.eq(propertyOfProperty, value))
                .list();
    }

    protected Object findObjectByPropertyOfPropertyEqualTo(Class classObj, String property, String propertyOfProperty, Object value) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .createCriteria(property)
                .add(Restrictions.eq(propertyOfProperty, value))
                .setMaxResults(1)
                .uniqueResult();
    }

    protected List findByPropertyLessThanOrEqualTo(Class classObj, String propertyName, Object propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.le(propertyName, propertyValue) )
                .list();
    }

    protected List findByPropertyGreaterThanOrEqualTo(Class classObj, String propertyName, Object propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.ge(propertyName, propertyValue) )
                .list();
    }

    protected List findByPropertyLessThan(Class classObj, String propertyName, Object propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.lt(propertyName, propertyValue) )
                .list();
    }

    protected List findByPropertyGreaterThan(Class classObj, String propertyName, Object propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.gt(propertyName, propertyValue) )
                .list();
    }

    protected List findByPropertyLikeAnyWhereMode(Class classObj, String propertyName, String propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.like(propertyName, propertyValue, MatchMode.ANYWHERE) )
                .list();
    }

    protected List findByPropertyLikeAnyWhereModeIgnoreCase(Class classObj, String propertyName, String propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.like(propertyName, propertyValue, MatchMode.ANYWHERE).ignoreCase() )
                .list();
    }

    protected void deleteAll(Collection coll) {
        getCustomHibernateTemplate().deleteAll(coll);
        commit();
    }

    protected void commit() {
        getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession().flush();
    }

    protected Object findObjectByPropertyEqualToIgnoreCase(Class classObj, String propertyName, Object propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.eq(propertyName, propertyValue).ignoreCase() )
                .setMaxResults(1)
                .uniqueResult();
    }

    protected List findByProperties(Class classObj, String[] propertyName, Object[] propertyValue) {
        Criteria criteria = getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession().createCriteria(classObj);
        for(int i=0; i<propertyName.length; ++i){
            criteria.add(Restrictions.eq(propertyName[i], propertyValue[i]));
        }
        return criteria.list();
    }

    protected List findByPropertiesWithDescOrder(Class classObj, String[] propertyName, Object[] propertyValue, String propertyForOrder) {
        Criteria criteria = getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession().createCriteria(classObj);
        for(int i=0; i<propertyName.length; ++i){
            criteria.add(Restrictions.eq(propertyName[i], propertyValue[i]))
                    .addOrder(Order.desc(propertyForOrder));
        }
        return criteria.list();
    }

    protected List findByPropertyNotEqualTo(Class classObj, String propertyName, Object propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.ne(propertyName, propertyValue) )
                .list();
    }

    protected List findByPropertyLikeExact(Class classObj, String propertyName, String propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.ilike(propertyName, propertyValue, MatchMode.EXACT) )
                .list();
    }

    protected Object findByPropertyLikeExactModeIgnoreCase(Class classObj, String propertyName, String propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.like(propertyName, propertyValue, MatchMode.EXACT).ignoreCase() )
                .setMaxResults(1)
                .uniqueResult();
    }

    protected Object findByPropertyLikeModeIgnoreCase(Class classObj, String propertyName, String propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.like(propertyName, propertyValue).ignoreCase() )
                .setMaxResults(1)
                .uniqueResult();
    }

    protected List findByPropertyLikeAnyWhereModeIgnoreCasePartially(Class classObj, String propertyName, String propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .add( Restrictions.like(propertyName,"%"+propertyValue+"%", MatchMode.ANYWHERE).ignoreCase() )
                .list();
    }

    protected  List findByAssociatedProperty(Class classObj,String associatedProperty,String propertyName,Integer propertyValue) {
        return getHibernateSessionFactory().getCurrentSession().getSessionFactory().getCurrentSession()
                .createCriteria(classObj)
                .createCriteria(associatedProperty)
                .add(Restrictions.eq(propertyName,propertyValue))
                .list();
    }

    protected List findByProperty(Class className, String propertyName, Object property) {

        Session session = getHibernateSessionFactory().getCurrentSession();
        Query query = session.createQuery(new StringBuilder().append("from ").append(className.getName()).append(" tbl where tbl.").append(propertyName).append("=:property").toString());
        query.setParameter("property", property);
        List list = query.list();
        return list;
    }

}
