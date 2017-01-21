package com.bt.rest.crud.provider;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.glassfish.jersey.server.mvc.Viewable;

import com.bt.rest.crud.domain.Post;

@Path("/posts")
@RolesAllowed("admin")
public class PostService {
	private static Long postCount = 1L;
	private static Map<Long, Post> posts = new HashMap<Long, Post>();

	@POST
	@Consumes({ MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_XML })
	@RolesAllowed("admin")
	public Response create(Post post, @Context SecurityContext context) {
		System.out.println(context);
		posts.put(postCount, post);

		postCount++;

		Response response = Response.status(Response.Status.ACCEPTED)
				.entity(post).build();
		return response;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	@RolesAllowed("admin")
	public Response create(@FormParam("message") String msg) {
		Post post = new Post(postCount, msg, "user", new Date());

		posts.put(postCount, post);

		postCount++;

		Response response = Response.status(Response.Status.ACCEPTED)
				.entity(post).build();
		return response;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_XML })
	@RolesAllowed("admin")
	public Post createOld(@FormParam("message") String msg) {
		Post post = new Post(postCount, msg, "user", new Date());

		posts.put(postCount, post);

		postCount++;

		return post;
	}

	// @GET
	// @Path("/{id}")
	// @Produces({ MediaType.APPLICATION_XML })
	// public Post get(@PathParam("id") long id) {
	// return posts.get(id);
	// }

	@GET
	@Path("/{id}")
	// @Produces({ MediaType.TEXT_HTML })
	public Viewable getAsHtml(@PathParam("id") long id,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws ServletException,
			IOException {
		request.setAttribute("post", posts.get(id));

		return new Viewable("post.jsp");
	}

	@Path("/{id}")
	@PUT
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_XML })
	@RolesAllowed("admin")
	public Post update(@PathParam("id") Long id,
			@FormParam("message") String msg) {
		Post post = posts.get(id);
		post.setMessage(msg);

		return post;
	}

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML })
	public Post delete(@PathParam("id") long id) {
		Post post = posts.get(id);
		posts.remove(id);

		return post;
	}

}
