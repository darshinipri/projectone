package com.onebil.fms.dao;

import java.util.List;

import com.onebil.fms.entities.ProductPlan;

public interface ProductPlanDAO {

	public ProductPlan addProductPlan(ProductPlan productplan);

	public ProductPlan updateProductPlan(ProductPlan productplan);

	public ProductPlan getProductPlan(int planID);

	public ProductPlan deleteProductPlan(int planId);

	public List<ProductPlan> getAllProductPlan();

}
