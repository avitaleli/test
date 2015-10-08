package com.mytest.dropwizard;

import com.codahale.metrics.health.HealthCheck;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.mytest.dropwizard.configuration.DropwizardConfiguration;
import com.mytest.dropwizard.configuration.GuiceInjectionModule;
import com.mytest.dropwizard.configuration.SpringConfiguration;
import com.mytest.dropwizard.filters.ResourceAuthorizationFilterFactory;
import com.mytest.dropwizard.filters.SecurityFilter;
import com.mytest.dropwizard.resources.InjectResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.*;
import javax.ws.rs.Path;
import java.util.EnumSet;
import java.util.Map;

/**
 * Created by avitale on 9/28/15.
 */
public class DropwizardApplication extends Application<DropwizardConfiguration> {

    @Override
    public void run(DropwizardConfiguration configuration, Environment environment) throws Exception {

//        AnnotationConfigWebApplicationContext parent = new AnnotationConfigWebApplicationContext();
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        // Init Spring context before we init the app context, we have to create a parent context with all the
        // config objects others rely on to get initialized
//        parent.refresh();
//        parent.getBeanFactory().registerSingleton("configuration", configuration);
//        parent.registerShutdownHook();
//        parent.start();

        //the real main app context has a link to the parent context
//        ctx.setParent(parent);
//        ctx.register(SpringConfiguration.class);
//        ctx.refresh();
//        ctx.registerShutdownHook();
//        ctx.start();

//        environment.jersey().register(ResourceAuthorizationFilterFactory.class);

        // register health check
        environment.healthChecks().register("health-check", new HealthCheck() {
            @Override
            protected Result check() throws Exception {
                return Result.healthy("service is healthy");
            }
        });

        // add filter // http://stackoverflow.com/questions/19166603/custom-jetty-filters-in-dropwizard
//        environment.servlets()
//                   .addFilter("securityFilter", SecurityFilter.class)
//                   .addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        // register resource

        /* NO NEED TO REGISTER RESOURCES - IF WE USE THE SPRING WAY
        final GreetingResource greetingResource = new GreetingResource(configuration.getTemplate(), configuration.getDefaultName());
        environment.jersey().register(greetingResource);
         */

//        Map<String, Object> resources = ctx.getBeansWithAnnotation(Path.class);
//        for (Map.Entry<String, Object> entry : resources.entrySet()) {
//            environment.jersey().register(entry.getValue());
//        }

        environment.jersey().register(InjectResource.class);
    }

    @Override
    public String getName() {
        return "Dropwizatd Test";
    }

    @Override
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
        super.initialize(bootstrap);
        bootstrap.addBundle(GuiceBundle.<DropwizardConfiguration>newBuilder().addModule(new GuiceInjectionModule()).setConfigClass(DropwizardConfiguration.class).build());
    }

    public static void main(String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }
}
