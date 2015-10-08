package com.mytest.dropwizard.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by avitale on 10/5/15.
 */
public class MongoConfiguration {

    @NotEmpty
    private String host = "127.0.0.1";

    @Min(1000)
    @Max(65535)
    private int port = 27000;

    @NotEmpty
    private String db;

    public MongoConfiguration() {
        super();
    }

    @JsonProperty
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @JsonProperty
    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }
}
