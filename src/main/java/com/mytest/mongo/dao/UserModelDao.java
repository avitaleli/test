package com.mytest.mongo.dao;

import com.mytest.mongo.model.UserModel;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 * Created by eli on 07/10/15.
 */
public class UserModelDao extends BasicDAO<UserModel, String> {
    public UserModelDao(Datastore datastore) {
        super(UserModel.class, datastore);
    }
}
