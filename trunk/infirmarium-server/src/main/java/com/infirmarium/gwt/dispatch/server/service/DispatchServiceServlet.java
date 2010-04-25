package com.infirmarium.gwt.dispatch.server.service;

import net.customware.gwt.dispatch.client.service.DispatchService;
import net.customware.gwt.dispatch.server.Dispatch;
import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.ActionException;
import net.customware.gwt.dispatch.shared.Result;
import net.sf.beanlib.hibernate.UnEnhancer;
import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.gwt.GwtConfigurationHelper;
import net.sf.gilead.gwt.PersistentRemoteService;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.infirmarium.core.persistance.domain.Person;
import com.infirmarium.core.persistance.util.HibernateUtilImpl;
import com.infirmarium.server.shared.results.GetPersonsCommandResult;

@Singleton
public class DispatchServiceServlet extends PersistentRemoteService implements
		DispatchService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Dispatch dispatch;
	private net.sf.gilead.core.hibernate.HibernateUtil gileadHibernateUtil = new net.sf.gilead.core.hibernate.HibernateUtil();

	@Inject
	public DispatchServiceServlet(Dispatch dispatch) {
		this.dispatch = dispatch;
		gileadHibernateUtil.setSessionFactory(HibernateUtilImpl
				.getSessionFactory());
		UnEnhancer.setDefaultCheckCGLib(false);
		PersistentBeanManager persistentBeanManager = GwtConfigurationHelper
				.initGwtStatelessBeanManager(gileadHibernateUtil);
		persistentBeanManager.setPersistenceUtil(gileadHibernateUtil);
		setBeanManager(persistentBeanManager);

	}

	public Result execute(Action<?> action) throws ActionException {
		Session session = null;
		Transaction transaction = null;
		GetPersonsCommandResult result = null;
		try {
			session = gileadHibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Person.class);
			result = new GetPersonsCommandResult();
			result.setPerson(criteria.list());
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
		//
		// try {
		// return dispatch.execute(action);
		// } catch (RuntimeException e) {
		// log("Exception while executing " + action.getClass().getName()
		// + ": " + e.getMessage(), e);
		// throw e;
		// }
	}
}
