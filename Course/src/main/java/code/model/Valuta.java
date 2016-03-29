package code.model;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "valuta")
@Entity
public class Valuta implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    @Enumerated
    private ValutaType type;

    @Column
    private double courseValue;

    @Column
    private LocalDate addedTime;

    public Valuta() {
    }

    public Valuta(ValutaType type, double courseValue, LocalDate addedTime) {
        this.type = type;
        this.courseValue = courseValue;
        this.addedTime = addedTime;
    }

    public ValutaType getType() {
        return type;
    }

    public void setType(ValutaType type) {
        this.type = type;
    }

    public double getCourseValue() {
        return courseValue;
    }

    public void setCourseValue(double courseValue) {
        this.courseValue = courseValue;
    }

    public LocalDate getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(LocalDate addedTime) {
        this.addedTime = addedTime;
    }

    @Override
    public String toString() {
        return "Valuta{" +
                "type=" + type +
                ", courseValue=" + courseValue +
                ", addedTime=" + addedTime +
                '}';
    }
}
