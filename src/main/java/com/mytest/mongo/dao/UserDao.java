package com.mytest.mongo.dao;

import com.google.inject.Inject;
import com.mytest.mongo.model.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 * Created by avitale on 10/5/15.
 */
public class UserDao extends BasicDAO<User, String> {
    @Inject
    public UserDao(Datastore ds) {
        super(User.class, ds);
    }
}
