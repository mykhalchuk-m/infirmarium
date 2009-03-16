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
	private Logger logger = LoggerService.getLogger("daomanager");

	/**
	 * This method allow you to save an instance of any mapped object to data
	 * base
	 * 
	 * @param T
	 *            instance of object, which you indicate in generic
	 */
	public void newInstance(T t) {
		try {
			startOperation();
			session.save(t);
			endOperation();
		} catch (HibernateException e) {
			logger.info(e.getMessage());
		}
	}

	/**
	 * This method allow you to update an instance of any mapped object that you
	 * receive from data base early
	 * 
	 * @param T
	 *            instance of object, which you indicate in generic
	 */
	public void updateInstance(T t) {
		try {
			startOperation();
			session.update(t);
			endOperation();
		} catch (HibernateException e) {
			logger.info(e.getMessage());
		}
	}

	/**
	 * This method allow us to receive an list of objects from data base
	 * 
	 * @param Class
	 *            this parameter define us instance of which object we want to
	 *            receive
	 * @param List
	 *            here we must define list of parameters in format parameter
	 *            name - parameter value like criteria in data base. If this
	 *            list will be empty we receive all objects given class from
	 *            data base
	 * @return list of objects which we indicated in generic and filtered in
	 *         input parameters
	 */
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
			logger.info(e.getMessage());
		}
		return instances;
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
}
