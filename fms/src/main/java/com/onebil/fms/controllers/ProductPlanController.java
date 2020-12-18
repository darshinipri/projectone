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
import com.onebil.fms.entities.ProductPlan;
import com.onebil.fms.service.ProductPlanService;

@RestController
@RequestMapping("/plan")
@CrossOrigin("*")
public class ProductPlanController {
	@Autowired
	private ProductPlanService planservice;

	@PostMapping
	public ResponseDTO addProductPlan(@RequestBody ProductPlan productplan) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(planservice.addProductPlan(productplan));
		return response;
	}

	@GetMapping(value = "/{planID}")
	public ResponseDTO getProductPlan(@PathVariable int planID) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(planservice.getProductPlan(planID));
		return response;

	}

	@PutMapping
	public ResponseDTO updateProduct(@RequestBody ProductPlan productplan) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(planservice.updateProductPlan(productplan));
		return response;
	}

	@DeleteMapping(value = "/{planId}")
	public ResponseDTO deleteProductPlan(@PathVariable int planId) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(planservice.deleteProductPlan(planId));
		return response;
	}

	@GetMapping(value = "/plans")
	public ResponseDTO getAllProductPlan() {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(planservice.getAllProductPlan());
		return response;
	}

}
