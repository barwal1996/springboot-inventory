package com.niit.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.inventory.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}