package manager;

public class Managers {
    private static final TaskManager defaultTaskManager = new InMemoryTaskManager();

    public static TaskManager getDefault() {
        return defaultTaskManager;
    }
}