package com.demo.main;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.demo.bean.Customer;
 

public class DemoTest {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/demo-project/api";
     
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllCustomers(){
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> customerMap = restTemplate.getForObject(REST_SERVICE_URI+"/customer/", List.class);
         
        if(customerMap!=null){
            for(LinkedHashMap<String, Object> map : customerMap){
                System.out.println("Customer : id="+map.get("customerId")+", Name="+map.get("customerName"));
                for(String activeNumber : (List<String>)map.get("activeTelephoneNumbers")){
                	System.out.println(activeNumber + " ");
                }
                for(String passiveNumber : (List<String>)map.get("inactiveTelephoneNumbers")){
                	System.out.println(passiveNumber + " ");
                }
            }
        }else{
            System.out.println("No customer present");
        }
    }
     
    /* GET */
    private static void getCustomer(){
        RestTemplate restTemplate = new RestTemplate();
        Customer user = restTemplate.getForObject(REST_SERVICE_URI+"/customer/1", Customer.class);
        System.out.println(user);
    }
     
 
   
    private static void activateCustomerNumber() {
        RestTemplate restTemplate = new RestTemplate();
        Customer user  = restTemplate.getForObject(REST_SERVICE_URI+"/customer/1/02309324322", Customer.class);
        System.out.println(user);
    }
 
 
    public static void main(String args[]){
        listAllCustomers();
        getCustomer();
        activateCustomerNumber();
    }
}