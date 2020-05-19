package com.example.atividade3_pauloricardohortagrando_180173.service;

import java.util.List;

import com.example.atividade3_pauloricardohortagrando_180173.entity.Autor;
import com.example.atividade3_pauloricardohortagrando_180173.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    
    @Autowired
    private AutorRepository repository;

    public List<Autor> getAutores(){
        return repository.findAll();
    }

    public void salvar(Autor autor){
        repository.save(autor);
    }

    public Autor getAutorById(Integer id) {
		return repository.findById(id).get();
	}

	public void remover(Autor autor) {
        repository.delete(autor);
	}
}