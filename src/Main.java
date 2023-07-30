import manager.Manager;
import tasks.EpicTask;
import tasks.SubTask;
import tasks.Task;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        Manager manager = new Manager();

        Task taskFirst = new Task("Поесть", "Принять пищу", "NEW");
        Task taskSecond = new Task("Поспать", "Хорошенько выспаться", "DONE");

        ArrayList<SubTask> subTasksEpicTaskFirst = new ArrayList<>();
        SubTask subtaskFirstEpicTaskFirst = new SubTask(1,
                "Сдать все спринты", "Вовремя выполнить ТЗ", "NEW");
        SubTask subtaskSecondEpicTaskFirst = new SubTask(1,
                "Сдать дипломный проект", "Сделать дипломный проект", "DONE");

        subTasksEpicTaskFirst.add(subtaskFirstEpicTaskFirst);
        subTasksEpicTaskFirst.add(subtaskSecondEpicTaskFirst);

        EpicTask epicTaskFirst = new EpicTask("Закончить учебу",
                "Получить сертификат обучения", subTasksEpicTaskFirst);

        SubTask subtaskFirstEpicTaskSecond = new SubTask(2,
                "Закончить курс по Java", "Научиться программировать на языке Java",
                "NEW");
        ArrayList<SubTask> subTasksEpicTaskSecond = new ArrayList<>();

        subTasksEpicTaskSecond.add(subtaskFirstEpicTaskSecond);

        EpicTask epicTaskSecond = new EpicTask("Сменить работу"
                , "Начать работать Java разработчиком", subTasksEpicTaskSecond);

        manager.saveTaskStorage(taskFirst);
        manager.saveTaskStorage(taskSecond);
        manager.saveSubTaskStorage(subtaskFirstEpicTaskFirst);
        manager.saveSubTaskStorage(subtaskSecondEpicTaskFirst);
        manager.saveEpicTaskStorage(epicTaskFirst);
        manager.saveSubTaskStorage(subtaskFirstEpicTaskSecond);
        manager.saveEpicTaskStorage(epicTaskSecond);


        System.out.println("\n    2.1 Получение списка всех задач:");
        System.out.println(manager.getCompleteListOfTask(manager.getTaskStorage()));
        System.out.println(manager.getCompleteListOfEpicTask(manager.getEpicTaskStorage()));
        System.out.println(manager.getCompleteListOfSubTask(manager.getSubTaskStorage()));

        manager.deleteAllTasksOfAnyType(manager.getEpicTaskStorage());

        System.out.println("\n    2.2 Удаление всех задач:");
        System.out.println(manager.getCompleteListOfTask(manager.getTaskStorage()));
        System.out.println(manager.getCompleteListOfEpicTask(manager.getEpicTaskStorage()));
        System.out.println(manager.getCompleteListOfSubTask(manager.getSubTaskStorage()));

        System.out.println("\n    2.3 Получение по идентификатору:");
        System.out.println(manager.getTaskOfAnyTypeById(0));
        System.out.println(manager.getTaskOfAnyTypeById(1));
        System.out.println(manager.getEpicTaskOfAnyTypeById(2));
        System.out.println(manager.getEpicTaskOfAnyTypeById(3));
        System.out.println(manager.getSubTaskOfAnyTypeById(4));
        System.out.println(manager.getSubTaskOfAnyTypeById(5));


        System.out.println("\n    2.4 Создание. Сам объект должен передаваться в качестве параметра:");
        System.out.println(manager.createCopyTaskOfType(taskFirst));
        System.out.println(manager.createCopyTaskOfType(epicTaskFirst));
        System.out.println(manager.createCopyTaskOfType(subtaskFirstEpicTaskFirst));

        manager.updateTaskOfType(5, epicTaskFirst);
        manager.updateTaskOfType(7, epicTaskSecond);

        System.out.println("\n    2.5 Обновление. Новая версия объекта с верным идентификатором передаются в виде"
                + " параметра:");
        System.out.println(manager.getCompleteListOfEpicTask(manager.getEpicTaskStorage()));

        manager.removeTaskOfAnyTypeById(1);
        manager.removeTaskOfAnyTypeById(2);

        System.out.println("\n    2.6 Удаление по идентификатору:");
        System.out.println(manager.getCompleteListOfTask(manager.getTaskStorage()));


        System.out.println("\n    3.1 Получение списка всех подзадач определённого эпика:");
        System.out.println(manager.getCompleteListOfSubTaskByEpicTask(epicTaskFirst));
        System.out.println(manager.getCompleteListOfSubTaskByEpicTask(epicTaskSecond));
    }
}


