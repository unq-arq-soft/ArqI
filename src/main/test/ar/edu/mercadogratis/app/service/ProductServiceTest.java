package ar.edu.mercadogratis.app.service;

import ar.edu.mercadogratis.app.dao.GenericDao;
import ar.edu.mercadogratis.app.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith({SpringExtension.class})
public class ProductServiceTest {

    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public ProductService addressSearchService(GenericDao<Product> productDao) {
            return new ProductService(productDao);
        }
    }

    @Autowired
    private ProductService productService;

    @MockBean
    private GenericDao<Product> productDao;

    @Test
    void testGetProduct() {
        // given
        Long productId = 1L;
        Product product = mock(Product.class);

        when(productDao.get(eq(productId))).thenReturn(product);

        // when
        Optional<Product> result = productService.getProduct(productId);

        // then
        assertThat(result).isPresent();
        assertThat(result).hasValue(product);
    }

    @Test
    void testSaveProduct() {
        // given
        Product product = mock(Product.class);
        when(productDao.save(eq(product))).thenReturn(2L);

        // when
        Long result = productService.saveProduct(product);

        // then
        verify(productDao).save(eq(product));
        assertThat(result).isEqualTo(2L);
    }

    @Test
    void testUpdateProduct() {
        // given
        Product product = mock(Product.class);

        // when
        productService.updateProduct(product);

        // then
        verify(productDao).update(eq(product));
    }

    @Test
    void testListProducts() {
        // given
        Product product = mock(Product.class);

        when(productDao.list()).thenReturn(List.of(product));

        // when
        List<Product> products = productService.listProducts();

        // then
        assertThat(products).containsExactly(product);
    }
}