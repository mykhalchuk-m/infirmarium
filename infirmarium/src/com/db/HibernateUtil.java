package com.db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	//private static Logger log = LoggerService.getLogger("hibernateutil_log");!!!!!!!!!!!!!!!!!!!!!!!!!

	/**
	 * Constructs a new Singleton SessionFactory
	 * 
	 * @return {@link SessionFactory}
	 * @throws HibernateException
	 */
	public static SessionFactory buildSessionFactory()
			throws HibernateException {
		if (sessionFactory != null) {
			closeFactory();
		}
		return configureSessionFactory();
	}

	/**
	 * Builds a SessionFactory, if it hasn't been already.
	 */
	public static SessionFactory buildIfNeeded() throws HibernateException {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		try {
			return configureSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();////////////////////////////////////////////////////////
			throw new HibernateException(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session openSession() throws HibernateException {
		buildIfNeeded();
		return sessionFactory.openSession();
	}

	public static void closeFactory() {
		if (sessionFactory != null) {
			try {
				sessionFactory.close();
			} catch (HibernateException ignored) {
			//	log.info("Couldn't close SessionFactory. " + ignored); !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		}
	}

	public static void close(Session session) {
		if (session != null) {
			try {
				session.close();
			} catch (HibernateException ignored) {
				//log.info("Couldn't close Session. " + ignored);!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			}
		}
	}

	public static void rollback(Transaction tx) {
		try {
			if (tx != null) {
				tx.rollback();
			}
		} catch (HibernateException ignored) {
			//log.info("Couldn't rollback Transaction. " + ignored); !!!!!!!!!!!!!!!!!!!!!!
		}
	}

	/**
	 * Configure the SessionFactory
	 * 
	 * @return SessionFactory
	 * @throws HibernateException
	 */
	private static SessionFactory configureSessionFactory()
			throws HibernateException {
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}
}
