


package com.example.gestaoescolar.service;
import com.example.gestaoescolar.model.Aluno;

import com.example.gestaoescolar.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // Inserir (Create)
    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // Buscar todos (Read)
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    // Buscar por ID (Read)
    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    // Atualizar (Update)
    public Aluno atualizarAluno(Long id, Aluno alunoAtualizado) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setNome(alunoAtualizado.getNome());
                    aluno.setIdade(alunoAtualizado.getIdade());
                    aluno.setMatricula(alunoAtualizado.getMatricula());
                    return alunoRepository.save(aluno);
                })
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
    }

    // Deletar (Delete)
    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}