package com.bt.rest.crud.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;

import org.glassfish.jersey.server.ContainerRequest;

public class SecurityContextFilter implements ContainerRequestFilter {

    protected static final String HEADER_AUTHORIZATION = "Authorization";

    protected static final String HEADER_DATE = "x-java-rest-date";

    protected static final String HEADER_NONCE = "nonce";


    private HttpServletRequest httpRequest;




    public SecurityContextFilter() {


    }


    public ContainerRequest filter(ContainerRequest request) {

        SessionUser sessionUser = (SessionUser) httpRequest
                .getSession()
                .getAttribute("sessionUser");

        request.setSecurityContext(new SecurityContextImpl(sessionUser));

        return request;
    }


    public ContainerRequestFilter getRequestFilter() {
        return this;
    }

    public ContainerResponseFilter getResponseFilter() {
        return null;
    }

    public HttpServletRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpServletRequest httpRequest) {
        this.httpRequest = httpRequest;
    }


	@Override
	public void filter(ContainerRequestContext request) throws IOException {
        SessionUser sessionUser = (SessionUser) httpRequest
                .getSession()
                .getAttribute("sessionUser");

        request.setSecurityContext(new SecurityContextImpl(sessionUser));
	}


}
