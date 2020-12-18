package com.onebil.fms.service;

import java.util.List;

import com.onebil.fms.entities.ProductPlanDetails;

public interface ProductPlanDetailsService {
	public ProductPlanDetails addPlanDetails(ProductPlanDetails plandetails);

	public ProductPlanDetails UpdatePlanDetails(ProductPlanDetails plandetails);

	public ProductPlanDetails deletePlanDetails(int planDetailId);

	public ProductPlanDetails getPlanDetails(int planDetailId);

	public List<ProductPlanDetails> getAllplanDeatails();


}
