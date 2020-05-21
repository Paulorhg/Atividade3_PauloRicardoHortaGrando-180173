package com.example.atividade3_pauloricardohortagrando_180173.controller;

import com.example.atividade3_pauloricardohortagrando_180173.entity.Autor;
import com.example.atividade3_pauloricardohortagrando_180173.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/editarAutor")
    public ModelAndView editarAutor(@RequestParam Integer id){
        
        ModelAndView mv = new ModelAndView("autorEdit");
    
        Autor autor = autorService.getAutorById(id); 
        mv.addObject("autor",  autor);
        mv.addObject("autores", autorService.getAutores());

        return mv;
   
    }

    @PostMapping("/salvarAutor")
    public String salvar(@ModelAttribute Autor autor){

        
        autorService.salvar(autor);
      
        return "redirect:/autores";
    }

}