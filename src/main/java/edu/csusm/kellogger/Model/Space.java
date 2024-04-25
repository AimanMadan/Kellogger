package edu.csusm.kellogger.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int number;
    private int capacity;
    private int peopleCount;
    private int entrances;
    private float usage = getUsage();

    public float getUsage() {
        return (peopleCount > 0) ? (float)peopleCount / capacity * 100 : 0;
    }
}
