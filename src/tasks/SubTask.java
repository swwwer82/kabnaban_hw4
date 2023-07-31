package tasks;

public class SubTask extends Task {
     public final int epicId;

    public SubTask(int id, String nameSubTask, String descriptionSubTask, String done) {
        super(nameSubTask, descriptionSubTask);
        this.epicId = id;
    }

    @Override
    public String toString() {
        return "ID подзадачи SubTask = " + epicId + "," + "\nID Epic задачи = " + getId() + "\nНазвание подзадачи = " + getTitle() + ", "
                + "\nОписание = " + getDescription() + ", " + "\nСтатус = " + getStatus() + "\n";
    }
}