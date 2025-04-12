


package com.example.gestaoescolar.controller;
import com.example.gestaoescolar.model.Aluno;

import com.example.gestaoescolar.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // Listar todos (Read)
    @GetMapping
    public String listarAlunos(Model model) {
        List<Aluno> alunos = alunoService.listarTodos();
        model.addAttribute("alunos", alunos);
        return "alunos/listar";
    }

    // Formulário para novo aluno (Create)
    @GetMapping("/novo")
    public String novoAlunoForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "alunos/form";
    }

    // Salvar novo aluno (Create)
    @PostMapping("/salvar")
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        alunoService.salvarAluno(aluno);
        return "redirect:/alunos";
    }

    // Formulário para editar aluno (Update)
    @GetMapping("/editar/{id}")
    public String editarAlunoForm(@PathVariable Long id, Model model) {
        Aluno aluno = alunoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        model.addAttribute("aluno", aluno);
        return "alunos/form";
    }

    // Atualizar aluno (Update)
    @PostMapping("/atualizar/{id}")
    public String atualizarAluno(@PathVariable Long id, @ModelAttribute Aluno aluno) {
        alunoService.atualizarAluno(id, aluno);
        return "redirect:/alunos";
    }

    // Deletar aluno (Delete)
    @GetMapping("/deletar/{id}")
    public String deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return "redirect:/alunos";
    }
}