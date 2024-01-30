package com.jsp.MVCProjects.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.MVCProjects.EntityOrComponent.Product;
import com.jsp.MVCProjects.Service.ProductService;

@Controller
public class ProductController 
{
	@Autowired
	private ProductService productservice;
	
	@Autowired
	Product product;
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public ModelAndView doAdd(@RequestParam int productId, @RequestParam String productName, @RequestParam double productPrice)
	{
		productservice.service(productId,productName,productPrice);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		
		return mav;
	}
	
	@RequestMapping(value = "/display" , method = RequestMethod.GET)
	public ModelAndView doDisplayAllProducts()
	{
		List<Product> list = productservice.doDisplayAllProducts();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("DisplayAllProducts.jsp");
		mav.addObject("productslist" , list);
		
		return mav;
	}
	
	@RequestMapping(value = "/update" , method = RequestMethod.GET)
	public ModelAndView doUpdateProducts(@RequestParam int productId)
	{
		Product products = productservice.doUpdateProducts(productId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("UpdateProducts.jsp");
		mav.addObject("ProductsList" , products);
	
		return mav;
	}
	
	@RequestMapping(value = "/saveupdate" , method = RequestMethod.POST)
	public ModelAndView doSaveUpdateProducts(@RequestParam int productId, @RequestParam String productName, @RequestParam double productPrice)
	{
		productservice.doSaveUpdateProducts(productId,productName,productPrice);
		
		List<Product> prod = productservice.doDisplayAllProducts();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("DisplayAllProducts.jsp");
		mav.addObject("productslist" , prod);
	
		return mav;
	}
	
	@RequestMapping(value = "/delete" , method = RequestMethod.GET)
	public ModelAndView doDeleteProducts(@RequestParam int productId)
	{
		productservice.doDeleteProducts(productId);
		
		List<Product> pro = productservice.doDisplayAllProducts();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("DisplayAllProducts.jsp");
		mav.addObject("productslist" , pro);
		
		return mav;
	}
}