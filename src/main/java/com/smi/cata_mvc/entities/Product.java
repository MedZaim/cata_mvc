package com.smi.cata_mvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
public class Product implements Serializable {
    @Id@GeneratedValue
    private long idProduct;
    @NotNull
    @Size(min = 4,max = 15)
    private String designation;
    @DecimalMin("100.00")
    private double price;
    @Positive
    private int quantity;

    public Product(String designation, double price, int quantity) {
        this.designation = designation;
        this.price = price;
        this.quantity = quantity;
    }
}