package com.MochiJump.Repository;

import org.springframework.data.repository.CrudRepository;

import com.MochiJump.RevEng.PoVend;


public interface VendorRepository extends CrudRepository<PoVend, Long> {
	
}