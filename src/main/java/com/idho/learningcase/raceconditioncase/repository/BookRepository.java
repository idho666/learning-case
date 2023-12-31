package com.idho.learningcase.raceconditioncase.repository;

import com.idho.learningcase.raceconditioncase.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

/**
 * Updated by Idho.
 * Date: 06.04.2023
 * Time: 9:11
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    /** menggunakan locking **/
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "SELECT b FROM Book b WHERE b.name=:bookName")
    Optional<Book> getBookByNameWithLocking(@Param("bookName")String bookName);

    /** tidak menggunakan locking **/
    @Query(value = "SELECT b FROM Book b WHERE b.name=:bookName")
    Optional<Book> getBooByNameWithoutLocking(@Param("bookName")String bookName);
}