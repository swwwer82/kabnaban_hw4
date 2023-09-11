package manager;
import manager.HistoryManager;
import manager.InMemoryHistoryManager;
import manager.InMemoryTaskManager;
import manager.TaskManager;

public class Managers {
    private static final HistoryManager defaultHistoryManager = new InMemoryHistoryManager();
    private static final TaskManager defaultTaskManager = new InMemoryTaskManager(defaultHistoryManager);

    public static TaskManager getDefaultTaskManager() {
        return defaultTaskManager;
    }

    public static HistoryManager getDefaultHistoryManager() {
        return defaultHistoryManager;
    }
}
