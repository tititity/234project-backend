package camt.se234.project.service;

import camt.se234.project.dao.ProductDao;
import camt.se234.project.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTests  {
    ProductDao productDao;
    ProductServiceImpl productService;

    @Before
    public void setup(){
        productDao = mock(ProductDao.class);
        productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
    }

    @Test
    public void testGetAllProducts(){
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product(201L,"23","game","description","image",40.56));
        mockProducts.add(new Product(202L,"24","titi","description","image",45.56));
        mockProducts.add(new Product(203L,"26","pen","description","image",34.75));
        mockProducts.add(new Product(204L,"27","fan","description","image",85.89));
        mockProducts.add(new Product(205L,"28","bag","description","image",55.60));
        when(productDao.findAll()).thenReturn(mockProducts);
        assertThat(productService.getAllProducts());
    }

    @Test
    public void testGetAvailableProducts(){
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product(201L,"23","game","description","image",40.56));
        mockProducts.add(new Product(202L,"24","titi","description","image",45.56));
        mockProducts.add(new Product(203L,"26","pen","description","image",34.75));
        mockProducts.add(new Product(204L,"27","fan","description","image",85.89));
        mockProducts.add(new Product(205L,"28","bag","description","image",55.60));
        when(productDao.findAll()).thenReturn(mockProducts);
        assertThat(productService.getAvailableProducts());
    }

    @Test
    public void testGetUnavailableProducts(){
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setProductDao(productDao);
        List<Product> mockProducts = new ArrayList<>();
        mockProducts.add(new Product(201L,"23","game","description","image",40.56));
        mockProducts.add(new Product(202L,"24","titi","description","image",45.56));
        mockProducts.add(new Product(203L,"26","pen","description","image",34.75));
        mockProducts.add(new Product(204L,"27","fan","description","image",85.89));
        mockProducts.add(new Product(205L,"28","bag","description","image",55.60));
        when(productDao.findAll()).thenReturn(mockProducts);
        assertThat(productService.getUnavailableProductSize());
    }
}
