package com.project.betting_backend.repository;

import com.project.betting_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);

    Optional<User> findUserByEmail(String email);

    //Optional<User> findFavoriteTeam(String favTeam);

    @Query(value = "SELECT coins from users where id =?1", nativeQuery = true)
    Optional<User> getAllCoinByUserId(Long id);
}
