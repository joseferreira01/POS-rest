/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.api.service;

import br.edu.ifpb.api.entity.Autor;
import br.edu.ifpb.api.entity.Livro;
import br.edu.ifpb.api.repositorio.RepositorioAutor;
import br.edu.ifpb.api.repositorio.RepositorioLivro;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jose
 */
@Stateless
public class AutorSerciceImp implements AutorSercice {
    @EJB
    private RepositorioAutor rl;
    @Override
 public void salvar(Autor autor){
     this.rl.salvar(autor);
 }
    @Override
 public List<Autor> todos(){
        List<Autor> list = this.rl.list(Autor.class);
        
        return list;
 }

    @Override
    public Autor localizarPorId(int id) {
       return this.rl.find(Autor.class, Integer.valueOf(id));
    }

    @Override
    public Autor remove(int id) {
        Autor autor = localizarPorId(id);
    return this.rl.remove(autor);
    }

    @Override
    public Autor update(Autor autor) {
        return this.rl.update(autor);
    }
}
