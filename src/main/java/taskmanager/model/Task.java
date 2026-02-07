package taskmanager.model;

import java.time.LocalDate;

public class Task {

    private int taskId;
    private String title;
    private String status;   // Pending, InProgress, Completed
    private LocalDate dueDate;

    public Task(int taskId, String title, String status, LocalDate dueDate) {
        this.taskId = taskId;
        this.title = title;
        this.status = status;
        this.dueDate = dueDate;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
