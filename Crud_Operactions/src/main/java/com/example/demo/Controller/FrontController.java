package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Service.ServiceInterface;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FrontController 
{
	@Autowired
	ServiceInterface service;
	
	
	public FrontController(ServiceInterface service) {
		super();
		this.service = service;
	}

	@PostMapping("/")
	public Product insertData(@RequestBody Product product)
	{
		return service.insert(product);
	}
	
	@GetMapping("/")
	public List<Product> getData()
	{
		return service.getData();
				
	}
	
	@DeleteMapping("/{productCode}")
	public String delete(@PathVariable int productCode )
	{
		return service.delete(productCode);
	}
	
	@GetMapping("/{productCode}")
	public Product find(@PathVariable int productCode)
	{
		return service.find(productCode);
	}
	
	@PutMapping("/{productCode}")
	public Product put(@RequestBody Product product, @PathVariable int productCode)
	{
		return service.update(product, productCode);
	}
}
