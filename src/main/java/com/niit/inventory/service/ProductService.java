package com.niit.inventory.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.inventory.model.Product;
import com.niit.inventory.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	@Autowired
	public ProductRepository repo;
	 public List<Product> listAll()
	 {
		 return repo.findAll();
	 }
	 public void save (Product product)
	 {
		 repo.save(product);
	 }
	 public Product get(long id)
	 {
		 return repo.findById(id).get();
	 }
public void  delete(long id)
{
	repo.deleteById(id);
}

}