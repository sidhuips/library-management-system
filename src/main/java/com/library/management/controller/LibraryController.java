package com.library.management.controller;

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
import com.library.management.service.LibraryManager;

@Controller
@RequestMapping("/library")
public class LibraryController 
{
	@Autowired
	LibraryManager manager;

	@RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
	public String getAllBooks(Model model)
	{
		model.addAttribute("books", manager.getAllBooks());
		model.addAttribute("displayheader", true);

		return "booksListDisplay";
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
        final RedirectView redirectView = new RedirectView("/library/addBook", true);
        redirectAttributes.addFlashAttribute("savedBook", book);
        redirectAttributes.addFlashAttribute("addBookSuccess", true);
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
        final RedirectView redirectView = new RedirectView("/library/removeBook", true);
        redirectAttributes.addFlashAttribute("removedBook", book);
        redirectAttributes.addFlashAttribute("removeBookSuccess", true);
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
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
			if (loginBean.getUserName().equals("inder") && loginBean.getPassword().equals("inder123")) {
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
