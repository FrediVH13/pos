package com.fredivazquez.pos.controllers;

import com.fredivazquez.pos.models.Product;
import com.fredivazquez.pos.services.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{code}")
    public Product getProduct(@PathVariable(name = "code") String code) {
        return service.getProduct(code);
    }

    @GetMapping
    public List<Product> allProducts() {
        return service.getProducts();
    }

    @PostMapping
    public Product saveProduct(@Valid @RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PutMapping(value = "/{productId}")
    public Product editProduct(@Valid @RequestBody Product product, @PathVariable(name = "productId") Long productId) {
        return service.updateProduct(product, productId);
    }
}
