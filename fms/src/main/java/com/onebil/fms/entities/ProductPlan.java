package com.onebil.fms.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="product_plan")
public class ProductPlan {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="plan_id")
	private int planId;
	
	@Column(name="plan_name")
	private String planName;
	
	@Column(name="plan_type")
	private String planType;
	
	@Column(name="price")
	private double price;
	
	@Column(name="validity")
	private String validity;
	
	@Column(name="plan_description")
	private String planDescription;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@JsonIgnore
	@OneToMany(mappedBy="plan")
	private List<ProductPlanDetails> plandetails;
	
	@JsonIgnore
	@OneToMany(mappedBy="plan",cascade=CascadeType.ALL)
	private List<AddOnCharge> addonCharges;
	
}

