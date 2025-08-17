package Src;

// TaskTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//JUnit tests, based on examples from https://www.vogella.com/tutorials/JUnit/article.html and various StackOverflow examples
public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("TASK123", "Project Planning", "Plan the project phases and timelines");
        assertEquals("TASK123", task.getTaskID());
        assertEquals("Project Planning", task.getName());
        assertEquals("Plan the project phases and timelines", task.getDescription());
    }

    @Test
    public void testInvalidTaskIDNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Project Planning", "Plan the project phases and timelines"));
    }

    @Test
    public void testInvalidTaskIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Task("TASK1234567", "Project Planning", "Plan the project phases and timelines"));
    }

    @Test
    public void testInvalidNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task("TASK123", null, "Plan the project phases and timelines"));
    }

    @Test
    public void testInvalidNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Task("TASK123", "This name is way too long", "Plan the project phases and timelines"));
    }

    @Test
    public void testInvalidDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task("TASK123", "Project Planning", null));
    }

    @Test
    public void testInvalidDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Task("TASK123", "Project Planning", "A description that is purposefully and intentionally made longer than fifty characters to test the limit"));
    }

    @Test
    public void testUpdateNameValid() {
        Task task = new Task("TASK123", "Project Planning", "Plan the project phases and timelines");
        task.setName("Updated Planning");
        assertEquals("Updated Planning", task.getName());
    }

    @Test
    public void testUpdateNameInvalid() {
        Task task = new Task("TASK123", "Project Planning", "Plan the project phases and timelines");
        assertThrows(IllegalArgumentException.class, () -> task.setName("This updated name is too long"));
    }

    @Test
    public void testUpdateDescriptionValid() {
        Task task = new Task("TASK123", "Project Planning", "Plan the project phases and timelines");
        task.setDescription("Updated project phases");
        assertEquals("Updated project phases", task.getDescription());
    }

    @Test
    public void testUpdateDescriptionInvalid() {
        Task task = new Task("TASK123", "Project Planning", "Plan the project phases and timelines");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription("A description that is purposefully and intentionally made longer than fifty characters to test the limit"));
    }
}