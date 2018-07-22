/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.api.service;

import br.edu.ifpb.api.entity.Livro;
import br.edu.ifpb.api.repositorio.RepositorioLivro;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jose
 */
@Stateless
public class LivroSerciceImp implements LivroSercice {
    @EJB
    private RepositorioLivro rl;
    @Override
 public void salvar(Livro livro){
     this.rl.salvar(livro);
 }
    @Override
 public List<Livro> todos(){
        List<Livro> list = this.rl.list(Livro.class);
        
        return list;
 }

    @Override
    public Livro localizarPorId(int id) {
       return this.rl.find(Livro.class, Integer.valueOf(id));
    }

    @Override
    public Livro remove(int id) {
        Livro livro = localizarPorId(id);
    return this.rl.remove(livro);
    }

    @Override
    public Livro update(Livro livro) {
        return this.rl.update(livro);
    }
}
