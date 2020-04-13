package com.niit.inventory.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.inventory.exception.ResourceNotFoundException;
import com.niit.inventory.model.Product;
import com.niit.inventory.repository.ProductRepository;

/*
 * Cross-origin resource sharing (CORS) is a standard protocol that defines the interaction between a
 *  browser and a server for safely handling cross-origin HTTP requests.
Simply put, a cross-origin HTTP request is a request to a specific resource, which is located at a
 different origin, namely a domain, protocol and port, than the one of the client performing the 
 request.
 */

	@RestController  
	@CrossOrigin(origins="http://localhost:4200")  
	@RequestMapping(value="/api") 
	public class ProductRestController {
		
		@Autowired
	    private ProductRepository prepo;
		
		 @GetMapping("/products")  
		    public List<Product> getAllProducts() {  
		         return prepo.findAll();    
		    }  
		 
		 /** 
		  * ResponseEntity represents an HTTP response, including headers, body, and status.
		  */
		 @GetMapping("/products/{id}")
			public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long pId)
					throws ResourceNotFoundException {
				Product product = prepo.findById(pId)
						.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
				return ResponseEntity.ok().body(product);
			}
		 
		 @PostMapping("/products")  
		    public Product saveProduct(@Valid @RequestBody Product product) {  
			 return prepo.save(product)  ;
		       	          
		    }  
		 
		 @DeleteMapping("/products/{id}")
		    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long pId) 
		    		throws ResourceNotFoundException{
			 Product product = prepo.findById(pId)
						.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
		        prepo.delete(product);
		        
		        Map<String, Boolean> response = new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return response;
		 }
		 
		 @PutMapping("/products/{id}")
		    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long pId,
					@Valid @RequestBody Product p) throws ResourceNotFoundException {
		     
			 Product product = prepo.findById(pId)
						.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + pId));
			 
			    		    
			    product.setBrand(p.getBrand());
			    product.setMadein(p.getMadein());
			    product.setName(p.getName());
			    product.setPrice(p.getPrice());
			    
			    final Product updatedProduct = prepo.save(product);
				return ResponseEntity.ok(updatedProduct);
		    }
		 
		 
	}
	
	
	

