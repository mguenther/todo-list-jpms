module todo.persistence.jpa {

    requires todo.domain;

    requires java.persistence;
    requires java.sql;

    requires spring.context;
    requires spring.data.jpa;

    exports net.mguenther.todo.persistence.jpa;

    opens net.mguenther.todo.persistence.jpa to spring.core, spring.beans, org.hibernate.orm.core;
    opens net.mguenther.todo.persistence.jpa.impl to spring.core, spring.beans, org.hibernate.orm.core;
}