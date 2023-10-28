package com.empapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Login_Master")
@Getter
@Setter
public class LoginMasterInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "login_id")
	private String loginId;

	@NonNull
	@Column(name = "usermail")
	private String userMail;

	@NonNull
	@Column(name = "password")
	private String password;

	@NonNull
	@Column(name = "login_attempts")
	private Integer loginAttempts;

	@NonNull
	@Column(name = "locked")
	private Boolean locked;

	@NonNull
	@Column(name = "status")
	private String status;

	@NonNull
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "modified_date")
	private Date modifiedDate;
	
	@NonNull
	@Column(name = "admin_user")
	private Boolean adminUser;
	
}
