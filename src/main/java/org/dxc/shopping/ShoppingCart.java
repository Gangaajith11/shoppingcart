package org.dxc.shopping;

import com.dxc.shopping.exception.ProductException;

import java.util.Scanner;

import com.dxc.shopping.exception.ProductException;
import com.dxc.shopping.model.Product;
import com.dxc.shopping.service.CartOperationImpl;
import com.dxc.shopping.service.CartOperationService;

public class ShoppingCart {
		 public static void main( String[] args ) throws ProductException{
		    	
			 Scanner s=new Scanner(System.in);
		    	
		    	CartOperationService cartService=new CartOperationImpl(10.2f); 
		    	System.out.println("Enter number of products");
		    	int no=Integer.parseInt(s.nextLine());
		    	
		    	
		    	
		    	for(int i=0;i<no;i++) {
		    	System.out.println("Enter Product Name");  	
		    	System.out.println("Enter Product Price");  	
		    	System.out.println("Enter Product Quantity");
		    	
		    	Product p=new Product(s.nextLine(),Integer.parseInt(s.nextLine()),Integer.parseInt(s.nextLine()));
		    	
		    	cartService.addToCart(p);
		    	
		    	}
		    	System.out.println(cartService.getInvoiceAmount());
		    	
		    	System.out.println("Remove Product? yes or no");
		    	
		    	
		    	if(s.nextLine().equalsIgnoreCase("yes")) {
		    		
		    		System.out.println("Enter Product Name");  	
		        	System.out.println("Enter Product Price");  	
		        	System.out.println("Enter Product Quantity");
		    		Product p=new Product(s.nextLine(),Integer.parseInt(s.nextLine()),Integer.parseInt(s.nextLine()));
		    		cartService.removeFromCart(p);
		    		
		    	}
		    	
		    	
		    	System.out.println(cartService); 
				

		        
		    }

			
}