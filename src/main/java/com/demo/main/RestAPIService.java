package com.demo.main;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.Customer;
import com.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class RestAPIService {

	public static final Logger logger = LoggerFactory.getLogger(RestAPIService.class);

	@Autowired
	CustomerService customerService; 

	/**
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/customer/", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> listAllCustomers() {
		List<Customer> customers = customerService.findAllCustomers();
		if (customers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomer(@PathVariable("id") int id) {
		Customer customer = customerService.findById(id);
		if (customer == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/customer/{id}/{number}", method = RequestMethod.GET)
	public ResponseEntity<?> updateCustomer(@PathVariable("id") int id, @PathVariable("number") String number) {

		Customer currentCustomer = customerService.activateNumber(id, number);

		if (currentCustomer == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	
		return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
	}

}