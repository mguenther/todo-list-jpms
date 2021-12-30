module todo.persistence.jpa {

    requires todo.domain;

    requires java.persistence;
    requires java.sql;
    requires java.xml.bind;

    requires spring.beans;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires spring.jdbc;
    requires spring.tx;
    requires spring.orm;

    requires jakarta.activation;
    requires net.bytebuddy;

    requires com.fasterxml.classmate;

    requires org.hibernate.orm.core;

    exports net.mguenther.todo.persistence.jpa;

    opens net.mguenther.todo.persistence.jpa.impl to spring.core, spring.beans, spring.context, org.hibernate.orm.core;
    opens net.mguenther.todo.persistence.jpa.config to spring.core, spring.beans, spring.context;
}