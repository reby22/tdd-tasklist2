package edu.uaslp.objetos.taskslist;

import java.util.*;

public class TaskList {
    LinkedList<Task> taskLinkedList = new LinkedList<>();

    public TaskList(){
    }

    public int getSize() {
        return taskLinkedList.size();
    }

    public void add(Task tarea) {
        taskLinkedList.add(tarea);
    }

    public void remove(Task tarea) {
        taskLinkedList.remove(tarea);

    }

    public Task find(String tarea) throws TaskNotFoundException{
        for(int i=0;i<taskLinkedList.size();i++){
            if(tarea == taskLinkedList.get(i).getTitle()){
                return taskLinkedList.get(i);
            }
        }
        throw new TaskNotFoundException("Task with title 'Hacer ejercicio' not found");
    }

    public void markAsDone(String tarea) {
        Task task = find(tarea);

        task.setDone(true);
        //task.isDone() = true;

    }

    public void markAsNotDone(String tarea) {
        Task task = find(tarea);

        task.setDone(false);
    }

    public Task getNextTask() {
        String title = taskLinkedList.element().getTitle();

        int size = taskLinkedList.size(),i;

        for(i = 0; !Objects.equals(title, taskLinkedList.get(i).getTitle()) && size > i; i++);
        return taskLinkedList.get(i+1);//**
    }

    public List<Task> getNextTasks() {
        List<Task> taskList = new LinkedList<>();

        int size = this.taskLinkedList.size();
        for (Task task : this.taskLinkedList) {
            if (!task.isDone()) {
                taskList.add(task);
            }
        }

        taskList.sort(Comparator.comparing(Task::getDueDate));

        return taskList;
    }
}