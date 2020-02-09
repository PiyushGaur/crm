/**
 * 
 */
package com.piyush.crm.dao;

import java.util.List;

import com.piyush.crm.entity.Customer;

/**
 * @author Piyush Gaur
 *
 */
public interface CustomerDAO {
	
	public List<Customer> getCustomer();
	
	public void saveCustomer(String customer);
	
	public String getCustomer(int customerId);
	
	public void deleteCustomer(int customerId);
	

}
