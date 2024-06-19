package com.view;

import java.util.List;
import java.util.Scanner;
import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class ProductView {

	public static void main(String[] args) {

		addBtn();
//		getAll();
//		delete();
//		// show products after deleted
//		getAll();
	}

	// add product
	static void addBtn() {

		ProductService service = new ProductServiceImpl();

		  char flag = 'y';
		  Scanner sc = new Scanner(System.in);
		
		do {
			Product p = new Product();
	
//			System.out.println("Enter id");
//			p.setId(sc.nextInt());
			
			System.out.println("Enter name ");
			p.setName(sc.next());
			
			System.out.println("Enter Company ");
			p.setCompany(sc.next());
			
			System.out.println("Enter price ");
			p.setPrice(sc.nextInt());
	
			service.addProduct(p);
			
			System.out.println("do you want to add more[y/n]");
			flag = sc.next().charAt(0);
			
		}while(flag == 'y');
		sc.close();
	}

	// get all products
	static void getAll() {

		ProductService service = new ProductServiceImpl();

		List<Product> plist = service.getAllProducts();
		System.out.println(plist);
	}

	// delete product
	static void delete() {
		 Scanner sc = new Scanner(System.in);
		ProductService service = new ProductServiceImpl();
		
		System.out.println("Enter the product ID to delete: ");
	    int id = sc.nextInt();
		
		service.deleteProduct(id);
		sc.close();
	}

}