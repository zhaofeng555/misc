package hjg.jdbc.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;

/**
 * @author hjg 
 * @version   创建时间：2010-2-3下午03:13:17
 * 类说明 : hibernate 的底层链接 用泛型的形式。
 *
 **/
public interface IBaseDao<T> {

	List findByHQL(String hql, Object...values);
	List<T> findBy(String propertyName, Object value);
	List<T> findBy(String propertyName, Object value, String orderBy, boolean isAsc);
	T findUniqueBy(String propertyName, Object vlaue);
	boolean isUnique(Object entity, String uniquePropertyNames);
	void addObject(Object obj);
	List getAllObject();
	List getAllObject(String orderBy, boolean isAsc);
	T getObject(Serializable id);
	void removeObjectById(Serializable id);
	void removeObject(Object o);
	void updateObject(Object o);
	
	public Page pagedQueryByHQL(String hql, int pageNo, int pageSize, Object...values);
	public Page pagedQueryByHQL(String hql, Page page, Object ...values);
	public Page pagedQueryBySQL(String sql, Page page, Object...values);
	public Page pagedQueryByCriteria(int pageNo, int pageSize, Criterion criterion);
	public Page pageGetAllObject(int pageNo, int pageSize);
	public String getIdName();
	public void updateByHql(String hql, Object...values);
	public SQLQuery createSQL(String sql, Object...values);
	public Query createSQLQuery(String sql, Object...values);
}

