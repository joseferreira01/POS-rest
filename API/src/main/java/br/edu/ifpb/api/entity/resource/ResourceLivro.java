/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.api.entity.resource;

import br.edu.ifpb.api.entity.Livro;
import br.edu.ifpb.api.service.LivroSercice;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jose
 */

@Path("livro")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class ResourceLivro {
    @EJB
    private LivroSercice sercice;
    @GET
     public Response recuperarTodos() {
        List<Livro> livros = sercice.todos();

        GenericEntity<List<Livro>> entity
                = new GenericEntity<List<Livro>>(livros) {
        };

        return Response.ok()
//                .header("Access-Control-Allow-Origin", "*")
                .entity(entity)
                .build();
    }
   
}
