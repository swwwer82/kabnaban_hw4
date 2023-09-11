package manager;



public class Managers {


    public static TaskManager getDefaultTaskManager(HistoryManager defaultHistoryManager) {
        return new InMemoryTaskManager(defaultHistoryManager);
    } ///

    public static HistoryManager getDefaultHistoryManager() {
        return new InMemoryHistoryManager();
    }
}
