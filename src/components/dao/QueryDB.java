/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.dao;

import components.entity.Product;
import components.utils.HibernateUtil;
import java.util.ArrayList;
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
        if (_instance == null) {
            _instance = new QueryDB();
        }
        return _instance;
    }

    public List runQuery(String Query) {
        try {
            return executeHQLQuery(Query);
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList();
        }
    }

    public Boolean save(Object obj) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.save(obj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            System.out.println(he);
            session.getTransaction().rollback();
            return false;
        }
    }

    public Boolean update(Object obj) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.update(obj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            System.out.println(he);
            session.getTransaction().rollback();
            return false;
        }
    }

    public Boolean delete(Object obj) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(obj);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            System.out.println(he);
            session.getTransaction().rollback();
            return false;
        }
    }

    public Long countTable(String hql) {//(Class c){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Query q = session.createQuery(hql);
            long count = (Long) q.uniqueResult();
            session.getTransaction().commit();
            return count;
        } catch (HibernateException he) {
            System.out.println(he);
            session.getTransaction().rollback();
            return (long) 0;
        }
    }

    public List executeHQLQuery(String hql) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            System.out.println(he);
            session.getTransaction().rollback();
            return new ArrayList();
        }
    }

    public List executeHQLQueryPaging(String hql, int lastPageNumber, int pageSize) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            Query q = session.createQuery(hql);
            q.setFirstResult((lastPageNumber - 1) * pageSize);//
            q.setMaxResults(pageSize);//
            List<Product> resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            System.out.println(he);
            session.getTransaction().rollback();
            return new ArrayList();
        }
    }
}
