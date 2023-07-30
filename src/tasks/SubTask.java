package tasks;

public class SubTask extends Task {
    private final int idEpicTask;
    private String titleEpicTask;

    public SubTask(int id, String nameSubTask, String descriptionSubTask, String statusSubTask) {
        super(nameSubTask, descriptionSubTask, statusSubTask);
        this.idEpicTask = id;
    }

    public SubTask(SubTask subtask) {
        this(subtask.idEpicTask, subtask.getTitle(), subtask.getDescription(), subtask.getStatus());
    }

    @Override
    public String toString() {
        return "ID подзадачи SubTask = " + idEpicTask + "," + "\nID Epic задачи = " + getId() + "\nНазвание EpicTask = " + titleEpicTask
                + ", " + "\nНазвание подзадачи = " + getTitle() + ", " + "\nОписание = " + getDescription() + ", "
                + "\nСтатус = " + getStatus() + "\n";
    }
}
