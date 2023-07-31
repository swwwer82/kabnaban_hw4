import manager.TaskManager;
import tasks.EpicTask;
import tasks.SubTask;
import tasks.Task;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

                TaskManager taskManager = new TaskManager();

                // Creating tasks
                Task taskFirst = new Task("Поесть", "Принять пищу");
                Task taskSecond = new Task("Поспать", "Хорошенько выспаться");

                // Creating subtasks for the first epic
                SubTask subtaskFirstEpicTaskFirst = new SubTask(1,
                        "Сдать все спринты", "Вовремя выполнить ТЗ", "NEW");
                SubTask subtaskSecondEpicTaskFirst = new SubTask(1,
                        "Сдать дипломный проект", "Сделать дипломный проект", "DONE");

                // Creating the first epic and adding subtasks
                EpicTask epicTaskFirst = new EpicTask("Закончить учебу",
                        "Получить сертификат обучения");
                epicTaskFirst.addSubtask(subtaskFirstEpicTaskFirst);
                epicTaskFirst.addSubtask(subtaskSecondEpicTaskFirst);

                // Creating subtask for the second epic
                SubTask subtaskFirstEpicTaskSecond = new SubTask(2,
                        "Закончить курс по Java", "Научиться программировать на языке Java",
                        "NEW");

                // Creating the second epic and adding subtask
                EpicTask epicTaskSecond = new EpicTask("Сменить работу",
                        "Начать работать Java разработчиком");
                epicTaskSecond.addSubtask(subtaskFirstEpicTaskSecond);

                // Save tasks and epics to the manager
                taskManager.addTask(taskFirst);
                taskManager.addTask(taskSecond);
                taskManager.addEpicTask(epicTaskFirst);
                taskManager.addEpicTask(epicTaskSecond);

                // Printing lists
                System.out.println("Epic Tasks:");
                System.out.println(taskManager.getEpicTasks());
                System.out.println("Tasks:");
                System.out.println(taskManager.getTasks());
                System.out.println("Subtasks:");
                System.out.println(taskManager.getSubTasks());

                // Updating statuses
                taskFirst.setStatus("IN_PROGRESS");
                subtaskFirstEpicTaskFirst.setStatus("IN_PROGRESS");

                // Printing lists after status update
                System.out.println("\nAfter Status Update:");
                System.out.println("Epic Tasks:");
                System.out.println(taskManager.getEpicTasks());
                System.out.println("Tasks:");
                System.out.println(taskManager.getTasks());
                System.out.println("Subtasks:");
                System.out.println(taskManager.getSubTasks());

                // Deleting tasks and epics
                taskManager.deleteTask(taskFirst);
                taskManager.deleteEpicTask(epicTaskSecond);

                // Printing lists after deletion
                System.out.println("\nAfter Deletion:");
                System.out.println("Epic Tasks:");
                System.out.println(taskManager.getEpicTasks());
                System.out.println("Tasks:");
                System.out.println(taskManager.getTasks());
                System.out.println("Subtasks:");
                System.out.println(taskManager.getSubTasks());
    }
}




