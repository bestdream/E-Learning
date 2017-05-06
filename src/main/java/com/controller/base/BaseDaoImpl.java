package com.controller.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

@Repository("baseDao")
public class BaseDaoImpl<T>
  implements BaseDao<T>
{
  @Resource
  private SessionFactory sessionFactory;
  
  private Session getCurrentSession()
  {
    return this.sessionFactory.getCurrentSession();
  }
  
  public Serializable save(T o)
  {
    return getCurrentSession().save(o);
  }
  
  public T get(Class<T> c, Serializable id)
  {
    return (T)getCurrentSession().get(c, id);
  }
  
  public T get(String hql)
  {
    Query q = getCurrentSession().createQuery(hql);
    List<T> l = q.list();
    if ((l != null) && (l.size() > 0)) {
      return (T)l.get(0);
    }
    return null;
  }
  
  public T get(String hql, Map<String, Object> params)
  {
    Query q = getCurrentSession().createQuery(hql);
    if ((params != null) && (!params.isEmpty())) {
      for (String key : params.keySet()) {
        q.setParameter(key, params.get(key));
      }
    }
    List<T> l = q.list();
    if ((l != null) && (l.size() > 0)) {
      return (T)l.get(0);
    }
    return null;
  }
  
  public void delete(T o)
  {
    getCurrentSession().delete(o);
  }
  
  public void deleteCollection(Collection o)
  {
    for (Iterator it = o.iterator(); it.hasNext();) {
      getCurrentSession().delete(it.next());
    }
  }
  
  public void update(T o)
  {
    getCurrentSession().update(o);
  }
  
  public void saveOrUpdate(T o)
  {
    getCurrentSession().saveOrUpdate(o);
  }
  
  public void merge(T o)
  {
    getCurrentSession().merge(o);
  }
  
  public void refresh(T o)
  {
    getCurrentSession().refresh(o);
  }
  
  public List<T> find(String hql)
  {
    Query q = getCurrentSession().createQuery(hql);
    return q.list();
  }
  
  public List<T> find(String hql, Map<String, Object> params)
  {
    Query q = getCurrentSession().createQuery(hql);
    if ((params != null) && (!params.isEmpty())) {
      for (String key : params.keySet()) {
        q.setParameter(key, params.get(key));
      }
    }
    return q.list();
  }
  
  public List<T> findByCache(String hql)
  {
    Query q = getCurrentSession().createQuery(hql);
    return q.setCacheable(true).list();
  }
  
  public List<T> findByCache(String hql, Map<String, Object> params)
  {
    Query q = getCurrentSession().createQuery(hql);
    if ((params != null) && (!params.isEmpty())) {
      for (String key : params.keySet()) {
        q.setParameter(key, params.get(key));
      }
    }
    return q.setCacheable(true).list();
  }
  
  public List<T> find(String hql, Map<String, Object> params, int page, int rows)
  {
    Query q = getCurrentSession().createQuery(hql);
    if ((params != null) && (!params.isEmpty())) {
      for (String key : params.keySet()) {
        q.setParameter(key, params.get(key));
      }
    }
    return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
  }
  
  public List<T> find(String hql, int page, int rows)
  {
    Query q = getCurrentSession().createQuery(hql);
    return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
  }
  
  public Long count(String hql)
  {
    Query q = getCurrentSession().createQuery(hql);
    return (Long)q.uniqueResult();
  }
  
  public Long count(String hql, Map<String, Object> params)
  {
    Query q = getCurrentSession().createQuery(hql);
    if ((params != null) && (!params.isEmpty())) {
      for (String key : params.keySet()) {
        q.setParameter(key, params.get(key));
      }
    }
    return (Long)q.uniqueResult();
  }
  
  public Long countByCache(String hql)
  {
    Query q = getCurrentSession().createQuery(hql);
    return (Long)q.setCacheable(true).uniqueResult();
  }
  
  public Long countByCache(String hql, Map<String, Object> params)
  {
    Query q = getCurrentSession().createQuery(hql);
    if ((params != null) && (!params.isEmpty())) {
      for (String key : params.keySet()) {
        q.setParameter(key, params.get(key));
      }
    }
    return (Long)q.setCacheable(true).uniqueResult();
  }
  
  public int executeHql(String hql)
  {
    Query q = getCurrentSession().createQuery(hql);
    return q.executeUpdate();
  }
  
  public int executeHql(String hql, Map<String, Object> params)
  {
    Query q = getCurrentSession().createQuery(hql);
    if ((params != null) && (!params.isEmpty())) {
      for (String key : params.keySet()) {
        q.setParameter(key, params.get(key));
      }
    }
    return q.executeUpdate();
  }
  
  public int executeSql(String sql)
  {
    Query q = getCurrentSession().createSQLQuery(sql);
    return q.executeUpdate();
  }
  
  public void batchSave(List<T> list)
  {
    int count = 0;
    for (T t : list)
    {
      getCurrentSession().save(t);
      count++;
      if (count % 20 == 0)
      {
        getCurrentSession().flush();
        getCurrentSession().clear();
      }
    }
  }
  
  public List<T> findBySql(String sql)
  {
    Query q = getCurrentSession().createSQLQuery(sql);
    return q.list();
  }
  
  public T getBySql(String sql)
  {
    Query q = getCurrentSession().createSQLQuery(sql);
    List<T> l = q.list();
    if ((l != null) && (l.size() > 0)) {
      return (T)l.get(0);
    }
    return null;
  }
  
  public List<T> findBySql(String sql, Class<T> clazz)
  {
    Query q = getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(clazz));
    return q.list();
  }
  
  public T getBySql(String sql, Class<T> clazz)
  {
    Query q = getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(clazz));
    List<T> l = q.list();
    if ((l != null) && (l.size() > 0)) {
      return (T)l.get(0);
    }
    return null;
  }
  
  public List<T> findBySql(String sql, Class<T> clazz, int page, int rows)
  {
    Query q = getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(clazz));
    return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
  }
  
  public List<T> findBySql(String sql, int page, int rows)
  {
    Query q = getCurrentSession().createSQLQuery(sql);
    return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
  }
  
  public Session getSession()
  {
    return this.sessionFactory.openSession();
  }
}
