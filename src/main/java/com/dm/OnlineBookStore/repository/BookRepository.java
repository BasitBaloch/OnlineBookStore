package com.dm.OnlineBookStore.repository;

import com.dm.OnlineBookStore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
