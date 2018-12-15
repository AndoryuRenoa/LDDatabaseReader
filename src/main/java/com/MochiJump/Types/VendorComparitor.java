package com.mochijump.types;

import java.util.Comparator;

import com.mochijump.reveng.PoVend;

public class VendorComparitor	implements Comparator {

	public int compare (Object o1, Object o2) {
		PoVend v1 = (PoVend) o1;
		PoVend v2 = (PoVend) o2;
		
		return v1.getNam().compareToIgnoreCase(v2.getNam());
	}
	
}
