package com.participant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private int theoryMarks1;
	private int theoryMarks2;
	private int practicalMarks1;
	private int practicalMarks2;
	private boolean sportsQuota;
	private double total;
	private String result;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "signup_id", referencedColumnName = "id")
	private Signup signup;

	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participant(int id, String name, String email ,int theoryMarks1, int theoryMarks2, int practicalMarks1,
			int practicalMarks2, boolean sportsQuota, double total, String result, Signup signup) {
		super();
		this.id = id;
		this.name = name;
		this.email=email;
		this.theoryMarks1 = theoryMarks1;
		this.theoryMarks2 = theoryMarks2;
		this.practicalMarks1 = practicalMarks1;
		this.practicalMarks2 = practicalMarks2;
		this.sportsQuota = sportsQuota;
		this.total = total;
		this.result = result;
		this.signup = signup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTheoryMarks1() {
		return theoryMarks1;
	}

	public void setTheoryMarks1(int theoryMarks1) {
		this.theoryMarks1 = theoryMarks1;
	}

	public int getTheoryMarks2() {
		return theoryMarks2;
	}

	public void setTheoryMarks2(int theoryMarks2) {
		this.theoryMarks2 = theoryMarks2;
	}

	public int getPracticalMarks1() {
		return practicalMarks1;
	}

	public void setPracticalMarks1(int practicalMarks1) {
		this.practicalMarks1 = practicalMarks1;
	}

	public int getPracticalMarks2() {
		return practicalMarks2;
	}

	public void setPracticalMarks2(int practicalMarks2) {
		this.practicalMarks2 = practicalMarks2;
	}

	public boolean isSportsQuota() {
		return sportsQuota;
	}

	public void setSportsQuota(boolean sportsQuota) {
		this.sportsQuota = sportsQuota;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Signup getSignup() {
		return signup;
	}

	public void setSignup(Signup signup) {
		this.signup = signup;
	}

}
