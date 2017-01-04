package com.asurion.bo.sb.customermanagement.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


import org.springframework.stereotype.Service;



import com.asurion.bo.sb.customermanagement.dto.CustomerManagementService;
import com.asurion.bo.sb.customermanagement.dto.GetAllCustomersPortType;
import com.asurion.bo.sb.customermanagement.dto.GetAllCustomersRequest;
import com.asurion.bo.sb.customermanagement.dto.GetAllCustomersResponse;
import com.asurion.bo.sb.customermanagement.dto.GetCustomerPortType;
import com.asurion.bo.sb.customermanagement.dto.GetCustomerRequest;
import com.asurion.bo.sb.customermanagement.dto.GetCustomerResponse;
import com.asurion.bo.sb.customermanagement.dto.CreateCustomerPortType;
import com.asurion.bo.sb.customermanagement.dto.CreateCustomerRequest;
import com.asurion.bo.sb.customermanagement.dto.CreateCustomerResponse;
import com.asurion.bo.sb.customermanagement.dto.Customer;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Customer> getCustomers() {
		try {
			CustomerManagementService service = new CustomerManagementService(new URL("http://customermanagementservice.jxutyfpvuk.us-east-1.elasticbeanstalk.com/services/getallcustomers?wsdl"));
			GetAllCustomersPortType port = service.getGetAllCustomersPortType();
			GetAllCustomersRequest parameters = new GetAllCustomersRequest();
			parameters.setId(1);
			GetAllCustomersResponse response = port.getAllCustomers(parameters);
			List<Customer> customer = response.getCustomer();
			return customer;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void addOrUpdateCustomer(Customer customer) {

		try {
			CustomerManagementService service = new CustomerManagementService(new URL("http://customermanagementservice.jxutyfpvuk.us-east-1.elasticbeanstalk.com/services/createcustomer?wsdl"));
			CreateCustomerPortType port = service.getCreateCustomerPortType();
			CreateCustomerRequest parameters = new CreateCustomerRequest();
			parameters.setCustomer(customer);
			CreateCustomerResponse response = port.createCustomer(parameters);
			System.out.println(response);
				
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		}


	}

	@Override
	public Customer getCustomer(int customerId) {

		try {
			CustomerManagementService service = new CustomerManagementService(new URL("http://customermanagementservice.jxutyfpvuk.us-east-1.elasticbeanstalk.com/services/getcustomer?wsdl"));
			GetCustomerPortType port = service.getGetCustomerPortType();
			GetCustomerRequest parameters = new GetCustomerRequest();
			parameters.setId(customerId);
			GetCustomerResponse response = port.getCustomer(parameters);
			Customer customer = response.getCustomer();
			return customer;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
