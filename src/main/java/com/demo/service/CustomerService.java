package com.demo.service;

import java.util.List;
import com.demo.bean.Customer;

public interface CustomerService {

	Customer findById(int id);
			
	Customer activateNumber(int id, String number);
	
	List<Customer> findAllCustomers();
		
}
