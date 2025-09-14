package com.student.management.MAINET10.Controller;

import com.student.management.MAINET10.CommonUtil.JWTUtil;
import com.student.management.MAINET10.DTO.LoginDto;
import com.student.management.MAINET10.DTO.LoginResponse;
import com.student.management.MAINET10.Entity.Employee;
import com.student.management.MAINET10.Repository.LoginRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class loginController {

	@Autowired
	private LoginRepository loginRepository;

	private final JWTUtil jwtUtil;

	// Constructor injection (must be public)
	public loginController(JWTUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	// Register API
	@PostMapping("/register")
	public ResponseEntity<Employee> register(@RequestBody Employee empData) {
		Employee savedEmp = loginRepository.save(empData);
		return ResponseEntity.ok(savedEmp);
	}

	// Login API
	@PostMapping("/login")
	public ResponseEntity<?> login(HttpServletRequest req,  @RequestBody LoginDto logindto) {
		Employee emp = loginRepository.findByUserName(logindto.getUserName());

		if (logindto.getUserName().equals("Admin") && logindto.getPassword().equals("Pass@123")) {
			LoginResponse login = new LoginResponse();
			login.setToken(jwtUtil.generateJWTToken(logindto.getUserName()));
			login.setUsername(logindto.getUserName());
			return ResponseEntity.ok(login);
		} else {
			return ResponseEntity.status(401).body("Invalid username or password");
		}
	}
}
