package com.infirmarium.core.persistance.core;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infirmarium.core.persistance.coredomain.BaseEntity;

@Repository
public abstract class BaseDAO<E extends BaseEntity<PK>, PK extends Serializable> {

    private static final int BATCH_SIZE = 15;

    @Autowired
    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    protected Class<E> getEntityClass() {
        return (Class<E>) (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments())[0];
    }

    protected String getEntityName() {
        return getEntityClass().getSimpleName();
    }

    protected Criteria createBaseCriteria() {
        return getSession().createCriteria(getEntityClass());
    }

    protected Query createBaseQuery(String sql) {
        return getSession().createSQLQuery(sql);
    }

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public E get(final PK pk) {
        return (E) getSession().get(getEntityClass(), pk);
    }

    public void save(final E entity) {
        getSession().saveOrUpdate(entity);
    }

    @SuppressWarnings("unchecked")
    public E load(final PK pk) {
        return (E) getSession().load(getEntityClass(), pk);
    }

    public void flush() {
        getSession().flush();
    }

    public void save(final List<E> entityList) {
        final Session session = sessionFactory.getCurrentSession();
        int counter = 0;
        for (E e : entityList) {
            session.saveOrUpdate(e);
            if (counter++ % BATCH_SIZE == 0) {
                session.flush();
                session.clear();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void saveAny(final Object obj) {
        if (obj != null) {
            final Session session = sessionFactory.getCurrentSession();
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
        }
    }

    public void remove(final PK pk) {
        final E entity = load(pk);
        if (entity != null) {
            remove(entity);
        }
    }

    public void remove(final E e) {
        getSession().delete(e);
    }

    public int count() {
        final Integer result = (Integer) createBaseCriteria().setProjection(Projections.rowCount()).uniqueResult();
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
    public <T extends BaseEntity<?>> T loadEntity(final Class<?> clazz, final Serializable id) {
        return (T) getSession().load(clazz, id);
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
        getSession().delete(entity);
    }

    /** * GETTERS / SETTERS ** */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}