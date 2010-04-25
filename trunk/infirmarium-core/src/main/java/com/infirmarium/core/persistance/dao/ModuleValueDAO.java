/**
 * 
 */
package com.infirmarium.core.persistance.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.infirmarium.core.persistance.dao.core.BaseLongDAO;
import com.infirmarium.core.persistance.domain.Card;
import com.infirmarium.core.persistance.domain.field.FieldValue;
import com.infirmarium.core.persistance.domain.module.ModuleValue;

public class ModuleValueDAO extends BaseLongDAO<ModuleValue> {

	public FieldValue getByCard(Card card) {
		Criteria criteria = createBaseCriteria();
		criteria.add(Restrictions.eq(ModuleValue.Fields.CARD, card));
		return (FieldValue) criteria.list();
	}

}
