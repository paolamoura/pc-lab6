import java.util.concurrent.*;

public class Scenario1 {

    public static void main(String[] args) {
        BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1; i <= 5; i++) {
            TaskProducer producer = new TaskProducer(taskQueue, "Producer" + i);
            executorService.submit(producer);
        }

        for (int i = 1; i <= 3; i++) {
            Node node = new Node(taskQueue, "Node" + i);
            executorService.submit(node);
        }

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            System.out.println("Exibindo status das tarefas...");
        }, 0, 5, TimeUnit.SECONDS);
    }
}