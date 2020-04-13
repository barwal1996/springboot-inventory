package com.niit.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.inventory.model.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long> {

}