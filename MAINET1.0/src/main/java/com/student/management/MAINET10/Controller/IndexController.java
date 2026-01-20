package com.student.management.MAINET10.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Home.html")
public class IndexController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/")
	String index() {
		logger.info("Starting method index");
		return "index";
	}

}
