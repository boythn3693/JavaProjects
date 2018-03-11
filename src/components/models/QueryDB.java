/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.models;

import components.utils.HibernateUtil;
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
    
    public Boolean save(Object obj){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
             System.out.println(he);
            session.getTransaction().rollback();
            return false;
        }  finally {
            session.close();
        }
    }
    
    public Boolean update(Object obj){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(obj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
             System.out.println(he);
            session.getTransaction().rollback();
            return false;
        }  finally {
            session.close();
        }
    }
    
    public Boolean delete(Object obj){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            System.out.println(he);
            return false;
        } finally {
            session.close();
        }
    }

    public List executeHQLQuery(String hql) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            System.out.println(he);
            return null;
        } finally {
            session.close();
        }
    }
}
