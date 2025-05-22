package Model;

import java.util.ArrayList;

// Manages a list of Task objects, allows adding/removing/completing
public class TaskManager {
    private final ArrayList<Task> hey_gil_taskList;

    public TaskManager() {
        hey_gil_taskList = new ArrayList<>();
    }

    public ArrayList<Task> getTaskList() {
        return hey_gil_taskList;
    }

    public void addTask(Task task) {
        hey_gil_taskList.add(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < hey_gil_taskList.size()) {
            hey_gil_taskList.remove(index);
        }
    }

    public void completeTask(int index) {
        if (index >= 0 && index < hey_gil_taskList.size()) {
            hey_gil_taskList.get(index).toggleStatus();
        }
    }
}
