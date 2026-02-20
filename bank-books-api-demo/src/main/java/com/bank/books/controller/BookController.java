package com.bank.books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.bank.books.models.BookRequest;
import com.bank.books.models.BookResponse;
import com.bank.books.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	 private final BookService service;

	public BookController(BookService service) {
	    this.service = service;
	}
	
	@GetMapping("/")
    public String home() {
        return "Welcome to Bank Books API!";
    }
	
	@PostMapping
	public BookResponse create(@RequestBody BookRequest request) {
		return service.createBook(request);
	}
	
	@GetMapping
	public List<BookResponse> getAll(){
		return service.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public BookResponse getById(@PathVariable Long id){
		return service.getBookById(id);
	}
	
	
	@PutMapping("/{id}")
	public BookResponse update(@PathVariable Long id, @RequestBody BookRequest request){
		return service.updateBook(id, request);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		 service.deleteBookById(id);
	}
	
	
	
	

}
