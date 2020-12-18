package com.onebil.fms.dto;

import java.io.Serializable;
import java.util.List;

import com.onebil.fms.entities.ProductPlan;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class ProductDTO implements Serializable{

	private int productId;

	private String productName;

	private String companyName;

	private List<ProductPlan> plan;
}
