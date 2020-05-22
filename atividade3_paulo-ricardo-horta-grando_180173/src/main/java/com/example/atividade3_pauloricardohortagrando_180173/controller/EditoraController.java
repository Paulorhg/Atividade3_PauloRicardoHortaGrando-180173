package com.example.atividade3_pauloricardohortagrando_180173.controller;

import com.example.atividade3_pauloricardohortagrando_180173.entity.Editora;
import com.example.atividade3_pauloricardohortagrando_180173.service.EditoraService;
import com.example.atividade3_pauloricardohortagrando_180173.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditoraController {
    
    @Autowired
    private EditoraService editoraService;

    @Autowired
    private LivroService livroService;

    @GetMapping("/editoras")
    public ModelAndView getAlunos(){
        ModelAndView mv = new ModelAndView("editoraTemplate");

        mv.addObject("editora",  new Editora());
        mv.addObject("editoras", editoraService.getEditoras());
        mv.addObject("livros", livroService.getLivros());
        
        return mv;
    }

    @GetMapping("/removerEditora")
    public String removerEditora(@RequestParam Integer id){
        
        Editora editora = editoraService.getEditoraById(id);
        editoraService.remover(editora);

        return "redirect:/editoras";
    }

    @GetMapping("/detalheEditora/{id}")
    public ModelAndView detalhesEditora(@PathVariable(name = "id") Integer id){
        
        ModelAndView mv = new ModelAndView("detalheEditora");
    
        Editora editora = editoraService.getEditoraById(id); 
        mv.addObject("editora",  editora);
        mv.addObject("livros", editora.getLivros());

        return mv;
   
    }

    @GetMapping("/editarEditora/{id}")
    public ModelAndView editarEditora(@PathVariable(name = "id") Integer id){
        
        ModelAndView mv = new ModelAndView("editoraEdit");
    
        Editora editora = editoraService.getEditoraById(id); 
        mv.addObject("editora",  editora);

        return mv;
   
    }

    @PostMapping("/salvarEditora")
    public String salvar(@ModelAttribute Editora editora){

        
        editoraService.salvar(editora);
      
        return "redirect:/editoras";
    }
}