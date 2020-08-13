package se.lexicon.mattias.JPAExercise2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String desc;
    private LocalDateTime deadline;
    private boolean done = false;

    public ToDoItem() {
    }

    public ToDoItem(String title, String desc, LocalDateTime deadline, boolean done) {
        this.title = title;
        this.desc = desc;
        this.deadline = deadline;
        this.done = done;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return done == toDoItem.done &&
                Objects.equals(id, toDoItem.id) &&
                Objects.equals(title, toDoItem.title) &&
                Objects.equals(desc, toDoItem.desc) &&
                Objects.equals(deadline, toDoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, desc, deadline, done);
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                '}';
    }
}
