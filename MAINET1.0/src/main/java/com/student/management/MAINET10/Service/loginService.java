package com.student.management.MAINET10.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.MAINET10.DTO.LoginDto;
import com.student.management.MAINET10.Entity.Employee;
import com.student.management.MAINET10.Repository.LoginRepository;

@Service
public class loginService implements IloginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public LoginDto register(Employee empData) {
		Employee savedEmp = null;
		LoginDto resDto = new LoginDto();
		try {
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

	public void DecryptPassword(String LoginName) {

	}

	public void EncryptPassword(String LoginName) {

	}
}
