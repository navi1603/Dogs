package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Data;


@Data
public class Dog {

    private StringProperty name;
    private StringProperty breed;
    private IntegerProperty age;
    private StringProperty city;
    private IntegerProperty levelOfTraining;

    public Dog(String name, String breed, int age, String city, int levelOfTraining) {
        this.name = new SimpleStringProperty(name);
        this.breed = new SimpleStringProperty(breed);
        this.age = new SimpleIntegerProperty(age);
        this.city = new SimpleStringProperty(city);
        this.levelOfTraining = new SimpleIntegerProperty(levelOfTraining);
    }

    public Dog() {
        name = new SimpleStringProperty();
        breed = null;
        age = null;
        city = null;
        levelOfTraining = null;
    }
}