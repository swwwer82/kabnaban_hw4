package manager;


import statusOfTask.Status;
import tasks.EpicTask;
import tasks.SubTask;
import tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {

    private final Map<Integer, Task> taskStorage = new HashMap<>();

    private final Map<Integer, EpicTask> epicTaskStorage = new HashMap<>();

    private final Map<Integer, SubTask> subTaskStorage = new HashMap<>();
    private final List<Task> history = new ArrayList<>();


    @Override
    public Map<Integer, Task> getTaskStorage() {
        return taskStorage;
    }

    @Override
    public Map<Integer, EpicTask> getEpicTaskStorage() {
        return epicTaskStorage;
    }

    @Override
    public Map<Integer, SubTask> getSubTaskStorage() {
        return subTaskStorage;
    }

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }


    @Override
    public void saveTaskStorage(Task task) {
        taskStorage.put(task.getId(), task);
    }

    @Override
    public void saveEpicTaskStorage(EpicTask epic) {
        epicTaskStorage.put(epic.getId(), epic);
    }

    @Override
    public void saveSubTaskStorage(SubTask subTask) {
        subTaskStorage.put(subTask.getId(), subTask);
    }

    @Override
    public void addTask(Task task) {
        taskStorage.put(task.getId(), task);
    }

    @Override
    public void addEpicTask(EpicTask epicTask) {
        epicTaskStorage.put(epicTask.getId(), epicTask);
    }

    @Override
    public void addSubTask(SubTask subTask) {
        subTaskStorage.put(subTask.getId(), subTask);
        updateEpicStatus(subTask.epicId);
    }

    @Override
    public Task getTaskById(int id) {
        Task task = taskStorage.get(id);
        if (task != null && !history.contains(task)) {
            history.add(0, task); // Добавляем задачу в начало истории, если её там еще нет
            if (history.size() > 10) {
                history.remove(history.size() - 1); // Ограничиваем историю 10 элементами
            }
        }
        return task;
    }

    @Override
    public EpicTask getEpicTaskById(int id) {
        EpicTask epicTask = epicTaskStorage.get(id);
        if (epicTask != null && !history.contains(epicTask)) {
            history.add(0, epicTask);
            if (history.size() > 10) {
                history.remove(history.size() - 1);
            }
        }
        return epicTask;
    }
    @Override
    public SubTask getSubTaskById(int id) {
        SubTask subTask = subTaskStorage.get(id);
        if (subTask != null && !history.contains(subTask)) {
            history.add(0, subTask);
            if (history.size() > 10) {
                history.remove(history.size() - 1);
            }
        }
        return subTask;
    }
    @Override
    public void updateTask(Task task) {
        taskStorage.put(task.getId(), task);
    }
    @Override
    public void updateEpicTask(EpicTask epicTask) {
        epicTaskStorage.put(epicTask.getId(), epicTask);
    }
    @Override
    public void updateSubTask(SubTask subTask) {
        subTaskStorage.put(subTask.getId(), subTask);
        updateEpicStatus(subTask.epicId);
    }
    @Override
    public void deleteTask(Task task) {
        taskStorage.remove(task.getId());
    }
    @Override
    public void deleteEpicTask(EpicTask epicTask) {
        epicTaskStorage.remove(epicTask.getId());
    }
    @Override
    public void deleteSubTask(SubTask subTask) {
        subTaskStorage.remove(subTask.getId());
        updateEpicStatus(subTask.epicId);

    }
    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(this.taskStorage.values());
    }
    @Override
    public List<EpicTask> getEpicTasks() {
        return new ArrayList<>(epicTaskStorage.values());
    }
    @Override
    public List<SubTask> getSubTasks() {
        return new ArrayList<>(subTaskStorage.values());
    }

    @Override
    public void updateEpicStatus(int epicId) {
        Status statusEpicTask = Status.NEW; // Устанавливаем начальное значение

        List<SubTask> subTasks = getSubTasksForEpic(epicId);
        int countNew = 0;
        int countDone = 0;

        for (SubTask subTask : subTasks) {
            if (subTask.getStatus().equals(Status.NEW)) {
                countNew++;
            }
            if (subTask.getStatus().equals(Status.DONE)) {
                countDone++;
            }
        }

        if (subTasks.isEmpty() || countNew == subTasks.size()) {
            statusEpicTask = Status.NEW;
        } else if (countDone == subTasks.size()) {
            statusEpicTask = Status.DONE;
        } else {
            statusEpicTask = Status.IN_PROGRESS;
        }

        // Проверяем, существует ли EpicTask с заданным epicId
        EpicTask epicTask = getEpicTaskById(epicId);
        if (epicTask != null) {
            epicTask.setStatus(statusEpicTask.toString());
            updateEpicTask(epicTask);
        } else {
            System.out.println("EpicTask с id " + epicId + " не найден.");
        }
    }


    @Override
    public List<SubTask> getSubTasksForEpic(int epicId) {
        List<SubTask> subTasksForEpic = new ArrayList<>();
        for (SubTask subTask : subTaskStorage.values()) {
            if (subTask.epicId == epicId) { // Используйте epicId из параметра метода
                subTasksForEpic.add(subTask);
            }
        }
        return subTasksForEpic;
    }

}
