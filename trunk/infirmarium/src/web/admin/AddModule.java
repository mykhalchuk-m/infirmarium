package web.admin;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.ParameterAware;

import com.hospital.hr.Department;
import com.hospital.manageres.DaoManager;
import com.hospital.modulecreator.Module;
import com.hospital.modulecreator.field.Field;
import com.hospital.modulecreator.field.FieldTypes;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AddModule extends ActionSupport implements Action, ParameterAware {

	private static final long serialVersionUID = -2014642038634931829L;

	private Map params;
	private String department;
	private String result;
	private Module module;
	private List<String> types;

	public String execute() throws Exception {

		Department depart = DbService.getDepartmentByName(getDepartment());

		depart.addModule(module);

		DaoManager<Department> dao = new DaoManager<Department>();
		dao.updateInstance(depart);
		dao.close();

		result = "Модуль \"" + module.getModuleName() + "\""
				+ " був успішно доданий";
		return SUCCESS;

	}

	public void setParameters(Map params) {
		this.params = params;

	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public void validate() {

		setEnumFieldType();

		if (module.getModuleName().length() == 0) {
			addFieldError("module.moduleName", "введіть, будь-ласка, ім'я модуля");
		} else if (isDuplicatedModuleNameInDB()) {
			addFieldError("module.moduleName", "такий модуль вже існує");
		}

		if (module.getParameters().size() == 0) {
			addFieldError("module.moduleName", "введіть, будь-ласка, параметри модуля");
		} else {

			if (isDuplicatedFieldsNames()) {
				addFieldError("module.parameters.name",
						"такий параметер вже існує");
			}
			if (!isValidFieldsValues()) {
				addFieldError("module.parameters.values",
						"було введено менше двох значень");
			}

			if (!isValidFieldsNames()) {
				addFieldError("module.parameters.name",
						"введіть, будь-ласка, ім'я поля");
			}

			if (isEmptyFieldsValues()) {
				addFieldError("module.parameters.values",
						"введіть, будь-ласка, значення поля");
			}

			if (isDuplicatedFieldsValues()) {
				addFieldError("module.parameters.values",
						"таке значення вже було введено");
			}
		}
	}

	private boolean isDuplicatedModuleNameInDB() {

		List<Module> modules = DbService.getAllModules();
		for (Iterator<Module> iterator = modules.iterator(); iterator.hasNext();) {
			Module moduleFromDB = iterator.next();
			if (moduleFromDB.getModuleName().equalsIgnoreCase(
					module.getModuleName())) {
				return true;
			}
		}
		return false;
	}

	private boolean isEmptyFieldsValues() {
		for (Iterator<Field> iteratorField = module.getParameters().iterator(); iteratorField
				.hasNext();) {
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
		for (Iterator<Field> iteratorField = module.getParameters().iterator(); iteratorField
				.hasNext();) {
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
		for (Iterator<Field> iterator = module.getParameters().iterator(); iterator
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
		for (Iterator<Field> iterator = module.getParameters().iterator(); iterator
				.hasNext();) {
			Field field = iterator.next();

			names.add(field.getName());

		}

		if (names.size() == module.getParameters().size()) {
			return false;
		} else {
			return true;
		}

	}

	private boolean isValidFieldsValues() {

		for (Iterator<Field> iterator = module.getParameters().iterator(); iterator
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

		for (int i = 0; i < module.getParameters().size(); i++) {
			Field field = module.getParameters().get(i);
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
}
