package com.hospital.hr;


public class HealthWorker {
	private long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String speciality;
	private String login;
	private String password;
	private Boolean exist = Boolean.TRUE;
	private Role role = Role.WORKER;

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getExist() {
		return exist;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int hashCode() {
		return (int) (firstName.hashCode() + lastName.hashCode() + middleName
				.hashCode()
				* id);
	}

	public boolean equals(Object o) {
		return hashCode() == ((HealthWorker) o).hashCode();
	}
}
