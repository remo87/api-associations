package com.remo.associationsapi.exceptions;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@Component
public class GraphqlExceptionHandler {

    @ExceptionHandler({GraphQLException.class})
    public ThrowableGraphQLError handle(GraphQLException ex) {
        log.error("Graphlq error", ex);
        return new ThrowableGraphQLError(ex);
    }

    @ExceptionHandler({RuntimeException.class})
    public ThrowableGraphQLError handle(RuntimeException ex) {
        log.error("Internal server error", ex);
        return new ThrowableGraphQLError(ex, "Internal server error. Please contact support.");
    }

    @ExceptionHandler({NotFoundException.class})
    public ThrowableGraphQLError handle(NotFoundException ex) {
        log.error("Resource not found", ex);
        return new ThrowableGraphQLError(ex);
    }

}
