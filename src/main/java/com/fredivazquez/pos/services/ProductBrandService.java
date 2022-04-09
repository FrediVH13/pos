package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.ProductBrand;

import java.util.List;

public interface ProductBrandService {
    ProductBrand saveBrand(ProductBrand productBrand);
    List<ProductBrand> getProductBrands();
}
