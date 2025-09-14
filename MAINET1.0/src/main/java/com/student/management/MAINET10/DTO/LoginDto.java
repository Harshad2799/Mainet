package com.student.management.MAINET10.DTO;

import lombok.Data;

@Data
public class LoginDto {
	private String fName;
	private String mNane;
	private String lName;
	private Double deptId;
	private String userName;
	private String password;
	private Double otp;
	private String Authenticated;
	private String Ip_address;
	private Long organization;


}
