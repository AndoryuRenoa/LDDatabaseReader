package com.mochijump.repository;
import org.springframework.data.repository.CrudRepository;

import com.mochijump.reveng.ImItem;
import com.mochijump.reveng.ImPrc;


//import com.MochiJump.RevEng.*;

public interface ItemRepository extends CrudRepository<ImPrc, Long> {
	
	ImPrc findByImItem(ImItem imItem);

}