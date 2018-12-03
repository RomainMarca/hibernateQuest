package com.wildcodeschool.example.AtelierHibernate.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wildcodeschool.example.AtelierHibernate.entities.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {
}