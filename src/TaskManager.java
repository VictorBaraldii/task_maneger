import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int taskId) {
        tasks.removeIf(task -> task.getId() == taskId);
    }
    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTaskByid(int taskId) {
        return tasks.stream().filter(task -> task.getId() == taskId).findFirst().orElse(null);
    }
    public void updateTask(int taskId, String title, String descreption, LocalDate dueDate, String priority, String status) {
        Task task = getTaskByid(taskId);
        if (task != null) {
            task.setTitle(title);
            task.setDescription(descreption);
            task.setDueDate(dueDate);
            task.setPriority(priority);
            task.setStatus(status);
        }
    }
}
