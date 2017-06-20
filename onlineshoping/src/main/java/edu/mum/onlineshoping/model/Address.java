package edu.mum.onlineshoping.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message="Not Empty")
	private String street;
	@NotEmpty(message="Not Empty")
	private String city;
	@NotEmpty(message="Not Empty")
	@Size(min=2,max=2,message="Not valid")
	private String state;
	@NotEmpty
	//@Digits(integer=5,fraction=0,message="digit")
	@Size(min=1,max=1,message="Not Valid")
	private String zip;
	@NotEmpty(message="Not Empty")
	private String country;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
