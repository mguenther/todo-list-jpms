package net.mguenther.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoRestApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(TodoRestApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
