package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.model.FileModel;
import com.assignment.service.DataService;

@RestController
public class DataController {

	@Autowired
	DataService dataService;
	
	 /*
	  * Service to add Address for a specific user.
	  * Input json with address,address_type and user_id is mapped to AddressModel object.
	  */
	 @RequestMapping(value = "/addData", method = RequestMethod.POST, headers = "Accept=application/json")
	 public void addData(@RequestBody FileModel file) {
		 System.out.println("Inside addData Controller for addData method");
		 dataService.addData(file);
	 }
	 
}

