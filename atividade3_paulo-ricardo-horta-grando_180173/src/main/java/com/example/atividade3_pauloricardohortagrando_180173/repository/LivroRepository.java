package com.example.atividade3_pauloricardohortagrando_180173.repository;

import com.example.atividade3_pauloricardohortagrando_180173.entity.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer>{
    
}