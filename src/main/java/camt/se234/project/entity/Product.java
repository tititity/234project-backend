package camt.se234.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String productId;
    String name;
    String description;
    String imageLocation;
    double price;

    public Product(Long id, String productId, String name, String description, String imageLocation, double price){
        this.id = id;
        this.productId= productId;
        this.name = name;
        this.description = description;
        this.imageLocation = imageLocation;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public double getPrice() {
        return price;
    }
}
