package ar.edu.mercadogratis.app.dao;

import ar.edu.mercadogratis.app.model.Product;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductDaoImpl extends GenericDaoImp<Product> {

    private final SessionFactory sessionFactory;

    @Override
    protected Class<Product> getDomainClass() {
        return Product.class;
    }
}
