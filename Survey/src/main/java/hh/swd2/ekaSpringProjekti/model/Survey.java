package hh.swd2.ekaSpringProjekti.model;

import javax.persistence.*;

@Entity
public class Survey {
	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	// @column name="etunimi"
	private Long isbn;
	private String title;
	private String author;
	private String year;
	private double price;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "categoryid")
	private Category category;

	public Survey() {
	}

	public Survey(Long isbn, String author, String title, String year, double price, Category category) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;

		this.year = year;
		this.price = price;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public Long getIsbn() {
		return isbn;
	}

	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ",author=" + author + ", title=" + title + ", year=" + year + ", price=" + price
				+ "]";
	}
}
