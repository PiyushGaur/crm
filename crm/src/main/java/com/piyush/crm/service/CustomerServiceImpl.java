/**
 * 
 */
package com.piyush.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piyush.crm.dao.CustomerDAO;
import com.piyush.crm.entity.Customer;

/**
 * @author Piyush Gaur
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;
	@Override
	@Transactional
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		System.out.println("In service IMPL");
		return customerDao.getCustomer();
	}

	@Override
	@Transactional
	public void saveCustomer(String customer) {
		// TODO Auto-generated method stub
		customerDao.saveCustomer(customer);

	}

	@Override
	@Transactional
	public String getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomer(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(customerId);

	}

}
