package manager;


import tasks.EpicTask;
import tasks.SubTask;
import tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

    private final Map<Integer, Task> taskStorage = new HashMap<>();

    private final Map<Integer, EpicTask> epicTaskStorage = new HashMap<>();

    private final Map<Integer, SubTask> subTaskStorage = new HashMap<>();


    public Map<Integer, Task> getTaskStorage() {
        return taskStorage;
    }

    public Map<Integer, EpicTask> getEpicTaskStorage() {
        return epicTaskStorage;
    }

    public Map<Integer, SubTask> getSubTaskStorage() {
        return subTaskStorage;
    }

    public void saveTaskStorage(Task task) {
        taskStorage.put(task.getId(), task);
    }

    public void saveEpicTaskStorage(EpicTask epic) {
        epicTaskStorage.put(epic.getId(), epic);
    }

    public void saveSubTaskStorage(SubTask subTask) {
        subTaskStorage.put(subTask.getId(), subTask);
    }

    public void addTask(Task task) {
        taskStorage.put(task.getId(), task);
    }

    public void addEpicTask(EpicTask epicTask) {
        epicTaskStorage.put(epicTask.getId(), epicTask);
    }

    public void addSubTask(SubTask subTask) {
        subTaskStorage.put(subTask.getId(), subTask);
        updateEpicStatus(subTask.getId());
    }

    public Task getTaskById(int id) {
        return taskStorage.get(id);
    }

    public EpicTask getEpicTaskById(int id) {
        return epicTaskStorage.get(id);
    }

    public SubTask getSubTaskById(int id) {
        return subTaskStorage.get(id);
    }

    public void updateTask(Task task) {
        taskStorage.put(task.getId(), task);
    }

    public void updateEpicTask(EpicTask epicTask) {
        epicTaskStorage.put(epicTask.getId(), epicTask);
    }

    public void updateSubTask(SubTask subTask) {
        subTaskStorage.put(subTask.getId(), subTask);
        updateEpicStatus(subTask.getId());
    }

    public void deleteTask(Task task) {
        taskStorage.remove(task.getId());
    }

    public void deleteEpicTask(EpicTask epicTask) {
        epicTaskStorage.remove(epicTask.getId());
    }

    public void deleteSubTask(SubTask subTask) {
        subTaskStorage.remove(subTask.getId());
        updateEpicStatus(subTask.getId());

    }

    public List<Task> getTasks() {
        return new ArrayList<>(this.taskStorage.values());
    }

    public List<EpicTask> getEpicTasks() {
        return new ArrayList<>(epicTaskStorage.values());
    }

    public List<SubTask> getSubTasks() {
        return new ArrayList<>(subTaskStorage.values());
    }

    private String updateEpicStatus(int epicId) {
        String statusEpicTask;
        List<SubTask> subTasks = getSubTasksForEpic(epicId);
        int countNew = 0;
        int countDone = 0;

        for (SubTask subTask : subTasks) {
            if (subTask.getStatus().equals("NEW")) {
                countNew++;
            }
            if (subTask.getStatus().equals("DONE")) {
                countDone++;
            }
        }
        if (subTasks.isEmpty() || countNew == subTasks.size()) {
            statusEpicTask = "NEW";
        } else if (countDone == subTasks.size()) {
            statusEpicTask = "DONE";
        } else {
            statusEpicTask = "IN_PROGRESS";
        }
        return statusEpicTask;
    }

    private List<SubTask> getSubTasksForEpic(int epicId) {
        List<SubTask> subTasksForEpic = new ArrayList<>();
        for (SubTask subTask : subTaskStorage.values()) {
            if (subTask.epicId == epicId) {
                subTasksForEpic.add(subTask);
            }
        }
        return subTasksForEpic;
    }

}
