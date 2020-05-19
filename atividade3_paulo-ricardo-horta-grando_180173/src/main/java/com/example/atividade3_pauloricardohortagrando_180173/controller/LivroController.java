package com.example.atividade3_pauloricardohortagrando_180173.controller;

import com.example.atividade3_pauloricardohortagrando_180173.entity.Livro;
import com.example.atividade3_pauloricardohortagrando_180173.service.AutorService;
import com.example.atividade3_pauloricardohortagrando_180173.service.EditoraService;
import com.example.atividade3_pauloricardohortagrando_180173.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LivroController {
    
    @Autowired
    private LivroService livroService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private EditoraService editoraService;

    @GetMapping("/livros")
    public ModelAndView getLivros(){
        ModelAndView mv = new ModelAndView("livroTemplate");

        mv.addObject("livro",  new Livro());
        mv.addObject("livros", livroService.getLivros());
        mv.addObject("autores", autorService.getAutores());
        mv.addObject("editoras", editoraService.getEditoras());
        
        return mv;
    }

    @GetMapping("/removerLivro")
    public String removerLivro(@RequestParam Integer id){
        
        Livro livro = livroService.getLivroById(id);
        livroService.remover(livro);

        return "redirect:/livros";
    }

    @GetMapping("/editarLivro")
    public ModelAndView editarLivro(@RequestParam Integer id){
        
        ModelAndView mv = new ModelAndView("livroEdit");
    
        Livro livro = livroService.getLivroById(id); 
        mv.addObject("livro",  livro);
        mv.addObject("autores", autorService.getAutores());
        mv.addObject("editoras", editoraService.getEditoras());

        return mv;
   
    }

    @PostMapping("/salvarLivro")
    public String salvar(@ModelAttribute Livro livro){

        
        livroService.salvar(livro);
      
        return "redirect:/livros";
    }
}