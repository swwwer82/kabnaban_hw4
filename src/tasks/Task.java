package tasks;

import statusOfTask.Status;

public class Task {
    private static int count = 0;
    protected final int id;
    protected String title;
    protected String description;
    protected Status status;

    public Task(String titleTask, String descriptionTask) {
        this.id = generateId();
        this.title = titleTask;
        this.description = descriptionTask;
    }

    private static Integer generateId() {
        return ++count;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    @Override
    public String toString() {
        return "ID задачи Task = " + id + ", " + "\nНазвание задачи = " + title + ",\nОписание = " + description
                + ", " + "\nСтатус = " + status + "\n";
    }
}
