package hh.swd2.ekaSpringProjekti.model;

import javax.persistence.*;
import java.util.List;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryid;

	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Survey> books;

	public Category() {
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Survey> getBooks() {
		return books;
	}

	public void setBooks(List<Survey> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category{" + "categoryid=" + categoryid + ", name='" + name + '\'' + ", books=" + books + '}';
	}
}
