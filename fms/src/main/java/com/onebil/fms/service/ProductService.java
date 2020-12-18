package com.onebil.fms.service;

import java.util.List;

import com.onebil.fms.entities.Product;

public interface ProductService {
	public Product addProduct(Product product);

	public Product deleteProduct(int productId);

	public Product UpdateProduct(Product product);

	public Product getProduct(int productId);

	public List<Product> getAllProduct();

}
