package com.java.jsf;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="book")
@SessionScoped
public class Books {

	private List<Books> bookArrayList;

	private boolean sortAscending = true; 
	
	private static final Books[] bookList = {
		new Books("1234", "Java", 2303.0, 3),
		new Books("3211", "Web", 4232.00, 6),
		new Books("2344", "SQL", 5230.00, 10),
		new Books("5643", "CSS", 11320.00, 9),
		new Books("4565", "HTML",232.00, 20)
	};
	
	//sort by book no
		public String sortByBookNo() {
			if(sortAscending){
				//ascending book
				Collections.sort(bookArrayList, new Comparator<Books>() {
					@Override
					public int compare(Books o1, Books o2) {
						return o1.getBookNo().compareTo(o2.getBookNo());
					}
				});
				sortAscending = false;
			}else{
				//descending book
				Collections.sort(bookArrayList, new Comparator<Books>() {
					@Override
					public int compare(Books o1, Books o2) {
						return o2.getBookNo().compareTo(o1.getBookNo());
					}
				});
				sortAscending = true;
			}
			return null;
		}
	public List<Books> getBookList() {
		 
		return bookArrayList;
 
	}
	public Books() {
		bookArrayList = new ArrayList<Books>(Arrays.asList(bookList));
	}
	public Books(String bookNo, String productName, double price, int qty) {
		this.bookNo = bookNo;
		this.productName = productName;
		this.price = price;
		this.qty = qty;
	}
	private String bookNo;
	private String productName;
	private double price;
	private int qty;
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
