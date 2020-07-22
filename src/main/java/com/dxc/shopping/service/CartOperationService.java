package com.dxc.shopping.service;


import com.dxc.shopping.exception.ProductException;
import com.dxc.shopping.model.Product;

public interface CartOperationService {
	public float getInvoiceAmount();
	public float addToCart(Product p);
	void removeFromCart(Product p) throws ProductException;

}
