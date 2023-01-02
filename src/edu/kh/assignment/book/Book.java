package edu.kh.assignment.book;

public class Book {
	
	private String bookName;
	private String author;
	private int price;
	private int bookNum;
	private String company;
	
	
	public Book() {
		
		
	}


	public Book(String bookName, String author, int price, int bookNum, String company) {
		
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.bookNum = bookNum;
		this.company = company;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getBookNum() {
		return bookNum;
	}
	
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}

	public String information() {
		
		return bookNum + "\t" + bookName + "\t" + author + "\n";
		
		
	}

	@Override
	public String toString() {
		return bookName + "\t" + author + "\t" + price +  "\t" +  company + "\n";
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
