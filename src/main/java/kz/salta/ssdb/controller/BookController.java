package kz.salta.ssdb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kz.salta.ssdb.model.Book;
import kz.salta.ssdb.model.Logbook;
import kz.salta.ssdb.service.BookService;
import kz.salta.ssdb.service.LibraryCardService;
import kz.salta.ssdb.service.LogbookService;
import kz.salta.ssdb.service.UserService;

@Controller
public class BookController {
	
	@Resource(name = "userService")
    private UserService userService;
	
	@Resource(name = "libraryCardService")
    private LibraryCardService libraryCardService;
	
	@Resource(name = "logbookService")
    private LogbookService logbookService;
	
	@Resource(name = "bookService")
    private BookService bookService;
	
	@RequestMapping(value = "/take-book", method = RequestMethod.GET)
    public String takeBook(@RequestParam(value = "id", required = true) Long id, Model model) {
		logbookService.addRecord(id,Logbook.ActionType.checked_out);
		bookService.takeBook(id);
		return "redirect:/library";
	}
	
	@RequestMapping(value = "/books-to-return", method = RequestMethod.GET)
    public String booksToReturn(Model model) {
		List<Logbook> logbooks = logbookService.findByLibraryCardAndActionType(Logbook.ActionType.checked_out);
		model.addAttribute("logbooks",logbooks);
		return "/student/return";
	}
	
	@RequestMapping(value = "/return-book", method = RequestMethod.GET)
    public String returnBook(@RequestParam(value = "id", required = true) Long id, Model model) {
		logbookService.addRecord(id,Logbook.ActionType.returned);
		bookService.returnBook(id);
		return "redirect:/books-to-return";
	}
}
