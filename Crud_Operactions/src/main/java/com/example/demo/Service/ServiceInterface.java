package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Product;

public interface ServiceInterface 
{
	public Product insert(Product product);
	public List<Product> getData();
	public String delete(int productCode);
	public Product find(int producCode);
	
	public Product update(Product product, int producCode);
	
}
