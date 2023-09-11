package manager;

import tasks.*;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private final List<Task> history = new ArrayList<>();

    @Override
    public void addToHistory(Task task) {
        history.add(0, task);
        if (history.size() > 10) {
            history.remove(history.size() - 1);
        }
    }

    @Override
    public void addToHistory(EpicTask epicTask) {
        history.add(0, epicTask);
        if (history.size() > 10) {
            history.remove(history.size() - 1);
        }
    }

    @Override
    public void addToHistory(SubTask subTask) {
        history.add(0, subTask);
        if (history.size() > 10) {
            history.remove(history.size() - 1);
        }
    }

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }
}
