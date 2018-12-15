package com.mochijump.repository;

import org.springframework.data.repository.CrudRepository;

import com.mochijump.reveng.PoVend;


public interface VendorRepository extends CrudRepository<PoVend, Long> {
	
}