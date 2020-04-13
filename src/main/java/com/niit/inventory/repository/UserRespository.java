package com.niit.inventory.repository;

import org.springframework.data.repository.CrudRepository;

import com.niit.inventory.model.Dealer;

public interface UserRespository extends CrudRepository<Dealer,Long> {
	public Dealer findByEmail(String email);

}
