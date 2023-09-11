import java.util.List;
import manager.*;
import tasks.*;



public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefaultTaskManager();
        HistoryManager historyManager = Managers.getDefaultHistoryManager();

        Task task1 = new Task("Задача 1", "Описание задачи 1");
        Task task2 = new Task("Задача 2", "Описание задачи 2");
        EpicTask epicTask = new EpicTask("Эпическая задача", "Описание эпической задачи");
        SubTask subTask1 = new SubTask(epicTask.getId(), "Подзадача 1", "Описание подзадачи 1");
        SubTask subTask2 = new SubTask(epicTask.getId(), "Подзадача 2", "Описание подзадачи 2");


        // Добавляем задачи в менеджер
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addEpicTask(epicTask);
        taskManager.addSubTask(subTask1);
        taskManager.addSubTask(subTask2);

        // Изменяем статусы задач
        task1.setStatus("IN_PROGRESS");
        subTask1.setStatus("DONE");

        // Выводим информацию о задачах
        System.out.println("Все задачи:");
        for (Task task : taskManager.getTasks()) {
            System.out.println(task);
        }

        System.out.println("Все эпические задачи:");
        for (EpicTask epic : taskManager.getEpicTasks()) {
            System.out.println(epic);
        }

        System.out.println("Все подзадачи:");
        for (SubTask subTask : taskManager.getSubTasks()) {
            System.out.println(subTask);
        }

        // Получаем задачи по ID
        Task retrievedTask = taskManager.getTaskById(task1.getId());
        EpicTask retrievedEpicTask = taskManager.getEpicTaskById(epicTask.getId());
        SubTask retrievedSubTask = taskManager.getSubTaskById(subTask1.getId());




        // Выводим историю просмотров
        System.out.println("История просмотров:");
        List<Task> history = historyManager.getHistory();
        for (Task task : history) {
            System.out.println(task);
        }

    }
}





