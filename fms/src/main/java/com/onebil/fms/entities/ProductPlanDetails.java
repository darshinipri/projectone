package com.onebil.fms.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "product_plan_details")
public class ProductPlanDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int plandetailId;
	
	@Column(name = "plan_type")
	private String planType;

	@Column(name = "plan_description")
	private String planShortDescription;

	@Column(name = "plan_long_description")
	private String planLongDescription;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "plan_id")
	private ProductPlan plan;

}
