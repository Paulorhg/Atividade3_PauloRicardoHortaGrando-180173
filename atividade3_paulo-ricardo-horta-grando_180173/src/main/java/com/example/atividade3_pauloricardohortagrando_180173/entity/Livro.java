package com.example.atividade3_pauloricardohortagrando_180173.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

/**
 * Livro
 */
@Entity
public class Livro implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;

    @ManyToOne
    @JoinColumn(name="ID_Editora")
    private Editora editora;

    @ManyToMany
    @JoinTable(
        name="LivrosAutores", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_livro", "id_autor" }),
        joinColumns        = @JoinColumn(name = "id_livro"), 
        inverseJoinColumns = @JoinColumn(name = "id_autor")
    )
    private List<Autor> autores;

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

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Livro [autores=" + autores + ", editora=" + editora + ", id=" + id + ", nome=" + nome + "]";
    }
    
}