package com.onebil.fms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onebil.fms.dto.ResponseDTO;
import com.onebil.fms.entities.ProductPlanDetails;
import com.onebil.fms.service.ProductPlanDetailsService;

@RestController
@RequestMapping("/productdetail")
@CrossOrigin("*")
public class ProductDetailsController {
	@Autowired
	public ProductPlanDetailsService detailservice;
	
	
	@PostMapping
	public ResponseDTO addPlanDetails(@RequestBody ProductPlanDetails plandetails) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(detailservice.addPlanDetails(plandetails));
		return response;
	}
	@GetMapping(value = "/{planDetailId}")
	public ResponseDTO getPlanDetails(@PathVariable int planDetailId) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(detailservice.getPlanDetails(planDetailId));
		return response;

	}

	@PutMapping
	public ResponseDTO UpdatePlanDetails(@RequestBody ProductPlanDetails plandetails) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(detailservice.UpdatePlanDetails(plandetails));
		return response;
	}

	@DeleteMapping(value = "/{planDetailId}")
	public ResponseDTO deletePlanDetails(@PathVariable int planDetailId) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(detailservice.deletePlanDetails(planDetailId));
		return response;
	}

	@GetMapping(value = "/productdetails")
	public ResponseDTO getAllplanDeatails() {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(detailservice.getAllplanDeatails());
		return response;
	}

	

	

}
