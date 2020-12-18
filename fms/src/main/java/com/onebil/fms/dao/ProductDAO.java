package com.onebil.fms.dao;

import java.util.List;

import com.onebil.fms.entities.Product;

public interface ProductDAO {

	public Product addProduct(Product product);

	public Product deleteProduct(int productId);

	public Product UpdateProduct(Product product);

	public Product getProduct(int productId);

	public List<Product> getAllProduct();

}
