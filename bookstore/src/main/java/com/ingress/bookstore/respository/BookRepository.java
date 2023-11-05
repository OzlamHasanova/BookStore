package com.ingress.bookstore.respository;

import com.ingress.bookstore.entity.Book;
import com.ingress.bookstore.enums.EnumAvailableStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAllByActive(Integer active);
}
