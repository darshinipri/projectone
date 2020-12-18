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
import com.onebil.fms.entities.Product;
import com.onebil.fms.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping
	public ResponseDTO addProduct(@RequestBody Product product) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.addProduct(product));
		return response;
	}

	@GetMapping(value = "/{productId}")
	public ResponseDTO getProduct(@PathVariable int productId) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getProduct(productId));
		return response;

	}

	@PutMapping
	public ResponseDTO updateProduct(@RequestBody Product product) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.UpdateProduct(product));
		return response;
	}

	@DeleteMapping(value = "/product/{productId}")
	public ResponseDTO deleteProduct(@PathVariable int productId) {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.deleteProduct(productId));
		return response;
	}

	@GetMapping(value = "/products")
	public ResponseDTO getAllProduct() {
		ResponseDTO response = new ResponseDTO();
		response.setResponse(service.getAllProduct());
		return response;
	}

}
