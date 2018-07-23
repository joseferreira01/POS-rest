/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.api.entity.resource;

import br.edu.ifpb.api.entity.Autor;
import br.edu.ifpb.api.entity.Livro;
import br.edu.ifpb.api.service.AutorSercice;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jose
 */
@Path("autor")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class ResourceAutor {

    @EJB
    private AutorSercice sercice;

    @GET
    public Response recuperarTodos() {
        List<Autor> atores = sercice.todos();

        GenericEntity<List<Autor>> entity
                = new GenericEntity<List<Autor>>(atores) {
        };

        return Response.ok()
                //                
                .entity(entity)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response autorPorId(
            @PathParam("id") int id) {

        Autor autor = sercice.localizarPorId(id);
        if (autor == null) {
            return Response.noContent().build();
        }

        return Response.ok() //200
                .entity(autor)
                .build();

    }

    @DELETE
    @Path("{id}")
    public Response removerLivro(@PathParam("id") int id) {
        Autor autor = sercice.remove(id);
        return Response.ok() // 200
                .entity(autor)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response novaLivro(JsonObject json) {
        Autor autor = new Autor(json.getString("email"),
                json.getString("nome"),
                json.getString("abreviacao"));
        sercice.salvar(autor);

        if (autor == null) {
            return Response.noContent().build();
        }
        return Response.ok() //200
                .entity(autor)
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editaLivro(JsonObject json) {
        Autor autor = new Autor(json.getInt("id"),
                json.getString("email"),
                json.getString("nome"),
                json.getString("abreviacao"));
        sercice.update(autor);

        if (autor == null) {
            return Response.noContent().build();
        }
        return Response.ok() //200
                .entity(autor)
                .build();
    }

//    @PUT
//    @Path("{id}")
//    public Response atualizarLivro(
//            @PathParam("id") int id,
//            Livro livro) {
//
//        sercice.update(livro);
//        return Response.ok()
//                .entity(livro)
//                .build();
//    }
}
