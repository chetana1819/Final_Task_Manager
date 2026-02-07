package taskmanager.module3;

import taskmanager.model.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TaskStatusServiceTest {

    TaskStatusService service = new TaskStatusService();

    @Test
    void testUpdateTaskStatus_ValidChange() {
        Task task = new Task(1, "Test Task", "Pending", LocalDate.now().plusDays(1));
        assertTrue(service.updateTaskStatus(task, "InProgress"));
    }

    @Test
    void testUpdateTaskStatus_InvalidChange() {
        Task task = new Task(2, "Done Task", "Completed", LocalDate.now());
        assertFalse(service.updateTaskStatus(task, "Pending"));
    }

    @Test
    void testIsTaskOverdue_True() {
        Task task = new Task(3, "Late Task", "Pending", LocalDate.now().minusDays(1));
        assertTrue(service.isTaskOverdue(task));
    }

    @Test
    void testIsTaskOverdue_False() {
        Task task = new Task(4, "Future Task", "Pending", LocalDate.now().plusDays(2));
        assertFalse(service.isTaskOverdue(task));
    }

    @Test
    void testGetOverdueTasks() {
        Task t1 = new Task(5, "Late", "Pending", LocalDate.now().minusDays(1));
        Task t2 = new Task(6, "On Time", "Pending", LocalDate.now().plusDays(2));

        List<Task> tasks = Arrays.asList(t1, t2);
        List<Task> overdue = service.getOverdueTasks(tasks);

        assertEquals(1, overdue.size());
    }
}
