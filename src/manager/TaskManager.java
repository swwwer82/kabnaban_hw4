package manager;

import tasks.*;

import java.util.List;
import java.util.Map;

public interface TaskManager {
    Map<Integer, Task> getTaskStorage();
    Map<Integer, EpicTask> getEpicTaskStorage();
    Map<Integer, SubTask> getSubTaskStorage();
    void saveTaskStorage(Task task);
    void saveEpicTaskStorage(EpicTask epic);
    void saveSubTaskStorage(SubTask subTask);
    void addTask(Task task);
    void addEpicTask(EpicTask epicTask);
    void addSubTask(SubTask subTask);
    Task getTaskById(int id);
    EpicTask getEpicTaskById(int id);
    SubTask getSubTaskById(int id);
    void updateTask(Task task);
    void updateEpicTask(EpicTask epicTask);
    void updateSubTask(SubTask subTask);
    void deleteTask(Task task);
    void deleteEpicTask(EpicTask epicTask);
    void deleteSubTask(SubTask subTask);
    List<Task> getTasks();
    List<EpicTask> getEpicTasks();
    List<SubTask> getSubTasks();
    List<SubTask> getSubTasksForEpic(int epicId);
    List<Task> getHistory();
}
