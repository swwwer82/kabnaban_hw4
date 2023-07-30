package tasks;

import managers.Manager;

import java.util.ArrayList;
import java.util.List;

public class EpicTask extends Task {
    private final List<SubTask> subTasks;
    Manager manager = new Manager();

    public EpicTask(String titleEpicTask, String descriptionEpicTask, ArrayList<SubTask> subTasks) {
        super(titleEpicTask, descriptionEpicTask);
        this.setStatus(manager.getEpicTaskStatus(subTasks));
        this.subTasks = subTasks;
    }

    public EpicTask(EpicTask epicTask) {
        this(epicTask.getTitle(), epicTask.getDescription(), (ArrayList<SubTask>) epicTask.subTasks);
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    @Override
    public String toString() {
        return "ID задачи Epic = " + getId() + ", " + "\nНазвание Epic задачи = " + getTitle() + ",\nОписание = " +
                getDescription() + ", " + subTasks + ", " + "\nСтатус = " + getStatus() + "\n";
    }
}