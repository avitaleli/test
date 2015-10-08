package com.mytest.dropwizard.filters;

import com.mytest.dropwizard.utils.AuthorizedForRole;
import com.mytest.dropwizard.utils.Role;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by avitale on 10/1/15.
 */
public class ResourceAuthorizationFilterFactory implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        final AuthorizedForRole authorizedForRole = resourceInfo.getResourceMethod().getAnnotation(AuthorizedForRole.class);
        if (authorizedForRole != null) {
            final Set<Role> roles = new HashSet<Role>();
            roles.add(authorizedForRole.value());
            context.register(new ResourceAuthorizationFilter(Collections.unmodifiableSet(roles)));
        }
    }
}
