package com.MochiJump;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.MochiJump.Repository.BarcodeRepository;
import com.MochiJump.Repository.PriceRepository;
import com.MochiJump.RevEng.ImBarcod;

@Controller    
@RequestMapping(path="/")
public class MainController { 
	
	@Autowired
	private BarcodeRepository bcRepo;
	@Autowired
	private PriceRepository priceRepo;
	
	@RequestMapping ("/barcode")
	@ResponseBody
	public String lookupBarcode(@RequestParam String barcode) {
		try {
		System.out.print("lookupBarcode Called");
		System.out.println(bcRepo.findByBarcod(barcode).getImItem());
		return ""+bcRepo.findByBarcod(barcode).getImItem().getDescr()+"   Price $"+
		//found price
		bcRepo.findByBarcod(barcode).getImItem().getPrc1().toString()+"    Cost $"+
		//looks like listed cost?
		bcRepo.findByBarcod(barcode).getImItem().getLstCost().toString()+"  Avail Inv"+
		//this feels like a very backwards way to get to the inventory amount...
		bcRepo.findByBarcod(barcode).getImItem().getImInvs().iterator().next().getNetQty().toString();
		//returned 0 as string
		//bcRepo.findByBarcod(barcode).getImItem().getPrefUnit();
				//below returned 0 as a string...
				//bcRepo.findByBarcod(barcode).getUnit();
				// below is getItemNo
				// bcRepo.findByBarcod(barcode).getImItem().getItemNo();
				// note the below is null .getRegPrc on coors returns null so that can't be what is used for Price.
				//priceRepo.findByImItem(bcRepo.findByBarcod(barcode).getImItem()).getRegPrc();
		}catch (Exception e) {
			return "Item not found";
		}
	}

}
