package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.ProductTag;

import java.util.List;

public interface IProductTagService {
    List<ProductTag> getProductTags();

    ProductTag updateProductTag(ProductTag productTag, Long id);

    void deleteProductTag(Long id);

    void saveProductTag(ProductTag productTag);

    void saveProductTags(List<ProductTag> productTags);
}
