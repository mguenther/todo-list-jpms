module todo.domain {

    exports net.mguenther.todo.domain;
    //exports net.mguenther.todo.domain.impl;

    requires spring.context;

    opens net.mguenther.todo.domain to spring.core, spring.beans, spring.context;
    opens net.mguenther.todo.domain.impl to spring.core, spring.beans, spring.context;
}