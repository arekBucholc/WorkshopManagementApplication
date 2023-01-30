package com.example.workshopmanagementapp.model;

import com.example.workshopmanagementapp.model.Mechanic;
import javax.persistence.*;
import java.time.LocalDate;


@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Opis",nullable = false)
    private String description;

    @Column(name = "Marka",nullable = false)
    private String carMake;

    @Column(name = "Model",nullable = false)
    private String carModel;

    @Column(name = "Koszt",nullable = false)
    private Double cost;

    @Column(name = "Imie_Wlasciciela",nullable = false,length = 45)
    private String ownerFirstName;

    @Column(name = "Nazwisko_Wlasciciela",nullable = false,length = 50)
    private String ownerLastName;

    @Column(name = "Nr_Kontaktowy",nullable = false,length = 9)
    private String ownerContactNr;

    @Column(name = "data_rozpoczecia")
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getOwnerContactNr() {
        return ownerContactNr;
    }

    public void setOwnerContactNr(String ownerContactNr) {
        this.ownerContactNr = ownerContactNr;
    }

    public LocalDate getStartDate() {

        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", carMake='" + carMake + '\'' +
                ", carModel='" + carModel + '\'' +
                ", cost=" + cost +
                ", ownerFirstName='" + ownerFirstName + '\'' +
                ", ownerLastName='" + ownerLastName + '\'' +
                ", ownerContactNr='" + ownerContactNr + '\'' +
                '}';
    }
}
