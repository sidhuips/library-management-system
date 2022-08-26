package com.library.management.dao;

import java.util.List;

import com.library.management.model.BookVO;

public interface BookDAO 
{
	public List<BookVO> getAllBooks();
}