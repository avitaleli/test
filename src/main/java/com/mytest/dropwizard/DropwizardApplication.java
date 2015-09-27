package com.mytest.dropwizard;

import com.codahale.metrics.health.HealthCheck;
import com.mytest.dropwizard.configuration.DropwizardConfiguration;
import com.mytest.dropwizard.resources.GreetingResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by avitale on 9/28/15.
 */
public class DropwizardApplication extends Application<DropwizardConfiguration> {

    @Override
    public void run(DropwizardConfiguration configuration, Environment environment) throws Exception {
        final GreetingResource greetingResource = new GreetingResource(configuration.getTemplate(), configuration.getDefaultName());

        // register health check
        environment.healthChecks().register("health-check", new HealthCheck() {
            @Override
            protected Result check() throws Exception {
                return Result.healthy("service is healthy");
            }
        });

        // register resource
        environment.jersey().register(greetingResource);
    }

    @Override
    public String getName() {
        return "Dropwizatd Test";
    }

    @Override
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    public static void main(String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }
}
