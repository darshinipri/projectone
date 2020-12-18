package com.onebil.fms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onebil.fms.dao.ProductPlanDetailsDAO;
import com.onebil.fms.entities.ProductPlanDetails;
import com.onebil.fms.exception.PricingException;

@Service
public class ProductPlanDetailsServiceImpl  implements ProductPlanDetailsService{
	@Autowired
	public ProductPlanDetailsDAO detaildao;

	@Override
	public ProductPlanDetails addPlanDetails(ProductPlanDetails plandetails) {
		 ProductPlanDetails detailDto = detaildao.addPlanDetails(plandetails);
		if (detailDto!= null) {
			return detailDto;
		} else {
			throw new PricingException("Unable to add Product plan details");
		}

	}

	@Override
	public ProductPlanDetails UpdatePlanDetails(ProductPlanDetails plandetails) {
		ProductPlanDetails  detailDto = detaildao.UpdatePlanDetails(plandetails);
		if (detailDto != null) {
			return detailDto;
		} else {
			throw new PricingException("Unable to update the  Product plan details");
		}

	}

	@Override
	public ProductPlanDetails deletePlanDetails(int planDetailId) {
		ProductPlanDetails detailDto = detaildao.deletePlanDetails(planDetailId);
		if (detailDto != null) {
			return detailDto;
		} else {
			throw new PricingException("Unable to delete the Product");
		}
	}

	@Override
	public ProductPlanDetails getPlanDetails(int planDetailId) {
		ProductPlanDetails  detailDto = detaildao.getPlanDetails(planDetailId);
		if (detailDto!= null) {
			return detailDto ;
		} else {
			throw new PricingException("Unable to fetch the Product plan details");
		}

	}

	@Override
	public List<ProductPlanDetails> getAllplanDeatails() {
		List<ProductPlanDetails> detaillist = detaildao.getAllplanDeatails();
		if (!detaillist.isEmpty()) {
			return detaillist;
		} else {
			throw new PricingException("Unable to fetch all product plan details please try after some time");
		}
	}

	
}
