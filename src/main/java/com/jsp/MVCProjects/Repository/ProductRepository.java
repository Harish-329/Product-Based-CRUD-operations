package com.jsp.MVCProjects.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.MVCProjects.EntityOrComponent.Product;

@Repository
public class ProductRepository 
{
	@Autowired
	private Product product;
	
	public Session getSession()
	{
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		return session;
	}
	
	public void buy(int productId,String productName,double productPrice)
	{
		Session session = getSession();
		Transaction trans = session.beginTransaction();
			
		Product product = new Product();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setProductPrice(productPrice);
		
		session.save(product);
		
		trans.commit();
		session.close();
	}

	public List<Product> buyAll() 
	{
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		
		Query<Product> query = session.createQuery("FROM Product");
		List<Product> list = query.getResultList();
		
		trans.commit();
		session.close();
		
		return list;
	}

	public Product exchange(int productId) 
	{
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		
		Product pro = session.get(Product.class , productId);
		
		trans.commit();
		session.close();
		
		return pro;
	}

	public Product replaced(int productId, String productName, double productPrice) 
	{
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		
		Product p = new Product();
		p.setProductId(productId);
		p.setProductName(productName);
		p.setProductPrice(productPrice);
		session.update(p);
		
		trans.commit();
		session.close();
		
		return p;
	}
	
	public void remove(int productId) 
	{
		Session session = getSession();
		Transaction trans = session.beginTransaction();
		
		Product prod = session.get(Product.class, productId);
		prod.setProductId(productId);
		session.delete(prod);
		
		trans.commit();
		session.close();
	}
}