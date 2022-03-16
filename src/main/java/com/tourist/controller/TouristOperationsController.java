package com.tourist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourist.common.ResponseHandler;
import com.tourist.entity.Tourist;
import com.tourist.exception.TouristNotFoundException;
import com.tourist.service.ITouristService;

@RestController
@RequestMapping("/tourist")
public class TouristOperationsController {

	@Autowired
	private ITouristService service;

	@PostMapping("/save")
	public ResponseEntity<Object> saveTourist(@RequestBody Tourist tourist) throws Exception {
		String result = service.registerTourist(tourist);
		System.out.println("Tourist details are " + result);
		// return new ResponseEntity<String>(result, HttpStatus.CREATED);
		return ResponseHandler.generateResponse("Successfully Tourist data inserted", HttpStatus.CREATED, result);
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourists() throws Exception {
		List<Tourist> list = service.fetchAllTourists();
		// return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		return ResponseHandler.generateResponse("All Tourist Details are", HttpStatus.OK, list);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> findTouristById(@PathVariable("id") Integer id) throws TouristNotFoundException {
		Tourist tourist = service.findByTourist(id);
		// return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		return ResponseHandler.generateResponse("This TouristId Details is", HttpStatus.OK, tourist);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateTourist(@RequestBody Tourist tourist) throws TouristNotFoundException {
		String msg = service.updateTourist(tourist);
		// return new ResponseEntity<String>(msg, HttpStatus.OK);
		return ResponseHandler.generateResponse("Tourist data is Updated", HttpStatus.OK, msg);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteTourist(@PathVariable("id") Integer id) throws TouristNotFoundException {
		String msg = service.deleteTourit(id);
		// return new ResponseEntity<String>(msg, HttpStatus.OK);
		return ResponseHandler.generateResponse("Tourist Deleted Successfully", HttpStatus.OK, msg);
	}

}
