package com.example.bfjavaserver.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    public String name;

    @Column(name = "photo_path")
    public String photoPath;

    @Transient
    @OneToMany(mappedBy = "product_category")
    public Set<Product> products;
}
