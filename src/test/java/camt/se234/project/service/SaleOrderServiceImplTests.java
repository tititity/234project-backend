package camt.se234.project.service;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.service.SaleOrderServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class SaleOrderServiceImplTests {
    @Test
    public void testGetSaleOders(){
        OrderDao orderDao = mock(OrderDao.class);
        List<SaleOrder> mockSaleOrders = new ArrayList<>();
        SaleOrderServiceImpl saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);
        mockSaleOrders.add(new SaleOrder("001L","o001"));
        mockSaleOrders.add(new SaleOrder("002L", "o002"));
        mockSaleOrders.add(new SaleOrder("003L", "o003"));
        when(orderDao.findAll()).thenReturn(mockSaleOrders);
        assertThat(saleOrderService.getSaleOrders(),hasItems(new SaleOrder("001L","o001"),
                new SaleOrder("002L","o002"), new SaleOrder("003L","o003")));
    }
}

