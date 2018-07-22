/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.api.repositorio;

import java.util.List;

/**
 *
 * @author jose
 */
public interface Repositorio<T, KEY> {

    T find(Class<T> tipo, KEY id);

    List<T> list(Class<T> tipo);

    void remove(T entity);

    void salvar(T entity);

    T update(T entity);
    
}
