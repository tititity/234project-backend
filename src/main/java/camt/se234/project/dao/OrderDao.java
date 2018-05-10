package camt.se234.project.dao;

import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;

import java.util.List;

public interface OrderDao {
    SaleOrder addOrder(SaleOrder saleOrder);
    List<SaleOrder> getOrders();

    List<SaleOrder> findAll();
}
