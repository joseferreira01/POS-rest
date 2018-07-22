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
                //                
                .entity(entity)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response produtosPorId(
            @PathParam("id") int id) {

        Livro produto = sercice.localizarPorId(id);
        if (produto == null) {
            return Response.noContent().build();
        }

        return Response.ok() //200
                .entity(produto)
                .build();

    }

    @DELETE
    @Path("{id}")
    public Response removerLivro(@PathParam("id") int id) {
        Livro livro = sercice.remove(id);
        return Response.ok() // 200
                .entity(livro)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response novaLivro(JsonObject json) {
        Livro livro = new Livro(json.getString("editora"),
                json.getString("titulo"),
                json.getString("descricao"), null);
        sercice.salvar(livro);

        if (livro == null) {
            return Response.noContent().build();
        }
        return Response.ok() //200
                .entity(livro)
                .build();
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editaLivro(JsonObject json) {
        Livro livro = new Livro(Integer.valueOf(json.getString("editora"))
                ,json.getString("editora"),
                json.getString("titulo"),
                json.getString("descricao"), null);
        sercice.update(livro);

        if (livro == null) {
            return Response.noContent().build();
        }
        return Response.ok() //200
                .entity(livro)
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
