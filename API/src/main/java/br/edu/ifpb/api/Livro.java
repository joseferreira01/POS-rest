/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.api;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author jose
 */
@Entity
public class Livro implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String edicao;
    private String titulo;
    private String descricao;
    private List<Autor> autores;

    public Livro() {
    }

    public Livro( String edicao, String titulo, String descricao, List<Autor> autores) {
        
        this.edicao = edicao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autores = autores;
    }

    public Livro(int id, String edicao, String titulo, String descricao, List<Autor> autores) {
        this.id = id;
        this.edicao = edicao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autores = autores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

}
