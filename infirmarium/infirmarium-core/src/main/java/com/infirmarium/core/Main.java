package com.infirmarium.core;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new AnnotationConfiguration()
				.setProperty("hibernate.dialect",
						"org.hibernate.dialect.SQLServerDialect").setProperty(
						"connection.url",
						"jdbc:sqlserver://localhost;databaseName=infirmarium")
				.setProperty("connection.username", "admin").setProperty(
						"connection.password", "admin").setProperty(
						"connection.password", "admin").setProperty(
						"connection.driver_class",
						"com.microsoft.sqlserver.jdbc.SQLServerDriver")
				.configure().buildSessionFactory();
	}
}
