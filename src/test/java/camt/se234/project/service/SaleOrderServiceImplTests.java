package camt.se234.project.service;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import camt.se234.project.service.ProductServiceImpl;
import camt.se234.project.service.SaleOrderServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaleOrderServiceImplTests {
    OrderDao orderDao;
    SaleOrderServiceImpl saleOrderService;

    @Before
    public void setup(){
        orderDao = mock(OrderDao.class);
        saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
    }

    @Test
    public void testGetSaleOders(){
        OrderDao orderDao = mock(OrderDao.class);
        List<SaleOrder> mockSaleOrder = new ArrayList<>();
        SaleOrderServiceImpl saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
        mockSaleOrder.add(new SaleOrder("001L","o001"));
        mockSaleOrder.add(new SaleOrder("002L", "o002"));
        mockSaleOrder.add(new SaleOrder("003L", "o003"));
        when(orderDao.getOrders()).thenReturn(mockSaleOrder);
        assertThat(saleOrderService.getSaleOrders(),hasItem(new SaleOrder("001L","o001")));
//        assertThat(saleOrderService.getSaleOrders(),hasItems(new SaleOrder(001L,"o001"),
//                new SaleOrder(002L,"o002"), new SaleOrder(003L,"o003")));
    }

    @Test
    public void testGetAverageSaleOrderPrice(){
        OrderDao orderDao = mock(OrderDao.class);
        List<SaleOrder> mockSaleOrder = new ArrayList<>();
        SaleOrderServiceImpl saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
        mockSaleOrder.add(new SaleOrder("001L","o001"));
        mockSaleOrder.add(new SaleOrder("002L", "o002"));
        mockSaleOrder.add(new SaleOrder("003L", "o003"));
        when(orderDao.getOrders()).thenReturn(mockSaleOrder);
        assertThat(saleOrderService.getSaleOrders(),hasItems(new SaleOrder("001L","o001"),
                new SaleOrder("002L","o002"), new SaleOrder("003L","o003")));
    }
}
