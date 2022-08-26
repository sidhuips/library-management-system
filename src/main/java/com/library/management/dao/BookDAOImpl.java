package com.library.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.library.management.model.BookVO;

@Repository
public class BookDAOImpl implements BookDAO {

	public List<BookVO> getAllBooks() 
	{
		List<BookVO> books = new ArrayList<BookVO>();
		
		BookVO vo1 = new BookVO();
		vo1.setId("1");
		vo1.setBookName("The Tribute");
		vo1.setAuthor("John Wall");
		vo1.setType("Classic");

		books.add(vo1);
		
		BookVO vo2 = new BookVO();
		vo2.setId("2");
		vo2.setBookName("History in the making");
		vo2.setAuthor("Adam Silver");
		vo2.setType("History");

		books.add(vo2);
		
		return books;
	}
}