package oncall.domain;

import java.util.Objects;

public class Worker {
    private final String name;
    private boolean worked;

    public Worker(String name){
        this.name = name;
        this.worked = false;
    }

    public boolean isWorked() {
        return worked;
    }

    public void reset() {
        worked = false;
    }

    public String getName() {
        return name;
    }

    public void work() {
        worked = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
