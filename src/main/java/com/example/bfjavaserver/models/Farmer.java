package com.example.bfjavaserver.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "farmers")
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column
    public String email;

    @Column
    public String password;

    @Column(name = "phone_number")
    public String phoneNumber;

    @Column(name = "photo_path")
    public String photoPath;

    @Column
    public String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="farmer_delivery_type_id")
    public FarmerDeliveryType farmerDeliveryType;

    @Column(name = "pickup_address")
    public String pickupAddress;

    @Column(name = "lat_lng")
    public String latLng;
}
