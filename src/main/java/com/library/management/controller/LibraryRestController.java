package com.library.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.model.BookVO;
import com.library.management.service.LibraryService;

@RestController
public class LibraryRestController {

	@Autowired
	LibraryService libraryService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ResponseEntity<List<BookVO>> getProducts() {
		List<BookVO> books = libraryService.getAllBooks();
		if (books.isEmpty()) {
			return new ResponseEntity<List<BookVO>>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(books);
	}
}