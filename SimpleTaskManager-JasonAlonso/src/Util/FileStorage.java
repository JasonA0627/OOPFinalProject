package Util;

import Model.Storable;
import Model.Task;
import Model.TaskManager;
import java.io.*;
import java.util.Scanner;

// Utility class to handle saving/loading tasks to/from a text file
public class FileStorage implements Storable {
    private final TaskManager hey_gil_taskMngr;

    public FileStorage(TaskManager manager) {
        this.hey_gil_taskMngr = manager;
    }

    @Override
    public void saveToFile(String filepath) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filepath));
        for (Task task : hey_gil_taskMngr.getTaskList()) {
            writer.println(task.isComplete() + ";" + task.getDescription());
        }
        writer.close();
    }

    @Override
    public void loadFromFile(String filepath) throws IOException {
        hey_gil_taskMngr.getTaskList().clear(); // Clear existing tasks
        Scanner scanner = new Scanner(new File(filepath));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            if (parts.length == 2) {
                Task task = new Task(parts[1]);
                if (Boolean.parseBoolean(parts[0])) {
                    task.toggleStatus(); // Mark as complete
                }
                hey_gil_taskMngr.addTask(task);
            }
        }
        scanner.close();
    }
}