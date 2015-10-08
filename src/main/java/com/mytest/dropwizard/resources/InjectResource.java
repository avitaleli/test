package com.mytest.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.mytest.dropwizard.model.Saying;
import com.mytest.mongo.dao.UserDao;
import com.mytest.mongo.model.User;
import org.mongodb.morphia.Key;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by avitale on 10/6/15.
 */
@Service
@Path("/inject")
@Produces(MediaType.APPLICATION_JSON)
public class InjectResource {

    private UserDao userDao;

    @Inject
    public InjectResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @GET
    @Timed
    public Saying inject() {
        String name = "inject";

//        User user = new User("testid2");
        User user = new User();
        user.setName("test user 4 no classname auto id");
        final Key<User> save = userDao.save(user);

        if (save == null) {

        }

        return new Saying(1L, name);
    }
}
