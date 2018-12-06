package com.MochiJump.Repository;
import org.springframework.data.repository.CrudRepository;

import com.MochiJump.RevEng.ImBarcod;

//import com.MochiJump.RevEng.*;

public interface BarcodeRepository extends CrudRepository<ImBarcod, Long> {
	
	ImBarcod findByBarcod(String barcod);

}