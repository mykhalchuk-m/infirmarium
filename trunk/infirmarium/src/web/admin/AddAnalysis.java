package web.admin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.ParameterAware;

import com.hospital.hr.Department;
import com.hospital.manageres.DaoManager;
import com.hospital.modulecreator.Analysis;
import com.hospital.modulecreator.Module;
import com.hospital.modulecreator.field.Field;
import com.hospital.modulecreator.field.FieldTypes;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AddAnalysis extends ActionSupport implements Action,
		ParameterAware {

	private static final long serialVersionUID = -2014642038634931829L;

	private Map params;
	private String department;
	private String result;
	private Analysis analysis;
	private List<String> types;

	public String execute() throws Exception {

		setOneToOneRelation();

		Department depart = DbService.getDepartmentByName(getDepartment());

		depart.addAnalysis(analysis);

		DaoManager<Department> dao = new DaoManager<Department>();
		dao.updateInstance(depart);
		dao.close();

		result = "Аналіз \"" + analysis.getModuleName() + "\""
				+ " був успішно доданий";
		return SUCCESS;

	}

	public void setParameters(Map params) {
		this.params = params;

	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	private void setOneToOneRelation() {
		for (Iterator<Field> iterator = analysis.getParameters().iterator(); iterator
				.hasNext();) {
			Field field = iterator.next();
				
			if (field.getType().name().equals(FieldTypes.NORM.name())) {
				field.getNorm().setField(field);
				field.setSexNorm(null); // update jsp form
			}else if (field.getType().name().equals(FieldTypes.SEX_NORM.name())) {
				field.getSexNorm().setField(field);
				field.setNorm(null); // update jsp form
			}else  {
				field.setNorm(null);// update jsp form
				field.setSexNorm(null);// update jsp form
			}
			

		}
	}

	public void validate() {

		setEnumFieldType();

		if (analysis.getModuleName().length() == 0) {
			addFieldError("module.moduleName", "введіть, будь-ласка, назву аналізу");
		} else if (isDuplicatedModuleNameInDB()) {
			addFieldError("module.moduleName",
					"такий аналіз вже існує");
		}

		if (analysis.getParameters().size() == 0) {
			addFieldError("module.moduleName", "введіть, будь-ласка, хоча б один параметер");
		} else {

			if (isDuplicatedFieldsNames()) {
				addFieldError("module.parameters.name",
						"поле з такою назвою вже існує");
			}
			if (!isValidFieldsValues()) {
				addFieldError("module.parameters.values",
						"було введено менше двох параметрів для вибору");
			}

			if (!isValidFieldsNames()) {
				addFieldError("module.parameters.name",
						"введіть, будь-ласка, назву поля");
			}

			if (isEmptyFieldsValues()) {
				addFieldError("module.parameters.values",
						"введіть, будь-ласка, значення поля");
			} else if (isDuplicatedFieldsValues()) {
				addFieldError("module.parameters.values",
						"таке значення поля вже існує");
			}
			if (!isValidNormValues()) {
				addFieldError("module.parameters.norm",
						"мінімальне значення було введене більшим ніж максимальне, поправте, будь-ліска");
			}
			if (!isValidUnitValue()) {
				addFieldError("module.parameters.norm.unit",
						"введіть, будь-ласка, розмірну величину");
			}

		}

	}

	private boolean isValidNormValues() {
		for (Iterator<Field> iterator = analysis.getParameters().iterator(); iterator
				.hasNext();) {
			Field field = iterator.next();
			if (field.getType().name().equals(FieldTypes.NORM.name())) {
				if (field.getNorm().getMinValue() >= field.getNorm()
						.getMaxValue()) {
					return false;
				}
			}

			if (field.getType().name().equals(FieldTypes.SEX_NORM.name())) {
				if (field.getSexNorm().getMinMaleValue() >= field.getSexNorm()
						.getMaxMaleValue()) {
					return false;
				}
				if (field.getSexNorm().getMinFemaleValue() >= field
						.getSexNorm().getMaxFemaleValue()) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isValidUnitValue() {
		for (Iterator<Field> iterator = analysis.getParameters().iterator(); iterator
				.hasNext();) {
			Field field = iterator.next();
			if (field.getType().name().equals(FieldTypes.NORM.name())) {
				if (field.getNorm().getUnit().length() == 0) {
					return false;
				}
			}
			if (field.getType().name().equals(FieldTypes.SEX_NORM.name())) {
				if (field.getSexNorm().getUnit().length() == 0) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isDuplicatedModuleNameInDB() {

		List<Module> modules = DbService.getAllModules();
		for (Iterator<Module> iterator = modules.iterator(); iterator.hasNext();) {
			Module moduleFromDB = iterator.next();
			if (moduleFromDB.getModuleName().equalsIgnoreCase(
					analysis.getModuleName())) {
				return true;
			}
		}
		return false;
	}

	private boolean isEmptyFieldsValues() {
		for (Iterator<Field> iteratorField = analysis.getParameters()
				.iterator(); iteratorField.hasNext();) {
			Field field = iteratorField.next();
			if (field.getType().name().equals(FieldTypes.SELECTBOX.name())) {
				for (Iterator<String> iteratorValues = field.getValues()
						.iterator(); iteratorValues.hasNext();) {
					String fieldValue = iteratorValues.next();
					if (fieldValue.length() == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isDuplicatedFieldsValues() {
		for (Iterator<Field> iteratorField = analysis.getParameters()
				.iterator(); iteratorField.hasNext();) {
			Field field = iteratorField.next();

			if (field.getType().name().equals(FieldTypes.SELECTBOX.name())) {
				Set<String> names = new HashSet<String>();
				for (Iterator<String> iteratorValues = field.getValues()
						.iterator(); iteratorValues.hasNext();) {
					String fieldValue = iteratorValues.next();
					names.add(fieldValue);
				}
				if (names.size() != field.getValues().size()) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isValidFieldsNames() {
		for (Iterator<Field> iterator = analysis.getParameters().iterator(); iterator
				.hasNext();) {
			Field field = iterator.next();
			if (field.getName().length() == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isDuplicatedFieldsNames() {
		Set<String> names = new HashSet<String>();
		for (Iterator<Field> iterator = analysis.getParameters().iterator(); iterator
				.hasNext();) {
			Field field = iterator.next();

			names.add(field.getName());

		}

		if (names.size() == analysis.getParameters().size()) {
			return false;
		} else {
			return true;
		}

	}

	private boolean isValidFieldsValues() {

		for (Iterator<Field> iterator = analysis.getParameters().iterator(); iterator
				.hasNext();) {
			Field field = iterator.next();
			if (field.getType().name().equals(FieldTypes.SELECTBOX.name())) {
				if (field.getValues().size() < 2) {
					return false;
				}
			}
		}

		return true;

	}

	private void setEnumFieldType() {

		for (int i = 0; i < analysis.getParameters().size(); i++) {
			Field field = analysis.getParameters().get(i);
			field.setType(FieldTypes.valueOf(types.get(i)));
		}

	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}
}
