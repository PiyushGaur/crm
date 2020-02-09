/**
 * 
 */
package com.piyush.crm.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piyush.crm.entity.Customer;
import com.piyush.crm.entity.Project;

/**
 * @author Piyush Gaur
 *
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomer() {
		System.out.println("DaoImpl");
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println(currentSession.toString());

		// Criteria cr = currentSession.createCriteria(Customer.class);
		
		CriteriaBuilder cb = currentSession.getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery(Customer.class);
		Root<Customer> rootCustomer = cq.from(Customer.class);
		Subquery<Project> project = cq.subquery(Project.class);
		Root<Project> rootProject = project.from(Project.class);
		cq.where(cb.equal(rootProject.get("type"), "FullTime"));

		cq.select(rootCustomer);
		cq.where(cb.equal(rootCustomer.get("id"), 69));

		Query<Customer> query = currentSession.createQuery(cq);
		
		return query.getResultList();
	}

	@Override
	public void saveCustomer(String customer) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("In Daoimpl");
		ObjectMapper om = new ObjectMapper();
		Customer cm = null;
		try {
			cm = om.readValue(customer, Customer.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentSession.saveOrUpdate(cm);

	}

	@Override
	public String getCustomer(int customerId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();

		Customer customer = (Customer) currentSession.get(Customer.class, customerId);
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(customer);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Customer cs = currentSession.get(Customer.class, customerId);
		currentSession.delete("Customer", cs);
		/*
		 * NativeQuery<Customer> deleteQuery = currentSession
		 * .createNativeQuery("delete from Customer where id =:customerId");
		 * deleteQuery.setParameter("customerId", customerId);
		 * deleteQuery.executeUpdate();
		 */
	}

}
