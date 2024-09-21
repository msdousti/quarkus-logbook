package io.msdousti;


import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.jaxrs.LogbookServerFilter;

import java.io.IOException;

@SuppressWarnings("unused")
@Provider
public class LogbookFilterSetup implements ContainerRequestFilter, ContainerResponseFilter, WriterInterceptor {

    private final LogbookServerFilter logbookServerFilter;

    public LogbookFilterSetup() {
        logbookServerFilter = new LogbookServerFilter(Logbook.create());
    }

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        logbookServerFilter.filter(context);
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        logbookServerFilter.filter(requestContext, responseContext);
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        logbookServerFilter.aroundWriteTo(context);
    }
}
