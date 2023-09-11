package manager;
import manager.HistoryManager;
import manager.InMemoryHistoryManager;
import manager.InMemoryTaskManager;
import manager.TaskManager;

public class Managers {
    private static final HistoryManager defaultHistoryManager = new InMemoryHistoryManager();
    private static final TaskManager defaultTaskManager = new InMemoryTaskManager();

    public static TaskManager getDefaultTaskManager() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistoryManager() {
        return defaultHistoryManager;
    }
}
