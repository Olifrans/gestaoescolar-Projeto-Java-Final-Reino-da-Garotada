package com.example.gestaoescolar.repository;



import com.example.gestaoescolar.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}