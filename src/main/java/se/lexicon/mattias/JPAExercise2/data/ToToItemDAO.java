package se.lexicon.mattias.JPAExercise2.data;

import se.lexicon.mattias.JPAExercise2.entity.ToDoItem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ToToItemDAO {

    Optional<ToDoItem> findById(UUID id);
    List<ToDoItem> findAll();
    List<ToDoItem> findByTitle(String title);
    List<ToDoItem> findByDone();
    ToDoItem update(ToDoItem toDoItem);
    ToDoItem save(ToDoItem toDoItem);
    boolean delete(ToDoItem toDoItem);

}
