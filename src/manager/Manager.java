package manager;


import tasks.EpicTask;
import tasks.SubTask;
import tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {
    private static int id = 0;

    private final Map<Integer, Task> taskStorage = new HashMap<>();

    private final Map<Integer, EpicTask> epicTaskStorage = new HashMap<>();

    private final Map<Integer, SubTask> subTaskStorage = new HashMap<>();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


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

    public List<Task> getCompleteListOfTask(Map<Integer, Task> taskMap) {
        List<Task> completeListOfTask = new ArrayList<>();

        for (Integer key : taskMap.keySet()) {
            completeListOfTask.add(taskMap.get(key));
        }
        return completeListOfTask;
    }

    public List<EpicTask> getCompleteListOfEpicTask(Map<Integer, EpicTask> epicMap) {
        List<EpicTask> completeListOfEpicTask = new ArrayList<>();

        for (Integer key : epicMap.keySet()) {
            completeListOfEpicTask.add(epicMap.get(key));
        }
        return completeListOfEpicTask;
    }

    public List<SubTask> getCompleteListOfSubTask(Map<Integer, SubTask> subMap) {
        List<SubTask> completeListOfSubTask = new ArrayList<>();

        for (Integer key : subMap.keySet()) {
            completeListOfSubTask.add(subMap.get(key));
        }
        return completeListOfSubTask;
    }

    public void deleteAllTasksOfAnyType(Map<Integer, ? extends Task> map) {
        map.clear();
    }

    public Object getTaskOfAnyTypeById(int id) {
        Object taskOfKind = null;

        if (taskStorage.get(id) != null) {
            taskOfKind = taskStorage.get(id);
        }
        return taskOfKind;
    }

    public Object getEpicTaskOfAnyTypeById(int id) {
        Object epicTaskOfKind = null;

        if (taskStorage.get(id) != null) {
            epicTaskOfKind = epicTaskStorage.get(id);
        }
        return epicTaskOfKind;
    }

    public Object getSubTaskOfAnyTypeById(int id) {
        Object subTaskOfKind = null;

        if (taskStorage.get(id) != null) {
            subTaskOfKind = subTaskStorage.get(id);
        }
        return subTaskOfKind;
    }

    public Object createCopyTaskOfType(Object object) {
        switch (object.getClass().toString()) {
            case "Task": {
                return new Task((Task) object);
            }
            case "SubTask": {
                return new SubTask((SubTask) object);
            }
            case "EpicTask": {
                return new EpicTask((EpicTask) object);
            }
            default:
                return null;
        }
    }

    public void updateTaskOfType(int id, Object object) {
        switch (object.getClass().toString()) {
            case "Task": {
                taskStorage.put(id, (Task) object);
                break;
            }
            case "EpicTask": {
                epicTaskStorage.put(id, (EpicTask) object);
                break;
            }
            case "SubTask": {
                subTaskStorage.put(id, (SubTask) object);
                break;
            }
        }
    }

    public void removeTaskOfAnyTypeById(int id) {
        for (Integer task : taskStorage.keySet()) {
            if (id == task) {
                taskStorage.remove(id);
                break;
            }
        }
        for (Integer epicTask : epicTaskStorage.keySet()) {
            if (id == epicTask) {
                epicTaskStorage.remove(id);
                break;
            }
        }
        for (Integer subTask : subTaskStorage.keySet()) {
            if (id == subTask) {
                subTaskStorage.remove(id);
                break;
            }
        }
    }

    public List<SubTask> getCompleteListOfSubTaskByEpicTask(EpicTask epicTask) {
        return epicTask.getSubTasks();
    }

    public String getEpicTaskStatus(ArrayList<SubTask> subTasks) {
        String statusEpicTask;
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
        if ((subTasks.isEmpty()) || (countNew == subTasks.size())) {
            statusEpicTask = "NEW";
        } else if (countDone == subTasks.size()) {
            statusEpicTask = "DONE";
        } else {
            statusEpicTask = "IN_PROGRESS";
        }
        return statusEpicTask;
    }
}
