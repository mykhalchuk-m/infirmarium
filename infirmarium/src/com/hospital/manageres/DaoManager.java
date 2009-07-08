package com.hospital.manageres;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.db.HibernateUtil;
import com.logger.LoggerService;

public class DaoManager<T> {
	private Session session;
	private Transaction transaction;
	//private Logger logger = LoggerService.getLogger("daomanager");!!!!!!!!!!!!!!!!!!!!!!!

	public void newInstance(T t) {
		try {
			startOperation();
			session.save(t);
			endOperation();
		} catch (HibernateException e) {
			//logger.info(e.getMessage());!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> getInstance(Class<T> instanceClass, List<Param> params) {
		List<T> instances = new LinkedList<T>();
		try {
			startOperation();
			Criteria criteria = session.createCriteria(instanceClass);
			for (Iterator<Param> iterator = params.iterator(); iterator
					.hasNext();) {
				Param param = iterator.next();
				Criterion modNameCriteria = Restrictions.eq(param
						.getParamName(), param.getParamValue());
				criteria.add(modNameCriteria);
			}
			instances = criteria.list();
			endOperation();
		} catch (HibernateException e) {
			//logger.info(e.getMessage());!!!!!!!!!!!!!!!!!!!!!!!!!!
			System.out.println(e);
		}
		return instances;
	}

	public void updateInstance(T t) {
		try {
			startOperation();
			session.update(t);
			endOperation();
		} catch (HibernateException e) {
			//logger.info(e.getMessage());!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			System.out.println(e);
			e.printStackTrace();
		}
	}

	private void startOperation() throws HibernateException {
		if (session == null) {
			session = HibernateUtil.openSession();
		}
		transaction = session.beginTransaction();
	}

	private void endOperation() throws HibernateException {
		transaction.commit();
	}

	public void close() throws HibernateException {
		session.close();
	}

	@Override
	protected void finalize() throws Throwable {
		close();
		super.finalize();
	}
}
