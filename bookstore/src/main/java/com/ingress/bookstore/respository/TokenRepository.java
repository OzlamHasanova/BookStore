package com.ingress.bookstore.respository;

import com.ingress.bookstore.entity.Token;
import com.ingress.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long> {
    Token findTokenByUserAndTokenAndActive(User user,String userToken, Integer active);
}
