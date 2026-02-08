package com.student.management.MAINET10.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.management.MAINET10.DTO.LoginDto;
import com.student.management.MAINET10.Entity.Employee;
import com.student.management.MAINET10.Repository.LoginRepository;

@Service
public class loginService implements IloginService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public LoginDto register(Employee empData) {
		Employee savedEmp = null;
		LoginDto resDto = new LoginDto();
		try {
			String encryptedPassword = passwordEncoder.encode(empData.getPassword());
			empData.setPassword(encryptedPassword);
			savedEmp = loginRepository.save(empData);
			BeanUtils.copyProperties(savedEmp, resDto);
			resDto.setStatus("success");
			resDto.setResMsg("User registered successfully");
			return resDto;
		} catch (Exception e) {
			resDto.setStatus("failure");
			resDto.setResMsg("User registration failed");
			return resDto;
		}
	}

	public Boolean login(String LoginName, String Password) {

		return true;
	}

}
