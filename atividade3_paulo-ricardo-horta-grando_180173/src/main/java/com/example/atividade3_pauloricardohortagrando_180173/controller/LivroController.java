package com.example.atividade3_pauloricardohortagrando_180173.controller;

import com.example.atividade3_pauloricardohortagrando_180173.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LivroController {
    
    @Autowired
    private LivroService livroService;

    
}