import org.example.ToDoList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    @Test
    void addAndList() {
        ToDoList t = new ToDoList();
        t.add("  task1  ");
        assertEquals(1, t.size());
        assertTrue(t.getAll().get(0).contains("task1"));
    }

    @Test
    void remove() {
        ToDoList t = new ToDoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        ToDoList t = new ToDoList();
        t.add("   ");
        assertEquals(0, t.size());
    }

    @Test
    void clearAll() {
        ToDoList t = new ToDoList();
        t.add("one");
        t.add("two");
        assertEquals(2, t.size());
        t.clear();
        assertEquals(0, t.size());
    }

    @Test
    void markDone() {
        ToDoList t = new ToDoList();
        t.add("task");
        assertTrue(t.markDone(0));
        List<String> all = t.getAll();
        assertTrue(all.get(0).startsWith("[x]"));
    }

    @Test
    void searchTasks() {
        ToDoList t = new ToDoList();
        t.add("Buy milk");
        t.add("Write code");
        t.add("Read book");
        List<String> found = t.search("code");
        assertEquals(1, found.size());
        assertTrue(found.get(0).contains("Write code"));
    }
}
