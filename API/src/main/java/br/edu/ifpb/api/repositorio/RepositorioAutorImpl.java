/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.api.repositorio;

import br.edu.ifpb.api.entity.Autor;
import javax.ejb.Stateless;

@Stateless
public class RepositorioAutorImpl extends RepositorioImpl<Autor, Integer> 
        implements RepositorioAutor {
 
}
