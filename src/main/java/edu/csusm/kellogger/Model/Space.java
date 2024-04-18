package edu.csusm.kellogger.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public int getUsage() {
        return (capacity != 0) ? (peopleCount * 100) / capacity : 0;
    }
}
