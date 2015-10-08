package com.mytest.mongo.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by avitale on 10/5/15.
 */
@Entity(value = "usersCollection", noClassnameStored = true)
public class User {

    @Id
    private String id;

    private String name;

    public User(String id) {
        super();
        this.id = id;
    }

    public User() {
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
    public int hashCode() {
        return Objects.hashCode(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof User && this.equals((User) obj));
    }

    public boolean equals(final User that) {
        return this == that || (this.id.equals(that.id) && this.name.equals(that.name));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id).add("name", name).toString();
    }
}
