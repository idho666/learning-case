package com.idho.learningcase.raceconditioncase.controller;

import com.idho.learningcase.raceconditioncase.entity.Book;
import com.idho.learningcase.raceconditioncase.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Updated by Idho.
 * Date: 06.04.2023
 * Time: 9:11
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/book")
public class BookController {

    private final BookService bookService;

    @PutMapping(value = "/checkout-with-lock")
    public ResponseEntity<Book> checkoutWithLock(@RequestBody Book book, @RequestParam(value = "requestName")String requestName){
        return ResponseEntity.ok(bookService.checkoutBookWithLocking(book, requestName));
    }

    @PutMapping(value = "/checkout-without-lock")
    public ResponseEntity<Book> checkoutWithoutLock(@RequestBody Book book, @RequestParam(value = "requestName")String requestName){
        return ResponseEntity.ok(bookService.checkoutBookWithoutLocking(book, requestName));
    }

    @GetMapping("ping")
    public String ping(){
        return "pong";
    }
}
