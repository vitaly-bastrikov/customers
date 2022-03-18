package io.bastrikov.customers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private int id;
    private String country;
    private String city;
    private String street;
    private int streetNumber;

    @Override
    public String toString(){
        return country + ", " + city + ", " + streetNumber + " " + street;
    }
}
