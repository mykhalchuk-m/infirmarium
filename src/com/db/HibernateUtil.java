package com.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hospital.cards.Card;
import com.hospital.hr.Address;
import com.hospital.hr.BloodGroup;
import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.hr.Patient;
import com.hospital.module.AnalysisData;
import com.hospital.module.ModuleData;
import com.hospital.modulecreator.AbstractModule;
import com.hospital.modulecreator.Analysis;
import com.hospital.modulecreator.Module;
import com.hospital.modulecreator.field.Field;
import com.hospital.modulecreator.field.Norm;
import com.hospital.modulecreator.field.SexNorm;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static Session session;

	static {
		try {
			AnnotationConfiguration conf = new AnnotationConfiguration();
			conf.addAnnotatedClass(Address.class);
			conf.addAnnotatedClass(BloodGroup.class);
			conf.addAnnotatedClass(HealthWorker.class);
			conf.addAnnotatedClass(Patient.class);
			conf.addAnnotatedClass(Card.class);
			conf.addAnnotatedClass(Department.class);
			conf.addAnnotatedClass(ModuleData.class);
			conf.addAnnotatedClass(AnalysisData.class);
			conf.addAnnotatedClass(AbstractModule.class);
			conf.addAnnotatedClass(Module.class);
			conf.addAnnotatedClass(Analysis.class);
			conf.addAnnotatedClass(Field.class);
			conf.addAnnotatedClass(Norm.class);
			conf.addAnnotatedClass(SexNorm.class);
			sessionFactory = conf.configure().buildSessionFactory();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Session getSession() {
		if (session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
}
