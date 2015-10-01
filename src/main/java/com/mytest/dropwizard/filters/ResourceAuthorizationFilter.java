package com.mytest.dropwizard.filters;

import com.mytest.dropwizard.utils.Role;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Random;
import java.util.Set;

/**
 * Created by avitale on 10/1/15.
 */
public class ResourceAuthorizationFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private final Set<Role> roles;

    public ResourceAuthorizationFilter(Set<Role> roles) {
        super();
        this.roles = roles;
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // TODO: get the user object with his roles - DO NOTHING
        boolean random = new Random().nextBoolean();
        if (random) {
            System.out.println("random");
        }
        else {
            requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

    }
}
