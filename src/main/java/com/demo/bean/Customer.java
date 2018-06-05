package com.demo.bean;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String customerName;
	private int customerId;
	List<String> activeTelephoneNumbers;
	List<String> inactiveTelephoneNumbers;

	public Customer(int customerId, String customerName, String[] telephoneNumbers) {
		this.customerId = customerId;
		this.customerName = customerName;
		activeTelephoneNumbers = new ArrayList<String>();
		for (String number : telephoneNumbers) {
			activeTelephoneNumbers.add(number);
		}
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the activeTelephoneNumbers
	 */
	public List<String> getActiveTelephoneNumbers() {
		return activeTelephoneNumbers;
	}

	/**
	 * @param activeTelephoneNumbers the activeTelephoneNumbers to set
	 */
	public void setActiveTelephoneNumbers(List<String> activeTelephoneNumbers) {
		this.activeTelephoneNumbers = activeTelephoneNumbers;
	}

	/**
	 * @return the inactiveTelephoneNumbers
	 */
	public List<String> getInactiveTelephoneNumbers() {
		return inactiveTelephoneNumbers;
	}

	/**
	 * @param inactiveTelephoneNumbers the inactiveTelephoneNumbers to set
	 */
	public void setInactiveTelephoneNumbers(List<String> inactiveTelephoneNumbers) {
		this.inactiveTelephoneNumbers = inactiveTelephoneNumbers;
	}

}
