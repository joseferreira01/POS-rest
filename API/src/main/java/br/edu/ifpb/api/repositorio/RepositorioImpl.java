/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.api.repositorio;

import br.edu.ifpb.api.entity.Livro;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jose
 */

public class RepositorioImpl<T, KEY> implements Repositorio<T, KEY> {

    @PersistenceContext(unitName = "editora-PU")
    private EntityManager em;

    @Override
    public void salvar(T entity) {
        em.persist(entity);
    }

    @Override
    public T find(Class<T> tipo, KEY id) {
        return em.find(tipo, id);
    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    @Override
    public List<T> list(Class<T> tipo) {
        TypedQuery<T> Query
                = em.createQuery("FROM " + tipo.getSimpleName() + " c", tipo);
        return Query.getResultList();
    }

    @Override
    public T remove(T entity) {
         Optional<T> of = Optional.of(entity);
        try {
            em.remove(entity);
           
            
        } catch (Exception e) {
        }
        return of.get();
    }
}
