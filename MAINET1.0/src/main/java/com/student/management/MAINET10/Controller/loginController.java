package com.student.management.MAINET10.Controller;

import com.student.management.MAINET10.CommonUtil.JWTUtil;
import com.student.management.MAINET10.DTO.LoginDto;
import com.student.management.MAINET10.DTO.LoginResponse;
import com.student.management.MAINET10.Entity.Employee;
import com.student.management.MAINET10.Repository.LoginRepository;
import com.student.management.MAINET10.Service.IloginService;
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
	private IloginService loginService;

	@Autowired
	private LoginRepository loginRepository;

	private final JWTUtil jwtUtil;

	// Constructor injection (must be public)
	public loginController(JWTUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	// Register API
	@PostMapping("/register")
	public ResponseEntity<LoginDto> register(@RequestBody Employee empData) {
		LoginDto response = loginService.register(empData);
		if (response.getStatus().equals("success")) {
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(401).body(response);
		}
	}

	// Login API
	@PostMapping("/login")
	public ResponseEntity<?> login(HttpServletRequest req, @RequestBody LoginDto logindto) {
		Employee emp = loginRepository.findByUserName(logindto.getUserName());

		if (logindto.getUserName().equals(emp.getUserName()) && logindto.getPassword().equals(emp.getPassword())) {
			LoginResponse login = new LoginResponse();
			login.setToken(jwtUtil.generateJWTToken(logindto.getUserName()));
			login.setUsername(logindto.getUserName());
			return ResponseEntity.ok(login);
		} else {
			return ResponseEntity.status(401).body("Invalid username or password");
		}
	}
}
