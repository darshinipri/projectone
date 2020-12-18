package com.onebil.fms.dto;

import com.onebil.fms.entities.Product;
import com.onebil.fms.entities.ProductPlan;
import lombok.Data;

@Data
public class ProductPlanDetailsDTO {

	private int plandetailId;

	private String planType;

	private String planShortDescription;

	private String planLongDescription;

	private Product product;

	private ProductPlan plan;

}
