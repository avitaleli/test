package com.mytest.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.mytest.dropwizard.configuration.DropwizardConfiguration;
import com.mytest.dropwizard.model.Saying;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by avitale on 9/28/15.
 */
@Service
@Path("/greet")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

//    private final String template;
//
//    private final String defaultName;

    @Autowired
    private DropwizardConfiguration configuration;

    private final AtomicLong counter;

//    public GreetingResource(String template, String defaultName) {
//        super();
//        this.template = template;
//        this.defaultName = defaultName;
//        this.counter = new AtomicLong();
//    }

    public GreetingResource() {
        super();
        counter = new AtomicLong();
    }

//    @GET
//    @Timed
//    public Saying greet(@QueryParam("name") Optional<String> name) {
//        final String value = name.or(defaultName);
//        return new Saying(counter.incrementAndGet(), value);
//    }

    @GET
    @Timed
    public Saying greet(@QueryParam("name") Optional<String> name) {
        final String value = name.or(configuration.getDefaultName());
        return new Saying(counter.incrementAndGet(), value);
    }

    @POST
    @Timed
    public Response greet() {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
