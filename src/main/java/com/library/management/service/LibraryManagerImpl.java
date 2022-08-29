package com.library.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.dao.BookDAO;
import com.library.management.model.BookVO;

@Service
public class LibraryManagerImpl implements LibraryManager {

	@Autowired
	BookDAO dao;
	
	public List<BookVO> getAllBooks() 
	{
		return dao.getAllBooks();
	}
}
