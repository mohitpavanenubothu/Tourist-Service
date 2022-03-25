package com.tourist.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Student-Service")
public interface IStudentServiceRestConsumer {
	
	@GetMapping("/student/allStudents")
	public String fetchStudentDetails();

}
