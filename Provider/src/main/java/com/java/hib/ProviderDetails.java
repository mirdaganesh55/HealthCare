package com.java.hib;

import java.util.Date;

public class ProviderDetails {
	
	private String providerid;
	private String firstname;
	private String lastname;
	private Date dateOfBirth;
	private Date enrollmentdate;
	private String email;
	private String licenseNumber;
	private String qualification;
	private String username;
	private String password;
	private String status;
	private String phoneno;
	private Gender gender;
	private String specialty;
	private String address;
	private Date updatedDate;
	private Date reviewDate;

	
	
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getProviderid() {
		return providerid;
	}
	public void setProviderid(String providerid) {
		this.providerid = providerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getEnrollmentdate() {
		return enrollmentdate;
	}
	public void setEnrollmentdate(Date enrollmentdate) {
		this.enrollmentdate = enrollmentdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ProviderDetails(String providerid, String firstname, String lastname, Date dateOfBirth, Date enrollmentdate,
			String email, String licenseNumber, String qualification, String username, String password, String status,
			String phoneno, Gender gender, String specialty, String address) {
		super();
		this.providerid = providerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
		this.enrollmentdate = enrollmentdate;
		this.email = email;
		this.licenseNumber = licenseNumber;
		this.qualification = qualification;
		this.username = username;
		this.password = password;
		this.status = status;
		this.phoneno = phoneno;
		this.gender = gender;
		this.specialty = specialty;
		this.address = address;
	}
	public ProviderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProviderDetails [providerid=" + providerid + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", dateOfBirth=" + dateOfBirth + ", enrollmentdate=" + enrollmentdate + ", email=" + email
				+ ", licenseNumber=" + licenseNumber + ", qualification=" + qualification + ", username=" + username
				+ ", password=" + password + ", status=" + status + ", phoneno=" + phoneno + ", gender=" + gender
				+ ", specialty=" + specialty + ", address=" + address + "]";
	}
	
}
