package com.example.gestaoescolar.repository;


import com.example.gestaoescolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}