package com.ecom.productcatalog.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id@GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private Set<Product>products;

}
