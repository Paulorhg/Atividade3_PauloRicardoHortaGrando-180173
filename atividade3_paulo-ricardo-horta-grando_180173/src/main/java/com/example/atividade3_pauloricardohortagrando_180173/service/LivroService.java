package com.example.atividade3_pauloricardohortagrando_180173.service;

import java.util.List;

import com.example.atividade3_pauloricardohortagrando_180173.entity.Livro;
import com.example.atividade3_pauloricardohortagrando_180173.repository.LivroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    

    @Autowired
    private LivroRepository repository;

    public List<Livro> getLivros(){
        return repository.findAll();
    }

    public void salvar(Livro livro){
        repository.save(livro);
    }

    public Livro getLivroById(Integer id) {
		return repository.findById(id).get();
	}

	public void remover(Livro livro) {
        repository.delete(livro);
	}
}