package com.participant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Signup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Name field is required !!")
	@Size(min = 2, max = 20, message = "min 2 and max 20 characters are allowed !!")
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private String collegeName;
	private String role;

	@OneToOne(mappedBy = "signup", cascade = CascadeType.ALL)
	private Participant participant;
	

	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Signup(int id,
			@NotBlank(message = "Name field is required !!") @Size(min = 2, max = 20, message = "min 2 and max 20 characters are allowed !!") String name,
			String email, String password, String collegeName, String role, Participant participant) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.collegeName = collegeName;
		this.role = role;
		this.participant = participant;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

}