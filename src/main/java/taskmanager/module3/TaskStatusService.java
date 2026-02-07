package taskmanager.module3;

import taskmanager.model.Task;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskStatusService {

    public boolean updateTaskStatus(Task task, String newStatus) {

        if (task.getStatus().equals("Completed")) {
            return false; // Cannot change completed task
        }

        if (!(newStatus.equals("Pending") ||
              newStatus.equals("InProgress") ||
              newStatus.equals("Completed"))) {
            return false; // Invalid status
        }

        task.setStatus(newStatus);
        return true;
    }

    public boolean isTaskOverdue(Task task) {
        return task.getDueDate().isBefore(LocalDate.now())
                && !task.getStatus().equals("Completed");
    }

    public List<Task> getOverdueTasks(List<Task> tasks) {

        List<Task> overdueTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (isTaskOverdue(task)) {
                overdueTasks.add(task);
            }
        }
        return overdueTasks;
    }
}
