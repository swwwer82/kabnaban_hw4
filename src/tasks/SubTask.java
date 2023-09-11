package tasks;

public class SubTask extends Task {
     public final int epicId;

    public SubTask(int epicId, String nameSubTask, String descriptionSubTask) {
        super(nameSubTask, descriptionSubTask);
        this.epicId = epicId;
    }

    @Override
    public String toString() {
        return "ID подзадачи SubTask = " + epicId + "," + "\nID Epic задачи = " + getId() + "\nНазвание подзадачи = " + getTitle() + ", "
                + "\nОписание = " + getDescription() + ", " + "\nСтатус = " + getStatus() + "\n";
    }
}