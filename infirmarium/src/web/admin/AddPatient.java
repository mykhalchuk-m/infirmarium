package web.admin;

import java.util.Date;

import com.hospital.hr.BloodGroup;
import com.hospital.hr.Patient;
import com.hospital.hr.SexTypes;
import com.hospital.manageres.DaoManager;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddPatient extends ActionSupport implements ModelDriven<Patient> {

	private static final long serialVersionUID = 9154861277722836537L;

	private Patient patient = new Patient();
	private String bloodGroupString;
	private String sexString;
	private String birthdayString;
	private String result;

	public String execute() throws Exception {

		BloodGroup bloodGroup = DbService
				.getBloodGroupByName(getBloodGroupString());
		patient.setBloodGroup(bloodGroup);

		SexTypes sex = SexTypes.valueOf(getSexString());
		patient.setSex(sex);

		DaoManager<Patient> dao = new DaoManager<Patient>();
		dao.newInstance(patient);
		dao.close();

		result = "пацієнт \"" + patient.getFirstName() + " "
				+ patient.getLastName() + "\"" + " доданий в базу лікані";
		return SUCCESS;
	}

	public void validate() {

		if (patient.getFirstName().length() == 0) {
			addFieldError("firstName", "введіть імя");
		}
		if (patient.getLastName().length() == 0) {
			addFieldError("lastName", "введіть прізвище");
		}
		if (patient.getMiddleName().length() == 0) {
			addFieldError("middleName", "введіть по-батькові");
		}
		if (patient.getAddress().length() == 0) {
			addFieldError("address", "введіть адрес");
		}
		if (getBirthdayString().length() == 0) {
			addFieldError("birthday", "введіть дату народження");
		}
		validateData();

	}

	public Patient getModel() {

		return patient;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getBloodGroupString() {
		return bloodGroupString;
	}

	public void setBloodGroupString(String bloodGroupString) {
		this.bloodGroupString = bloodGroupString;
	}

	public String getSexString() {
		return sexString;
	}

	public void setSexString(String sexString) {
		this.sexString = sexString;
	}

	public String getBirthdayString() {
		return birthdayString;
	}

	public void setBirthdayString(String birthdayString) {
		this.birthdayString = birthdayString;
	}

	@SuppressWarnings("deprecation")
	private void validateData() {
		try {
			String dd = getBirthdayString().substring(0,
					getBirthdayString().indexOf("-"));
			String mm = getBirthdayString().substring(
					getBirthdayString().indexOf("-") + 1,
					getBirthdayString().lastIndexOf("-"));
			String yyyy = getBirthdayString().substring(
					getBirthdayString().lastIndexOf("-") + 1,
					getBirthdayString().length());

			Date date = new Date();
			date.setDate(Integer.valueOf(dd));
			date.setMonth(Integer.valueOf(mm) - 1);
			date.setYear(Integer.valueOf(yyyy) - 1900);

			patient.setBirthday(date);

		} catch (Exception e) {
			addFieldError("birthday", "введіть коректно дату народження");
		}
	}

}
