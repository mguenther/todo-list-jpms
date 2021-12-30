module todo.rest.app {

    requires todo.domain;
    requires todo.persistence.jpa;
    requires todo.rest;

    requires spring.boot;
    requires spring.boot.autoconfigure;

    requires spring.core;
    requires spring.context;

    // otherwise the embedded Tomcat server will not be started and the
    // application terminates itself after creating the persistence unit
    requires org.apache.tomcat.embed.core;

    exports net.mguenther.todo;

    opens net.mguenther.todo to spring.core, spring.beans, spring.context;
}