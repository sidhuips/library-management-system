package com.library.management.controller;

import java.util.List;

import org.h2.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.library.management.model.BookVO;
import com.library.management.model.Login;
import com.library.management.model.SearchVO;
import com.library.management.service.LibraryService;

@Controller
@RequestMapping("/library")
public class LibraryController 
{
	@Autowired
	LibraryService libraryService;

	@RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
	public String getAllBooks(Model model)
	{
		model.addAttribute("books", libraryService.getAllBooks());
		model.addAttribute("displayheader", true);

		return "booksListDisplay";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model)
	{

		model.addAttribute("search", new SearchVO());
		model.addAttribute("displayheader", true);
		return "searchBook";
	}
	
	@RequestMapping(value = "/searchBook", method = RequestMethod.POST)
	public RedirectView searchBooks(@ModelAttribute("search") SearchVO search, RedirectAttributes redirectAttributes)
	{
		List<BookVO> booksFound = libraryService.findBooksByName(search.getSearchString());

		 final RedirectView redirectView = new RedirectView("/library/searchResult", true);
	        redirectAttributes.addFlashAttribute("books", booksFound);
	        redirectAttributes.addFlashAttribute("searchString", search);
	        redirectAttributes.addFlashAttribute("addBookSuccess", true);
	        redirectAttributes.addFlashAttribute("displayheader", true);
	        return redirectView;
	}
	@RequestMapping(value = "/searchResult", method = RequestMethod.GET)
	public String searchResult(Model model, @ModelAttribute("searchString") SearchVO search)
	{
		model.addAttribute("search",search);
		model.addAttribute("displayheader", true);
	    return "searchResult";
	}	

	@RequestMapping(value = "/getAllBooksUsingAngularRest", method = RequestMethod.GET)
	public String getAllBooksUsingRest(Model model)
	{
		model.addAttribute("displayheader", true);
		return "booksListDisplayAngular";
	}
		
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addBookView(Model model) {
        model.addAttribute("book", new BookVO());
		model.addAttribute("displayheader", true);
        return "add-book";
    }

	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public RedirectView addBook(@ModelAttribute("book") BookVO book, RedirectAttributes redirectAttributes) {
		BookVO bookAdded = libraryService.addBook(book);
		if(bookAdded!=null) {
	        redirectAttributes.addFlashAttribute("savedBook", bookAdded);
	        redirectAttributes.addFlashAttribute("addBookSuccess", true);

		}else {
	        redirectAttributes.addFlashAttribute("bookExists", true);
	        redirectAttributes.addFlashAttribute("addBookSuccess", false);
	        redirectAttributes.addFlashAttribute("savedBook", book);

		}
		final RedirectView redirectView = new RedirectView("/library/addBook", true);
        redirectAttributes.addFlashAttribute("displayheader", true);
        return redirectView;
    }
	
	@RequestMapping(value = "/updateBook", method = RequestMethod.GET)
    public String updateBookView(Model model) {
        model.addAttribute("book", new BookVO());
		model.addAttribute("displayheader", true);
        return "update-book";
    }

	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public RedirectView updateBook(@ModelAttribute("book") BookVO book, RedirectAttributes redirectAttributes) {
		BookVO bookUpdated = libraryService.updateBook(book);
		if(bookUpdated!=null) {
	        redirectAttributes.addFlashAttribute("updatedBook", bookUpdated);
	        redirectAttributes.addFlashAttribute("updateBookSuccess", true);

		}else {
	        redirectAttributes.addFlashAttribute("bookDoesNotExist", true);
	        redirectAttributes.addFlashAttribute("updateBookSuccess", false);
	        redirectAttributes.addFlashAttribute("updatedBook", book);

		}
		final RedirectView redirectView = new RedirectView("/library/updateBook", true);
        redirectAttributes.addFlashAttribute("displayheader", true);
        return redirectView;
    }
	
	@RequestMapping(value = "/removeBook", method = RequestMethod.GET)
    public String removeBookView(Model model) {
        model.addAttribute("book", new BookVO());
		model.addAttribute("displayheader", true);
        return "remove-book";
    }

	@RequestMapping(value = "/removeBook", method = RequestMethod.POST)
    public RedirectView removeBook(@ModelAttribute("book") BookVO book, RedirectAttributes redirectAttributes) {
		BookVO bookRemoved = libraryService.removeBook(book);

		final RedirectView redirectView = new RedirectView("/library/removeBook", true);
		if(bookRemoved!=null) {
	        redirectAttributes.addFlashAttribute("removedBook", bookRemoved);
	        redirectAttributes.addFlashAttribute("removeBookSuccess", true);

		}else {
	        redirectAttributes.addFlashAttribute("bookDoesNotExist", true);
	        redirectAttributes.addFlashAttribute("removeBookSuccess", false);
	        redirectAttributes.addFlashAttribute("removedBook", book);

		}
        redirectAttributes.addFlashAttribute("displayheader", true);
        return redirectView;
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") Login loginBean) {
		Login login = libraryService.getUser(loginBean.getUserName());
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null && login!=null) {
			if (StringUtils.equals(loginBean.getUserName(), login.getUserName()) && StringUtils.equals(loginBean.getPassword(), login.getPassword())) {
				model.addAttribute("msg", loginBean.getUserName());
				model.addAttribute("displayheader", true);
				return "success";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}
}
