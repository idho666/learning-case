package com.idho.learningcase.raceconditioncase.service;

import com.idho.learningcase.raceconditioncase.entity.Book;
import com.idho.learningcase.raceconditioncase.entity.Orders;
import com.idho.learningcase.raceconditioncase.repository.BookRepository;
import com.idho.learningcase.raceconditioncase.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Updated by Idho.
 * Date: 06.04.2023
 * Time: 9:11
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final OrdersRepository ordersRepository;

    /** use locking **/
    @Transactional()
    public Book checkoutBookWithLocking(Book book, String requestName){
        /** cari buku berdasarkan nama **/
        Optional<Book> findBook = bookRepository.getBookByNameWithLocking(book.getName());

        if (findBook.isPresent()){
            if (findBook.get().getQty() < book.getQty()){
                log.error("error karena jumlah yang dipinjam melebihi kapasitas");
                throw new RuntimeException("error please check log !!");
            }
            /** update ke table buku qty **/
            findBook.get().setQty(findBook.get().getQty() - book.getQty());
            bookRepository.save(findBook.get());

            /** insert ke table orders **/
            Orders orders = new Orders();
            orders.setBookId(findBook.get().getId());
            orders.setQty(book.getQty());
            orders.setName(requestName);
            orders.setBookName(findBook.get().getName());
            ordersRepository.save(orders);
        }
        log.info("success checkout book !!");
        return findBook.get();
    }

    /** tidak menggunakan locking **/
    public Book checkoutBookWithoutLocking(Book book, String requestName){
        /** cari buku berdasarkan nama **/
        Optional<Book> findBook = bookRepository.getBooByNameWithoutLocking(book.getName());

        if (findBook.isPresent()){
            if (findBook.get().getQty() < book.getQty()){
                log.error("error karena jumlah yang dipinjam melebihi kapasitas");
                throw new RuntimeException("error please check log !!");
            }
            /** update ke table buku qty **/
            findBook.get().setQty(findBook.get().getQty() - book.getQty());
            bookRepository.save(findBook.get());

            /** insert ke table orders **/
            Orders orders = new Orders();
            orders.setBookId(findBook.get().getId());
            orders.setQty(book.getQty());
            orders.setName(requestName);
            orders.setBookName(findBook.get().getName());
            ordersRepository.save(orders);
        }
        log.info("success checkout book !!");
        return findBook.get();
    }
}
