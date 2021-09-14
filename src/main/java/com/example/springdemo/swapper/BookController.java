package com.example.springdemo.swapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/api/book")
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping()
    String helloWord()
    {
        return "helloWord";
    }
    @GetMapping(path = "/home")
    String login()
    {
        return "Home";
    }
    @GetMapping(path = "/logout")
    String logout()
    {
        return "Logout";
    }
    @GetMapping(path = "/success")
    String success()
    {
        return "Success";
    }
    @GetMapping(path = "/fail")
    String failed()
    {
        return "Failed";
    } //tu nay den tren k lq den mapper


    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content) })
    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) {
        return repository.findById(id);
    }

//    @GetMapping("/")
//    public Collection<Book> findBooks() {
//        return repository.getBooks();
//    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(
            @PathVariable("id") final String id, @RequestBody final Book book) {
        return book;
    }
}