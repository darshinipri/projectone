package com.onebil.fms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onebil.fms.dao.ProductDAO;
import com.onebil.fms.entities.Product;
import com.onebil.fms.exception.PricingException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductDAO productdao;

	@Override
	public Product addProduct(Product product) {
		Product productDto = productdao.addProduct(product);
		if (productDto != null) {
			return productDto;
		} else {
			throw new PricingException("Unable to add Product");
		}

	}

	@Override
	public Product deleteProduct(int productId) {
		Product productDto = productdao.deleteProduct(productId);
		if (productDto != null) {
			return productDto;
		} else {
			throw new PricingException("Unable to delete the Product");
		}

	}

	@Override
	public Product UpdateProduct(Product product) {
		Product productDto = productdao.UpdateProduct(product);
		if (productDto != null) {
			return productDto;
		} else {
			throw new PricingException("Unable to update the  Product");
		}

	}

	@Override
	public Product getProduct(int productId) {
		Product productDto = productdao.getProduct(productId);
		if (productDto != null) {
			return productDto;
		} else {
			throw new PricingException("Unable to fetch the Product details");
		}

	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> productlist = productdao.getAllProduct();
		if (!productlist.isEmpty()) {
			return productlist;
		} else {
			throw new PricingException("Unable to fetch all product please try after some time");
		}

	}

}
