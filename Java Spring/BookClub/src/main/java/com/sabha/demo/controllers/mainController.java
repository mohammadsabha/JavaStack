package com.sabha.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sabha.demo.models.Book;
import com.sabha.demo.models.LoginUser;
import com.sabha.demo.models.User;
import com.sabha.demo.services.BookService;
import com.sabha.demo.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class mainController {
 
	@Autowired
    private UserService userService;
	@Autowired
	private BookService bookService;
 @GetMapping("/")
 public String index(Model model) {
 
     // Bind empty User and LoginUser objects to the JSP
     // to capture the form input
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
     return "index.jsp";
 }
 
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {
     
     // TO-DO Later -- call a register method in the service 
	 userService.register(newUser, result);
     // to do some extra validations and create a new user!
     
     if(result.hasErrors()) {
         // Be sure to send in the empty LoginUser before 
         // re-rendering the page.
    	 session.setAttribute("user_id", newUser.getId());
         model.addAttribute("newLogin", new LoginUser());
         return "index.jsp";
     }
     
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
 
     return "redirect:/";
 }
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     
     // Add once service is implemented:
	 User user = userService.login(newLogin, result);
     // User user = userServ.login(newLogin, result);
 
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "index.jsp";
     }
 
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("user_id", user.getId());
     return "redirect:/books";
 }
 
 @GetMapping("/books")
 public String books(@ModelAttribute("book") Book book , Model model, HttpSession session) {
	 // put login _current_ user in seeion
	 Long user_id = (Long) session.getAttribute("user_id");
	 User thisUser = userService.findUserById(user_id);
	 model.addAttribute("thisUser", thisUser);
	 // retrieve all books
	 List<Book> allBooks = bookService.allBooks();
	 model.addAttribute("allBooks" , allBooks);
	 //System.out.print(allBooks.get(0).getTitle());
     //model.addAttribute("newUser", new User());
	 //model.addAttribute("newLogin", new LoginUser());
	 return "books.jsp";
 }
 
 @GetMapping("/books/new")
 public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) { 
	 Long user_id = (Long) session.getAttribute("user_id");
	 User thisUser = userService.findUserById(user_id);
	 model.addAttribute("thisUser", thisUser);
	 return "newbook.jsp";
 }
 
 @PostMapping("/shelfs/{user_id}/books/new")
 public String createShelf(@PathVariable("user_id") Long id, 
			@Valid @ModelAttribute("book") Book book,
			BindingResult result, 
			Model model) {
	 model.addAttribute("user",userService.findUserById(id));
	 if(result.hasErrors()) {
		 return "newbook.jsp"; 
	 }
	 else {
		 bookService.addBook(book);
		 return "redirect:/books/new";
	 }
 }
 
	 @GetMapping("/books/{bookId}")
	 public String showBook(@PathVariable("bookId") Long bookId , Model model, HttpSession session) {
		 Long user_id = (Long) session.getAttribute("user_id");
		 User thisUser = userService.findUserById(user_id);
		 model.addAttribute("thisUser", thisUser);
		 Book thisBook = bookService.findbook(bookId);
		 model.addAttribute("thisBook",thisBook);
		 return "showbook.jsp";
	}

//@GetMapping("/books/{bookId}/edit")
//public String editBook(@PathVariable("bookId") Long bookId , Model model) {
//	Book thisBook = bookService.findbook(bookId);
//	model.addAttribute("book",thisBook);
//	return "edit.jsp";
//}
//
//@RequestMapping("/users/{user_id}/books/{bookId}/edit")
//public String editShelf(@PathVariable("user_id") Long id, @Valid @ModelAttribute("book") Book book , Model model , BindingResult result) {
//	if(result.hasErrors()) {
//		//model.addAttribute("book",book);
//		model.addAttribute("user", userService.findUserById(id));
//		return "edit.jsp"; 
//	 }
//	 else {
//		 bookService.updateBook(book);
//		 return "redirect:/books";
//	 }
//}
	 @RequestMapping("/books/{id}/edit")
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Book book = bookService.findbook(id);
	     model.addAttribute("book", book);
	     return "edit.jsp";
	 }

	 @RequestMapping(value="/book/{id}", method=RequestMethod.PUT)
	 public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
	     if (result.hasErrors()) {
	         model.addAttribute("book", book);
	         return "edit.jsp";
	     } else {
	      bookService.updateBook(book);
	         return "redirect:/books";
	     } 
	 }
	@RequestMapping(value="/books/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
	 bookService.deleteBook(id);
	    return "redirect:/books";
	}
}
	