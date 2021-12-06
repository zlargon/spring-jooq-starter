package co.cantina.springjooq.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import co.cantina.springjooq.services.BookService;
import co.cantina.springjooq.domain.Book;

@RestController
@RequestMapping(value ="/api/v1/books", produces = "application/json")
public class ApiController {

	@Autowired
	BookService bookService;

	@GetMapping
	public List<Book> getBooks() {
		return this.bookService.getBooks();
	}

	@PostMapping
	@ResponseBody
	public Book addBooks(@RequestBody Book book) {
		return this.bookService.addBooks(book);
	}

}
