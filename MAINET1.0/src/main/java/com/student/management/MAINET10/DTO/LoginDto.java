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
	private String authenticated;
	private String ipAddress;
	private Long organization;
	private String resMsg;
	private String status;
	private String tocken;

}
