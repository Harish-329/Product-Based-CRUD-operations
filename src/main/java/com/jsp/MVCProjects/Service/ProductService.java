package com.jsp.MVCProjects.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.MVCProjects.EntityOrComponent.Product;
import com.jsp.MVCProjects.Repository.ProductRepository;

@Service
public class ProductService 
{
	
	@Autowired
	ProductRepository productrepository;
	
	public void service(int productId,String productName,double productPrice)
	{
		productrepository.buy(productId,productName,productPrice);
	}

	public List<Product> doDisplayAllProducts() 
	{
		return productrepository.buyAll();
	}

	public Product doUpdateProducts(int productId) {
		return productrepository.exchange(productId);
	}

	public void doSaveUpdateProducts(int productId, String productName, double productPrice) {
		productrepository.replaced(productId, productName, productPrice);
	}

	public void doDeleteProducts(int productId) {
		productrepository.remove(productId);
	}
}