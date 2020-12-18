package com.onebil.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onebil.fms.dao.ProductPlanDAO;
import com.onebil.fms.entities.ProductPlan;
import com.onebil.fms.exception.PricingException;

@Service
public class ProductPlanServiceImpl implements ProductPlanService {

	@Autowired
	public ProductPlanDAO productplandao;

	@Override
	public ProductPlan addProductPlan(ProductPlan productplan) {
		ProductPlan productplan1 = productplandao.addProductPlan(productplan);
		
		if (productplan1!= null) {
			return productplan1;
		} else {
			throw new PricingException("Unable to add Productplan");
		}
	}

	@Override
	public ProductPlan updateProductPlan(ProductPlan productplan) {
		ProductPlan productplan1 = productplandao.updateProductPlan(productplan);
		if (productplan!= null) {
			return productplan1;
		} else {
			throw new PricingException("Unable to update the  Product");
		}
	}

	@Override
	public ProductPlan getProductPlan(int planId) {
		ProductPlan productplanDto = productplandao.getProductPlan(planId);
		if (productplanDto!= null) {
			return productplanDto;
		} else {
			throw new PricingException("Unable to fetch the Productplan details");
		}

	}

	@Override
	public ProductPlan deleteProductPlan(int planId) {
		ProductPlan productplanDto = productplandao.deleteProductPlan(planId);
		if (productplanDto!= null) {
			return productplanDto;
		} else {
			throw new PricingException("Unable to detele the propductplan");
		}
	}

	@Override
	public List<ProductPlan> getAllProductPlan() {
		List<ProductPlan> productplanlist = productplandao.getAllProductPlan();
		if (!productplanlist.isEmpty()) {
			return productplanlist;
		} else {
			throw new PricingException("Unable to fetch all productplans please try after some time");
		}

	}

}
