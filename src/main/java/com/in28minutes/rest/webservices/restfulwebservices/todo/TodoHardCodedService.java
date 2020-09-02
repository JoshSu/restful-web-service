package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    private static List<Todo> todos = new ArrayList();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "in28", "Learn to Dance", new Date(), false));
        todos.add(new Todo(++idCounter, "in28", "Learn to Dance1", new Date(), false));
        todos.add(new Todo(++idCounter, "in28", "Learn to Dance2", new Date(), false));
        todos.add(new Todo(++idCounter, "in28", "Learn to Dance3", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }


    public Todo deleteById(long id) {
        Todo todo = findById(id);
        todos.remove(todo);

        return todo;
    }

    public Todo save(Todo todo){
        if (todo.getId() == -1 || todo.getId() == 0 ){
            todo.setId(++idCounter);
            todos.add(todo);
        }else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo findById(long id) {

        for (Todo todo:todos){
            if (todo.getId() ==id){
                return todo;
            }
        }
        return null;
    }

}
