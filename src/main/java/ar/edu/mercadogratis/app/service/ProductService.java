package ar.edu.mercadogratis.app.service;

import ar.edu.mercadogratis.app.dao.GenericDao;
import ar.edu.mercadogratis.app.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ProductService {

    private final GenericDao<Product> productDao;

    @Transactional
    public Optional<Product> getProduct(Long productId) {
        return Optional.ofNullable(productDao.get(productId));
    }

    @Transactional
    public Long saveProduct(Product product) {
        return productDao.save(product);
    }

    @Transactional
    public void updateProduct(Product product) {
        productDao.update(product);
    }

    @Transactional
    public List<Product> listProducts() {
        return productDao.list();
    }
}
