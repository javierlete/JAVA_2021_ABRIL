package com.ipartek.formacion.multimaven.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ipartek.formacion.multimaven.dal.Dao;
import com.ipartek.formacion.multimaven.dal.DaoMySqlRol;
import com.ipartek.formacion.multimaven.entidades.Rol;

@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RolesRest {
	private static final Dao<Rol> dao = DaoMySqlRol.obtenerInstancia();
	
	@GET
	public Response getRoles() {
		return Response.ok(dao.obtenerTodos(), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getRol(@PathParam("id") long id) {
		return Response.ok(dao.obtenerPorId(id), MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	public Response postRol(Rol rol) {
		return Response.ok(dao.insertar(rol), MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	public Response putRol(Rol rol) {
		return Response.ok(dao.modificar(rol), MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteRol(@PathParam("id") long id) {
		dao.borrar(id);
		return Response.noContent().build();
	}
}
