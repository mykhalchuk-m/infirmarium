/**
 * 
 */
package com.infirmarium.core.persistance.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.infirmarium.core.persistance.core.BaseLongDAO;
import com.infirmarium.core.persistance.domain.field.FieldValue;
import com.infirmarium.core.persistance.domain.module.ModuleValue;

public class FieldValueDAO extends BaseLongDAO<FieldValue> {

	public FieldValue getByModuleValue(ModuleValue moduleValue) {
		Criteria criteria = createBaseCriteria();
		criteria.add(Restrictions.eq(FieldValue.Fields.MODULE_VALUE,
				moduleValue));
		return (FieldValue) criteria.list();
	}

}
