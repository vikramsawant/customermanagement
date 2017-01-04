package com.asurion.bo.sb.customermanagement.service;

import java.util.List;
import com.asurion.bo.sb.customermanagement.dto.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void addOrUpdateCustomer(Customer customer);

	public Customer getCustomer(int customerId);
}
