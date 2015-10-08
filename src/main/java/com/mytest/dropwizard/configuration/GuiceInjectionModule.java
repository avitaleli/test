package com.mytest.dropwizard.configuration;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.mongodb.MongoClient;
import com.mytest.mongo.dao.UserDao;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by avitale on 10/5/15.
 */
public class GuiceInjectionModule implements Module {

    private Datastore datastore;

    private UserDao userDao;

    @Override
    public void configure(Binder binder) {
//        binder.bind(Datastore.class);
//        binder.bind(UserDao.class);
    }

    @Provides
    public Datastore getDatastore(DropwizardConfiguration dropwizardConfiguration) {
        if (datastore ==  null) {
            final MongoConfiguration mongoConfiguration = dropwizardConfiguration.getMongoConfiguration();
            MongoClient mongoClient = new MongoClient(mongoConfiguration.getHost(), mongoConfiguration.getPort());
            datastore = new Morphia().createDatastore(mongoClient, mongoConfiguration.getDb());
        }
        return datastore;
    }

    @Provides
    public UserDao getUserDao(DropwizardConfiguration dropwizardConfiguration) {
        if (userDao == null)
            userDao = new UserDao(getDatastore(dropwizardConfiguration));
        return userDao;
    }
}
