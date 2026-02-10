package org.satvik.moviebooking.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "theatre")
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theatre_id")
    private int theatreId;

    @Column(name = "theatre_name")
    private String theatreName;

    @Column(name = "city")
    private String city;

    // Constructors
    public Theatre() {}

    public Theatre(String theatreName, String city) {
        this.theatreName = theatreName;
        this.city = city;
    }

    // Getters and Setters
    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
