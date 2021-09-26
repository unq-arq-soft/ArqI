package ar.edu.mercadogratis.app.service;

import ar.edu.mercadogratis.app.dao.GenericDao;
import ar.edu.mercadogratis.app.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ProductService {

    private final GenericDao<Product> productDao;

    @Transactional
    public Optional<Product> getProduct(Long productId) {

        if (productId == 1) {
            return Optional.of(new Product(1L, "test nomre", "test dscripcio"));
        }

        return Optional.ofNullable(productDao.get(productId));
    }
}
