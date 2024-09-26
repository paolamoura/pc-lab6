package scenario1;

import java.util.Random;

public class Task {
    private final long id;
    private String producerName;
    private long executionTime;

    public Task(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public void execute() {
        try {
            long execDuration = 1000 + (new Random().nextInt(14000)); 
            Thread.sleep(execDuration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}