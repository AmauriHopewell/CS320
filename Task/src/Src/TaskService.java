package Src;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
 private List<Task> tasks = new ArrayList<>(); //list of Task elements

 public void addTask(Task task) { //addition with error checking
     if (task == null) {
         throw new IllegalArgumentException("Task cannot be null");
     }
     for (Task t : tasks) {
         if (t.getTaskID().equals(task.getTaskID())) {
             throw new IllegalArgumentException("Task ID already exists");
         }
     }
     tasks.add(task);
 }

 //deletion using built-in function for lists
 public void deleteTask(String taskID) {
     tasks.removeIf(t -> t.getTaskID().equals(taskID));
 }

 //update function with error checking
 public void updateTask(String taskID, String name, String description) {
     for (Task t : tasks) {
         if (t.getTaskID().equals(taskID)) {
             if (name != null) {
                 t.setName(name);
             }
             if (description != null) {
                 t.setDescription(description);
             }
             return;
         }
     }
     throw new IllegalArgumentException("Task not found");
 }

// Printing funciton to help with testing
 public Task getTask(String taskID) {
     for (Task t : tasks) {
         if (t.getTaskID().equals(taskID)) {
        	 System.out.println("Task found :" +t.toString() +"\n");
             return t;
         }
     }
	 System.out.println("Task not found :" +taskID +"\n");
     return null;
 }
}