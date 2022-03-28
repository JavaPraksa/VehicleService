package levi9.VehicleService.model;

import javax.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    private Address address;

    public Vehicle() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
