package tasks;

import java.util.ArrayList;
import java.util.List;

public class EpicTask extends Task {
    private final List<SubTask> subTasks;

    public EpicTask(String titleEpicTask, String descriptionEpicTask) {
        super(titleEpicTask, descriptionEpicTask);
        this.subTasks = new ArrayList<>();
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void addSubtask(SubTask subTask) {
        subTasks.add(subTask);
    }

    @Override
    public String toString() {
        return "ID задачи Epic = " + getId() + ", " + "\nНазвание Epic задачи = " + getTitle() + ",\nОписание = " +
                getDescription() + ", " + subTasks + ", " + "\nСтатус = " + getStatus() + "\n";
    }
}