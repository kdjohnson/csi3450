package edu.oakland.csi3450.models;
import lombok.Data;
import java.util.Date;

@Data
public class Service {
    private String id;
    private String movie;
    private String wifi;
    private String meal;

    public Service() {}

    public Service(String id, String movie, String wifi, String meal) {
        this.id = id;
        this.movie = movie;
        this.wifi = wifi;
        this.meal = meal;
    }
}
