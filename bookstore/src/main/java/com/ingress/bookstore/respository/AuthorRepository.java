package com.ingress.bookstore.respository;

import com.ingress.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Author,Long>{
        Author findAuthorByIdAndActive(Long id,Integer active);
}
