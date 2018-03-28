/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.entity.Product;
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
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
             System.out.println(he);
            session.getTransaction().rollback();
            return false;
        }  
        finally {
            //session.close();
        }
    }
    
    public Boolean update(Object obj){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
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
            //session.close();
        }
    }
    
    public Boolean delete(Object obj){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            System.out.println(he);
            return false;
        } finally {
            //session.close();
        }
    }
    
    public Long countTable(String hql){//(Class c){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery(hql);
            long count = (Long)q.uniqueResult();
            return count;
        } catch (HibernateException he) {
            System.out.println(he);
            return (long)0;
        } finally {
            //session.close();
        }
//        try {
//            Criteria criteriaCount = session.createCriteria(c);
//            criteriaCount.setProjection(Projections.rowCount());
//            Long count = (Long) criteriaCount.uniqueResult();
//            return count;
//        } catch (HibernateException he) {
//            System.out.println(he);
//            return (long)0;
//        } finally {
//            session.close();
//        }
    }

    public List executeHQLQuery(String hql) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            System.out.println(he);
            return null;
        } 
//        finally {
//            session.close();
//        }
    }
    
    public List executeHQLQueryPaging(String hql, int lastPageNumber, int pageSize){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            //Criteria criteria = session.createCriteria(c);
            Query q = session.createQuery(hql);
            q.setFirstResult((lastPageNumber-1)*pageSize);//
            q.setMaxResults(pageSize);//
            List<Product> resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            System.out.println(he);
            return null;
        } 
//        finally {
//            session.close();
//        }
    }
}
