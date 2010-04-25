package com.infirmarium.core.persistance.dao.core;

import com.infirmarium.core.persistance.coredomain.BaseLongEntity;

public abstract class BaseLongDAO<E extends BaseLongEntity> extends
		BaseDAO<E, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseLongDAO() {
		super();
	}
}
