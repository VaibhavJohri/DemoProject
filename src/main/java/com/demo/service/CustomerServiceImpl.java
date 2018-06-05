package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.demo.bean.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	private static List<Customer> customers;
	private static final AtomicInteger counter = new AtomicInteger();

	static {
		customers = populateDummyCustomers();
		System.out.println("Here-----------");
	}

	public List<Customer> findAllCustomers() {
		System.out.println("Here-----------");
		return customers;
	}

	public Customer findById(int id) {
		for (Customer customer : customers) {
			if (customer.getCustomerId() == id) {
				return customer;
			}
		}
		return null;
	}

	public Customer activateNumber(int id, String number) {
		Customer customer = findById(id);
		if (null == customer) {
			return null;
		}
		if (customer.getActiveTelephoneNumbers().size() > 0
				&& !(customer.getActiveTelephoneNumbers().contains(number))) {
			customer.getActiveTelephoneNumbers().add(number);
		}
		return customer;
	}
	
	public static List<Customer> populateDummyCustomers(){
		System.out.println("Here-----------");
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(counter.incrementAndGet(),"John Smith", new String[]{"02309324322","02309324321"}));
		customers.add(new Customer(counter.incrementAndGet(),"Alan Smith", new String[]{"02309324323","02309324324"}));
		customers.add(new Customer(counter.incrementAndGet(),"John Ryan", new String[]{"02309324325","02309324326"}));		
		customers.add(new Customer(counter.incrementAndGet(),"Smith Booth", new String[]{"02309324327","02309324328"}));
		return customers;
	}
}
