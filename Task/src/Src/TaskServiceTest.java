package Src;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//JUnit tests, based on examples from https://www.vogella.com/tutorials/JUnit/article.html and various StackOverflow examples
public class TaskServiceTest {
 private TaskService service;

 @BeforeEach
 public void setUp() { //applies to all tests
     service = new TaskService();
 }

 @Test
 public void testAddTaskValid() { 
     Task task = new Task("TASK123", "Project Planning", "Plan the project phases and timelines");
     service.addTask(task);
     assertEquals(task, service.getTask("TASK123"));
 }

 @Test
 public void testAddTaskNull() { //test null ID
     assertThrows(IllegalArgumentException.class, () -> service.addTask(null));
 }

 @Test
 public void testAddDuplicateTask() { //test various duplicates addition errors and the proper case
     Task task1 = new Task("TASK123", "Project Planning", "Plan the project phases and timelines");
     service.addTask(task1);
     Task task2 = new Task("TASK123", "Another Task", "Different description");
     assertThrows(IllegalArgumentException.class, () -> service.addTask(task2));
 }

 @Test
 public void testDeleteTaskExisting() { //test various deletions, proper and wrong
     Task task = new Task("TASK123", "Project Planning", "Plan the project phases and timelines");
     service.addTask(task);
     service.deleteTask("TASK123");
     assertNull(service.getTask("TASK123"));
 }

 @Test
 public void testDeleteTaskNonExisting() { //test nonexisting deletion
     service.deleteTask("NONEXIST"); // Should not throw exception, just do nothing
     assertNull(service.getTask("NONEXIST"));
 }

 @Test
 public void testUpdateTaskAllFields() { //test complete update use case, with both proper and wrong examples
     Task task = new Task("TASK123", "Project Planning", "Plan the project phases and timelines");
     service.addTask(task);
     service.updateTask("TASK123", "Updated Planning", "Updated description");
     Task updated = service.getTask("TASK123");
     assertEquals("Updated Planning", updated.getName());
     assertEquals("Updated description", updated.getDescription());
 }

 @Test
 public void testUpdateTaskPartialFields() { //test partial updating use case, with valid and invalid examples
     Task task = new Task("TASK123", "Project Planning", "Plan the project phases and timelines");
     service.addTask(task);
     service.updateTask("TASK123", null, "Updated description only");
     Task updated = service.getTask("TASK123");
     assertEquals("Project Planning", updated.getName());
     assertEquals("Updated description only", updated.getDescription());
 }

 @Test
 public void testUpdateTaskNonExisting() { //ensure error if attempt to update nonexistent tasks
     assertThrows(IllegalArgumentException.class, () -> service.updateTask("NONEXIST", "Updated Name", "Updated Description"));
 }

 @Test
 public void testUpdateWithInvalidData() { //test data validation when updating
     Task task = new Task("TASK123", "Project Planning", "Plan the project phases and timelines");
     service.addTask(task);
     assertThrows(IllegalArgumentException.class, () -> service.updateTask("TASK123", "This name is too long now", null));
 }
}
