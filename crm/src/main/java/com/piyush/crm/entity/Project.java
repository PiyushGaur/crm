/**
 * 
 */
package com.piyush.crm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Piyush Gaur
 *
 */
@Entity
public class Project {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name = "name")
	String name;

	@Column(name = "type")
	String type;

	@JsonIgnore
	@JoinColumn(name = "customer_id")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Customer customer;

	public Project() {

	}

	public Project(String name, String type, Customer customer) {
		this.name = name;
		this.type = type;
		this.customer = customer;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	public Long getId() {
		return id;
	}

}
