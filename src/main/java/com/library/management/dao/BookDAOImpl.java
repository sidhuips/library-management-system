package com.library.management.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.management.model.BookVO;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<BookVO> getAllBooks() 
	{
		Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<BookVO> cr = cb.createQuery(BookVO.class);
        Root <BookVO> root = cr.from(BookVO.class);
        cr.select(root);
        Query<BookVO> query = session.createQuery(cr);
        List<BookVO> results = query.getResultList();
        return results;
	}
	
	@Transactional
	@Override
	public BookVO addBook(BookVO book) 
	{
		Session session = sessionFactory.getCurrentSession();
		String isbn = (String) session.save(book);
		book.setId(isbn);
		return book;
	}
	
	@Transactional
	@Override
	public BookVO findBookById(String isbn) {
		Session session = sessionFactory.getCurrentSession();
		BookVO book = session.byId(BookVO.class).load(isbn);
		return book;
	}
	
	@Transactional
	@Override
	public BookVO updateBook(BookVO book)
	{
		Session session = sessionFactory.getCurrentSession();
		session.update(book);
		return book;
	}
	
	@Transactional
	@Override
	public BookVO removeBook(BookVO book)
	{
		Session session = sessionFactory.getCurrentSession();
		session.remove(book);
		return book;
	}
	
	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<BookVO> searchBooks(String keyword)
	{
		Session session = sessionFactory.getCurrentSession();
		String hql = "from BookVO where bookName like :keyword";		 
		Query<BookVO> query = session.createQuery(hql);
		query.setParameter("keyword", "%" + keyword + "%");
		 
		List<BookVO> listBooks = query.list();
		return listBooks;
	}
}