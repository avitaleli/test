package com.mytest.dropwizard.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by avitale on 9/28/15.
 */
public class Saying {

    private long id;

    @Length
    private String content;

    public Saying() {
        super();
    }

    public Saying(long id, String content) {
        super();
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
