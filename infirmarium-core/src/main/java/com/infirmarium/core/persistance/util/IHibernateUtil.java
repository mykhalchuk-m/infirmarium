package com.infirmarium.core.persistance.util;

import javax.ejb.Local;

import org.hibernate.SessionFactory;

@Local
public interface IHibernateUtil {
	public SessionFactory getSessionFactoryInstance();

}
