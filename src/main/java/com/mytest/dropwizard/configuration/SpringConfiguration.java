package com.mytest.dropwizard.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by eli on 29/09/15.
 */
@Configuration
@ImportResource({"classpath:spring/applicationContext.xml"})
@ComponentScan(basePackages = {"com.mytest"})
public class SpringConfiguration {

}
