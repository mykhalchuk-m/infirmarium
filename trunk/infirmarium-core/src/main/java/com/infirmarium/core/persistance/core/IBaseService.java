package com.infirmarium.core.persistance.core;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unchecked")
public interface IBaseService<E extends BaseEntity, DAO extends BaseDAO> {

    void setDao(final DAO dao);

    DAO getDao();

    List<E> getAll();

    void save(final E entity);

    void save(final List<E> entityList);

    void saveCascade(final List<E> entityList);

    E loadEntity(final Class<E> clazz, final Serializable pk);

    E getByPK(final Serializable pk);

    E load(final Serializable pk);

    E merge(final E entity);

    int count();

    void remove(final Serializable pk);

    void flush();

    void remove(final E entity);

    void removeFromCache();

    void removeFromCache(final Serializable pk);
}
