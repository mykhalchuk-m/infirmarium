package com.hospital.hr;

public class Address {
	private long id;
	private String country;
	private String region;
	private String district;
	private String city;
	private String street;
	private int home;
	private int fletNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public int getHome() {
		return home;
	}

	public void setHome(int home) {
		this.home = home;
	}

	public int getFletNumber() {
		return fletNumber;
	}

	public void setFletNumber(int fletNumber) {
		this.fletNumber = fletNumber;
	}
	
	public String toString()
	{
		return getCity();
	}

}
