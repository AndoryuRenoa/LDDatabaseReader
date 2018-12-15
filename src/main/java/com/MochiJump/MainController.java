package com.mochijump;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mochijump.repository.BarcodeRepository;
import com.mochijump.repository.ItemRepository;
import com.mochijump.repository.VendorRepository;
import com.mochijump.reveng.PoVend;
import com.mochijump.types.BarcodeResponse;
import com.mochijump.types.VendorComparitor;
import com.mochijump.types.VendorResponse;

@Controller    
@RequestMapping(path="/")
public class MainController { 
	
	@Autowired
	private BarcodeRepository bcRepo;
	@Autowired
	private VendorRepository vendorRepo;
	
	List <PoVend> vendorList;
	
	@RequestMapping ("/vendors")
	@ResponseBody
	public List <VendorResponse> returnListOfVendors() {
		List<VendorResponse> response = new ArrayList<VendorResponse>();
		for (PoVend vl: vendorList) {
			VendorResponse r = new VendorResponse();
			r.setName(vl.getNam());
			r.setVendorNo(vl.getVendNo());
			response.add(r);
		}
		return response;
	}
	@RequestMapping ("/getItemNo")
	@ResponseBody
	public String getItemNo(@RequestParam String barcode) {
		return bcRepo.findByBarcod(barcode).getImItem().getItemNo();
	}
	
	@RequestMapping ("/barcode")
	@ResponseBody
	// we need to create a new class to return for this data
	public BarcodeResponse lookupBarcode(@RequestParam String barcode) {
		BarcodeResponse response = new BarcodeResponse();
		try {
			response.setItem(bcRepo.findByBarcod(barcode).getImItem().getDescr());
			response.setLastCost(bcRepo.findByBarcod(barcode).getImItem()
					.getLstCost());
			response.setAvailableInventory(bcRepo.findByBarcod(barcode)
					.getImItem().getImInvs().iterator().next()
					.getQtyOnHnd());
			response.setUnitType(bcRepo.findByBarcod(barcode).getImItem()
					.getAlt1Unit());
			response.setUnitMultiplier(bcRepo.findByBarcod(barcode).getImItem()
					.getAlt1Numer());
			response.setLastReceivedDate(bcRepo.findByBarcod(barcode).getImItem().getLstRecvDat());
			response.setItemNo(bcRepo.findByBarcod(barcode).getImItem().getItemNo());
			System.out.println(response.getItemNo());
			return response;
		/* System.out.print("lookupBarcode Called");
		System.out.println(bcRepo.findByBarcod(barcode).getImItem());
		return ""+bcRepo.findByBarcod(barcode).getImItem().getDescr()+"   Item No:"+
				bcRepo.findByBarcod(barcode).getImItem().getItemNo()+"   Price $"+
		//found price
		bcRepo.findByBarcod(barcode).getImItem().getPrc1().toString()+"    Cost $"+
		//looks like listed cost?
		bcRepo.findByBarcod(barcode).getImItem().getLstCost().toString()+"  Avail Inv "+
		// this feels like a very backwards way to get to the inventory amount. However, nothing beneath it seems to matter for inventory amount.
		// I wonder if one should test inventory size. perhaps this is how multiple vendors are handled, or it's a strange design.
		//should be corresponding variable for "qty_on_hnd" instead of netQty --DONE
		bcRepo.findByBarcod(barcode).getImItem().getImInvs().iterator().next().getQtyOnHnd().toString() + "    Unit Type: "+
		bcRepo.findByBarcod(barcode).getImItem().getAlt1Unit()+ "         Unit Multipler: "+
		bcRepo.findByBarcod(barcode).getImItem().getAlt1Numer();
		// This the ImInvCells hash set is empty.
		// bcRepo.findByBarcod(barcode).getImItem().getImInvs().iterator().next().getImInvCells().size();
		// This returns no such element exception (i guess it's not important)
		// bcRepo.findByBarcod(barcode).getImItem().getImInvs().iterator().next().getImInvCells().iterator().next().getQtyAvail().toString();
		//returned 0 as string
		//bcRepo.findByBarcod(barcode).getImItem().getPrefUnit();
				//below returned 0 as a string...
				//bcRepo.findByBarcod(barcode).getUnit();
				// below is getItemNo
				// bcRepo.findByBarcod(barcode).getImItem().getItemNo();
				// note the below is null .getRegPrc on coors returns null so that can't be what is used for Price.
				//priceRepo.findByImItem(bcRepo.findByBarcod(barcode).getImItem()).getRegPrc();
				 * 
				 */
		}catch (Exception e) {
			System.out.println(e);
			response.setItem("Item not found");
			return response;
		}
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		System.out.println("Wait for Vendor's to load");
		vendorList = (List<PoVend>) vendorRepo.findAll();
		vendorList.sort(new VendorComparitor());
	    System.out.println("Vendor's have loaded");
	}

}
