package com.example.springsecurity.dao;

import com.example.springsecurity.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<Users, Long> {
    // Mock
//    private static final List<UserDetails> APPLICATION_USERS = Arrays.asList(
//            new User("teste@gmail.com", "123", Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))),
//            new User("123@gmail.com", "test", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
//    );
//
//    public UserDetails findUserByEmail(String email){
//        return APPLICATION_USERS
//                .stream().filter(user -> user.getUsername().equals(email))
//                .findFirst().orElseThrow(() -> new UsernameNotFoundException("User not found!"));
//    }

    @Query(value = "SELECT u FROM tb_users u WHERE u.username=?1")
    Users findUserByEmail(String email);
}
