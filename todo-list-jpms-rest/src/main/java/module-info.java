module todo.rest {

    requires todo.domain;
    requires spring.web;
    requires java.validation;
    requires com.fasterxml.jackson.annotation;

    exports net.mguenther.todo.rest;

    opens net.mguenther.todo.rest to spring.beans, spring.context, spring.web, spring.core;
}