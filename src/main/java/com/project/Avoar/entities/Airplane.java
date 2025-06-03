package com.project.Avoar.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_airplane")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String company;
    @Transient
    private Integer totalCapacity;
    private Integer quantityEconomic;
    private Integer quantityExecutive;
    private Integer quantityFirstClass;

    @OneToMany(mappedBy = "airplane")
    private Set<Flight> flights = new HashSet<>();

    public Airplane() {}

    public Airplane(Long id, String model, String company, Integer totalCapacity,
                    Integer quantityEconomic,
                    Integer quantityExecutive,
                    Integer quantityFirstClass) {
        this.id = id;
        this.model = model;
        this.company = company;
        this.totalCapacity = totalCapacity;
        this.quantityEconomic = quantityEconomic;
        this.quantityExecutive = quantityExecutive;
        this.quantityFirstClass = quantityFirstClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Integer getQuantityEconomic() {
        return quantityEconomic;
    }

    public void setQuantityEconomic(Integer quantityEconomic) {
        this.quantityEconomic = quantityEconomic;
    }

    public Integer getQuantityExecutive() {
        return quantityExecutive;
    }

    public void setQuantityExecutive(Integer quantityExecutive) {
        this.quantityExecutive = quantityExecutive;
    }

    public Integer getQuantityFirstClass() {
        return quantityFirstClass;
    }

    public void setQuantityFirstClass(Integer quantityFirstClass) {
        this.quantityFirstClass = quantityFirstClass;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Objects.equals(id, airplane.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", totalCapacity=" + totalCapacity +
                '}';
    }
}
