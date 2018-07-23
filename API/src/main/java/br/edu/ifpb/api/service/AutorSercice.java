/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.api.service;

import br.edu.ifpb.api.entity.Autor;
import br.edu.ifpb.api.entity.Livro;
import java.util.List;

/**
 *
 * @author jose
 */
public interface AutorSercice {

    void salvar(Autor autor);

    List<Autor> todos();

    public Autor localizarPorId(int id);

    public Autor remove(int id);

    public Autor update(Autor entity);
}
