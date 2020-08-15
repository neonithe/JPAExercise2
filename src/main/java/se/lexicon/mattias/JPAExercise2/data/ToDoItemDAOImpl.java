package se.lexicon.mattias.JPAExercise2.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.mattias.JPAExercise2.entity.ToDoItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public class ToDoItemDAOImpl implements ToToItemDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<ToDoItem> findById(UUID id) {
        //?
        ToDoItem todo = entityManager.find(ToDoItem.class, id);
        Optional<ToDoItem> returnOptional = Optional.of(todo);

        return returnOptional;
    }

    @Override
    public List<ToDoItem> findAll() {
        // How do I use the variable, or how is it used?
        // How do I set the alias?
        Query query = entityManager.createQuery("SELECT s FROM ToDoItem s");
        List<ToDoItem> allToDo = query.getResultList();
        return allToDo;
    }

    @Override
    public List<ToDoItem> findByTitle(String title) {
        Query query = entityManager.createQuery("SELECT title FROM ToDoItem title ");
        List<ToDoItem> allToDo = query.getResultList();
        return allToDo;
    }

    @Override
    public List<ToDoItem> findByDone() {
        Query query = entityManager.createQuery("SELECT true FROM ToDoItem done ");
        List<ToDoItem> allToDo = query.getResultList();
        return allToDo;
    }

    @Override
    public ToDoItem update(ToDoItem toDoItem) {
       ToDoItem todo = entityManager.merge(toDoItem);
        return todo;
    }

    @Override
    public ToDoItem save(ToDoItem toDoItem) {
        entityManager.persist(toDoItem);
        return toDoItem;
    }

    @Override
    public boolean delete(ToDoItem toDoItem) {
        Optional<ToDoItem> todo = findById(toDoItem.getId());
        if(todo != null) {
            entityManager.remove(todo);
            return true;
        }
        return false;
    }
}
