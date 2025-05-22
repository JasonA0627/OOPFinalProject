package Model;

// Class that represents a single task item in our task manager
public class Task {
    private String hey_gil_dscn; // Task details ("Buy milk")
    private boolean hey_gil_isCmp; // Tracks if the task is done

    public Task(String description) {
        this.hey_gil_dscn = description;
        this.hey_gil_isCmp = false; // By default, _task is incomplete
    }

    public String getDescription() {
        return hey_gil_dscn;
    }

    public boolean isComplete() {
        return hey_gil_isCmp;
    }

    public void setDescription(String description) {
        this.hey_gil_dscn = description;
    }

    public void toggleStatus() {
        this.hey_gil_isCmp = !this.hey_gil_isCmp;
    }

    @Override
    public String toString() {
        return (hey_gil_isCmp ? "[X] " : "[ ] ") + hey_gil_dscn;
    }
}