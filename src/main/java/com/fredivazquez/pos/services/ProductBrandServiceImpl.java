package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.ProductBrand;
import com.fredivazquez.pos.repository.ProductBrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBrandServiceImpl implements ProductBrandService{

    private final ProductBrandRepository repository;

    ProductBrandServiceImpl (ProductBrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductBrand saveBrand(ProductBrand productBrand) {
        return repository.save(productBrand);
    }

    @Override
    public List<ProductBrand> getProductBrands() {
        return repository.findAll();
    }
}
