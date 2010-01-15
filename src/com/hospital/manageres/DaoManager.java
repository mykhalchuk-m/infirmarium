package com.hospital.manageres;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import com.db.HibernateUtil;

public class DaoManager<T> {

	public void newInstance(T t) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> getInstance(Class<T> instanceClass, List<Param> params) {
		List<T> instances = new LinkedList<T>();
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(instanceClass);
			for (Iterator<Param> iterator = params.iterator(); iterator
					.hasNext();) {
				Param param = iterator.next();
				Criterion modNameCriteria = Restrictions.eq(param
						.getParamName(), param.getParamValue());
				criteria.add(modNameCriteria);
			}
			instances = criteria.list();
			transaction.commit();
		} catch (HibernateException e) {
			//logger.info(e.getMessage());!!!!!!!!!!!!!!!!!!!!!!!!!!
			System.out.println(e);
		}
		return instances;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getInstance(Class<T> instanceClass, String searchString) {
		Session session = HibernateUtil.getSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		
		String[] productsField = {"healthWorker.firstName", "healthWorker.lastName", "healthWorker.middleName", "healthWorker.speciality"};

		QueryParser parser = new MultiFieldQueryParser(productsField, new StandardAnalyzer(Version.LUCENE_CURRENT));
		
		parser.setAllowLeadingWildcard(true);
		List<T> result = new LinkedList<T>();
		
		try {
			Query luceneQuery = parser.parse(searchString);
			FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, instanceClass);
			fullTextQuery.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			result = fullTextQuery.list();
			System.out.println("end searching..");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public void updateInstance(T t) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.update(t);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
