package com.niit.inventory.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.inventory.model.Dealer;
import com.niit.inventory.repository.DealerRepository;
import com.niit.inventory.repository.UserRespository;


@Service
@Transactional
public class LoginService {
	@Autowired
	private UserRespository urepo;
	
	public Dealer findByEmail(String email) {
		return urepo.findByEmail(email);
	}
	
	@Autowired
	private DealerRepository drepo;
	 public void saveDealer(Dealer dealer)
	 {
		 drepo.save(dealer);
	 }

}
