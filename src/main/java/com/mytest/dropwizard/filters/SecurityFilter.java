package com.mytest.dropwizard.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by avitale on 9/28/15.
 */
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        final String authentication = request.getHeader("authentication");
        if ("shimshen".equalsIgnoreCase(authentication)) {
            System.out.println("authenticated");
        } else {
            System.out.println("not authenticated");
        }
        chain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
