package com.student.management.MAINET10.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Table(name = "TB_EMPLOYEE_MAS")
@Entity
public class Employee {
	@Column(name = "E_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eid;

	@NotNull
	@Column(name = "EMP_FNAME")
	@JsonProperty("fName")
	private String fName;

	@Column(name = "EMP_MNAME")
	@JsonProperty("mName")
	private String mName;

	@JsonProperty("lName")
	@NotNull
	@Column(name = "EMP_LNAME")
	private String lName;

	@JsonProperty("deptId")
	@NotNull
	@Column(name = "EMP_DEPT")
	private Double deptId;

	@NotNull
	@Column(name = "EMP_LOGIN_NAME")
	private String userName;
	@NotNull
	@Column(name = "PASSWORD")
	private String password;

	@JsonProperty("otp")
	@NotNull
	@Column(name = "OTP")
	private Double otp;
	@NotNull
	@Column(name = "AUTHENTICATION")
	private String authenticated;
	@NotNull
	@Column(name = "IP_ADDRESS")
	private String ipAddress;

}
