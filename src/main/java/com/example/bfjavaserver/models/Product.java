package com.example.bfjavaserver.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    public String name;

    @Column
    public int price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "price_measurement_id")
    public PriceMeasurement priceMeasurement;

    @Column
    public int amount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "amount_measurement_id")
    public AmountMeasurement amountMeasurement;

    @Column
    public String description;

    @Column
    public double rating;

    @Column(name = "photo_path")
    public String photoPath;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "farmer_id")
    public Farmer farmer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_category_id")
    public ProductCategory productCategory;

}
