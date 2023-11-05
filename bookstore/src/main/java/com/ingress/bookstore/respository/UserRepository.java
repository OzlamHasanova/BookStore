package com.ingress.bookstore.respository;

import com.ingress.bookstore.entity.User;
import com.ingress.bookstore.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsernameAndPasswordAndRoleAndActive(String username, String password, UserRole role, Integer active);

    User findUserByUserIdAndActive(Long userId,Integer active);
}
