package com.controller.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

public abstract interface BaseDao<T>
{
  public abstract Serializable save(T paramT);
  
  public abstract void delete(T paramT);
  
  public abstract void deleteCollection(Collection paramCollection);
  
  public abstract void update(T paramT);
  
  public abstract void saveOrUpdate(T paramT);
  
  public abstract void merge(T paramT);
  
  public abstract void refresh(T paramT);
  
  public abstract T get(Class<T> paramClass, Serializable paramSerializable);
  
  public abstract T get(String paramString);
  
  public abstract T get(String paramString, Map<String, Object> paramMap);
  
  public abstract List<T> find(String paramString);
  
  public abstract List<T> find(String paramString, Map<String, Object> paramMap);
  
  public abstract List<T> findByCache(String paramString);
  
  public abstract List<T> findByCache(String paramString, Map<String, Object> paramMap);
  
  public abstract List<T> find(String paramString, int paramInt1, int paramInt2);
  
  public abstract List<T> find(String paramString, Map<String, Object> paramMap, int paramInt1, int paramInt2);
  
  public abstract Long count(String paramString);
  
  public abstract Long count(String paramString, Map<String, Object> paramMap);
  
  public abstract Long countByCache(String paramString);
  
  public abstract Long countByCache(String paramString, Map<String, Object> paramMap);
  
  public abstract int executeHql(String paramString);
  
  public abstract int executeHql(String paramString, Map<String, Object> paramMap);
  
  public abstract int executeSql(String paramString);
  
  public abstract void batchSave(List<T> paramList);
  
  public abstract List<T> findBySql(String paramString);
  
  public abstract T getBySql(String paramString);
  
  public abstract List<T> findBySql(String paramString, Class<T> paramClass);
  
  public abstract T getBySql(String paramString, Class<T> paramClass);
  
  public abstract List<T> findBySql(String paramString, Class<T> paramClass, int paramInt1, int paramInt2);
  
  public abstract List<T> findBySql(String paramString, int paramInt1, int paramInt2);
  
  public abstract Session getSession();
}
