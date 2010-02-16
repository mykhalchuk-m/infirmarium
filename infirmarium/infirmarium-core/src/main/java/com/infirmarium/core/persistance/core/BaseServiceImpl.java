package com.infirmarium.core.persistance.core;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infirmarium.core.persistance.coredomain.BaseEntity;

@SuppressWarnings("unchecked")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public abstract class BaseServiceImpl<E extends BaseEntity, DAO extends BaseDAO> implements IBaseService<E, DAO> {

    private DAO dao;

    @Override
    public void flush() {
        getDao().flush();
    }

    @Override
    public List<E> getAll() {
        return getDao().getAll();
    }

    @Override
    public E getByPK(Serializable pk) {
        return (E) getDao().get(pk);
    }

    @Override
    public DAO getDao() {
        return dao;
    }

    @Override
    public E load(Serializable pk) {
        return (E) getDao().load(pk);
    }

    @Override
    public E loadEntity(Class<E> clazz, Serializable pk) {
        return (E) getDao().loadEntity(clazz, pk);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public E merge(E entity) {
        return (E) getDao().merge(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void remove(Serializable pk) {
        getDao().remove(pk);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void remove(E entity) {
        getDao().remove(entity);
    }

    @Override
    /* TODO config second level cache */
    public void removeFromCache() {
        getDao().evict();
    }

    @Override
    /* TODO config second level cache */
    public void removeFromCache(Serializable pk) {
        getDao().evict(pk);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NESTED)
    public void save(final E entity) {
        getDao().save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NESTED)
    public void save(final List<E> entityList) {
        getDao().save(entityList);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.NESTED)
    public void saveCascade(final List<E> entityList) {
        throw new UnsupportedOperationException("Operation is unsupported.");
    }

    @Override
    public void setDao(final DAO dao) {
        this.dao = dao;
    }

    @Override
    public int count() {
        return getDao().count();
    }

}
