public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTask(new Task("Code Review", 3, 20));
        scheduler.addTask(new Task("System Update", 5, 45));
        scheduler.addTask(new Task("Database Backup", 2, 30));
        scheduler.addTask(new Task("Deploy New Feature", 5, 50));
        scheduler.addTask(new Task("Bug Fixing", 4, 25));

        scheduler.displayScheduledTasks();
        System.out.println();

        scheduler.processTask();
        scheduler.delayTask();
        scheduler.displayScheduledTasks();
        scheduler.displayPendingTasks();
        System.out.println();

        scheduler.delayTask();
        scheduler.displayScheduledTasks();
        scheduler.displayPendingTasks();
        System.out.println();

        scheduler.processTask();
        scheduler.displayScheduledTasks();
        scheduler.displayPendingTasks();
        System.out.println();

        scheduler.processTask();
        scheduler.displayScheduledTasks();
        scheduler.displayPendingTasks();
        System.out.println();

        scheduler.processPendingTask();
        scheduler.displayScheduledTasks();
        scheduler.displayPendingTasks();
        System.out.println();

        scheduler.processPendingTask();
        scheduler.displayScheduledTasks();
        scheduler.displayPendingTasks();
    }
}