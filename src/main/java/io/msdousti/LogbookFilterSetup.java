package io.msdousti;


import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.jaxrs.LogbookServerFilter;

import java.io.IOException;

@Provider
public class LogbookFilterSetup implements ContainerRequestFilter {

    private final LogbookServerFilter logbookServerFilter;

    public LogbookFilterSetup() {
        logbookServerFilter = new LogbookServerFilter(Logbook.create());
    }

    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        logbookServerFilter.filter(context);
    }
}
