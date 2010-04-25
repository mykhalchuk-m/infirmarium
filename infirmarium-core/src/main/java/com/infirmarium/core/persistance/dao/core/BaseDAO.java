package com.infirmarium.core.persistance.dao.core;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.infirmarium.core.persistance.coredomain.BaseEntity;
import com.infirmarium.core.persistance.util.HibernateUtilImpl;

//@Repository
public abstract class BaseDAO<E extends BaseEntity<PK>, PK extends Serializable> {

	private static final int BATCH_SIZE = 15;

	protected SessionFactory sessionFactory;

	public BaseDAO() {
		sessionFactory = HibernateUtilImpl.getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	protected Class<E> getEntityClass() {
		return (Class<E>) (((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments())[0];
	}

	protected String getEntityName() {
		return getEntityClass().getSimpleName();
	}

	protected Criteria createBaseCriteria() {
		Criteria result = null;
		Session session = getSession();
		session.beginTransaction();
		result = getSession().createCriteria(getEntityClass());
		session.getTransaction().commit();
		return result;
	}

	protected Query createBaseQuery(String sql) {
		Query result = null;
		Session session = getSession();
		session.beginTransaction();
		result = getSession().createSQLQuery(sql);
		session.getTransaction().commit();
		return result;
	}

	protected Session getSession() {
		Session session = HibernateUtilImpl.getSessionFactory()
				.getCurrentSession();
		if (!session.isOpen())
			session = HibernateUtilImpl.getSessionFactory().openSession();
		return session;
	}

	@SuppressWarnings("unchecked")
	public E get(final PK pk) {
		Session session = getSession();
		session.beginTransaction();
		E result = (E) session.get(getEntityClass(), pk);
		session.getTransaction().commit();
		return result;
	}

	public void save(final E entity) {
		Session session = getSession();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public E load(final PK pk) {
		Session session = getSession();
		session.beginTransaction();
		E result = (E) getSession().load(getEntityClass(), pk);
		session.getTransaction().commit();
		return result;
	}

	public void flush() {
		getSession().flush();
	}

	public void save(final List<E> entityList) {
		Session session = getSession();
		session.beginTransaction();
		int counter = 0;
		for (E e : entityList) {
			session.saveOrUpdate(e);
			if (counter++ % BATCH_SIZE == 0) {
				session.flush();
				session.clear();
			}
		}
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public void saveAny(final Object obj) {
		if (obj != null) {
			final Session session = getSession();
			session.beginTransaction();
			if (obj instanceof List) {
				int counter = 0;
				List l = (List) obj;
				for (Object e : l) {
					session.saveOrUpdate(e);
					if (counter++ % BATCH_SIZE == 0) {
						session.flush();
						session.clear();
					}
				}
			} else {
				session.saveOrUpdate(obj);
			}
			session.getTransaction().commit();
		}
	}

	public void remove(final PK pk) {
		final E entity = load(pk);
		if (entity != null) {
			remove(entity);
		}
	}

	public void remove(final E e) {
		Session session = getSession();
		session.beginTransaction();
		session.delete(e);
		session.getTransaction().commit();
	}

	public int count() {
		final Integer result = (Integer) createBaseCriteria().setProjection(
				Projections.rowCount()).uniqueResult();
		return result == null ? 0 : result.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<E> getAll() {
		return createBaseCriteria().list();
	}

	@SuppressWarnings("unchecked")
	public List<E> getAllOrderedBy(final String... fields) {
		final Criteria criteria = createBaseCriteria();
		for (String field : fields) {
			criteria.addOrder(Order.asc(field));
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public <T extends BaseEntity<?>> T loadEntity(final Class<?> clazz,
			final Serializable id) {
		Session session = getSession();
		session.beginTransaction();
		T result = (T) getSession().load(clazz, id);
		session.getTransaction().commit();
		return result;
	}

	public void evict() {
		this.sessionFactory.evict(getEntityClass());
	}

	public void evict(final PK pk) {
		this.sessionFactory.evict(getEntityClass(), pk);
	}

	@SuppressWarnings("unchecked")
	public E merge(final E entity) {
		return (E) getSession().merge(entity);

	}

	public void delete(final E entity) {
		Session session = getSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
	}

	/** * GETTERS / SETTERS ** */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}