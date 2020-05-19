package com.example.atividade3_pauloricardohortagrando_180173.service;

import java.util.List;

import com.example.atividade3_pauloricardohortagrando_180173.entity.Editora;
import com.example.atividade3_pauloricardohortagrando_180173.repository.EditoraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {
    
    @Autowired
    private EditoraRepository repository;

    public List<Editora> getEditoras(){
        return repository.findAll();
    }

    public void salvar(Editora editora){
        repository.save(editora);
    }
    
}