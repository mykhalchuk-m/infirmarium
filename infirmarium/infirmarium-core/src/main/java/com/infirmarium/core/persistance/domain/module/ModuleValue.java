package com.infirmarium.core.persistance.domain.module;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.infirmarium.core.persistance.coredomain.BaseLongEntity;
import com.infirmarium.core.persistance.domain.Card;
import com.infirmarium.core.persistance.domain.field.FieldValue;

@Entity
@Table(name = ModuleDef.Constants.TABLE_NAME)
@Data
@EqualsAndHashCode(callSuper = true, exclude = { "fieldsValues" })
@ToString(callSuper = true, exclude = { "fieldsValues" })
public class ModuleValue extends BaseLongEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(targetEntity = ModuleDef.class)
	@JoinColumn(name = Columns.MODULE_DEF_ID)
	private ModuleDef moduleDef;
	@ManyToOne(targetEntity = Card.class)
	@JoinColumn(name = Columns.CARD_ID)
	private Card card;
	@OneToMany(mappedBy = FieldValue.Fields.MODULE_VALUE)
	private List<FieldValue> fieldsValues;

	public static class Constants extends BaseLongEntity.Constants {
		public static final String TABLE_NAME = "module_value";
	}

	public static class Columns extends BaseLongEntity.Columns {

		public static final String MODULE_DEF_ID = "module_def_id";
		public static final String CARD_ID = "card_id";

	}

	public static class Fields extends BaseLongEntity.Fields {
		public static final String MODULE_DEF = "moduleDef";
		public static final String CARD = "card";
		public static final String fieldsValues = "fieldsValues";

	}
}
