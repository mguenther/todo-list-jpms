module todo.rest.app {

    requires todo.domain;
    requires todo.persistence.jpa;
    requires todo.rest;

    requires java.persistence;
    requires java.sql;
    requires java.xml.bind;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.web;
    requires spring.data.jpa;
    requires spring.jdbc;
    requires spring.tx;
    requires spring.orm;

    requires jakarta.activation;
    requires net.bytebuddy;

    requires com.fasterxml.classmate;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;

    // otherwise the embedded Tomcat server will not be started and the
    // application terminates itself after creating the persistence unit
    requires org.apache.tomcat.embed.core;

    exports net.mguenther.todo;

    opens net.mguenther.todo to spring.core, spring.beans, spring.context;
}