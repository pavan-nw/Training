package com.bt.rest.crud.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bt.rest.crud.domain.Post;

public class PostsDao {
	private static Long postCount = 1L;
	private Map<Long, Post> posts = new HashMap<Long, Post>();
	
	public Post create(String msg) {
		Post post = new Post(postCount, msg, "user", new Date());
		
		posts.put(postCount, post);
		
		postCount++;
		
		return post;
	}
	
	public Post get(long id) {
		return posts.get(id);
	}

}
