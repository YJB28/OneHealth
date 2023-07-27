package com.oneHealth.PatientCheckout.Entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Patient {
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

   
    @Column(name = "user_id")
    private Integer userId;
    
    private String firstName;
    
    private String lastName;
  
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Patient(Integer patientId, Integer userId, String firstName, String lastName, String mobileNumber,
			String address, String pinCode, String country, String city, String gender, Integer age, Date dob,
			String bloodGroup, BigDecimal height, BigDecimal weight, String maritalStatus, String email) {
		super();
		this.patientId = patientId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.pinCode = pinCode;
		this.country = country;
		this.city = city;
		this.gender = gender;
		this.age = age;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.height = height;
		this.weight = weight;
		this.maritalStatus = maritalStatus;
		this.email = email;
	}


	@Column(length = 10)
    private String mobileNumber;
	
	

	@Column(length = 100)
    private String address;

    @Column(length = 6)
    private String pinCode;

    @Column(length = 50)
    private String country;

    @Column(length = 30)
    private String city;

    @Column(length = 10)
    private String gender;

    private Integer age;

    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(length = 10)
    private String bloodGroup;

    private BigDecimal height;

    private BigDecimal weight;

    @Column(length = 20)
    private String maritalStatus;

    @Column(length = 100)
    private String email;

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Patient(Integer patientId, Integer userId, String mobileNumber, String address, String pinCode,
			String country, String city, String gender, Integer age, Date dob, String bloodGroup, BigDecimal height,
			BigDecimal weight, String maritalStatus, String email) {
		super();
		this.patientId = patientId;
		this.userId = userId;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.pinCode = pinCode;
		this.country = country;
		this.city = city;
		this.gender = gender;
		this.age = age;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.height = height;
		this.weight = weight;
		this.maritalStatus = maritalStatus;
		this.email = email;
	}

    // Constructors, getters, setters, etc.
    
    
}

