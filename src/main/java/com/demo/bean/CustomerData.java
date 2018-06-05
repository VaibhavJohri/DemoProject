package com.demo.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerData {
	private static final AtomicInteger counter = new AtomicInteger();

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
