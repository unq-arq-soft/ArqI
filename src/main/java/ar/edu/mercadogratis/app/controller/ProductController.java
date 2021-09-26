package ar.edu.mercadogratis.app.controller;

import ar.edu.mercadogratis.app.model.Product;
import ar.edu.mercadogratis.app.exceptions.NotFoundException;
import ar.edu.mercadogratis.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        return productService.getProduct(productId)
                .orElseThrow(() -> new NotFoundException("product_not_found", "Product not found: " + productId));
    }
}
