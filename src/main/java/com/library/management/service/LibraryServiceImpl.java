package com.library.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.dao.BookDAO;
import com.library.management.dao.UserDAO;
import com.library.management.model.BookVO;
import com.library.management.model.Login;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	BookDAO bookDao;
	
	@Autowired
	UserDAO user;
	
	public List<BookVO> getAllBooks() 
	{
		return bookDao.getAllBooks();
	}

	@Override
	public Login getUser(String username) {
		return user.findUserByUserName(username);
	}

	@Override
	public BookVO addBook(BookVO book) {
		return bookDao.addBook(book);
	}

	@Override
	public BookVO updateBook(BookVO book) {
		return bookDao.updateBook(book);
	}
	
	@Override
	public BookVO removeBook(BookVO book) {
		return bookDao.removeBook(book);
	}
	
	@Override
	public List<BookVO> findBooksByName(String keyword) {
		return bookDao.searchBooks(keyword);
	}
}
