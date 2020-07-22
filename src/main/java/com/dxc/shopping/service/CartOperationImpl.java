package com.dxc.shopping.service;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import com.dxc.shopping.exception.ProductException;
import com.dxc.shopping.model.*;


public class CartOperationImpl implements CartOperationService {
	 private float tax_percentage;
	 private float invoiceAmount=0;
	 List<Product> product=new ArrayList<Product>();

	public CartOperationImpl(float tax_percentage) {
		 this.tax_percentage=tax_percentage;
	 }
	
	@Override
	public float getInvoiceAmount() {
		System.out.println("Invoice Amount is:");
		return invoiceAmount;
	}

	@Override
	public float addToCart(Product p) {
		product.add(p);
		float cost= p.getPrice() *p.getQuantity()+tax_percentage;
		invoiceAmount=cost+invoiceAmount;
		return cost;
	}

	@Override
	public void removeFromCart(Product p)throws ProductException {
		Iterator<Product> iterator= product.iterator();
		try {
		if(product.isEmpty())
				throw new ProductException(p.getName());
			}catch(ProductException e) {
				e.printStackTrace();
				System.out.println("ProductException:"+e);
			}
		while(iterator.hasNext()){
			if(iterator.next().getName().equals(p.getName())) {
				float tax=(p.getPrice()*p.getQuantity())+tax_percentage;
				invoiceAmount-=p.getPrice()*p.getQuantity()+tax;	
				System.out.println("amount deducted from previous bill is "+ invoiceAmount);
				iterator.remove();
			}
		}
		
	}

	@Override
	public String toString() {
		return product.toString();
	}
	
}
