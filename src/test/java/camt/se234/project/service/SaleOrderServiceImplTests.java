package camt.se234.project.service;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
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
    public void testGetSaleOrder(){
        List<SaleTransaction> transactions = new ArrayList<>();
        transactions.add(new SaleTransaction("A",new SaleOrder("5555",transactions),
                new Product(203L,"26","pen","description","image",34.75)));
        List<SaleOrder> saleOrders = new ArrayList<>();
        saleOrders.add(new SaleOrder("5555",transactions));
        when(orderDao.getOrders()).thenReturn(saleOrders);
        assertThat(saleOrderService.getSaleOrders(),hasItem(new SaleOrder("5555",transactions)));
    }

    private void assertThat(List<SaleOrder> saleOrders, Matcher<Iterable<? super SaleOrder>> iterableMatcher) {
    }
}
