package com.java.hib;

public class Doctor {

	private String speciality;
	private String qualification;
	private String licensePattern;

	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getLicensePattern() {
		return licensePattern;
	}
	public void setLicensePattern(String licensePattern) {
		this.licensePattern = licensePattern;
	}
	@Override
	public String toString() {
		return "Doctor [speciality=" + speciality + ", qualification=" + qualification + ", licensePattern="
				+ licensePattern + "]";
	}



}
