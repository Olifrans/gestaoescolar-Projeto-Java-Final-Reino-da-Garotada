// package com.example.gestaoescolar.controller;



// import com.example.gestaoescolar.model.Professor;


// import com.example.gestaoescolar.service.ProfessorService;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// @Controller
// @RequestMapping("/professores")
// public class ProfessorController {

//     @Autowired
//     private ProfessorService professorService;

//     @GetMapping
//     public String listarProfessores(Model model) {
//         model.addAttribute("professores", professorService.listarTodos());
//         return "professores/listar";
//     }

//     @GetMapping("/novo")
//     public String novoProfessorForm(Model model) {
//         model.addAttribute("professor", new Professor());
//         return "professores/form";
//     }

//     @PostMapping("/salvar")
//     public String salvarProfessor(@ModelAttribute Professor professor) {
//         professorService.salvarProfessor(professor);
//         return "redirect:/professores";
//     }

//     @GetMapping("/editar/{id}")
//     public String editarProfessorForm(@PathVariable Long id, Model model) {
//         Professor professor = professorService.buscarPorId(id);
//         model.addAttribute("professor", professor);
//         return "professores/form";
//     }

//     @GetMapping("/deletar/{id}")
//     public String deletarProfessor(@PathVariable Long id) {
//         professorService.deletarProfessor(id);
//         return "redirect:/professores";
//     }
// }





package com.example.gestaoescolar.controller;

import com.example.gestaoescolar.model.Professor;
import com.example.gestaoescolar.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    // Listar todos (Read)
    @GetMapping
    public String listarProfessores(Model model) {
        List<Professor> professores = professorService.listarTodos();
        model.addAttribute("professores", professores);
        return "professores/listar";
    }

    // Formulário para novo professor (Create)
    @GetMapping("/novo")
    public String novoProfessorForm(Model model) {
        model.addAttribute("professor", new Professor());
        return "professores/form";
    }

    // Salvar novo professor (Create)
    @PostMapping("/salvar")
    public String salvarProfessor(@ModelAttribute Professor professor) {
        professorService.salvarProfessor(professor);
        return "redirect:/professores";
    }

    // Formulário para editar professor (Update)
    @GetMapping("/editar/{id}")
    public String editarProfessorForm(@PathVariable Long id, Model model) {
        Professor professor = professorService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: " + id));
        model.addAttribute("professor", professor);
        return "professores/form";
    }

    // Atualizar professor (Update)
    @PostMapping("/atualizar/{id}")
    public String atualizarProfessor(@PathVariable Long id, @ModelAttribute Professor professor) {
        professorService.atualizarProfessor(id, professor);
        return "redirect:/professores";
    }

    // Deletar professor (Delete)
    @GetMapping("/deletar/{id}")
    public String deletarProfessor(@PathVariable Long id) {
        professorService.deletarProfessor(id);
        return "redirect:/professores";
    }
}