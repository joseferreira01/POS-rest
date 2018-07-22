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
}
