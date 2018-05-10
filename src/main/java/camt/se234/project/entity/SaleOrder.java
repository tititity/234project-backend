package camt.se234.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrder {
    String product;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String saleOrderId;
    @Builder.Default
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<SaleTransaction> transactions = new ArrayList<>();

    public SaleOrder(String saleOrderId, List<SaleTransaction> transactions) {
    }

    public double getTotalPrice(){
        double totalPrice = 0;
        for (SaleTransaction transaction :
                transactions) {
            totalPrice += transaction.getAmount() * transaction.getProduct().getPrice();
        }
        return totalPrice;
    }

    public SaleOrder(String saleOrderId,String product){
        this.id = id;
        this.saleOrderId = saleOrderId;
        this.product = product;
    }
}
