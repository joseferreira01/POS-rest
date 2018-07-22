/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.api.service;

import br.edu.ifpb.api.entity.Livro;
import java.util.List;

/**
 *
 * @author jose
 */
public interface LivroSercice {

    void salvar(Livro livro);

    List<Livro> todos();

    public Livro localizarPorId(int id);

    public Livro remove(int id);

    public Livro update(Livro entity);
}
