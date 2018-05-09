package camt.se234.project;

import camt.se234.project.dao.OrderDao;
import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import camt.se234.project.entity.SaleOrder;
import camt.se234.project.entity.SaleTransaction;
import camt.se234.project.service.ProductServiceImpl;
import camt.se234.project.service.SaleOrderServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SaleOrderServiceImplTests {
    @Test
    public void testGetSaleOders(){
        OrderDao orderDao = mock(OrderDao.class);
        List<SaleOrder> mockSaleOrder = new ArrayList<>();
        SaleOrderServiceImpl saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);

        mockSaleOrder.add(new SaleOrder(001L,"o001"));
        mockSaleOrder.add(new SaleOrder(002L, "o002"));
        mockSaleOrder.add(new SaleOrder(003L, "o003"));
        when(orderDao.getOrders()).thenReturn(mockSaleOrder);

        assertThat(saleOrderService.getSaleOrders(),hasItems(new SaleOrder(001L,"o001"),
                new SaleOrder(002L,"o002"), new SaleOrder(003L,"o003")));
    }

    @Test
    public void testGetAverageSaleOrderPrice(){
        ProductDao productDao = mock(ProductDao.class);
        List<Product> mockProduct = new ArrayList<>();
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductDao(productDao);


        mockProduct.add(new Product(001L,"p0001","Garden", "The garden which you can grow everything on earth", "garden.jpg", 20000.0));
        mockProduct.add(new Product(002L,"p0002","Banana", "A good fruit with very cheap price", "banana.jpg", 150.0));
        mockProduct.add(new Product(003L,"p0003","Orange", "Nothing good about it", "orange.jpg", 280.0));
        mockProduct.add(new Product(004L,"p0004","Papaya", "Use for papaya salad", "papaya.jpg", 12.0));
        mockProduct.add(new Product(005L,"p0005","Rambutan", "An expensive fruit from the sout", "rumbutan.jpg", 20.0));
        mockProduct.add(new Product(006L,"p0006","Unknow", "Don't use this\n", "rambutan.jpg", -1.0));
        when(productDao.getProducts()).thenReturn(mockProduct);

        OrderDao orderDao = mock(OrderDao.class);
        List<SaleOrder> mockSaleOrder = new ArrayList<>();
        SaleOrderServiceImpl saleOrderService = new SaleOrderServiceImpl();
        saleOrderService.setOrderDao(orderDao);

        mockSaleOrder.add(new SaleOrder(001L,"o001"));
        mockSaleOrder.add(new SaleOrder(002L, "o002"));
        mockSaleOrder.add(new SaleOrder(003L, "o003"));
        when(orderDao.getOrders()).thenReturn(mockSaleOrder);

        List<SaleTransaction> mockSaleTransaction = new ArrayList<>();
        mockSaleTransaction.add(new SaleTransaction(001L,"t001","p0001",1));
        mockSaleTransaction.add(new SaleTransaction(002L,"t002","p0004",10));
        mockSaleTransaction.add(new SaleTransaction(003L,"t003","p0002",2));
        mockSaleTransaction.add(new SaleTransaction(004L,"t004","p0001",3));
        mockSaleTransaction.add(new SaleTransaction(005L,"t005","p0002",1));
        mockSaleTransaction.add(new SaleTransaction(006L,"t006","p0005",6));

        assertThat(saleOrderService.getAverageSaleOrderPrice(),is(closeTo(3508.26,0.1)));
    }
}
