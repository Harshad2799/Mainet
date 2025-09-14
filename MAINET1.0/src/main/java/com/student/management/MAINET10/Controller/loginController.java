package com.student.management.MAINET10.Controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.student.management.MAINET10.Entity.Employee;
import com.student.management.MAINET10.Repository.LoginRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.student.management.MAINET10.DTO.LoginDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping({"/Login.html" ,"/Rggister.html"})
public class loginController {

	@Autowired
	public LoginRepository loginInterface;

	@RequestMapping("/register")
	public @ResponseBody LoginDto register(HttpServletRequest request, @RequestParam  LoginDto empData) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(empData, emp);
		loginInterface.save(emp);
		return empData;
	}

	@RequestMapping("/Login")
	public @ResponseBody String Login(HttpServletRequest request, @RequestBody LoginDto logindto) {
		LoginDto login = new LoginDto();
		Employee emp = loginInterface.findByUserName(logindto.getUserName());
		return "User Exist";
	}
}
