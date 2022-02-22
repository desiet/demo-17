package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<CollageStudent, Long> {

    @Query("SELECT c FROM CollageStudent  c WHERE c.email=?1")
    Optional<CollageStudent> findByEmail(String email);
}
