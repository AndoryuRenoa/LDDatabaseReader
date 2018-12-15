package com.mochijump.repository;
import org.springframework.data.repository.CrudRepository;

import com.mochijump.reveng.ImBarcod;

//import com.MochiJump.RevEng.*;

public interface BarcodeRepository extends CrudRepository<ImBarcod, Long> {
	
	ImBarcod findByBarcod(String barcod);

}