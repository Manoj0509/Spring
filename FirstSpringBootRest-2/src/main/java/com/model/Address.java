package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Address123")
public class Address {
	
	@Id
	@GeneratedValue
	private int aid;
	private String city;
	
	
	@ManyToOne
	@JoinColumn(name="jaid")
	Coder coder1;
	
	public Coder getCoder1() {
		return coder1;
	}
	public void setCoder1(Coder coder1) {
		this.coder1 = coder1;
	}

	public int getAid() {
		return aid;
	}
	
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", city=" + city + ", coder=" + coder1 + "]";
	}
}
