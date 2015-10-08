package com.mytest.mongo.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by eli on 07/10/15.
 */
@Entity(value = "mongoUsers", noClassnameStored = true)
public class UserModel {

    @Id
    private String id;

    private String name;

    public UserModel() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserModel) {
            UserModel that = (UserModel) obj;
            return this.id.equals(that.id) && this.name.equals(that.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("name", name).toString();
    }
}
