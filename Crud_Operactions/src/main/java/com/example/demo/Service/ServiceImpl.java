package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.Dao;

@Service
public class ServiceImpl implements ServiceInterface
{
	@Autowired
	Dao dao;
	
	
	public ServiceImpl(Dao dao) {
		super();
		this.dao = dao;
	}


	@Override
	public Product insert(Product product) {
		return dao.save(product);
		
	}


	@Override
	public List<Product> getData() {
		List<Product> list= (List<Product>) dao.findAll();
		return list;
	}


	@Override
	public String delete(int productCode) {
		dao.deleteById(productCode);
		return "1 row delted succesfully";
	}


	@Override
	public Product find(int producCode) {
		Optional<Product> opt= dao.findById(producCode);
		Product product=opt.get();
		return product;
		
	}


	@Override
	public Product update(Product product, int producCode) {
		Product prod=find(producCode);
		prod.setProductName(product.getProductName());
		prod.setProductCode(product.getProductCode());
		prod.setQuantity(product.getQuantity());
		prod.setPrice(product.getPrice());
		return dao.save(prod);
		
	}



}
