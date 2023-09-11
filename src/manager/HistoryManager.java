package manager;

import tasks.*;


import java.util.List;

public interface HistoryManager {
    void addToHistory(Task task);
    void addToHistory(EpicTask epicTask);
    void addToHistory(SubTask subTask);
    List<Task> getHistory();
}
