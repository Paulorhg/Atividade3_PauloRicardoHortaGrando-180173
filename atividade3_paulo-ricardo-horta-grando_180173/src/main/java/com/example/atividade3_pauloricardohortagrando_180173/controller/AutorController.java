package com.example.atividade3_pauloricardohortagrando_180173.controller;

import com.example.atividade3_pauloricardohortagrando_180173.entity.Autor;
import com.example.atividade3_pauloricardohortagrando_180173.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutorController {
    
    @Autowired
    private AutorService autorService;

    @GetMapping("/autores")
    public ModelAndView getAutores(){
        ModelAndView mv = new ModelAndView("autorTemplate");

        mv.addObject("autor",  new Autor());
        mv.addObject("autores", autorService.getAutores());
        
        return mv;
    }

    @GetMapping("/removerAutor")
    public String removerAutor(@RequestParam Integer id){
        
        Autor autor = autorService.getAutorById(id);
        autorService.remover(autor);

        return "redirect:/autores";
    }

    @GetMapping("/detalheAutor/{id}")
    public ModelAndView detalheAutor(@PathVariable(name = "id") Integer id){
        
        ModelAndView mv = new ModelAndView("detalheAutor");
    
        Autor autor = autorService.getAutorById(id);
        mv.addObject("autor",  autor);
        mv.addObject("livros", autor.getLivros());

        return mv;
   
    }

    @GetMapping("/editarAutor/{id}")
    public ModelAndView editarAutor(@PathVariable(name = "id") Integer id){
        
        ModelAndView mv = new ModelAndView("autorEdit");
    
        Autor autor = autorService.getAutorById(id); 
        mv.addObject("autor",  autor);

        return mv;
   
    }

    @PostMapping("/salvarAutor")
    public String salvar(@ModelAttribute Autor autor){

        
        autorService.salvar(autor);
      
        return "redirect:/autores";
    }

}