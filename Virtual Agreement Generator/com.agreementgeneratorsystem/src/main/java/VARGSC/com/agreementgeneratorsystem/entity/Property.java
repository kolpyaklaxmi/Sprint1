package VARGSC.com.agreementgeneratorsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    @Column(name = "rent") // Ensures it maps correctly to DB column
    private double rentPrice;

    private String description;
    private String address;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private Landlord landlord;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Landlord getLandlord() {
        return landlord;
    }

    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }

    @Override
    public String toString() {
        return "Property [ID=" + id + ", Type=" + type + ", Rent=" + rentPrice +
               ", Description=" + description + ", Address=" + address + "]";
    }
}
