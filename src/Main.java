import java.util.List;
import manager.*;
import tasks.*;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefaultTaskManager(Managers.getDefaultHistoryManager());
        // Provide the history manager
//
//        Task task1 = new Task("Задача 1", "Описание задачи 1");
//        Task task2 = new Task("Задача 2", "Описание задачи 2");
//        EpicTask epicTask = new EpicTask("Эпическая задача", "Описание эпической задачи");
//        SubTask subTask1 = new SubTask(epicTask.getId(), "Подзадача 1", "Описание подзадачи 1");
//        SubTask subTask2 = new SubTask(epicTask.getId(), "Подзадача 2", "Описание подзадачи 2");
//
//        taskManager.addTask(task1);
//        taskManager.addTask(task2);
//        taskManager.addEpicTask(epicTask);
//        taskManager.addSubTask(subTask1);
//        taskManager.addSubTask(subTask2);
//
//        task1.setStatus("IN_PROGRESS");
//        subTask1.setStatus("DONE");
//
//        System.out.println("Все задачи:");
//        for (Task task : taskManager.getTasks()) {
//            System.out.println(task);
//        }
//
//        System.out.println("Все эпические задачи:");
//        for (EpicTask epic : taskManager.getEpicTasks()) {
//            System.out.println(epic);
//        }
//
//        System.out.println("Все подзадачи:");
//        for (SubTask subTask : taskManager.getSubTasks()) {
//            System.out.println(subTask);
//        }
//
//        Task retrievedTask = taskManager.getTaskById(task1.getId());
//        EpicTask retrievedEpicTask = taskManager.getEpicTaskById(epicTask.getId());
//        SubTask retrievedSubTask = taskManager.getSubTaskById(subTask1.getId());
//
//        if (taskManager instanceof InMemoryTaskManager) {
//            InMemoryTaskManager inMemoryTaskManager = (InMemoryTaskManager) taskManager;
//            System.out.println("История просмотров:");
//            List<Task> history = inMemoryTaskManager.getHistory();
//            for (Task task : history) {
//                System.out.println(task);
//            }
//        } else {
//            System.out.println("Указанный TaskManager не поддерживает историю просмотров.");
//        }
        for (int i = 1; i < 20; i++) {
            taskManager.addTask(new Task("name" + i, "desc" + i));
        }
        for (int i = 5; i < 18; i++) {
            taskManager.getTaskById(i);
        }
        var history = taskManager.getHistory();
        ///должно быть все корректно
        System.out.println(history);

    }
}
