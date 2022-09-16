package com.library.management.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.library.management.model.BookVO;
import com.library.management.model.Login;
import com.library.management.model.SearchVO;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public List<BookVO> getAllBooks() 
	{
		ResponseEntity<BookVO[]> response =
				  restTemplate.getForEntity(
				  "/books",
				  BookVO[].class);
		BookVO[] bookArray = response.getBody();

		return Arrays.asList(bookArray);
	}

	@Override
	public Login getUser(String username) {

		Login login =
				  restTemplate.postForObject(
				  "/login",new Login(username),
				  Login.class);
		return login;
	}

	@Override
	public BookVO addBook(BookVO book) {
				
		BookVO existingBook = this.findBookById(book.getId());
		if(existingBook != null)
			return null;
		BookVO bookSaved =
				  restTemplate.postForObject(
				  "/addBook",book,
				  BookVO.class);
		
		return bookSaved;
	}

	@Override
	public BookVO updateBook(BookVO book) {
		BookVO existingBook = this.findBookById(book.getId());
		if(existingBook == null)
			return null;
		BookVO bookSaved =
				  restTemplate.postForObject(
				  "/updateBook",book,
				  BookVO.class);
		return bookSaved;
	}
	
	@Override
	public BookVO removeBook(BookVO book) {
		BookVO existingBook = this.findBookById(book.getId());
		if(existingBook == null)
			return null;
		BookVO bookRemoved =
				  restTemplate.postForObject(
				  "/removeBook",book,
				  BookVO.class);
		return bookRemoved;
	}
	
	@Override
	public List<BookVO> findBooksByName(SearchVO search) {
		
		ResponseEntity<BookVO[]> response =
				  restTemplate.postForEntity(
				  "/searchBook",search,
				  BookVO[].class);
		BookVO[] bookArray = response.getBody();
		if(bookArray==null || bookArray.length==0)
		{
			return new ArrayList<BookVO>();
		}
		
		return Arrays.asList(bookArray);
	}
	
	public BookVO findBookById(String id) {
		ResponseEntity<BookVO> response =
				  restTemplate.getForEntity(
				  "/findBookById/"+id,
				  BookVO.class);
		BookVO bookFound = response.getBody();
		return bookFound;
	}
}
