# Hexagonal Architecture with Spring Boot and JPMS

## Concept

A hexagonal architecture implements the ports and adapters pattern. Thus, we refer to the core of the application as the domain layer (the hexagon), that implements the business functionality of our application. This business functionality has no ties to any external resource, e.g. database integration or the like. This has the benefit that the core of the application is easily testable. The core in a hexagonal architecture has well defined interfaces (or: ports and adapters, hence the name of the pattern) for dealing with external stimuli such as user inputs (the application layer) and the integration with external resources as outputs (the infrastructure layer). For instance, the application layer might implement a RESTful HTTP interface that uses the inbound port of the domain layer to execute a specific use case. On the other hand, if some the internal state of the domain has been altered and has to be persisted, a database-centric implementation of the resp. outbound adapter might provide the means to do just that. Thus, *ports and adapters* establish a bridge between the actual business functionality and everything else that needs to be in place to run the entire application.

<div align="center">
    <div><img src="doc/conceptual-hexagonal-architecture.jpg"></div>
</div>

The domain layer defines interfaces for the resp. ports and adapters. It is agnostic to their implementation. We'll provide the resp. implementation details as part of Java modules of the application and infrastructure layer and let the application framework - Spring in this case - do the necessary wiring.

<div align="center">
    <div><img src="doc/conceptual-domain-layer.jpg"></div>
</div>

## License

This work is released under the terms of the MIT license.