package web.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.hospital.hr.Address;
import com.hospital.hr.BloodGroup;
import com.hospital.hr.Patient;
import com.hospital.hr.SexTypes;
import com.hospital.manageres.DaoManager;
import com.hospital.service.DbService;
import com.opensymphony.xwork2.ActionSupport;

public class AddPatient extends ActionSupport {

	private static final long serialVersionUID = 9154861277722836537L;

	private Patient patient = new Patient();
	private Address address = new Address();
	private String lastName;
	private String firstName;
	private String middleName;
	private String country;
	private String region;
	private String district;
	private String city;
	private String street;
	private String home;
	private String flatNumber;
	private String bloodGroupString;
	private String sexString;
	private String birthdayString;
	private String result;

	public String execute() throws Exception {

		patient.setFirstName(getFirstName());
		patient.setMiddleName(getMiddleName());
		patient.setLastName(getLastName());

		address.setCountry(getCountry());
		address.setRegion(getRegion());
		address.setDistrict(getDistrict());
		address.setCity(getCity());
		address.setStreet(getStreet());

		patient.setAddress(address);

		BloodGroup bloodGroup = DbService
				.getBloodGroupByName(getBloodGroupString());
		patient.setBloodGroup(bloodGroup);

		SexTypes sex = SexTypes.valueOf(getSexString());
		patient.setSex(sex);

		DaoManager<Patient> dao = new DaoManager<Patient>();
		dao.newInstance(patient);
		// dao.close();

		result = "Пацієнт \"" + patient.getFirstName() + " "
				+ patient.getLastName() + "\"" + " був успішно доданий";
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+result);
		return SUCCESS;
	}

	public void validate() {

		if (getFirstName().length() == 0) {
			addFieldError("firstName", "Ім'я не введене.");
		}
		if (getLastName().length() == 0) {
			addFieldError("lastName", "Прізвище не введене.");
		}
		if (getMiddleName().length() == 0) {
			addFieldError("middleName", "По-батькові не введені.");
		}		
		if (getBirthdayString().length() == 0) {
			addFieldError("birthday", "Дата народження не введена.");
		}
		validateData();

	}

	// public Patient getModel() {
	//
	// return patient;
	// }

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

	private void validateData() {
		try {
			DateFormat formatter = new SimpleDateFormat("dd/mm/yy");
			Date date = (Date) formatter.parse(birthdayString);
			patient.setBirthday(date);
		} catch (ParseException e) {
			addFieldError("birthday",
					"дата народження була введена не коректно");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}