package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.assignment.model.FileModel;
import com.assignment.model.ReturnModel;
import com.assignment.service.DataService;

@CrossOrigin(origins="*", maxAge=4800, allowCredentials="False")
@RestController
public class DataController {

	@Autowired
	DataService dataService;
	
	 /*
	  * Service to add Address for a specific user.
	  * Input json with address,address_type and user_id is mapped to AddressModel object.
	  */
	 @RequestMapping(value = "/addData", method = RequestMethod.POST, headers = "Accept=application/json")
	 public ReturnModel addData(@RequestBody FileModel file) {
		 System.out.println("Inside addData Controller for addData method");
		 return dataService.addData(file);
	 }
	 
}

