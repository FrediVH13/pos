package com.fredivazquez.pos.services;

import com.fredivazquez.pos.exceptions.PosException;
import com.fredivazquez.pos.models.Product;
import com.fredivazquez.pos.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product newProduct, Long id) {
        return productRepository.findById(id).map(product -> {
            product.setImage(newProduct.getImage());
            product.setCode(newProduct.getCode());
            product.setName(newProduct.getName());
            product.setSalePrice(newProduct.getSalePrice());
            product.setPurchasePrice(newProduct.getPurchasePrice());
            product.setWholesalePrice(newProduct.getWholesalePrice());
            product.setUnitsInStock(newProduct.getUnitsInStock());
            product.setStatus(newProduct.getStatus());
            product.setProductCategory(newProduct.getProductCategory());
            log.info("ProductString: " + newProduct);
            return productRepository.save(product);
        }).orElseThrow(() -> new PosException(id));
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new PosException(id));
    }

    @Override
    public Product getProduct(String code) {
        return productRepository.findByCodeLike(code);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
