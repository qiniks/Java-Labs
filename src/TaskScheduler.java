import java.util.*;

public class TaskScheduler {
    private PriorityQueue<Task> taskQueue;
    private Queue<Task> pendingQueue;

    public TaskScheduler() {
        taskQueue = new PriorityQueue<>();
        pendingQueue = new LinkedList<>();
    }

    public void addTask(Task task) {
        taskQueue.add(task);
        System.out.println("Added: " + task);
    }

    public void processTask() {
        if (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Processing Task: " + task);
        } else {
            System.out.println("No priority tasks to process.");
        }
    }

    public void delayTask() {
        if (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            pendingQueue.add(task);
            System.out.println("Delaying Task: " + task.getTaskName());
        } else {
            System.out.println("No priority tasks to delay.");
        }
    }

    public void processPendingTask() {
        if (!pendingQueue.isEmpty()) {
            Task task = pendingQueue.poll();
            System.out.println("Processing Pending Task: " + task);
        } else {
            System.out.println("No pending tasks to process.");
        }
    }

    public void displayScheduledTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No priority tasks.");
        } else {
            System.out.println("Scheduled Tasks (sorted by priority):");
            for (Task task : taskQueue) {
                System.out.println(task);
            }
        }
    }

    public void displayPendingTasks() {
        if (pendingQueue.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            System.out.println("Pending Tasks (FIFO Order):");
            for (Task task : pendingQueue) {
                System.out.println(task);
            }
        }
    }
}