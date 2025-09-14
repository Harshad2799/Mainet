package com.student.management.MAINET10.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "TB_EMPLOYEE_MAS")
@Entity
public class Employee {
	@Column(name = "E_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eid;
	@Column(name = "EMP_FNAME")
	private String fName;
	@Column(name = "EMP_MNAME")
	private String mNane;
	@Column(name = "EMP_LNAME")
	private String lName;
	@Column(name = "EMP_DEPT")
	private Double deptId;
	@Column(name = "EMP_LOGIN_NAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "OTP")
	private Double otp;
	@Column(name = "AUTHENTICATION")
	private String Authenticated;
	@Column(name = "IP_ADDRESS")
	private String Ip_address;

}
