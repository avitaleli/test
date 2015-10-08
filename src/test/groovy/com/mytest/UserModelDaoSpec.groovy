package com.mytest

import com.mongodb.MongoClient
import com.mytest.mongo.dao.UserModelDao
import com.mytest.mongo.model.UserModel
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.Morphia
import spock.lang.Specification
import spock.lang.Subject

/**
 * Created by eli on 07/10/15.
 */
class UserModelDaoSpec extends Specification {
    @Subject
    UserModelDao userModelDao

    def setup() {
        Datastore datastore = new Morphia().createDatastore(new MongoClient("127.0.0.1", 27017), "testdb")
        userModelDao = new UserModelDao(datastore)
    }

    def "test create user"() {
        when:
            UserModel user = new UserModel()
            user.setName("test name")

        then:
            userModelDao.save(user).getId() != null
    }
}
