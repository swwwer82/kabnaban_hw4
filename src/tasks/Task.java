package tasks;

import manager.Manager;

public class Task {
    private final int id;
    private String title;
    private String description;
    private String status;
    Manager manager = new Manager();

    public Task(String titleTask, String descriptionTask, String statusTask) {
        this.id = manager.getId() + 1;
        manager.setId(this.id);
        this.title = titleTask;
        this.description = descriptionTask;
        this.status = statusTask;
    }

    Task(String titleTask, String descriptionTask) {
        this.id = manager.getId() + 1;
        manager.setId(this.id);
        this.title = titleTask;
        this.description = descriptionTask;
    }

    public Task(Task task) {
        this(task.title, task.description, task.status);
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

    public String getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "ID задачи Task = " + id + ", " + "\nНазвание задачи = " + title + ",\nОписание = " + description
                + ", " + "\nСтатус = " + status + "\n";
    }
}
