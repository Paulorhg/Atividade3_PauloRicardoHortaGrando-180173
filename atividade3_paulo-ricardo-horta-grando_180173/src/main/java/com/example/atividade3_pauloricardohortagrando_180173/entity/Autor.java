package com.example.atividade3_pauloricardohortagrando_180173.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
public class Autor implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String nascionalidade;

    @ManyToMany
    @JoinTable(
        name="LivrosAutores", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_livro", "id_autor" }),
        joinColumns        = @JoinColumn(name = "id_autor"), 
        inverseJoinColumns = @JoinColumn(name = "id_livro")
    )
    private List<Livro> livros;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nascionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nascionalidade = nacionalidade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Autor [id=" + id + ", livros=" + livros + ", nacionalidade=" + nascionalidade + ", nome=" + nome + "]";
    }

    
}