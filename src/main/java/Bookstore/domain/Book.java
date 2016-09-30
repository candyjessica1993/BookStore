package Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id; 
	private String title; 
	private String author; 
	private int year; 
	private String isbn; 
	private double price;
	
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category; 

	//Constructors
	public Book(String author, String title, String isbn, int year, double price, Category category) {
		super();	
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
		this.category = category; 
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if(this.category != null)
			return "Book [id=" + id + ", title=" + title + ", author=" + author
					+ ", year=" + year + ", isbn=" + isbn + ", price=" + price
					+ ", category=" + category + "]";
			else
			return "Book [title=" + title + ", author=" + author + ", year=" + year
				+ ", isbn=" + isbn + ", price=" + price + "]";
	}


}
