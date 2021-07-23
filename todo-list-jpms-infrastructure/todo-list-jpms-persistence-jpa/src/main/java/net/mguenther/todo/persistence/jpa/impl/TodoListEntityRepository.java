package net.mguenther.todo.persistence.jpa.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListEntityRepository extends JpaRepository<TodoListEntity, String> {
}
