package com.fredivazquez.pos.controllers;

import com.fredivazquez.pos.models.Product;
import com.fredivazquez.pos.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/{code}")
    public Product getProduct(@PathVariable(name = "code") String code) {
        log.info("code: " + code);
        return service.getProduct(code);
    }

    @GetMapping
    public List<Product> allProducts() {
        return service.getProducts();
    }

    @PostMapping
    public Product saveProduct(@Valid Product product, @RequestParam(value = "productImage", required = false) MultipartFile image) {
        validateImage(image);
        return service.saveProduct(product);
    }

    @PutMapping(value = "/{productId}")
    public Product editProduct(@Valid Product product, @PathVariable(name = "productId") Long productId, @RequestParam(value = "productImage", required = false) MultipartFile image) {
        validateImage(image);
        return service.updateProduct(product, productId);
    }

    public void validateImage(MultipartFile image) {
        if (image != null) {
            if (!image.isEmpty()) {
                String rootPath = "C://pos//images//product-images";
                try {
                    byte[] bytes = image.getBytes();
                    Path path = Paths.get(rootPath + "//" + Objects.requireNonNull(image.getOriginalFilename()));
                    Files.write(path, bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
