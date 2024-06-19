package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.model.Product;
import java.sql.Statement;


public class ProductServiceImpl implements ProductService{

	static List<Product> plist = new ArrayList<>();
	
	@Override
	public void addProduct(Product p) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//getConnection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","draksha","cdraksha@nep");
			String sql = "insert into product(name,company,price)values('"+p.getName()+"','"+p.getCompany()+"','"+p.getPrice()+"')";
			Statement stm = con.createStatement();
			stm.execute(sql);
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
//		plist.add(p);
//		System.out.println("-----added success----size = " +plist.size());

	}

	@Override
	public void deleteProduct(int id) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","draksha","cdraksha@nep");
		String sql = "delete from Product where id ="+id;
		Statement stm = con.createStatement();
		stm.execute(sql);
		plist.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		List<Product> plist = new ArrayList<>();
		
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","draksha","cdraksha@nep");
		String sql = "select * from Product";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while (rs.next()) {
			
			//row mapping object
			Product pd = new Product();
			
			pd.setId(rs.getInt("id"));
			pd.setName(rs.getString("name"));
			pd.setCompany(rs.getString("company"));
			pd.setPrice(rs.getInt("price"));
			
			plist.add(pd);
		}
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		return plist;
	
	}

	@Override
	public void updateProduct(Product p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","draksha","cdraksha@nep");
			String sql = "update product set name='"+p.getName()+"' , company = '"+p.getCompany()+"' , price = '"+p.getPrice()+"' ";
			Statement stm = con.createStatement();
			stm.execute(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}