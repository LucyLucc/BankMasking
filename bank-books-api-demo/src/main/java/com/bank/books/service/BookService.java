package com.bank.books.service;

import org.springframework.stereotype.Service;

import com.bank.books.entity.Book;
import com.bank.books.models.BookRequest;
import com.bank.books.models.BookResponse;
import com.bank.books.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository repository;
   
    // Constructor injection
    public BookService(BookRepository repository) {
        this.repository = repository;
        
    }

    public BookResponse createBook(BookRequest request) {
        // Create Book object using constructor / setters instead of builder
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setEmail(request.getEmail());
        book.setPhoneNumber(request.getPhoneNumber());

        // Save to repository
        Book savedBook = repository.save(book);

        return mapToResponse(savedBook);
    }

    public List<BookResponse> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public BookResponse getBookById(Long id) {
        return repository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow();
    }

    public BookResponse updateBook(Long id, BookRequest request) {
        Book book = repository.findById(id).orElseThrow();

        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setEmail(request.getEmail());
        book.setPhoneNumber(request.getPhoneNumber());

        Book updatedBook = repository.save(book);

        return mapToResponse(updatedBook);
    }

    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }

    private BookResponse mapToResponse(Book book) {
    	
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setEmail(book.getEmail());
        response.setPhoneNumber(book.getPhoneNumber());
        return response;
    }
    
}