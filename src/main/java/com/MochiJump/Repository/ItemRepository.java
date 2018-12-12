package com.MochiJump.Repository;
import org.springframework.data.repository.CrudRepository;

import com.MochiJump.RevEng.ImItem;
import com.MochiJump.RevEng.ImPrc;


//import com.MochiJump.RevEng.*;

public interface ItemRepository extends CrudRepository<ImPrc, Long> {
	
	ImPrc findByImItem(ImItem imItem);

}