package camt.se234.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String transactionId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    SaleOrder order;
    @OneToOne (fetch = FetchType.EAGER)
    Product product;
    int amount;

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public SaleTransaction(Long id, String transactionId, String ProductId, int amount){
        this.amount = amount;
        this.id = id;
        this.product.setProductId(ProductId);
        this.transactionId = transactionId;
    }
}
