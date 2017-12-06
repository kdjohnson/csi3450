package edu.oakland.csi3450.models;
import lombok.Data;

@Data
public class Job {
    private String id;
    private String type;
    private Double salary;

    public Job() {}

    public Job(String id, String type, Double salary) {
        this.id = id;
        this.type = type;
        this.salary = salary;
    }
}
