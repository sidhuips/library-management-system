package com.library.management.model;

import java.io.Serializable;

public class BookVO implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private String id;
	private String bookName;
	private String type;
	private String author;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "BookVO [id=" + id + ", bookName=" + bookName + ", type=" + type + ", author=" + author + "]";
	}
	
}