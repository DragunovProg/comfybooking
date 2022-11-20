package ua.dragunov.api.model;

import javax.persistence.Embeddable;

@Embeddable
public class Location {
    private String city;
    private String street;
    private String houseNumber;
    private String postcode;
}
