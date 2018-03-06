/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.model;

import components.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MitsuyoRai
 */
public class QueryDB {
    private static QueryDB _instance = null;
    public static QueryDB GetInstance() {
        if (_instance == null){
            _instance = new QueryDB();
        }
        return _instance;
    }
    
    public List runQuery(String Query) {
        return executeHQLQuery(Query);
    }
    
    public Boolean saveOrUpdate(Object obj){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(obj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            return false;
        }
    }
    
    public Boolean delete(Object obj){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            return false;
        }
    }

    public List executeHQLQuery(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            return null;
        }
    }
}
