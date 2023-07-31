package tasks;

public class SubTask extends Task {
    private final int epicId;

    public SubTask(int id, String nameSubTask, String descriptionSubTask, String statusSubTask) {
        super(nameSubTask, descriptionSubTask);
        this.epicId = id;
    }

    public SubTask(SubTask subtask) {
        this(subtask.epicId, subtask.getTitle(), subtask.getDescription(), subtask.getStatus());
    }

    @Override
    public String toString() {
        return "ID подзадачи SubTask = " + epicId + "," + "\nID Epic задачи = " + getId() + "\nНазвание подзадачи = " + getTitle() + ", "
                + "\nОписание = " + getDescription() + ", " + "\nСтатус = " + getStatus() + "\n";
    }
}