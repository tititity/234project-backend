package camt.se234.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    String product;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String productId;
    String name;
    String description;
    String imageLocation;
    double price;

    public Product(Long id,String productId,String name,String description,String imageLocation,double price){
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.imageLocation = imageLocation;
        this.price = price;
    }

}
