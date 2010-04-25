package com.infirmarium.core.persistance.util;

import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Stateless
public class HibernateUtilImpl implements IHibernateUtil {

	@PersistenceContext
	private static Session session;

	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;
		try {
			InitialContext ctx = new InitialContext();
			IHibernateUtil hibernateUtil = (IHibernateUtil) ctx
					.lookup("HibernateUtilImpl/local");
			sessionFactory = hibernateUtil.getSessionFactoryInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sessionFactory;

	}

	@Override
	public SessionFactory getSessionFactoryInstance() {
		return session.getSessionFactory();
	}
}